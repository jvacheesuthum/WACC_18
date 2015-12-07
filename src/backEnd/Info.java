package backEnd;

public class Info {
	
	public final Integer int_value;
	public final Boolean b_value;
	public String stringinfo;
	public String type;
	
	public Info(int i) {
		int_value = i;
		b_value = null;
		stringinfo = null;
		type = "int";
	}
	
	public Info(boolean b) {
		int_value = null;
		b_value = b;
		stringinfo = null;
		type = "bool";
	}
	
	public Info(String s) {
		int_value = null;
		b_value = null;
		stringinfo = s;
	}
	
	public Info setType(String s) {
		this.type= s;
		return this;
	}

}
