package SemanticAnalyser;

//need to implement type in IDENTIFIER or subclasses???

public class ForAST extends SharedMethods{

	String forloopvarname;
	ExpressionAST E1, E2;
	StatementAST S;
	boolean ascending;
	VARIABLE forvar;
	
	SymbolTable ST;
	
	public ForAST(SymbolTable ST) {
		this.ST = ST;
	}
	
	public void check() {
		E1.check();
		E2.check();
		IDENTIFIER F = ST.lookup(forloopvarname);
		
		if (F == null) throw new Error("for variable not declared locally");
		else if (!(F instanceof VARIABLE)) 
			throw new Error("for variable not a variable");
		else if (!scalartype(F.type(), "integer") &&
				!scalartype(F.type(), "bool") &&
				!scalartype(F.type(), "char")) {
			//more types above to check??????
			throw new Error("For variable not of a supported type");
		}
		else if (!assignCompat(F.type(), E1.type())) 
			throw new Error("From expression type not compatible with for variable");
		else if (!assignCompat(F.type(), E2.type()))
			throw new Error("To expression type not compatible with for variable");
		else {
			S.check();
			forvar = (VARIABLE) F;
		}
	}
}
