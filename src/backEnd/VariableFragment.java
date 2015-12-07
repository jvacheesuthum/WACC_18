package backEnd;

public class VariableFragment extends InstructionFragment {
	
	private String s;
	private String variable;
	
	public VariableFragment(String var) {
		this.variable = var;
	}
	
	public String getVariable() {
		return variable;
	}
	
	public void pointToStackPosition(int i) {
//		if (i == 0) {
//			s = "";
//		}
//		else {
			s = ", #" + i;
//		}
	}
	
	@Override
	public String getString() {
		assert s !=null: "Don't know the position of variable " + variable + " yet!";
		return s;
	}

}
