package backEnd;

public class StringFragment extends InstructionFragment {
	
	private String s;
	
	public StringFragment(String s) {
		this.s =s;
	}
	
	@Override
	public String getString() {
		return s;
	}
	
}
