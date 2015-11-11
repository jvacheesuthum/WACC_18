package SemanticAnalyser;

//Still need to add more type check in assignCompat

public class SharedMethods {

	SymbolTable CurrentSymbolTable;
	
	public boolean scalartype(TYPE type, String name) {
		return type == CurrentSymbolTable.lookup(name);
	}
	
	public boolean assignCompat(TYPE lhs, TYPE rhs) {
		IDENTIFIER INTtype = CurrentSymbolTable.lookup("int");
		IDENTIFIER DOUBLEtype = CurrentSymbolTable.lookup("double");
		return (lhs == rhs) || ((lhs == DOUBLEtype) && (rhs == INTtype));
	}
}
