
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import SemanticAnalyser.*;
import antlr.WaccParser;
import backEnd.*;


public class OptimisedWaccVisitor extends MyWaccVisitor {

	public OptimisedWaccVisitor(String filename) {
		super(filename);
	}
	
    @Override 
    public Info visitStat_declare(@NotNull WaccParser.Stat_declareContext ctx) {
    	if (prints) System.out.println("visitStat_declare");
    	
    	// constant optimisation. variables that are constant will not be declared.
		List<Instruction> savedList = currentList;
    	if (ctx.ident().constant) {
    		// put a dummy list to throw away.
    		currentList = new LinkedList<Instruction>();
    	}
    	// end of optimisation
  	
      WaccParser.Assign_rhsContext rhs = ctx.assign_rhs();
      visit(rhs);
      if (prints) System.out.println("SEP: ");
      visit(ctx.type());

      if (prints) System.out.println("After visit declare lhs and rhs");
      if (prints) System.out.println("declare rhs: " + rhs.typename);
      if (prints) System.out.println("declare lhs: " + ctx.type().typename);
      
      //---------------------- catching declaration of array with empty array ie int[] x = [] should be fine
      
      if(ctx.type().typename instanceof ARRAY_TYPE) {
        if(rhs.typename instanceof ARRAY_TYPE) {
          if(((ARRAY_TYPE)rhs.typename).TYPE() == null){
            VARIABLE var = new VARIABLE(rhs.typename);
            currentTable.add(ctx.ident().getText(), var);
            return null;
          }
        }
      }
      //------------------------
      
      if(rhs.typename == null) {
    	  rhs.typename = new NULL();
      }
      
      if(!SharedMethods.assignCompat(ctx.type().typename, rhs.typename)) {
 //   	  throw new Error("Different type");
      	  System.exit(200);
      }

      if (currentTable.lookup(ctx.ident().getText()) != null) {
 //   	  throw new Error("Variable already declared");
    	  if (prints) System.out.println("var already declared: " + ctx.ident().getText());
      	  System.exit(200);
      }

      VARIABLE var = new VARIABLE(rhs.typename);
      currentTable.add(ctx.ident().getText(), var);
  	if (!ctx.ident().constant) {
      int i = typeSize(ctx.type().typename);
      PositionFragment position= new PositionFragment(i);
      stackTotal += i;
      if (i == 1) {
    	  currentList.add(new Instruction(Arrays.asList(new StringFragment("STRB r"+ regCount + ", [sp"), position, new StringFragment("]\n")), new VariableFragment(ctx.ident().getText()), position));
      } else {
    	 currentList.add(new Instruction(Arrays.asList(new StringFragment("STR r" + regCount + ", [sp"), position, new StringFragment("]\n")), new VariableFragment(ctx.ident().getText()), position));
      }
      
      if (rhs.typename instanceof NULL) {
          currentList.add(new Instruction("LDR r"+ regCount + (fstVisited ? ", [sp, #4]\n" : ", [sp]\n")));
          fstVisited = false;
      }
      if (rhs.typename instanceof NULL && ctx.type().typename instanceof PAIR_TYPE) {
    	  newpairs++; //<--- need this whenever there is a new pair, tried moving it out but causes other things to break
    	  System.out.println("LHS IS NULL RHS IS PAIRR");
      }
	}
  	// constant optimisation. variables that are constant will not be declared.
  	if (ctx.ident().constant) {
		// restore previous list, throw away any declarations
		currentList = savedList;
	}
	// end of optimisation
      
  	  return null;
    }
	
