package SemanticAnalyser;

//Still need to add more type check in assignCompat

public class SharedMethods {

	SymbolTable CurrentSymbolTable;
	
	public boolean scalartype(TYPE type, String name) {
		return type == CurrentSymbolTable.lookup(name);
	}



	// does assignCompat do more than just check if the 2 TYPEs are the same?
	public static boolean assignCompat(TYPE lhs, TYPE rhs) {
/*		IDENTIFIER INTtype = CurrentSymbolTable.lookup("int");
		IDENTIFIER DOUBLEtype = CurrentSymbolTable.lookup("double");
		return (lhs == rhs) || ((lhs == DOUBLEtype) && (rhs == INTtype));
*/
	  
	  
		
		System.out.println("AssignCompat lhs: " + lhs);
		System.out.println("AssignCompat rhs: " + rhs);
		if (lhs == null) {
			System.out.println("lhs is null");
			return false;
		}
		if (rhs == null) {
			System.out.println("rhs is null");
			return false;
		}
		return lhs.equals(rhs);
		
	}
}
