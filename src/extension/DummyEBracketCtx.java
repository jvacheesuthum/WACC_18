package extension;

import org.antlr.v4.runtime.misc.NotNull;

import antlr.WaccParser;
import antlr.WaccParserBaseVisitor;

public class DummyEBracketCtx extends WaccParserBaseVisitor<WaccParser.Expr_bracketsContext>{
	
	@Override public WaccParser.Expr_bracketsContext visitProgram(@NotNull WaccParser.ProgramContext ctx) { return visit(ctx.stat()); }
	
	@Override public WaccParser.Expr_bracketsContext visitStat_declare(@NotNull WaccParser.Stat_declareContext ctx) { return visit(ctx.assign_rhs()); }
	
	@Override public WaccParser.Expr_bracketsContext visitAssign_rhs_expr(@NotNull WaccParser.Assign_rhs_exprContext ctx) { return visit(ctx.expr()); }
	
	@Override public WaccParser.Expr_bracketsContext visitExpr_brackets(@NotNull WaccParser.Expr_bracketsContext ctx) { return ctx; }

}
