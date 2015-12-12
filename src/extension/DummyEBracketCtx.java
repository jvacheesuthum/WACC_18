package extension;

import org.antlr.v4.runtime.misc.NotNull;

import antlr.WaccParser;
import antlr.WaccParserBaseVisitor;

public class DummyEBracketCtx extends WaccParserBaseVisitor<WaccParser.Expr_bracketsContext>{

	@Override public WaccParser.Expr_bracketsContext visitExpr_brackets(@NotNull WaccParser.Expr_bracketsContext ctx) { return ctx; }

}
