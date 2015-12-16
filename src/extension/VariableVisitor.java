package extension;

import java.util.*;

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
	private ScopeMap<String, VariableDependencies> map = new ScopeMap<>(null);

	@Override public WaccParser.ProgramContext visitProgram(@NotNull WaccParser.ProgramContext ctx) { 
		visitChildren(ctx);
		optimiseConstants();
		return ctx;
	}
	
	@Override public WaccParser.ProgramContext visitStat_declare(@NotNull WaccParser.Stat_declareContext ctx) {
		// add new variable to list of variables, remembering where it is declared.
		if (ctx.assign_rhs() instanceof WaccParser.Assign_rhs_exprContext) {
			WaccParser.Assign_rhs_exprContext expr = (WaccParser.Assign_rhs_exprContext) ctx.assign_rhs();
			if (!(expr.expr() instanceof WaccParser.Expr_strContext)) {
				VariableDependencies v = new VariableDependencies(ctx);
				vars.add(v);
				map.put(ctx.ident().VARIABLE().getText(), v);
			}else{
				map.addArrayOrPairDeclared(ctx.ident().VARIABLE().getText());
			}
		}
		else{
			map.addArrayOrPairDeclared(ctx.ident().VARIABLE().getText());
		}
		return visitChildren(ctx);

	}
	
	@Override public WaccParser.ProgramContext visitExpr_ident(@NotNull WaccParser.Expr_identContext ctx) {
		//add this expr as dependent on the variable
		VariableDependencies v = map.outwardsGet(ctx.ident().VARIABLE().getText());
		if (v != null) {
			v.addExpr(ctx);
		}
		return visitChildren(ctx); }
	
	@Override public WaccParser.ProgramContext visitAtom_ident(@NotNull WaccParser.Atom_identContext ctx) { 
		//add this atom as dependent on the variable
		VariableDependencies v = map.outwardsGet(ctx.ident().VARIABLE().getText());
		if (v != null) {
			v.addAtom(ctx);
		}
		return visitChildren(ctx); }
	
	@Override public WaccParser.ProgramContext visitParam(@NotNull WaccParser.ParamContext ctx) {
		//mark this variable as not constant (cannot handle params)
		VariableDependencies v = map.outwardsGet(ctx.ident().VARIABLE().getText());
		if (v != null) {
			v.notConstant();
		}
		return visitChildren(ctx); }
	
	@Override public WaccParser.ProgramContext visitAssign_lhs_ident(@NotNull WaccParser.Assign_lhs_identContext ctx) {
		//mark this variable as not constant (re-assigned or read)
		VariableDependencies v = map.outwardsGet(ctx.ident().VARIABLE().getText());
		if (v != null) {
			v.notConstant();
		}

		return visitChildren(ctx); }

	// --- visits that involve scope --- //
	@Override public WaccParser.ProgramContext visitStat_begin_end(@NotNull WaccParser.Stat_begin_endContext ctx) {
		List<VariableDependencies> encVars = vars;
		map = new ScopeMap<>(map);
		vars = new LinkedList<VariableDependencies>();

		WaccParser.ProgramContext output = visit(ctx.stat());
		optimiseConstants();

		vars = encVars;
		map  = map.getEnc();
		return output;
	}


	@Override public WaccParser.ProgramContext visitStat_if(@NotNull WaccParser.Stat_ifContext ctx) {
		visit(ctx.expr());

		List<VariableDependencies> encVars = vars;
		map = new ScopeMap<>(map);
		vars = new LinkedList<VariableDependencies>();
		visit(ctx.stat(0));
		optimiseConstants();
		vars = encVars;
		map  = map.getEnc();

		encVars = vars;
		map = new ScopeMap<>(map);
		vars = new LinkedList<VariableDependencies>();
		visit(ctx.stat(1));
		optimiseConstants();
		vars = encVars;
		map  = map.getEnc();

		return null;
	}
	@Override public WaccParser.ProgramContext visitStat_while(@NotNull WaccParser.Stat_whileContext ctx) {
		visit(ctx.expr());

		List<VariableDependencies> encVars = vars;
		map = new ScopeMap<>(map);
		vars = new LinkedList<VariableDependencies>();
		visit(ctx.stat());
		optimiseConstants();
		vars = encVars;
		map  = map.getEnc();

		return null;
	}


	@Override public WaccParser.ProgramContext visitLayer_s_s(@NotNull WaccParser.Layer_s_sContext ctx) {
		visit(ctx.expr());

		List<VariableDependencies> encVars = vars;
		map = new ScopeMap<>(map);
		vars = new LinkedList<VariableDependencies>();
		if (ctx.stat(0) != null) visit(ctx.stat(0));
		visit(ctx.stat_return(0));
		optimiseConstants();
		vars = encVars;
		map  = map.getEnc();

		encVars = vars;
		map = new ScopeMap<>(map);
		vars = new LinkedList<VariableDependencies>();
		if (ctx.stat(1) != null) visit(ctx.stat(1));
		visit(ctx.stat_return(1));
		optimiseConstants();
		vars = encVars;
		map  = map.getEnc();

		return null;
	}

	@Override public WaccParser.ProgramContext visitLayer_i_i(@NotNull WaccParser.Layer_i_iContext ctx) {
		visit(ctx.expr());

		List<VariableDependencies> encVars = vars;
		map = new ScopeMap<>(map);
		vars = new LinkedList<VariableDependencies>();
		if (ctx.stat(0) != null) visit(ctx.stat(0));
		visit(ctx.if_layers(0));
		optimiseConstants();
		vars = encVars;
		map  = map.getEnc();

		encVars = vars;
		map = new ScopeMap<>(map);
		vars = new LinkedList<VariableDependencies>();
		if (ctx.stat(1) != null) visit(ctx.stat(1));
		visit(ctx.if_layers(1));
		optimiseConstants();
		vars = encVars;
		map  = map.getEnc();

		return null;
	}

	@Override public WaccParser.ProgramContext visitLayer_i_s(@NotNull WaccParser.Layer_i_sContext ctx) {
		visit(ctx.expr());

		List<VariableDependencies> encVars = vars;
		map = new ScopeMap<>(map);
		vars = new LinkedList<VariableDependencies>();
		if (ctx.stat(0) != null) visit(ctx.stat(0));
		visit(ctx.if_layers());
		optimiseConstants();
		vars = encVars;
		map  = map.getEnc();

		encVars = vars;
		map = new ScopeMap<>(map);
		vars = new LinkedList<VariableDependencies>();
		if (ctx.stat(1) != null) visit(ctx.stat(1));
		visit(ctx.stat_return());
		optimiseConstants();
		vars = encVars;
		map  = map.getEnc();

		return null;
	}
	@Override public WaccParser.ProgramContext visitLayer_s_i(@NotNull WaccParser.Layer_s_iContext ctx) {
		visit(ctx.expr());

		List<VariableDependencies> encVars = vars;
		map = new ScopeMap<>(map);
		vars = new LinkedList<VariableDependencies>();
		if (ctx.stat(0) != null) visit(ctx.stat(0));
		visit(ctx.stat_return());
		optimiseConstants();
		vars = encVars;
		map  = map.getEnc();

		encVars = vars;
		map = new ScopeMap<>(map);
		vars = new LinkedList<VariableDependencies>();
		if (ctx.stat(1) != null) visit(ctx.stat(1));
		visit(ctx.if_layers());
		optimiseConstants();
		vars = encVars;
		map  = map.getEnc();

		return null;
	}
	// --------------------------------- //

	private void optimiseConstants() {
		for (VariableDependencies v : vars) {
			if (v.isConstant()) {
				// get the constant expr of variable
				WaccParser.Assign_rhs_exprContext expr = (WaccParser.Assign_rhs_exprContext) v.getDeclare().assign_rhs();
				System.out.println("im here");
				if (expr.expr() == null) {System.out.println("expr is null");}
				// replace all occurrences of variable with the constant expr
				for (WaccParser.Expr_identContext e : v.getExprs()) {
					//e.copyFrom(createEBrackets(expr.expr()));
					e.ident().constant = true;
					e.ident().constantExpr = expr.expr();
				}
				for (WaccParser.Atom_identContext a : v.getAtoms()) {
					//a.copyFrom(createABracekts(expr.expr()));
					a.ident().constant = true;
					a.ident().constantAtom = createABrackets(expr.expr());
				}
				// replace declaration with skip
				//v.getDeclare().copyFrom(createSkip());
				v.getDeclare().ident().constant = true;
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

	private AtomContext createABrackets(ExprContext expr) {
		//create a dummy brackets atom context, that brackets this expr
	    ParseTree dummy = dummyTree("begin int x = (1) + 1 end");
	    DummyABracketCtx dbc = new DummyABracketCtx();
	    WaccParser.Atom_bracketsContext b = dbc.visit(dummy);
		if (b == null) {System.out.println("wtf");}
		if (b.expr() == null) {System.out.println("wtf2");}
		//b.expr().copyFrom(expr);
		b.removeLastChild();
		b.removeLastChild();
		b.addChild(expr);
		expr.parent = b;
		return b;
	}

	private ExprContext createEBrackets(ExprContext expr) {
		//create a dummy brackets expr context, that brackets this expr
	    ParseTree dummy = dummyTree("begin int x = (1) end"); // begin parsing at program rule
	    DummyEBracketCtx dbc = new DummyEBracketCtx();
	    WaccParser.Expr_bracketsContext b = dbc.visit(dummy);
		//b.expr().copyFrom(expr);
	    if (b == null) {System.out.println("wtf");}
		b.removeLastChild();
		b.removeLastChild();
		b.addChild(expr);
		expr.parent = b;
		return b;
	}

}
