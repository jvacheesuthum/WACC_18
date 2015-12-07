package backEnd;

public class VariableFragment extends InstructionFragment {
	
	private String s;
	private String variable;
	private int funcCallOffset = 0;
	
	public VariableFragment(String var) {
		this.variable = var;
	}

	public VariableFragment(String var, int funcCallOffset) {
		this.variable = var;
		this.funcCallOffset = funcCallOffset;
	}
	
	public String getVariable() {
		return variable;
	}
	
	public void pointToStackPosition(int i) {
//		if (i == 0) {
//			s = "";
//		}
//		else {
			s = ", #" + (i + funcCallOffset);
		//s = ", #" + i;
//		}
	}
	
	@Override
	public String getString() {
		assert s !=null: "Don't know the position of variable " + variable + " yet!";
		return s;
	}

}
