package extension;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;

import SemanticAnalyser.SyntaxErrorListener;
import antlr.WaccLexer;
import antlr.WaccParser;
import antlr.WaccParser.AtomContext;
import antlr.WaccParser.ExprContext;
import antlr.WaccParser.StatContext;
import antlr.WaccParserBaseVisitor;

/* ------------------------------------------
 * This visitor finds all variables that are constant. (not re-assigned)
 * It only looks for variables of type int, bool and char, as only these have operations.
 * It ignores variables that may be constant, but is used in param (param can only accept variables)
 * It ignores variables that may be constant, but is used in read (read can only accept variables)
 * 
 * Constant variables will have their declarations removed, changed into skip
 * their occurrences (expr_ident and atom_ident) are replaced with their constant values.
 * 
 * SCOPING TO BE IMPLEMENTED.
 */

public class VariableVisitor extends WaccParserBaseVisitor<WaccParser.ProgramContext> {
	
	private List<VariableDependencies> vars = new LinkedList<VariableDependencies>();
	private Map<String, VariableDependencies> map = new HashMap<String, VariableDependencies>();

	@Override public WaccParser.ProgramContext visitProgram(@NotNull WaccParser.ProgramContext ctx) { 
		visitChildren(ctx);
		optimiseConstants();
		return ctx;
	}
	
	@Override public WaccParser.ProgramContext visitStat_declare(@NotNull WaccParser.Stat_declareContext ctx) {
		// add new variable to list of variables, remembering where it is declared.
		if (ctx.assign_rhs() instanceof WaccParser.Assign_rhs_exprContext) {
			VariableDependencies v = new VariableDependencies(ctx);
			vars.add(v);
			map.put(ctx.ident().VARIABLE().getText(), v);
		}
		return visitChildren(ctx);

	}
	
	@Override public WaccParser.ProgramContext visitExpr_ident(@NotNull WaccParser.Expr_identContext ctx) {
		//add this expr as dependent on the variable
		VariableDependencies v = map.get(ctx.ident().VARIABLE().getText());
		if (v != null) {
			v.addExpr(ctx);
		}
		return visitChildren(ctx); }
	
	@Override public WaccParser.ProgramContext visitAtom_ident(@NotNull WaccParser.Atom_identContext ctx) { 
		//add this atom as dependent on the variable
		VariableDependencies v = map.get(ctx.ident().VARIABLE().getText());
		if (v != null) {
			v.addAtom(ctx);
		}
		return visitChildren(ctx); }
	
	@Override public WaccParser.ProgramContext visitParam(@NotNull WaccParser.ParamContext ctx) {
		//mark this variable as not constant (cannot handle params)
		VariableDependencies v = map.get(ctx.ident().VARIABLE().getText());
		if (v != null) {
			v.notConstant();
		}
		return visitChildren(ctx); }
	
	@Override public WaccParser.ProgramContext visitAssign_lhs_ident(@NotNull WaccParser.Assign_lhs_identContext ctx) {
		//mark this variable as not constant (re-assigned or read)
		VariableDependencies v = map.get(ctx.ident().VARIABLE().getText());
		if (v != null) {
			v.notConstant();
		}
		return visitChildren(ctx); }
	
	private void optimiseConstants() {
		for (VariableDependencies v : vars) {
			if (v.isConstant()) {
				// get the constant expr of variable
				WaccParser.Assign_rhs_exprContext expr = (WaccParser.Assign_rhs_exprContext) v.getDeclare().assign_rhs();
				// replace all occurrences of variable with the constant expr
				for (WaccParser.Expr_identContext e : v.getExprs()) {
					e.copyFrom(createEBrackets(expr.expr()));
				}
				for (WaccParser.Atom_identContext a : v.getAtoms()) {
					a.copyFrom(createABracekts(expr.expr()));
				}
				// replace declaration with skip
				v.getDeclare().copyFrom(createSkip());
			}
		}
	}

	private StatContext createSkip() {
		ParseTree dummy = dummyTree("begin skip end");
		DummySkipCtx dsc = new DummySkipCtx();
		return dsc.visit(dummy);
	}

	private ParseTree dummyTree(String string) {
		//create a dummy tree to extract parts from
		ANTLRInputStream input = new ANTLRInputStream(string);
	    WaccLexer lexer = new WaccLexer(input);
	    lexer.removeErrorListeners();
	    lexer.addErrorListener(SyntaxErrorListener.INSTANCE);
	    CommonTokenStream tokens = new CommonTokenStream(lexer);
	    WaccParser parser = new WaccParser(tokens);
	    parser.removeErrorListeners();
	    parser.addErrorListener(SyntaxErrorListener.INSTANCE);
	    return parser.program();
	}

	private AtomContext createABracekts(ExprContext expr) {
		//create a dummy brackets atom context, that brackets this expr
	    ParseTree dummy = dummyTree("begin int x = (1) + 1 end");
	    DummyABracketCtx dbc = new DummyABracketCtx();
	    WaccParser.Atom_bracketsContext b = dbc.visit(dummy);
		if (b == null) {System.out.println("wtf");}
		if (b.expr() == null) {System.out.println("wtf2");}
	    b.expr().copyFrom(expr);
		return b;
	}

	private ExprContext createEBrackets(ExprContext expr) {
		//create a dummy brackets expr context, that brackets this expr
	    ParseTree dummy = dummyTree("begin int x = (1) end"); // begin parsing at program rule
	    DummyEBracketCtx dbc = new DummyEBracketCtx();
	    WaccParser.Expr_bracketsContext b = dbc.visit(dummy);
	    b.expr().copyFrom(expr);
		return b;
	}

}
