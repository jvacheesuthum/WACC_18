package extension;

import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;


public class extendedInfo<T> {
	private T context;
	private RuleContext parent;
	private TerminalNode n;
	
	public extendedInfo(T context, TerminalNode n, RuleContext parent) {
		this.context = context;
		this.n = n;
		this.parent = parent;
	}

	public T getContext() {
		return context;
	}
	
	public TerminalNode getN() {
		return n;
	}

	public RuleContext getParent() {
		return parent;
	}
	
	public void setParent(RuleContext parent) {
		this.parent = parent;
	}

}
