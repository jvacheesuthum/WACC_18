package SemanticAnalyser;

public class SymbolTable {

	SymbolTable encSymTable;
	Dictionary dict;
	
	public SymbolTable(SymbolTable encSymTable) {
		dict = new Dictionary();
		this.encSymTable = encSymTable;
	}
	
	public void add(String name, IDENTIFIER obj) {
		dict.add(name, obj);
	}
	
	public IDENTIFIER lookup(String name) {
		return dict.get(name);
	}
	
	public IDENTIFIER lookupAll(String name) {
		SymbolTable st = this;
		IDENTIFIER obj;
		while (st != null) {
			obj = st.lookup(name);
			if(obj != null) {
				return obj;
			}
			st = encSymTable;
		}
		return null;
	}
}
