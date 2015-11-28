package backEnd;

public class PositionFragment extends InstructionFragment {
	
	private String s;
	private int size;
	
	public PositionFragment(int size) {
		this.size = size;
	}
	
	public void setStackPosition(int i) {
		if (i == 0) {
			s = "";
		}
		else {
			s = ", #" + i;
		}
	}
	
	public int getSize() {
		return size;
	}
	
	@Override
	public String getString() {
		assert s !=null: "Have not allocated a stack position yet!";
		return s;
	}

}
