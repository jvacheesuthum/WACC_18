package extension;

import java.util.LinkedList;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;

import antlr.WaccParser;
import antlr.WaccParser.AtomContext;
import antlr.WaccParser.Expr_bin_plus_atomContext;
import antlr.WaccParser.Expr_bin_plus_plusContext;
import antlr.WaccParserBaseVisitor;

public class BinopTreeReorder extends WaccParserBaseVisitor<WaccParser.ProgramContext> {
	
	private LinkedList<extendedInfo<AtomContext>> RmostPMatom = new LinkedList<extendedInfo<AtomContext>>();
	private int bppCount = 0;
	
	@Override public WaccParser.ProgramContext visitProgram(@NotNull WaccParser.ProgramContext ctx) { visitChildren(ctx); return ctx;}
	
	@Override public WaccParser.ProgramContext visitExpr_bin_plus_plus(@NotNull WaccParser.Expr_bin_plus_plusContext ctx) {
		bppCount ++;
		TerminalNode n = findOP(ctx);
		if (!(ctx.atom() instanceof WaccParser.Atom_identContext)) {
			RmostPMatom.add(new extendedInfo<AtomContext>(ctx.atom(), n, ctx));
		} else {
			if (!RmostPMatom.isEmpty()) {
				extendedInfo<AtomContext> i = RmostPMatom.getFirst();
				ctx.atom().parent = i.getParent();
				WaccParser.Expr_bin_plus_plusContext p = (WaccParser.Expr_bin_plus_plusContext) i.getParent();
				p.removeLastChild();
				p.removeLastChild();
				p.addChild(n);
				p.addChild(ctx.atom());
				ctx.removeLastChild();
				ctx.removeLastChild();
				ctx.addChild(i.getN());
				ctx.addChild(i.getContext());
				i.getContext().parent = ctx;
				RmostPMatom.add(new extendedInfo<AtomContext>(i.getContext(), i.getN(), ctx));
				RmostPMatom.remove(i);
			}
		}
		if (ctx.plusminus() instanceof WaccParser.Expr_bin_plus_atomContext) {
			WaccParser.Expr_bin_plus_atomContext a = (WaccParser.Expr_bin_plus_atomContext) ctx.plusminus();
			TerminalNode atomn = findOP(a);
			if (a.atom(0) instanceof WaccParser.Atom_identContext && !RmostPMatom.isEmpty()) {
				extendedInfo<AtomContext> i = RmostPMatom.getFirst();
				WaccParser.Expr_bin_plus_plusContext p = (WaccParser.Expr_bin_plus_plusContext) i.getParent();
				if (p.MULTIPLY() != null) {
				a.atom(0).parent = i.getParent();
				p.removeLastChild();
				p.addChild(a.atom(0));
				AtomContext two = a.atom(1);
				a.removeLastChild();
				a.removeLastChild();
				a.removeLastChild();
				a.addChild(i.getContext());
				a.addChild(atomn);
				a.addChild(two);
				i.getContext().parent = a;
				RmostPMatom.removeFirst();
				}
			}
			if (a.atom(1) instanceof WaccParser.Atom_identContext && !RmostPMatom.isEmpty()) {
				extendedInfo<AtomContext> i = RmostPMatom.getFirst();
				a.atom(1).parent = i.getParent();
				WaccParser.Expr_bin_plus_plusContext p = (WaccParser.Expr_bin_plus_plusContext) i.getParent();
				p.removeLastChild();
				p.removeLastChild();
				p.addChild(atomn);
				p.addChild(a.atom(1));
				a.removeLastChild();
				a.removeLastChild();
				a.addChild(i.getN());
				a.addChild(i.getContext());
				i.getContext().parent = a;
				RmostPMatom.removeFirst();
			}
		}
		visitChildren(ctx);
		bppCount --;
		if (bppCount == 0) {
			RmostPMatom.clear();
		}
		return null;
	}
	
	private TerminalNode findOP(Expr_bin_plus_atomContext ctx) {
		if (ctx.MOD() != null) {
			return ctx.MOD();
		}
		if (ctx.DIVIDE() != null) {
			return ctx.DIVIDE();
		}
		if (ctx.MULTIPLY() != null) {
			return ctx.MULTIPLY();
		}
		return null;
	}

	private TerminalNode findOP(Expr_bin_plus_plusContext ctx) {
		if (ctx.MOD() != null) {
			return ctx.MOD();
		}
		if (ctx.DIVIDE() != null) {
			return ctx.DIVIDE();
		}
		if (ctx.MULTIPLY() != null) {
			return ctx.MULTIPLY();
		}
		return null;
	}

}
