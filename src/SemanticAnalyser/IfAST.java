package SemanticAnalyser;

public class IfAST extends SharedMethods {
	
	ExpressionAST E;
	StatementAST S1, S2;
	
	SymbolTable ST;
	
	public IfAST(SymbolTable ST) {
		this.ST = ST;
	}
	
	public void check() {
		E.check();
		if (!scalartype(E.type(), "bool")) throw new Error("if conditional expression not a boolean");
		S1.check();
		if (S2 != null) S2.check();
	}
}