	@Override public Info visitExpr_bin_plus_plus(@NotNull WaccParser.Expr_bin_plus_plusContext ctx) {
		if (prints) System.out.println("visitExpr_bin_math_math");
		Info m = visit(ctx.plusminus());
		Info a = visit(ctx.atom());
		ctx.returntype = new INT();
		ctx.argtype = new INT();
		if(!SharedMethods.assignCompat(ctx.plusminus().returntype, ctx.argtype)) {
			System.exit(200);
		}
		if(!SharedMethods.assignCompat(ctx.atom().typename, ctx.argtype)) {
			System.exit(200);
		}
		
		// Constant Evaluation
		if (m.type.equals("int")) {
			if (a.type.equals("int")) {
				if (ctx.MULTIPLY() != null) {
					return new Info(doMath("multiply", m.int_value, a.int_value));
				}
				if (ctx.DIVIDE() != null) {
					return new Info(doMath("divide", m.int_value, a.int_value));
				}
				if (ctx.MOD() != null) {
					return new Info(doMath("mod", m.int_value, a.int_value));
				}
				assert false;
			} else {
				currentList.add(new Instruction("LDR r" + regCount + ", =" + m.int_value + "\n"));
			}
		}
		// end of optimisation
		
		if (a.type.equals("int")) {
			currentList.add(new Instruction("LDR r" + (regCount + 1) + ", =" + a.int_value + "\n"));
		} else if (a.type.equals("reg")) {
			//do nothing
		} else {
			assert a.type.equals("var");
//			VariableFragment v  = new VariableFragment(a.stringinfo, funcCallOffset);
//			currentList.add(new Instruction(Arrays.asList(new StringFragment("LDR r" + (regCount + 1) + ", [sp"), v, new StringFragment("]\n")), v));
			currentList.add(ib.instr().ldrVarOffset(regCount +1, a.stringinfo, funcCallOffset).build());
		}
		if (ctx.MULTIPLY() != null) {
			err.pOverflow();
			currentList.add(ib.instr().qop("SMULL", regCount, regCount+1, regCount, regCount+1).build());
			currentList.add(new Instruction("CMP r" + (regCount + 1) + ", r" + regCount + ", ASR #31\nBLNE p_throw_overflow_error\n"));
		}
		if (ctx.DIVIDE() != null) {
			err.pDivZero();
			currentList.add(ib.instr().movReg(0, regCount).build());
			currentList.add(ib.instr().movReg(1, regCount+1).build());
			currentList.add(new Instruction("BL p_check_divide_by_zero\nBL __aeabi_idiv\n"));
			currentList.add(ib.instr().movReg(regCount, 0).build());
//			currentList.add(new Instruction("MOV r0, r" + regCount + "\nMOV r1, r" + (regCount + 1) + "\nBL p_check_divide_by_zero\nBL __aeabi_idiv\nMOV r" + regCount + ", r0\n"));
		}
		if (ctx.MOD() != null) {
			err.pDivZero();
			currentList.add(ib.instr().movReg(0, regCount).build());
			currentList.add(ib.instr().movReg(1, regCount+1).build());
			currentList.add(new Instruction("BL p_check_divide_by_zero\nBL __aeabi_idivmod\n"));
			currentList.add(ib.instr().movReg(regCount, 1).build());
//			currentList.add(new Instruction("MOV r0, r" + regCount + "\nMOV r1, r" + (regCount + 1) + "\nBL p_check_divide_by_zero\nBL __aeabi_idivmod\nMOV r" + regCount + ", r1\n"));
		}
		
		return (new Info("r" + regCount)).setType("reg"); 
	}

	
	@Override public Info visitExpr_bin_plus_atom(@NotNull WaccParser.Expr_bin_plus_atomContext ctx) {
		if (prints) System.out.println("visitExpr_bin_plus_atom");
		Info one = visit(ctx.atom(0));
		Info two = visit(ctx.atom(1));
		ctx.returntype = new INT();
		ctx.argtype = new INT();
		if(!SharedMethods.assignCompat(ctx.atom(0).typename, ctx.argtype)) {
			if (prints) System.out.println("got " +  ctx.atom(0).typename);
			System.exit(200);
		}
		if (prints) System.out.println("HERE: " + ctx.atom(1).typename);
		if(!SharedMethods.assignCompat(ctx.atom(1).typename, ctx.argtype)) {
			System.exit(200);
		}
		
		// Constant Evaluation
		if (one.type.equals("int") && two.type.equals("int")) {
			if (ctx.MULTIPLY() != null) {
					return new Info(doMath("multiply", one.int_value, two.int_value));
			}
			if (ctx.DIVIDE() != null) {
					return new Info(doMath("divide", one.int_value, two.int_value));
			}
			if (ctx.MOD() != null) {
					return new Info(doMath("mod", one.int_value, two.int_value));
			}
				assert false;
		}
		// end of optimisation	
		
		
		if (one.type.equals("int")) {
			currentList.add(new Instruction("LDR r" + regCount + ", =" + one.int_value + "\n"));
		} else if (one.type.equals("reg")) {
			//do nothing
		} else {
			assert one.type.equals("var");
//			VariableFragment v  = new VariableFragment(one.stringinfo, funcCallOffset);
//			currentList.add(new Instruction(Arrays.asList(new StringFragment("LDR r" + regCount + ", [sp"), v, new StringFragment("]\n")), v));
			currentList.add(ib.instr().ldrVarOffset(regCount, one.stringinfo, funcCallOffset).build());
		}
		if (two.type.equals("int")) {
			currentList.add(new Instruction("LDR r" + (regCount + 1) + ", =" + two.int_value + "\n"));
		} else if (two.type.equals("reg")) {
			//do nothing
		} else {
			assert two.type.equals("var");
//			VariableFragment v  = new VariableFragment(two.stringinfo, funcCallOffset);
//			currentList.add(new Instruction(Arrays.asList(new StringFragment("LDR r" + (regCount + 1) + ", [sp"), v, new StringFragment("]\n")), v));
			currentList.add(ib.instr().ldrVarOffset(regCount +1, two.stringinfo, funcCallOffset).build());
		}
		if (ctx.MULTIPLY() != null) {
			err.pOverflow();
			currentList.add(ib.instr().qop("SMULL", regCount, regCount+1, regCount, regCount+1).build());
			currentList.add(new Instruction("CMP r" + (regCount + 1) + ", r" + regCount + ", ASR #31\nBLNE p_throw_overflow_error\n"));
		}
		if (ctx.DIVIDE() != null) {
			err.pDivZero();
			currentList.add(ib.instr().movReg(0, regCount).build());
			currentList.add(ib.instr().movReg(1, regCount+1).build());
			currentList.add(new Instruction("BL p_check_divide_by_zero\nBL __aeabi_idiv\n"));
			currentList.add(ib.instr().movReg(regCount, 0).build());
//			currentList.add(new Instruction("MOV r0, r" + regCount + "\nMOV r1, r" + (regCount + 1) + "\nBL p_check_divide_by_zero\nBL __aeabi_idiv\nMOV r" + regCount + ", r0\n"));
		}
		if (ctx.MOD() != null) {
			err.pDivZero();
			currentList.add(ib.instr().movReg(0, regCount).build());
			currentList.add(ib.instr().movReg(1, regCount+1).build());
			currentList.add(new Instruction("BL p_check_divide_by_zero\nBL __aeabi_idivmod\n"));
			currentList.add(ib.instr().movReg(regCount, 1).build());
//			currentList.add(new Instruction("MOV r0, r" + regCount + "\nMOV r1, r" + (regCount + 1) + "\nBL p_check_divide_by_zero\nBL __aeabi_idivmod\nMOV r" + regCount + ", r1\n"));
		}
				
		return (new Info("r" + regCount)).setType("reg"); 
	}

