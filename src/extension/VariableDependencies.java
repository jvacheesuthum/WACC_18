package extension;

import java.util.ArrayList;
import java.util.List;

import antlr.WaccParser;

public class VariableDependencies {
	
	private WaccParser.Stat_declareContext declare;
	private boolean constant = true;
	private List<WaccParser.Expr_identContext> exprs = new ArrayList<WaccParser.Expr_identContext>();
	private List<WaccParser.Atom_identContext> atoms = new ArrayList<WaccParser.Atom_identContext>();
	private List<VariableDependencies> subscribers = new ArrayList<VariableDependencies>();

	public VariableDependencies(WaccParser.Stat_declareContext declare) {
		this.declare = declare;
	}
	
	public void addExpr(WaccParser.Expr_identContext ctx) {
		exprs.add(ctx);
	}
	
	public void addAtom(WaccParser.Atom_identContext ctx) {
		atoms.add(ctx);
	}
	
	public void addSubscriber(VariableDependencies v) {
		subscribers.add(v);
	}
	
	//-----------------getters------------------------------------------------------

	public WaccParser.Stat_declareContext getDeclare() {
		return declare;
	}

	public List<WaccParser.Expr_identContext> getExprs() {
		return exprs;
	}

	public List<WaccParser.Atom_identContext> getAtoms() {
		return atoms;
	}
	
	public boolean isConstant() {
		return constant;
	}
	
	public void notConstant() {
		constant = false;
		for (VariableDependencies v : subscribers) {
			System.out.println("notifying subscriber: " + v.getDeclare().ident().getText());
			v.notConstant();
		}
	}

}
