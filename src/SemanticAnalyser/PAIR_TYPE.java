package SemanticAnalyser;

public class PAIR_TYPE extends TYPE{
	TYPE t1;
	TYPE t2;
	
	public PAIR_TYPE() {}
	
	public PAIR_TYPE(TYPE t1, TYPE t2){
		this.t1 = t1;
		this.t2 = t2;
	}
	
	public TYPE firstType(){
		return t1;
	}
	
	public TYPE secondType(){
		return t2;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o.getClass().equals(this.getClass())) {
			PAIR_TYPE p = (PAIR_TYPE) o;
			return (p.firstType().equals(this.firstType()) && 
					p.secondType().equals(this.secondType()));
		}
		return false;
	}
}