	@Override public Info visitExpr_bin_math_math(@NotNull WaccParser.Expr_bin_math_mathContext ctx) {
		if (prints) System.out.println("visitExpr_bin_math_math");
		Info p = visit(ctx.math());
		regCount ++ ;
		Info a = visit(ctx.plusminus());
		regCount --;
		ctx.returntype = new INT();
		ctx.argtype = new INT();
		if(!SharedMethods.assignCompat(ctx.math().returntype, ctx.argtype)) {
			System.exit(200);
		}
		if(!SharedMethods.assignCompat(ctx.plusminus().returntype, ctx.argtype)) {
			System.exit(200);
		}
		
		// Constant Evaluation
		if (p.type.equals("int") && a.type.equals("int")) {
			int constant = doMath((ctx.PLUS() != null)? "plus" : "minus", p.int_value, a.int_value);
			return new Info(constant);
		}
		if (p.type.equals("int")) {
			currentList.add(new Instruction("LDR r" + regCount + ", =" + p.int_value + "\n"));
		}
		// end of optimisation
		
		if (a.type.equals("int")) {
			currentList.add(new Instruction("LDR r" + (regCount + 1) + ", =" + a.int_value + "\n"));
		} else if (a.type.equals("reg")) {
			//do nothing
		} else {
			assert a.type.equals("var");
//			VariableFragment v  = new VariableFragment(a.stringinfo, funcCallOffset);
//			currentList.add(new Instruction(Arrays.asList(new StringFragment("LDR r" + (regCount + 1) + ", [sp"), v, new StringFragment("]\n")), v));
			currentList.add(ib.instr().ldrVarOffset(regCount +1, a.stringinfo, funcCallOffset).build());
		}
		if (ctx.PLUS() != null) {
			err.pOverflow();
			currentList.add(ib.instr().triop("ADDS", regCount, regCount+1).build());
			currentList.add(new Instruction("BLVS p_throw_overflow_error\n"));
			}
		if (ctx.MINUS() != null) {
			err.pOverflow();
			currentList.add(ib.instr().triop("SUBS", regCount, regCount+1).build());
			currentList.add(new Instruction("BLVS p_throw_overflow_error\n"));
		}
		
		return (new Info("r" + regCount)).setType("reg"); 
	}
	
	@Override public Info visitExpr_bin_math_plusminus(@NotNull WaccParser.Expr_bin_math_plusminusContext ctx) {
		if (prints) System.out.println("visitExpr_bin_math_plusminus");
		Info one = visit(ctx.plusminus(0));
		if (one.type.equals("reg")) {regCount++;}
		Info two = visit(ctx.plusminus(1));
		if (two.type.equals("reg")) {regCount++;}
		ctx.returntype = new INT();
		ctx.argtype = new INT();
		if(!SharedMethods.assignCompat(ctx.plusminus(0).returntype, ctx.argtype)) {
			if (prints) System.out.println("got " +  ctx.plusminus(0).returntype);
			System.exit(200);
		}
		if (prints) System.out.println("HERE: " + ctx.plusminus(1).returntype);
		if(!SharedMethods.assignCompat(ctx.plusminus(1).returntype, ctx.argtype)) {
			System.exit(200);
		}
		
		// Constant Evaluation
		if (one.type.equals("int") && two.type.equals("int")) {
			System.out.println("gere");
			int constant = doMath((ctx.PLUS() != null)? "plus" : "minus", one.int_value, two.int_value);
			return new Info(constant);
		}
		// end of optimisation
		
		
		if (one.type.equals("int")) {
			currentList.add(new Instruction("LDR r" + regCount + ", =" + one.int_value + "\n"));
			regCount ++;
		} else if (one.type.equals("reg")) {
			//do nothing
		} else {
			assert one.type.equals("var");
//			VariableFragment v  = new VariableFragment(one.stringinfo, funcCallOffset);
//			currentList.add(new Instruction(Arrays.asList(new StringFragment("LDR r" + regCount + ", [sp"), v, new StringFragment("]\n")), v));
			currentList.add(ib.instr().ldrVarOffset(regCount, one.stringinfo, funcCallOffset).build());
			regCount ++;
		}
		if (two.type.equals("int")) {
			currentList.add(new Instruction("LDR r" + regCount + ", =" + two.int_value + "\n"));
			regCount ++;
		} else if (two.type.equals("reg")) {
			//do nothing
		} else {
			assert two.type.equals("var");
//			VariableFragment v  = new VariableFragment(two.stringinfo, funcCallOffset);
//			currentList.add(new Instruction(Arrays.asList(new StringFragment("LDR r" + regCount + ", [sp"), v, new StringFragment("]\n")), v));
			currentList.add(ib.instr().ldrVarOffset(regCount, two.stringinfo, funcCallOffset).build());
			regCount ++;
		}
		if (ctx.PLUS() != null) {
			err.pOverflow();
			currentList.add(ib.instr().triop("ADDS", regCount-2, regCount-1).build());
			currentList.add(new Instruction("BLVS p_throw_overflow_error\n"));
			}
		if (ctx.MINUS() != null) {
			err.pOverflow();
			currentList.add(ib.instr().triop("SUBS", regCount-2, regCount-1).build());
			currentList.add(new Instruction("BLVS p_throw_overflow_error\n"));
		}
		
		regCount = regCount -2;
		return (new Info("r" + regCount)).setType("reg"); 
	}

