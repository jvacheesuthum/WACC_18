package backEnd;

import java.util.ArrayList;
import java.util.List;

public class InstrBuilder {
	
	private List<InstructionFragment> instructions;
	private VariableFragment variable;
	private PositionFragment pos;
	
	public InstrBuilder instr() {
		return new InstrBuilder();
	}
	
	public Instruction build() {
		instructions.add(new StringFragment("\n"));
		if (variable == null && pos == null) {
			String output = "";
			for (InstructionFragment str : instructions) {
				assert str instanceof StringFragment;
				output += str.getString();
			}
			return new Instruction(output);
		}
		if (pos == null) {
			assert variable != null;
			return new Instruction(instructions, variable);
		}
		return new Instruction(instructions, variable, pos);
	}
	
	private void add(InstructionFragment f) {
		if (instructions == null) {
			instructions = new ArrayList<InstructionFragment>();
		}
		instructions.add(f);
	}
	
	public InstrBuilder withString(String s) {
		add(new StringFragment(s));
		return this;
	}
	
	public InstrBuilder withVar(String s) {
		assert variable == null: "already has variable!";
		assert pos == null: "already has pos!";
		variable = new VariableFragment(s);
		add(variable);
		return this;
	}
	
	public InstrBuilder withVarCallOffset(String s, int offset) {
		assert variable == null: "already has variable!";
		assert pos == null: "already has pos!";
		variable = new VariableFragment(s, offset);
		add(variable);
		return this;
	}
	
	public InstrBuilder withVarDec(String var, int size) {
		assert variable == null: "already has variable!";
		assert pos == null: "already has pos!";
		variable = new VariableFragment(var);
		pos = new PositionFragment(size);
		add(pos);
		return this;
	}
	
	public InstrBuilder ldrInt(int dest, int i) {
		add(new StringFragment("LDR r" + dest + ", =" + i));
		return this;
	}
	
	public InstrBuilder ldrVar(int dest, String var) {
		variable = new VariableFragment(var);
		add(new StringFragment("LDR r" + dest + ", [sp"));
		add(variable);
		add(new StringFragment("]"));
		return this;
	}
	
	public InstrBuilder ldrVarOffset(int dest, String var, int offset) {
		variable = new VariableFragment(var, offset);
		add(new StringFragment("LDR r" + dest + ", [sp"));
		add(variable);
		add(new StringFragment("]"));
		return this;
	}
	
	public InstrBuilder ldrsbVarOffset(int typesize, int dest, String var, int offset) {
		variable = new VariableFragment(var, offset);
		String load = (typesize == 4)? "LDR" : "LDRSB";
		add(new StringFragment(load + " r" + dest + ", [sp"));
		add(variable);
		add(new StringFragment("]"));
		return this;
	}
	
	public InstrBuilder movBasic(int dest, String s) {
		add(new StringFragment("MOV r" + dest + ", #" + s));
		return this;
	}
	
	public InstrBuilder movReg(int dest, int src) {
		add(new StringFragment("MOV r" + dest + ", r" + src));
		return this;
	}
	
	public InstrBuilder binop(String op, int dest, int src) {
		add(new StringFragment(op + " r" + dest + ", r" + src));
		return this;
	}

}
