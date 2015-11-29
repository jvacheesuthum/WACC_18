package backEnd;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class Instruction {
	
	private List<InstructionFragment> instructions;
	private List<VariableFragment> variables;
	private PositionFragment pos;
	
	public Instruction(String s) {
		// when no variables and positions are needed
		instructions = Arrays.asList((InstructionFragment) new StringFragment(s));
	}
	
	public Instruction(List<InstructionFragment> instr, List<VariableFragment> vars){
		// when two previously declared variables are used eg x = x + y; vars(x, y)
		instructions = instr;
		variables = vars;
	}
	
	public Instruction(List<InstructionFragment> instr, VariableFragment var) {
		// when one previously declared variable is used eg print x; var(x)
		instructions = instr;
		variables = Arrays.asList(var);
	}
	
	public Instruction(List<InstructionFragment> instr, VariableFragment var, PositionFragment pos) {
		// declaration eg int x = 0; var(x), pos(size = 4);
		instructions = instr;
		variables = Arrays.asList(var);
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
	
	public void varsToPos(Map<String, Integer> st) {
		// given stack map, gives a position string to all variables in this instruction
		for (VariableFragment v : variables) {
			v.pointToStackPosition(st.get(v.getVariable()));
		}
		variables = null;
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

}