	private int doMath(String operation, int x, int y) {
		try {
			switch (operation) {
			case "plus" : return Math.addExact(x, y);
			case "minus" : return Math.subtractExact(x, y);
			case "multiply" : return Math.multiplyExact(x, y);
			case "divide" : return (y == 0)? divByZero() : x / y;
			case "mod" : return (y == 0)? divByZero() : x % y;
			}
		} catch (ArithmeticException e) {
			err.pOverflow();
			currentList.add(new Instruction("BL p_throw_overflow_error\n"));
		}
		assert false;
		return 0;
	}
	
	private int divByZero() {
			err.pOptDivZero();
			currentList.add(new Instruction("BL p_divided_by_zero\n"));
			return 0;
	}
	
	@Override public Info visitExpr_binary(@NotNull WaccParser.Expr_binaryContext ctx) { 
		if (prints) System.out.println("visitExpr_binary");
		Info i = visit(ctx.bin_bool());
		ctx.typename = ctx.bin_bool().returntype;
		if (i.type.equals("int")) {
			currentList.add(new Instruction("LDR r" + regCount + ", =" + i.int_value + "\n"));
		} 
		if (i.type.equals("bool")) {
			currentList.add(new Instruction("MOV r" + regCount + ", #" + (i.b_value ? 1 : 0) + "\n"));
		}

		return i;
	}
	
	@Override public Info visitExpr_bin_bool(@NotNull WaccParser.Expr_bin_boolContext ctx) {
		if (prints) System.out.println("visitExpr_bin_bool_bool");
		Info one = visit(ctx.bin_bool(0));
		if (one.type.equals("reg")) {
			regCount ++;
			System.out.println("5");
		} else {assert false;}
		Info two = visit(ctx.bin_bool(1));
		if (two.type.equals("reg"))  {
			regCount ++;
			System.out.println("6");
		} else {assert false;}
		
		ctx.returntype = new BOOL();
		ctx.argtype = new BOOL();
		if(!SharedMethods.assignCompat(ctx.bin_bool(0).returntype, ctx.argtype)) {
			System.exit(200);
		}
		if(!SharedMethods.assignCompat(ctx.bin_bool(1).returntype, ctx.argtype)) {
			System.exit(200);
		}
		
		// Constant evaluation
		if (one.type.equals("bool") && two.type.equals("bool")) {
			return new Info((ctx.AND() != null)? one.b_value && two.b_value : one.b_value || two.b_value);
		}
		// end of optimisation
		
		if (ctx.AND() != null) {
			currentList.add(ib.instr().triop("AND", regCount-2, regCount-1).build());
//			currentList.add(new Instruction("AND r" + (regCount - 2) + ", r" + (regCount - 2) + ", r" + (regCount - 1) + "\n"));
		}
		if (ctx.OR() != null) {
			currentList.add(ib.instr().triop("ORR", regCount-2, regCount-1).build());
//			currentList.add(new Instruction("ORR r" + (regCount - 2) + ", r" + (regCount - 2) + ", r" + (regCount - 1) + "\n"));
		}
		regCount = regCount -2;
		return new Info("r" + regCount).setType("reg"); 
	}
	
