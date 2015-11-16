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
}
