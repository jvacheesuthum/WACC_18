package backEnd;
import java.util.*;


public class Instruction {
	
	protected List<InstructionFragment> instructions;
	protected List<VariableFragment> variables;
	protected PositionFragment pos;

	protected boolean isScoped = false;
	protected int scopedDepth = 0;
	
	public Instruction(String s) {
		// when no variables and positions are needed
		instructions = Arrays.asList((InstructionFragment)new StringFragment(s));
	}
	
	public Instruction(List<InstructionFragment> instr, List<VariableFragment> vars){
		// when two previously declared variables are used eg x = x + y; vars(x, y)
		instructions = instr;
		variables = vars;
	}
	
	public Instruction(List<InstructionFragment> instr, VariableFragment var) {
		// when one previously declared variable is used eg print x; var(x)
		instructions = instr;
		variables = new ArrayList<>();
		variables.add(var);
	}
	
	public Instruction(List<InstructionFragment> instr, VariableFragment var, PositionFragment pos) {
		// declaration eg int x = 0; var(x), pos(size = 4);
		instructions = instr;
		variables = new ArrayList<>();
		variables.add(var);
		this.pos = pos;
	}
	
	public boolean toDeclare() {
		// check if this instruction requires allocation something to the stack
		return pos != null;
	}
	
	public boolean needsVarPos() {
		// check if this instruction requires information on where things are stored on the stack
		return variables != null;
	}

	public boolean isScoped(){
		return isScoped;
	}

	public void addScopeDepth(int x){
		scopedDepth += x;
	}
	
	public void varsToPos(Map<String, Integer> st, int scopedStackTotal) {
		// given stack map, gives a position string to all variables in this instruction

		Iterator<VariableFragment> it = variables.iterator();
		while(it.hasNext()){
			VariableFragment v = it.next();
			Integer varPosition = st.get(v.getVariable());
			// varPosition can be null when in 'if' scope u tried to access outer-scoped variable
			// that is declared but not yet known the position
			if(varPosition != null) {
				varPosition += scopedDepth;
				v.pointToStackPosition(varPosition);
				it.remove();
			}
			else{
				if(!isScoped){
					isScoped = true;
				}
				else{
					addScopeDepth(scopedStackTotal);
				}
			}
		}
		if(variables.isEmpty()){
			variables = null;
		}
	}
	
	public int sizeOnStack() {
		return pos.getSize();
	}
	
	public int allocateStackPos(int total, Map<String, Integer> st) {
		// allocates the stack position for a variable declaration, and stores it in the map
		// eg int x  = 0; gives the #8 part for STORE R4 SP #8
		// returns the new stack position after allocating this
		assert variables.size() == 1: "Do not have excactly 1 variable. Not a valid declaration";
		int result = total - pos.getSize();
		pos.setStackPosition(result);
		pos = null;
		st.put(variables.get(0).getVariable(), result);
		return result;
	}
	@Override
	public String toString() {
		assert !toDeclare() && !needsVarPos() : "not a complete instruction!";
		String result = "";
		for (InstructionFragment instr : instructions) {
			result += instr.getString();
		}
		return result;
	}

	public int scopeDepth() {
		return scopedDepth;
	}

	public List<InstructionFragment> getInstructions() {
		return instructions;
	}

	public List<VariableFragment> getVariables() {
		return variables;
	}
	
	public PositionFragment getPos() {
		return pos;
	}
}