	@Override public Info visitExpr_bin_bool_bool(@NotNull WaccParser.Expr_bin_bool_boolContext ctx) {
		if (prints) System.out.println("visitExpr_bin_bool_bool");
		Info b = visit(ctx.bin_bool());
		if (b.type.equals("reg")) {
			regCount ++;
			System.out.println("5");
		}
		Info m = visit(ctx.math());
		if (m.type.equals("reg"))  {
			regCount ++;
			System.out.println("6");
		}
		
		ctx.returntype = new BOOL();
		ctx.argtype = new BOOL();
		if(!SharedMethods.assignCompat(ctx.bin_bool().returntype, ctx.argtype)) {
			System.exit(200);
		}
		if(!SharedMethods.assignCompat(ctx.math().returntype, ctx.argtype)) {
			System.exit(200);
		}
		
		// Constant evaluation
		if (b.type.equals("bool") && m.type.equals("bool")) {
			return new Info((ctx.AND() != null)? b.b_value && m.b_value : b.b_value || m.b_value);
		}		
		// end of optimisation
		
		if (b.type.equals("bool")) {
			currentList.add(new Instruction("MOV r" + regCount + ", #" + (b.b_value ? 1 : 0) + "\n"));
			regCount ++;
			System.out.println("1");
		} else if (b.type.equals("var")){
//			VariableFragment v  = new VariableFragment(b.stringinfo, funcCallOffset);
//			String load = (typeSize(ctx.bin_bool().returntype) == 4)? "LDR" : "LDRSB";
//			currentList.add(new Instruction(Arrays.asList(new StringFragment(load + " r" + regCount + ", [sp"), v, new StringFragment("]\n")), v));
			currentList.add(ib.instr().ldrsbVarOffset(typeSize(ctx.bin_bool().returntype), regCount, b.stringinfo, funcCallOffset).build());
			regCount++;
			System.out.println("2");
		}
		if(m.type.equals("bool")) {
			currentList.add(new Instruction("MOV r" + regCount + ", #" + (m.b_value ? 1 : 0) + "\n"));
			regCount ++;
			System.out.println("3");
		} else if (m.type.equals("var")){
//			VariableFragment v  = new VariableFragment(m.stringinfo, funcCallOffset);
//			String load = (typeSize(ctx.math().returntype) == 4)? "LDR" : "LDRSB";
//			currentList.add(new Instruction(Arrays.asList(new StringFragment(load + " r" + regCount + ", [sp"), v, new StringFragment("]\n")), v));
			currentList.add(ib.instr().ldrsbVarOffset(typeSize(ctx.math().returntype), regCount, m.stringinfo, funcCallOffset).build());
			regCount++;
			System.out.println("4");
		}
		
		if (ctx.AND() != null) {
			currentList.add(ib.instr().triop("AND", regCount-2, regCount-1).build());
//			currentList.add(new Instruction("AND r" + (regCount - 2) + ", r" + (regCount - 2) + ", r" + (regCount - 1) + "\n"));
		}
		if (ctx.OR() != null) {
			currentList.add(ib.instr().triop("ORR", regCount-2, regCount-1).build());
//			currentList.add(new Instruction("ORR r" + (regCount - 2) + ", r" + (regCount - 2) + ", r" + (regCount - 1) + "\n"));
		}
		regCount = regCount -2;
		return new Info("r" + regCount).setType("reg"); 
	}
	
