package extension;

import org.antlr.v4.runtime.misc.NotNull;

import antlr.WaccParser;
import antlr.WaccParserBaseVisitor;

public class DummySkipCtx extends WaccParserBaseVisitor<WaccParser.Stat_skipContext> {
	
	@Override public WaccParser.Stat_skipContext visitProgram(@NotNull WaccParser.ProgramContext ctx) { return visit(ctx.stat()); }

	@Override public WaccParser.Stat_skipContext visitStat_skip(@NotNull WaccParser.Stat_skipContext ctx) { return ctx; }

}
