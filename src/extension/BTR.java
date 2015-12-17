package extension;

import antlr.WaccParser;

public class BTR {
	
	private boolean isVariable;
	private WaccParser.ProgramContext ctx;
	
	public BTR(boolean isVariable, WaccParser.ProgramContext ctx) {
		this.isVariable = isVariable;
		this.ctx = ctx;
	}

	public boolean isVariable() {
		return isVariable;
	}

	public WaccParser.ProgramContext getCtx() {
		return ctx;
	}

}