	@Override 
	public Info visitExpr_bin_bool_math_eq(@NotNull WaccParser.Expr_bin_bool_math_eqContext ctx) { 
		if (prints) System.out.println("visitExpr_bin_bool_math_eq");
		Info one = visit(ctx.math(0));
		if (one.type.equals("reg")) {
			regCount ++;
			System.out.println("5");
		}
		Info two = visit(ctx.math(1));
		if (two.type.equals("reg"))  {
			regCount ++;
			System.out.println("6");
		}

		ctx.returntype = new BOOL();
		ctx.argtype = new EQUALITY();
		
		if(!SharedMethods.assignCompat(ctx.math(0).returntype, ctx.math(1).returntype)) {
			System.exit(200);
		}

		if(!ctx.argtype.getClass().isAssignableFrom(ctx.math(0).returntype.getClass())) {

			System.exit(200);
		}
		
		// Constant Evaluation
		if (one.type.equals("int") && two.type.equals("int")) {
			boolean result = one.int_value == two.int_value;
			return new Info((ctx.IS_EQUAL() != null)? result : !result);
		}
		if (one.type.equals("char") && two.type.equals("char")) {
			boolean result = one.stringinfo.equals(two.stringinfo);
			return new Info((ctx.IS_EQUAL() != null)? result : !result);
		}
		if (one.type.equals("bool") && two.type.equals("bool")) {
			boolean result = one.b_value == two.b_value;
			return new Info((ctx.IS_EQUAL() != null)? result : !result);
		}
		// end of optimisation
		
		if(ctx.math(0).returntype instanceof NULL || ctx.math(1).returntype instanceof NULL) {
			regCount++;
//			VariableFragment v  = new VariableFragment(one.stringinfo, funcCallOffset);
//			currentList.add(new Instruction(Arrays.asList(new StringFragment("LDR r" + regCount + ", [sp"), v, new StringFragment("]\n")), v));
			currentList.add(ib.instr().ldrVarOffset(regCount, one.stringinfo, funcCallOffset).build());
			regCount++;
			
			currentList.add(new Instruction("CMP r" + (regCount - 2) + ", r" + (regCount - 1) + "\n"));
			if (ctx.IS_EQUAL() != null) {
				currentList.add(ib.instr().movop("EQ", regCount-2, 1).build());
				currentList.add(ib.instr().movop("NE", regCount-2, 0).build());
//				currentList.add(new Instruction("MOVEQ r" + (regCount - 2) + ", #1\nMOVNE r" + (regCount - 2) + ", #0\n"));
			}
			if (ctx.NOT_EQUAL() != null) {
				currentList.add(ib.instr().movop("NE", regCount-2, 1).build());
				currentList.add(ib.instr().movop("EQ", regCount-2, 0).build());
//				currentList.add(new Instruction("MOVNE r" + (regCount - 2) + ", #1\nMOVEQ r" + (regCount - 2) + ", #0\n"));
			}
			regCount = regCount -2;
			
//			//back end while
//			if(inWhile) {
//				currentList.add(new Instruction("CMP r" + regCount + ", #1\nBEQ L" + (whileCount + 1) + "\n"));
//			}
			return new Info("r" + regCount).setType("reg"); 
		}
		
		if (one.type.equals("int")) {
			currentList.add(new Instruction("LDR r" + regCount + ", =" + one.int_value + "\n"));
			regCount ++;
			System.out.println("1");
		} else if (one.type.equals("bool")) {
			currentList.add(new Instruction("MOV r" + regCount + ", #" + (one.b_value ? 1 : 0) + "\n"));
			regCount ++;
			System.out.println("1");
		} else if (one.type.equals("char")) {
			currentList.add(new Instruction("MOV r" + regCount + ", #" + one.stringinfo + "\n"));
			regCount ++;
			System.out.println("1");
		} else if (one.type.equals("var")){
			
//			VariableFragment v  = new VariableFragment(one.stringinfo, funcCallOffset);
//			String load = (typeSize(ctx.math(0).returntype) == 4)? "LDR" : "LDRSB";
//			currentList.add(new Instruction(Arrays.asList(new StringFragment(load + " r" + regCount + ", [sp"), v, new StringFragment("]\n")), v));
			currentList.add(ib.instr().ldrsbVarOffset(typeSize(ctx.math(0).returntype), regCount, one.stringinfo, funcCallOffset).build());
			regCount++;
			System.out.println("2");
		}
		if (two.type.equals("int")) {
			currentList.add(new Instruction("LDR r" + regCount + ", =" + two.int_value + "\n"));
			regCount++;
			System.out.println("3");
		} else if(two.type.equals("bool")) {
			currentList.add(new Instruction("MOV r" + regCount + ", #" + (two.b_value ? 1 : 0) + "\n"));
			regCount ++;
			System.out.println("3");
		} else if(two.type.equals("char")) {
			if(two.stringinfo.length() > 3) {
				two.stringinfo = two.stringinfo.replace("\\n", "\n");
				two.stringinfo = two.stringinfo.replace("\\0", "\0");
				two.stringinfo = two.stringinfo.replace("\\b", "\b");
				two.stringinfo = two.stringinfo.replace("\\t", "\t");
				two.stringinfo = two.stringinfo.replace("\\f", "\f");
				two.stringinfo = two.stringinfo.replace("\\r", "\"");
				char c = two.stringinfo.charAt(1);
				int ascii = (int) c;
				currentList.add(new Instruction("MOV r" + regCount + ", #"  + ((ascii > 13)? "\'" + two.stringinfo.charAt(2) + "\'": String.valueOf(ascii)) + "\n"));
			} else {
				currentList.add(new Instruction("MOV r" + regCount + ", #" + two.stringinfo + "\n"));
			}
			regCount ++;
			System.out.println("3");
		} else if (two.type.equals("var")){
//			VariableFragment v  = new VariableFragment(two.stringinfo, funcCallOffset);
//			String load = (typeSize(ctx.math(1).returntype) == 4)? "LDR" : "LDRSB";
//			currentList.add(new Instruction(Arrays.asList(new StringFragment(load + " r" + regCount + ", [sp"), v, new StringFragment("]\n")), v));
			currentList.add(ib.instr().ldrsbVarOffset(typeSize(ctx.math(1).returntype), regCount, two.stringinfo, funcCallOffset).build());
			regCount++;
			System.out.println("4");
		}
		
		currentList.add(new Instruction("CMP r" + (regCount - 2) + ", r" + (regCount - 1) + "\n"));
		if (ctx.IS_EQUAL() != null) {
			currentList.add(ib.instr().movop("EQ", regCount-2, 1).build());
			currentList.add(ib.instr().movop("NE", regCount-2, 0).build());
//			currentList.add(new Instruction("MOVEQ r" + (regCount - 2) + ", #1\nMOVNE r" + (regCount - 2) + ", #0\n"));
		}
		if (ctx.NOT_EQUAL() != null) {
			currentList.add(ib.instr().movop("NE", regCount-2, 1).build());
			currentList.add(ib.instr().movop("EQ", regCount-2, 0).build());
//			currentList.add(new Instruction("MOVNE r" + (regCount - 2) + ", #1\nMOVEQ r" + (regCount - 2) + ", #0\n"));
		}
		regCount = regCount -2;
		
//		//back end while
//		if(inWhile) {
//			currentList.add(new Instruction("CMP r" + regCount + ", #1\nBEQ L" + (whileCount + 1) + "\n"));
//		}
		return new Info("r" + regCount).setType("reg"); 
	}

