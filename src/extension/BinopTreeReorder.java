package extension;

import java.util.Iterator;
import java.util.LinkedList;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;

import antlr.WaccParser;
import antlr.WaccParser.AtomContext;
import antlr.WaccParser.Expr_bin_math_mathContext;
import antlr.WaccParser.Expr_bin_plus_atomContext;
import antlr.WaccParser.Expr_bin_plus_plusContext;
import antlr.WaccParser.PlusminusContext;
import antlr.WaccParserBaseVisitor;

public class BinopTreeReorder extends WaccParserBaseVisitor<BTR> {
	
	private LinkedList<extendedInfo<AtomContext>> RmostPMatom = new LinkedList<extendedInfo<AtomContext>>();
	private int bppCount = 0;
	
	private LinkedList<extendedInfo<PlusminusContext>> RmostPMctx = new LinkedList<extendedInfo<PlusminusContext>>();
	private int mathCount = 0;
	
	@Override public BTR visitProgram(@NotNull WaccParser.ProgramContext ctx) { visitChildren(ctx); return new BTR(false,ctx);}
	
	@Override public BTR visitExpr_bin_plus_plus(@NotNull WaccParser.Expr_bin_plus_plusContext ctx) {
		bppCount ++;
		TerminalNode n = findOP(ctx);
		if (!(ctx.atom() instanceof WaccParser.Atom_identContext)) {
			RmostPMatom.add(new extendedInfo<AtomContext>(ctx.atom(), n, ctx));
		} else if (((WaccParser.Atom_identContext) ctx.atom()).ident().constant) {
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
				if (!((WaccParser.Atom_identContext) a.atom(0)).ident().constant) {
					Iterator<extendedInfo<AtomContext>> it = RmostPMatom.iterator();
					boolean found = false;
					while (!found && it.hasNext()) {
					extendedInfo<AtomContext> i = it.next();
					WaccParser.Expr_bin_plus_plusContext p = (WaccParser.Expr_bin_plus_plusContext) i.getParent();
					if (p.MULTIPLY() != null) {
						found = true;
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
						it.remove();
					}
				}
				}
			}
			if (a.atom(1) instanceof WaccParser.Atom_identContext && !RmostPMatom.isEmpty()) {
				if (!((WaccParser.Atom_identContext) a.atom(0)).ident().constant) {
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
		}
		visitChildren(ctx);
		bppCount --;
		if (bppCount == 0) {
			RmostPMatom.clear();
			if (ctx.atom() instanceof WaccParser.Atom_identContext) {
				if (!((WaccParser.Atom_identContext) ctx.atom()).ident().constant) {
					return new BTR(true, null);
				}
			}
		}
		return new BTR(false, null);
	}
	
	@Override public BTR visitExpr_bin_math_math(@NotNull WaccParser.Expr_bin_math_mathContext ctx) {
		mathCount ++;
		TerminalNode n = findOP(ctx);
		boolean constant = isBMMconstant(ctx.plusminus());
		if (constant) {
			RmostPMctx.add(new extendedInfo<PlusminusContext>(ctx.plusminus(), n, ctx));
		}
		if (!constant && !RmostPMctx.isEmpty()) {
			extendedInfo<PlusminusContext> i = RmostPMctx.getFirst();
			ctx.plusminus().parent = i.getParent();
			WaccParser.Expr_bin_math_mathContext p = (WaccParser.Expr_bin_math_mathContext) i.getParent();
			p.removeLastChild();
			p.removeLastChild();
			p.addChild(n);
			p.addChild(ctx.plusminus());
			ctx.removeLastChild();		
			ctx.removeLastChild();
			ctx.addChild(i.getN());
			ctx.addChild(i.getContext());
			i.getContext().parent = ctx;
			RmostPMctx.add(new extendedInfo<PlusminusContext>(i.getContext(), i.getN(), ctx));
			RmostPMctx.remove(i);
		}
		if (ctx.math() instanceof WaccParser.Expr_bin_math_plusminusContext) {
			WaccParser.Expr_bin_math_plusminusContext mpm = (WaccParser.Expr_bin_math_plusminusContext) ctx.math();
			TerminalNode tn = (mpm.PLUS() != null)? mpm.PLUS() : mpm.MINUS();
			if (!isBMMconstant(mpm.plusminus(0)) && !RmostPMctx.isEmpty()) {
				Iterator<extendedInfo<PlusminusContext>> it = RmostPMctx.iterator();
				boolean found = false;
				while (!found && it.hasNext()) {
				extendedInfo<PlusminusContext> i = it.next();
				WaccParser.Expr_bin_math_mathContext p = (WaccParser.Expr_bin_math_mathContext) i.getParent();
				if (p.PLUS() != null) {
					found = true;
					mpm.plusminus(0).parent = i.getParent();
					p.removeLastChild();
					p.addChild(mpm.plusminus(0));
					PlusminusContext two = mpm.plusminus(1);
					mpm.removeLastChild();
					mpm.removeLastChild();
					mpm.removeLastChild();
					mpm.addChild(i.getContext());
					mpm.addChild(tn);
					mpm.addChild(two);
					i.getContext().parent = mpm;
					it.remove();
				}
				}
			}
			if (!isBMMconstant(mpm.plusminus(1)) && !RmostPMctx.isEmpty()) {
				extendedInfo<PlusminusContext> i = RmostPMctx.getFirst();
				mpm.plusminus(1).parent = i.getParent();
				WaccParser.Expr_bin_math_mathContext p = (WaccParser.Expr_bin_math_mathContext) i.getParent();
				p.removeLastChild();
				p.removeLastChild();
				p.addChild(tn);
				p.addChild(mpm.plusminus(1));
				mpm.removeLastChild();
				mpm.removeLastChild();
				mpm.addChild(i.getN());
				mpm.addChild(i.getContext());
				i.getContext().parent = mpm;
				RmostPMctx.removeFirst();
			}
		}
		visitChildren(ctx);
		mathCount --;
		if (mathCount == 0) {
			RmostPMctx.clear();
			if (!isBMMconstant(ctx.plusminus())) {
				return new BTR(true, null);
			}
		}
		return new BTR(false, null);
	}
	
	private boolean isBMMconstant(WaccParser.PlusminusContext ctx) {
		boolean constant = true;
		//find if pm is constant
		// case 1, pm is atom
		if (ctx instanceof WaccParser.Expr_bin_atomContext) {
			WaccParser.Expr_bin_atomContext a = (WaccParser.Expr_bin_atomContext) ctx;
			if (a.atom() instanceof WaccParser.Atom_identContext) {
				// case atom is ident, check if constant var
				if (!((WaccParser.Atom_identContext) a.atom()).ident().constant) {
					constant = false;
				}
			}
		}
		//case 2 pm is a bpp, visit to check
		if (ctx instanceof WaccParser.Expr_bin_plus_plusContext) {
			BTR btr = visit(ctx);
			if (btr.isVariable()) {
				constant = false;
			}
		}
		//case 3 pm is bAtom, check both.
		if (ctx instanceof WaccParser.Expr_bin_plus_atomContext) {
			WaccParser.Expr_bin_plus_atomContext ba = (WaccParser.Expr_bin_plus_atomContext) ctx;
			if (ba.atom(0) instanceof WaccParser.Atom_identContext) {
				constant = constant && ((WaccParser.Atom_identContext) ba.atom(0)).ident().constant;
			}
			if (ba.atom(1) instanceof WaccParser.Atom_identContext) {
				constant = constant && ((WaccParser.Atom_identContext) ba.atom(1)).ident().constant;
			}
		}
		return constant;
	}

	
	private TerminalNode findOP(Expr_bin_math_mathContext ctx) {
		if (ctx.PLUS() != null) {
			return ctx.PLUS();
		}
		if (ctx.MINUS() != null) {
			return ctx.MINUS();
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
