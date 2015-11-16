package SemanticAnalyser;

public class ARRAY_TYPE extends TYPE{
	TYPE type;
	int elements;
	
	public ARRAY_TYPE(TYPE type) {
		this.type = type;
	}
	
	public TYPE TYPE(){
		return type;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o.getClass().equals(this.getClass())) {
			ARRAY_TYPE a = (ARRAY_TYPE) o;
			return a.TYPE().equals(this.TYPE());
		}
		return false;
	}
}