	@Override 
	public Info visitExpr_bin_bool_math_moreless(@NotNull WaccParser.Expr_bin_bool_math_morelessContext ctx) { 
		if (prints) System.out.println("visitExpr_bin_bool_math_moreless");
		Info one = visit(ctx.math(0));
		if (one.type.equals("reg")) {
			regCount ++;
			System.out.println("5");
		}
		Info two = visit(ctx.math(1));
		if (two.type.equals("reg"))  {
			regCount ++;
			System.out.println("6");
		}
		System.out.println("one is " + one.type);
		System.out.println("two is " + two.type);

		if(ctx.math(0).returntype instanceof PAIR_TYPE || 
				ctx.math(0).returntype instanceof ARRAY_TYPE ||
				ctx.math(1).returntype instanceof PAIR_TYPE ||
				ctx.math(1).returntype instanceof ARRAY_TYPE) {
			System.exit(200);
		}
				
		
		ctx.returntype = new BOOL();
		ctx.argtype = new EQUALITY();
		
		if(!SharedMethods.assignCompat(ctx.math(0).returntype, ctx.math(1).returntype)) {
			System.exit(200);
		}

		if(!ctx.argtype.getClass().isAssignableFrom(ctx.math(0).returntype.getClass())) {

			System.exit(200);
		}
		
		// Constant Evaluation
		if (one.type.equals("int") && two.type.equals("int")) {
			if (ctx.LESS() != null) {
				return new Info(one.int_value < two.int_value);
			}
			if (ctx.LESS_EQUAL() != null) {
				return new Info(one.int_value <= two.int_value);
			}
			if (ctx.GREATER_EQUAL() != null) {
				return new Info(one.int_value >= two.int_value);
			}
			if (ctx.GREATER() != null) {
				return new Info(one.int_value > two.int_value);
			}
			assert false;
		}
		// end of optimisation
		
		if (one.type.equals("int")) {
			currentList.add(new Instruction("LDR r" + regCount + ", =" + one.int_value + "\n"));
			regCount ++;
			System.out.println("1");
		} else if (one.type.equals("char")) {
			currentList.add(new Instruction("MOV r" + regCount + ", #" + one.stringinfo + "\n"));
			regCount ++;
		} else if (one.type.equals("var")){
//			VariableFragment v  = new VariableFragment(one.stringinfo, funcCallOffset);
//			String load = (typeSize(ctx.math(0).returntype) == 4)? "LDR" : "LDRSB";
//			currentList.add(new Instruction(Arrays.asList(new StringFragment(load + " r" + regCount + ", [sp"), v, new StringFragment("]\n")), v));
			currentList.add(ib.instr().ldrsbVarOffset(typeSize(ctx.math(0).returntype), regCount, one.stringinfo, funcCallOffset).build());
			regCount++;
			System.out.println("2");
		}
		if (two.type.equals("int")) {
			currentList.add(new Instruction("LDR r" + regCount + ", =" + two.int_value + "\n"));
			regCount++;
			System.out.println("3");
		} else if (two.type.equals("char")) {
			currentList.add(new Instruction("MOV r" + regCount + ", #" + two.stringinfo + "\n"));
			regCount ++;
		} else if (two.type.equals("var")){
//			VariableFragment v  = new VariableFragment(two.stringinfo, funcCallOffset);
//			String load = (typeSize(ctx.math(1).returntype) == 4)? "LDR" : "LDRSB";
//			currentList.add(new Instruction(Arrays.asList(new StringFragment(load + " r" + regCount + ", [sp"), v, new StringFragment("]\n")), v));
			currentList.add(ib.instr().ldrsbVarOffset(typeSize(ctx.math(1).returntype), regCount, two.stringinfo, funcCallOffset).build());
			regCount++;
			System.out.println("4");
		}
		
		currentList.add(new Instruction("CMP r" + (regCount - 2) + ", r" + (regCount - 1) + "\n"));
		if (ctx.LESS() != null) {
			currentList.add(ib.instr().movop("LT", regCount-2, 1).build());
			currentList.add(ib.instr().movop("GE", regCount-2, 0).build());
//			currentList.add(new Instruction("MOVLT r" + (regCount - 2) + ", #1\nMOVGE r" + (regCount - 2) + ", #0\n"));
		}
		if (ctx.LESS_EQUAL() != null) {
			currentList.add(ib.instr().movop("LE", regCount-2, 1).build());
			currentList.add(ib.instr().movop("GT", regCount-2, 0).build());
//			currentList.add(new Instruction("MOVLE r" + (regCount - 2) + ", #1\nMOVGT r" + (regCount - 2) + ", #0\n"));
		}
		if (ctx.GREATER_EQUAL() != null) {
			currentList.add(ib.instr().movop("GE", regCount-2, 1).build());
			currentList.add(ib.instr().movop("LT", regCount-2, 0).build());
//			currentList.add(new Instruction("MOVGE r" + (regCount - 2) + ", #1\nMOVLT r" + (regCount - 2) + ", #0\n"));
		}
		if (ctx.GREATER() != null) {
			currentList.add(ib.instr().movop("GT", regCount-2, 1).build());
			currentList.add(ib.instr().movop("LE", regCount-2, 0).build());
//			currentList.add(new Instruction("MOVGT r" + (regCount - 2) + ", #1\nMOVLE r" + (regCount - 2) + ", #0\n"));
		}
		regCount = regCount -2;
		
//		if(inWhile) {
//			currentList.add(new Instruction("CMP r" + regCount + ", #1\nBEQ L" + (whileCount + 1) + "\n"));
//		}
		return new Info("r" + regCount).setType("reg"); 
	}
	
