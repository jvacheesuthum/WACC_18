package extension;

import org.antlr.v4.runtime.misc.NotNull;

import antlr.WaccParser;
import antlr.WaccParserBaseVisitor;

public class DummyABracketCtx extends WaccParserBaseVisitor<WaccParser.Atom_bracketsContext>{
	
	@Override public WaccParser.Atom_bracketsContext visitProgram(@NotNull WaccParser.ProgramContext ctx) { 		System.out.println("found atom brackets7");return visit(ctx.stat()); }
	
	@Override public WaccParser.Atom_bracketsContext visitStat_declare(@NotNull WaccParser.Stat_declareContext ctx) {		System.out.println("found atom brackets6"); return visit(ctx.assign_rhs()); }
	
	@Override public WaccParser.Atom_bracketsContext visitAssign_rhs_expr(@NotNull WaccParser.Assign_rhs_exprContext ctx) { 		System.out.println("found atom brackets5");return visit(ctx.expr()); }
	
	@Override public WaccParser.Atom_bracketsContext visitExpr_binary(@NotNull WaccParser.Expr_binaryContext ctx) { 		System.out.println("found atom brackets4");return visit(ctx.bin_bool()); }
	
	@Override public WaccParser.Atom_bracketsContext visitExpr_bin_math(@NotNull WaccParser.Expr_bin_mathContext ctx) { 		System.out.println("found atom brackets3");return visit(ctx.math()); }
	
	@Override public WaccParser.Atom_bracketsContext visitExpr_bin_math_plusminus(@NotNull WaccParser.Expr_bin_math_plusminusContext ctx) { System.out.println("found atom brackets2"); return visit(ctx.plusminus(0)); }
	
	@Override public WaccParser.Atom_bracketsContext visitExpr_bin_atom(@NotNull WaccParser.Expr_bin_atomContext ctx) { 		System.out.println("found atom brackets1");return visit(ctx.atom()); }
	
	@Override public WaccParser.Atom_bracketsContext visitAtom_brackets(@NotNull WaccParser.Atom_bracketsContext ctx) { 
		System.out.println("found atom brackets");
		return ctx; }

}
