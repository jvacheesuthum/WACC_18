package SemanticAnalyser;

//need to implement type in IDENTIFIER or subclasses???

public class AssignmentAST {

	String varname;
	ExpressionAST expr;
	VARIABLE varObj;
	
	SymbolTable ST;
	
	public AssignmentAST(SymbolTable ST) {
		this.ST = ST;
	}
	
	public void check() {
		IDENTIFIER V = ST.lookup(varname);
		expr.check();
		
		if (V == null) throw new Error("Unknown variable");
		else if (!(V instanceof VARIABLE)) throw new Error("Identifier is not a variable");
		else if (!assignCompat(V.type(), expr.type())) throw new Error("lhs and rhs not type compatible");
		else varObj = (VARIABLE) V;
	}
}