	@Override public Info visitAtom_ident(@NotNull WaccParser.Atom_identContext ctx) {
		// optimisation - check if constant//
		if (ctx.ident().constant) {
			Info i = visit(ctx.ident().constantAtom);
			ctx.typename = ctx.ident().constantAtom.typename;
			return i;
		}
		// end of optimisation
		visit(ctx.ident());
		ctx.typename = ctx.ident().typename;
		return (new Info(ctx.ident().VARIABLE().getText())).setType("var");
	}
	
	@Override public Info visitExpr_ident(@NotNull WaccParser.Expr_identContext ctx) {
		if (prints) System.out.println("visitExpr_ident, maybe constant");
		// optimisation - check if constant//
		if (ctx.ident().constant) {
			Info i = visit(ctx.ident().constantExpr);
			ctx.typename = ctx.ident().constantExpr.typename;
			return i;
		}
		// end of optimisation
		if (prints) System.out.println("visitExpr_ident");
		visit(ctx.ident());

		ctx.typename = ctx.ident().typename;
		String id = ctx.ident().getText();

		if(ctx.typename == null || ctx.typename instanceof NULL) {
			return null;
		}
		//also check if the ident has been declared

		if (currentTable.lookupAll(id) == null) System.exit(200);//throw new Error(id + "has not been declared");
		// do we have static variabsle in Wacc language. ^this would not support static var usage in stat in function declaration


		System.out.println("!!!!!!!!!!!!!" + ctx.ident().getText() + "//funcOffset: " + funcCallOffset);
//		VariableFragment v = new VariableFragment(ctx.ident().getText(), funcCallOffset);
		//CHECK : bug in functionmanyarguments.wacc -> ref compiler line 122
//		currentList.add(new Instruction(Arrays.asList(new StringFragment(( typeSize(ctx.typename) == 1 ? "LDRSB r" : "LDR r") + regCount  + ", [sp"), v, new StringFragment("]\n")), v));
		currentList.add(ib.instr().ldrsbVarOffset(typeSize(ctx.typename), regCount, ctx.ident().getText(), funcCallOffset).build());
		return null;
	}
	
	@Override public Info visitAtom_brackets(@NotNull WaccParser.Atom_bracketsContext ctx) {
		// constant optimisation: brackets will no longer load into reg, tries to give its answer upwards
		// give dummy list to discard
		System.out.println("BRACKETS");
		List <Instruction> savedList = currentList;
		currentList = new LinkedList<Instruction>();
		Info i = visit(ctx.expr());
		ctx.typename = ctx.expr().typename;
		if (i != null && i.type != null && !i.type.equals("reg")) {
			System.out.println("not null, not reg");
			currentList = savedList;
			return i;
		}
		savedList.addAll(currentList);
		currentList = savedList;
		return (new Info("")).setType("reg");
	}
	
	@Override 
	public Info visitExpr_int(@NotNull WaccParser.Expr_intContext ctx) { 
		if (prints) System.out.println("visitExpr_int");
		Info i = visit(ctx.int_liter());
		currentList.add(new Instruction("LDR r" + regCount + ", =" + i.int_value + "\n"));
		ctx.typename = new INT();
		
		return i; 
	}
	
	@Override 
	public Info visitExpr_char(@NotNull WaccParser.Expr_charContext ctx) { 
		if (prints) System.out.println("visitExpr_char");
		ctx.typename = new CHAR();
		String text = ctx.char_liter().CHARACTER().getText();
		
		

		if(text.length() > 3) {
			if(text.charAt(2) == '\'') {
				currentList.add(new Instruction("MOV r" + regCount +", #" + text + "\n"));
				return null;
			}
			System.out.println(text.length());
			text = text.replace("\\n", "\n");
			text = text.replace("\\0", "\0");
			text = text.replace("\\b", "\b");
			text = text.replace("\\t", "\t");
			text = text.replace("\\f", "\f");
			text = text.replace("\\r", "\"");
			char c = text.charAt(1);
			int ascii = (int) c;
			currentList.add(new Instruction("MOV r" + regCount +", #" + ((ascii > 13)? "\'" + text.charAt(2) + "\'": String.valueOf(ascii)) + "\n"));
			return new Info((ascii > 13)? "\'" + text.charAt(2) + "\'": String.valueOf(ascii)).setType("char");
		} else {
//		currentList.add(new Instruction("MOV r" + regCount +", #" + ctx.char_liter().CHARACTER().getText() + "\n"));
			currentList.add(new Instruction("MOV r" + regCount +", #" + text + "\n"));
			return new Info(text).setType("char");
		}
		//return new Info("argument").setType(ctx.typename.toString());
		//return null;
	}
	
	@Override 
	public Info visitExpr_bool(@NotNull WaccParser.Expr_boolContext ctx) {
		if (prints) System.out.println("visitExpr_bool");
		ctx.typename = new BOOL();
		int i = 0;
		if (ctx.bool_liter().TRUE() != null) {
			i = 1;
		}

		if (!(controlFlowTrue || controlFlowFalse)) {
			currentList.add(new Instruction("MOV r" + regCount +", #" + i + "\n"));
		}

		//return new Info("argument").setType(ctx.typename.toString());
		return new Info(i == 1);
	}


}
