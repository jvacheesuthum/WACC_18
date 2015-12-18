import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.misc.NotNull;

import SemanticAnalyser.BOOL;
import SemanticAnalyser.SharedMethods;
import SemanticAnalyser.SymbolTable;
import antlr.WaccParser;
import backEnd.Info;
import backEnd.Instruction;
import backEnd.Instruction_Return;


public class WaccVisitorWithCFA extends MyWaccVisitor {

	public WaccVisitorWithCFA(String filename) {
		super(filename);
	}
	
	@Override public Info visitStat_if(@NotNull WaccParser.Stat_ifContext ctx) {
		//backend
		ifCount++ ;
		//

    	if (prints) System.out.println("visitStat_if");
		Info boolInfo = visit(ctx.expr());
		if (prints) System.out.println("expr = "+ ctx.expr().getText());
		
		//EXTENSION - short circuiting
  		if (ctx.expr().getText().replaceAll("[//(//)]", "").equals(new String("true"))) {
  			if (prints) System.out.println("control flow true");
  			controlFlowTrue = true;
  		}
  		
  		if (ctx.expr().getText().replaceAll("[//(//)]", "").equals(new String("false"))) {
  			if (prints) System.out.println("control flow false");
  			controlFlowFalse = true;
  		}
  	
  	//---------------------------------------------------

		//backend - after visit expr
		int currentIfLable = ifCount * 2;
		
		if (!(controlFlowTrue || controlFlowFalse)) { //no control flow breaks
			currentList.add(new Instruction("CMP r" + regCount + ", #0\n"));
			currentList.add(new Instruction("BEQ L" + (currentIfLable) + "\n"));
		}
		//

		if(!(SharedMethods.assignCompat(ctx.expr().typename, new BOOL()))){
			System.out.print("if condition is not of type bool");
			System.exit(200);
		}

		//backend - before visit then-stat
		int encStackCount = stackTotal;
		stackTotal = 0;
		Map<String, Integer> encStackMap = currentStackMap;
		Map<String,Integer> scopedStackMap = new HashMap<>();
		currentStackMap = scopedStackMap;
		List<Instruction> encInstr = currentList;
		List<Instruction> scopedInstr = new ArrayList<Instruction>();
		currentList = scopedInstr;
		//

		currentTable = new SymbolTable(currentTable);
		visit(ctx.stat(0));
		currentTable = currentTable.encSymTable;

		//backend - after visit first stat
		//locating variables from outer scope correctly when there is a change in stack pointer
		int hasDeclared = stackTotal;
		currentStackMap.put("total", stackTotal);

		
		for(Instruction instr: currentList) {
			//if (instr.isScoped()){
			//	instr.addScopeDepth(hasDeclared);
			//}
			if (instr instanceof Instruction_Return){
				// to add to stackCount and propagate the instruction up 1 layer, to keep accumulating stackCount to do ADD sp sp correctly
				((Instruction_Return) instr).addStackCount(currentStackMap.get("total"));
			}
			if (instr.toDeclare()) {
				stackTotal = instr.allocateStackPos(stackTotal, currentStackMap);
			}
			if (instr.needsVarPos() && !(instr instanceof Instruction_Return)) {
				// variable total is propagated up the if scopes
				instr.varsToPos(currentStackMap, hasDeclared);
			}
		}
		
		if (!controlFlowFalse) { //the expr is true and we dont need the if then part

			//adding to encInstrList
			if(hasDeclared > 0) encInstr.add(new Instruction("SUB sp, sp, #" + hasDeclared + "\n"));
			
			for(Instruction in : currentList){
				//for newly created scopedInstruction
				if(in.isScoped() && (in.scopeDepth() == 0)) in.addScopeDepth(hasDeclared);
				encInstr.add(in);
			}

			if(hasDeclared > 0) encInstr.add(new Instruction("ADD sp, sp, #" + hasDeclared + "\n"));
		}
			currentList = encInstr;
			currentStackMap = encStackMap;
			stackTotal = encStackCount;
		

		if (!(controlFlowTrue || controlFlowFalse)) {
			currentList.add(new Instruction("B L" + (currentIfLable+1) + "\n"));
			//backend - before visit else-stat
			currentList.add(new Instruction("L"+ currentIfLable +":\n"));
		}
		encStackCount = stackTotal;
		stackTotal = 0;
		encStackMap = currentStackMap;
		scopedStackMap = new HashMap<>();
		currentStackMap = scopedStackMap;
		encInstr = currentList;
		scopedInstr = new ArrayList<Instruction>();
		currentList = scopedInstr;
		//


		currentTable = new SymbolTable(currentTable);
		visit(ctx.stat(1));
		currentTable = currentTable.encSymTable;

		//backend - after visit else-stat
		//locating variables from outer scope correctly when there is a change in stack pointer

		hasDeclared = stackTotal;
		currentStackMap.put("total", stackTotal);
		for(Instruction instr: currentList) {
			//if (instr.isScoped()){
			//	instr.addScopeDepth(hasDeclared);
			//}
			if (instr instanceof Instruction_Return){
				// to add to stackCount and propagate the instruction up 1 layer, to keep accumulating stackCount to do ADD sp sp correctly
				((Instruction_Return) instr).addStackCount(currentStackMap.get("total"));
			}
			if (instr.toDeclare()) {
				stackTotal = instr.allocateStackPos(stackTotal, currentStackMap);
			}
			if (instr.needsVarPos() && !(instr instanceof Instruction_Return)) {
				instr.varsToPos(currentStackMap, hasDeclared);
			}
		}
		
		if (!controlFlowTrue) { //expr is true so no need else branch
			//adding to encInstrList
			if(hasDeclared > 0) encInstr.add(new Instruction("SUB sp, sp, #" + hasDeclared + "\n"));
		
			for(Instruction in : currentList){
				//for newly created scopedInstruction
				if(in.isScoped() && (in.scopeDepth() == 0)) in.addScopeDepth(hasDeclared);
				encInstr.add(in);
			}
			if(hasDeclared > 0) encInstr.add(new Instruction("ADD sp, sp, #" + hasDeclared + "\n"));
		}
			currentList = encInstr;
			currentStackMap = encStackMap;
			stackTotal = encStackCount;
		
		if (!(controlFlowTrue || controlFlowFalse)) {
			currentList.add(new Instruction("L"+ (currentIfLable+1) +":\n"));
		}
		//

		ctx.typename = ctx.stat(0).typename;
		controlFlowTrue = false;
		controlFlowFalse = false;

		return null;
	}

	
	
	
	//-----------------------------layers-----------------
	
	@Override public Info visitLayer_s_s(@NotNull WaccParser.Layer_s_sContext ctx) {
		if (prints) System.out.println("visitLayer_s_s");
		//backend
		ifCount++ ;
		//
		if (prints) System.out.println("visitStat_if");
		visit(ctx.expr());
		if (prints) System.out.println("expr = "+ ctx.expr().toString());
		
		//EXTENSION - short circuiting
  		if (ctx.expr().getText().replaceAll("[//(//)]", "").equals(new String("true"))) {
  			if (prints) System.out.println("control flow true");
  			controlFlowTrue = true;
  		}
  		
  		if (ctx.expr().getText().replaceAll("[//(//)]", "").equals(new String("false"))) {
  			if (prints) System.out.println("control flow false");
  			controlFlowFalse = true;
  		}
  	
  	//---------------------------------------------------

		currentTable = new SymbolTable(currentTable);

		//backend - after visit expr
		int currentIfLable = ifCount * 2;
		if (!(controlFlowTrue || controlFlowFalse)) {

			currentList.add(new Instruction("CMP r" + regCount + ", #0\n"));
			currentList.add(new Instruction("BEQ L" + (currentIfLable) + "\n"));
			//
		}
		if(!(SharedMethods.assignCompat(ctx.expr().typename, new BOOL()))){
			System.out.print("if condition is not of type bool");
			System.exit(200);
		}

		//backend - before visit then-stat
		int encStackCount = stackTotal;
		stackTotal = 0;
		Map<String, Integer> encStackMap = currentStackMap;
		Map<String,Integer> scopedStackMap = new HashMap<>();
		currentStackMap = scopedStackMap;
		List<Instruction> encInstr = currentList;
		List<Instruction> scopedInstr = new ArrayList<Instruction>();
		currentList = scopedInstr;
		//

		if (ctx.stat(0) != null) {
			visit(ctx.stat(0));
		}
		visit(ctx.stat_return(0));

		//backend - after visit first stat
		//locating variables from outer scope correctly when there is a change in stack pointer
		int hasDeclared = stackTotal;
		currentStackMap.put("total", stackTotal);

		for(Instruction instr: currentList) {
			if (instr instanceof Instruction_Return){
				// to add to stackCount and propagate the instruction up 1 layer, to keep accumulating stackCount to do ADD sp sp correctly
				((Instruction_Return) instr).addStackCount(currentStackMap.get("total"));
			}
			if (instr.toDeclare()) {
				stackTotal = instr.allocateStackPos(stackTotal, currentStackMap);
			}
			if (instr.needsVarPos() && !(instr instanceof Instruction_Return)) {
				// variable total is propagated up the if scopes
				instr.varsToPos(currentStackMap, hasDeclared);
			}
		}

		if (!controlFlowFalse) {
		//adding to encInstrList
			if(hasDeclared > 0) encInstr.add(new Instruction("SUB sp, sp, #" + hasDeclared + "\n"));
		
			for(Instruction in : currentList){
				//for newly created scopedInstruction
				if(in.isScoped() && (in.scopeDepth() == 0)) in.addScopeDepth(hasDeclared);
				encInstr.add(in);
			}
			if(hasDeclared > 0) encInstr.add(new Instruction("ADD sp, sp, #" + hasDeclared + "\n"));
		}
		currentList = encInstr;
		currentStackMap = encStackMap;
		stackTotal = encStackCount;
		
		if (!(controlFlowTrue || controlFlowFalse)) {
			currentList.add(new Instruction("B L" + (currentIfLable+1) + "\n"));
		//backend - before visit else-stat
		currentList.add(new Instruction("L"+ currentIfLable +":\n"));
		}
		
		encStackCount = stackTotal;
		stackTotal = 0;
		encStackMap = currentStackMap;
		scopedStackMap = new HashMap<>();
		currentStackMap = scopedStackMap;
		encInstr = currentList;
		scopedInstr = new ArrayList<Instruction>();
		currentList = scopedInstr;
		//
		if (ctx.stat(1) != null) {
			visit(ctx.stat(1));
		}
		visit(ctx.stat_return(1));

		//backend - after visit else-stat
		//locating variables from outer scope correctly when there is a change in stack pointer

		hasDeclared = stackTotal;
		currentStackMap.put("total", stackTotal);
		for(Instruction instr: currentList) {
			if (instr instanceof Instruction_Return){
				// to add to stackCount and propagate the instruction up 1 layer, to keep accumulating stackCount to do ADD sp sp correctly
				((Instruction_Return) instr).addStackCount(currentStackMap.get("total"));
			}
			if (instr.toDeclare()) {
				stackTotal = instr.allocateStackPos(stackTotal, currentStackMap);
			}
			if (instr.needsVarPos() && !(instr instanceof Instruction_Return)) {
				instr.varsToPos(currentStackMap, hasDeclared);
			}
		}
		
		if (!controlFlowTrue) {
			//adding to encInstrList
			if(hasDeclared > 0) encInstr.add(new Instruction("SUB sp, sp, #" + hasDeclared + "\n"));
			for(Instruction in : currentList){
				//for newly created scopedInstruction
				if(in.isScoped() && (in.scopeDepth() == 0)) in.addScopeDepth(hasDeclared);
				encInstr.add(in);
			}
			if(hasDeclared > 0) encInstr.add(new Instruction("ADD sp, sp, #" + hasDeclared + "\n"));
		}
		currentList = encInstr;
		currentStackMap = encStackMap;
		stackTotal = encStackCount;

		if (!(controlFlowTrue || controlFlowFalse)) {
			currentList.add(new Instruction("L"+ (currentIfLable+1) +":\n"));
		}
		//

		if (!SharedMethods.assignCompat(ctx.stat_return(0).typename, ctx.stat_return(1).typename)){
        	System.exit(200);
		}
		ctx.typename = ctx.stat_return(0).typename;

		currentTable = currentTable.encSymTable;
		controlFlowTrue = false;
		controlFlowFalse = false;
		return null;
	}
	
	@Override public Info visitLayer_i_i(@NotNull WaccParser.Layer_i_iContext ctx) {
		if (prints) System.out.println("visitLayer_i_i");

		//backend
		ifCount++ ;
		//

		if (prints) System.out.println("visitStat_if");
		visit(ctx.expr());
		if (prints) System.out.println("expr = "+ ctx.expr().toString());

		//EXTENSION - short circuiting
  		if (ctx.expr().getText().replaceAll("[//(//)]", "").equals(new String("true"))) {
  			if (prints) System.out.println("control flow true");
  			controlFlowTrue = true;
  		}
  		
  		if (ctx.expr().getText().replaceAll("[//(//)]", "").equals(new String("false"))) {
  			if (prints) System.out.println("control flow false");
  			controlFlowFalse = true;
  		}
  	
  	//---------------------------------------------------
		//backend - after visit expr
		int currentIfLable = ifCount * 2;
		if (!(controlFlowTrue || controlFlowFalse)) {
			currentList.add(new Instruction("CMP r" + regCount + ", #0\n"));
			currentList.add(new Instruction("BEQ L" + (currentIfLable) + "\n"));
		}
		
		currentTable = new SymbolTable(currentTable);


		//backend - before visit then-stat
		int encStackCount = stackTotal;
		stackTotal = 0;
		Map<String, Integer> encStackMap = currentStackMap;
		Map<String,Integer> scopedStackMap = new HashMap<>();
		currentStackMap = scopedStackMap;
		List<Instruction> encInstr = currentList;
		List<Instruction> scopedInstr = new ArrayList<Instruction>();
		currentList = scopedInstr;
		//

		if (ctx.stat(0) != null) {
			visit(ctx.stat(0));
		}
		visit(ctx.if_layers(0));

		//backend - after visit first/then stat
		//locating variables from outer scope correctly when there is a change in stack pointer
		int hasDeclared = stackTotal;
		currentStackMap.put("total", stackTotal);

		for(Instruction instr: currentList) {
			if (instr instanceof Instruction_Return){
				// to add to stackCount and propagate the instruction up 1 layer, to keep accumulating stackCount to do ADD sp sp correctly
				((Instruction_Return) instr).addStackCount(currentStackMap.get("total"));
			}
			if (instr.toDeclare()) {
				stackTotal = instr.allocateStackPos(stackTotal, currentStackMap);
			}
			if (instr.needsVarPos() && !(instr instanceof Instruction_Return)) {
				// variable total is propagated up the if scopes
				instr.varsToPos(currentStackMap, hasDeclared);
			}
		}
		if (!controlFlowFalse) {
			//adding to encInstrList
			if(hasDeclared > 0) encInstr.add(new Instruction("SUB sp, sp, #" + hasDeclared + "\n"));
			for(Instruction in : currentList){
				//for newly created scopedInstruction
				if(in.isScoped() && (in.scopeDepth() == 0)) in.addScopeDepth(hasDeclared);
				encInstr.add(in);
			}
			if(hasDeclared > 0) encInstr.add(new Instruction("ADD sp, sp, #" + hasDeclared + "\n"));
		}
		
		currentList = encInstr;
		currentStackMap = encStackMap;
		stackTotal = encStackCount;

		if (!(controlFlowTrue || controlFlowFalse)) {
			currentList.add(new Instruction("B L" + (currentIfLable+1) + "\n"));
		//backend - before visit else-stat
		currentList.add(new Instruction("L"+ currentIfLable +":\n"));
		}
		
		encStackCount = stackTotal;
		stackTotal = 0;
		encStackMap = currentStackMap;
		scopedStackMap = new HashMap<>();
		currentStackMap = scopedStackMap;
		encInstr = currentList;
		scopedInstr = new ArrayList<Instruction>();
		currentList = scopedInstr;
		//
		if (ctx.stat(1) != null) {
			visit(ctx.stat(1));
		}
		visit(ctx.if_layers(1));

		//backend - after visit else-stat
		//locating variables from outer scope correctly when there is a change in stack pointer

		hasDeclared = stackTotal;
		currentStackMap.put("total", stackTotal);
		for(Instruction instr: currentList) {
			if (instr instanceof Instruction_Return){
				// to add to stackCount and propagate the instruction up 1 layer, to keep accumulating stackCount to do ADD sp sp correctly
				((Instruction_Return) instr).addStackCount(currentStackMap.get("total"));
			}
			if (instr.toDeclare()) {
				stackTotal = instr.allocateStackPos(stackTotal, currentStackMap);
			}
			if (instr.needsVarPos() && !(instr instanceof Instruction_Return)) {
				instr.varsToPos(currentStackMap, hasDeclared);
			}
		}
		
		if (!controlFlowTrue) {
			//adding to encInstrList
			if(hasDeclared > 0) encInstr.add(new Instruction("SUB sp, sp, #" + hasDeclared + "\n"));
			for(Instruction in : currentList){
				//for newly created scopedInstruction
				if(in.isScoped() && (in.scopeDepth() == 0)) in.addScopeDepth(hasDeclared);
				encInstr.add(in);
			}
			if(hasDeclared > 0) encInstr.add(new Instruction("ADD sp, sp, #" + hasDeclared + "\n"));
		}
		currentList = encInstr;
		currentStackMap = encStackMap;
		stackTotal = encStackCount;

		if (!(controlFlowTrue || controlFlowFalse)) {
			currentList.add(new Instruction("L"+ (currentIfLable+1) +":\n"));
		}

		if (!SharedMethods.assignCompat(ctx.if_layers(0).typename, ctx.if_layers(1).typename)){
        	System.exit(200);
		}
		ctx.typename = ctx.if_layers(0).typename;

		currentTable = currentTable.encSymTable;
		controlFlowTrue = false;
		controlFlowFalse = false;
		return null;
	}
	
	@Override public Info visitLayer_s_i(@NotNull WaccParser.Layer_s_iContext ctx) {
		if (prints) System.out.println("visitLayer_s_i");

		//backend
		ifCount++ ;
		//

		if (prints) System.out.println("visitStat_if");
		visit(ctx.expr());
		if (prints) System.out.println("expr = "+ ctx.expr().toString());

		//EXTENSION - short circuiting
  		if (ctx.expr().getText().replaceAll("[//(//)]", "").equals(new String("true"))) {
  			if (prints) System.out.println("control flow true");
  			controlFlowTrue = true;
  		}
  		
  		if (ctx.expr().getText().replaceAll("[//(//)]", "").equals(new String("false"))) {
  			if (prints) System.out.println("control flow false");
  			controlFlowFalse = true;
  		}
  	
  	//---------------------------------------------------

		//backend - after visit expr
		int currentIfLable = ifCount * 2;

		if (!(controlFlowTrue || controlFlowFalse)) {
			currentList.add(new Instruction("CMP r" + regCount + ", #0\n"));
			currentList.add(new Instruction("BEQ L" + (currentIfLable) + "\n"));
		}
		
		currentTable = new SymbolTable(currentTable);

		//backend - before visit then-stat
		int encStackCount = stackTotal;
		stackTotal = 0;
		Map<String, Integer> encStackMap = currentStackMap;
		Map<String,Integer> scopedStackMap = new HashMap<>();
		currentStackMap = scopedStackMap;
		List<Instruction> encInstr = currentList;
		List<Instruction> scopedInstr = new ArrayList<Instruction>();
		currentList = scopedInstr;
		//
		if (ctx.stat(0) != null) {
			visit(ctx.stat(0));
		}
		visit(ctx.stat_return());

		//backend - after visit first stat
		//locating variables from outer scope correctly when there is a change in stack pointer
		int hasDeclared = stackTotal;
		currentStackMap.put("total", stackTotal);

		for(Instruction instr: currentList) {
			if (instr instanceof Instruction_Return){
				// to add to stackCount and propagate the instruction up 1 layer, to keep accumulating stackCount to do ADD sp sp correctly
				((Instruction_Return) instr).addStackCount(currentStackMap.get("total"));
			}
			if (instr.toDeclare()) {
				stackTotal = instr.allocateStackPos(stackTotal, currentStackMap);
			}
			if (instr.needsVarPos() && !(instr instanceof Instruction_Return)) {
				// variable total is propagated up the if scopes
				instr.varsToPos(currentStackMap, hasDeclared);
			}
		}

		if (!(controlFlowTrue || controlFlowFalse)) {
			//adding to encInstrList
			if(hasDeclared > 0) encInstr.add(new Instruction("SUB sp, sp, #" + hasDeclared + "\n"));
			for(Instruction in : currentList){
				//for newly created scopedInstruction
				if(in.isScoped() && (in.scopeDepth() == 0)) in.addScopeDepth(hasDeclared);
				encInstr.add(in);
			}
			if(hasDeclared > 0) encInstr.add(new Instruction("ADD sp, sp, #" + hasDeclared + "\n"));
		}
		currentList = encInstr;
		currentStackMap = encStackMap;
		stackTotal = encStackCount;

		if (!(controlFlowTrue || controlFlowFalse)) {
			currentList.add(new Instruction("B L" + (currentIfLable+1) + "\n"));
		
		//backend - before visit else-stat
		currentList.add(new Instruction("L"+ currentIfLable +":\n"));
		}

		encStackCount = stackTotal;
		stackTotal = 0;
		encStackMap = currentStackMap;
		scopedStackMap = new HashMap<>();
		currentStackMap = scopedStackMap;
		encInstr = currentList;
		scopedInstr = new ArrayList<Instruction>();
		currentList = scopedInstr;
		//
		if (ctx.stat(1) != null) {
			visit(ctx.stat(1));
		}
		visit(ctx.if_layers());
		//backend - after visit else-stat
		//locating variables from outer scope correctly when there is a change in stack pointer
		hasDeclared = stackTotal;
		currentStackMap.put("total", stackTotal);
		for(Instruction instr: currentList) {
			if (instr instanceof Instruction_Return){
				// to add to stackCount and propagate the instruction up 1 layer, to keep accumulating stackCount to do ADD sp sp correctly
				((Instruction_Return) instr).addStackCount(currentStackMap.get("total"));
			}
			if (instr.toDeclare()) {
				stackTotal = instr.allocateStackPos(stackTotal, currentStackMap);
			}
			if (instr.needsVarPos() && !(instr instanceof Instruction_Return)) {
				instr.varsToPos(currentStackMap, hasDeclared);
			}
		}
		if (!controlFlowTrue) {
			//adding to encInstrList
			if(hasDeclared > 0) encInstr.add(new Instruction("SUB sp, sp, #" + hasDeclared + "\n"));
			for(Instruction in : currentList){
				//for newly created scopedInstruction
				if(in.isScoped() && (in.scopeDepth() == 0)) in.addScopeDepth(hasDeclared);
				encInstr.add(in);
			}
			if(hasDeclared > 0) encInstr.add(new Instruction("ADD sp, sp, #" + hasDeclared + "\n"));
		}
		currentList = encInstr;
		currentStackMap = encStackMap;
		stackTotal = encStackCount;

		if (!(controlFlowTrue || controlFlowFalse)) {
			currentList.add(new Instruction("L"+ (currentIfLable+1) +":\n"));
		}
		//


		if (!SharedMethods.assignCompat(ctx.if_layers().typename, ctx.stat_return().typename)){
        	System.exit(200);
		}
		ctx.typename = ctx.stat_return().typename;

		currentTable = currentTable.encSymTable;
		controlFlowTrue = false;
		controlFlowFalse = false;
		return null;
	}

	@Override public Info visitLayer_i_s(@NotNull WaccParser.Layer_i_sContext ctx) {
		if (prints) System.out.println("visitLayer_s_i");

		//backend
		ifCount++ ;
		//

		if (prints) System.out.println("visitStat_if");
		visit(ctx.expr());
		if (prints) System.out.println("expr = "+ ctx.expr().toString());

		//EXTENSION - short circuiting
  		if (ctx.expr().getText().replaceAll("[//(//)]", "").equals(new String("true"))) {
  			if (prints) System.out.println("control flow true");
  			controlFlowTrue = true;
  		}
  		
  		if (ctx.expr().getText().replaceAll("[//(//)]", "").equals(new String("false"))) {
  			if (prints) System.out.println("control flow false");
  			controlFlowFalse = true;
  		}
  	
  	//---------------------------------------------------

		//backend - after visit expr
		int currentIfLable = ifCount * 2;
		if (!(controlFlowTrue || controlFlowFalse)) {
			currentList.add(new Instruction("CMP r" + regCount + ", #0\n"));
			currentList.add(new Instruction("BEQ L" + (currentIfLable) + "\n"));
		}

		currentTable = new SymbolTable(currentTable);


		//backend - before visit then-stat
		int encStackCount = stackTotal;
		stackTotal = 0;
		Map<String, Integer> encStackMap = currentStackMap;
		Map<String,Integer> scopedStackMap = new HashMap<>();
		currentStackMap = scopedStackMap;
		List<Instruction> encInstr = currentList;
		List<Instruction> scopedInstr = new ArrayList<Instruction>();
		currentList = scopedInstr;
		//
		if (ctx.stat(0) != null) {
			visit(ctx.stat(0));
		}
		visit(ctx.if_layers());
		//backend - after visit first stat
		//locating variables from outer scope correctly when there is a change in stack pointer
		int hasDeclared = stackTotal;
		currentStackMap.put("total", stackTotal);

		for(Instruction instr: currentList) {
			if (instr instanceof Instruction_Return){
				// to add to stackCount and propagate the instruction up 1 layer, to keep accumulating stackCount to do ADD sp sp correctly
				((Instruction_Return) instr).addStackCount(currentStackMap.get("total"));
			}
			if (instr.toDeclare()) {
				stackTotal = instr.allocateStackPos(stackTotal, currentStackMap);
			}
			if (instr.needsVarPos() && !(instr instanceof Instruction_Return)) {
				// variable total is propagated up the if scopes
				instr.varsToPos(currentStackMap, hasDeclared);
			}
		}
		if (!controlFlowFalse) {
			//adding to encInstrList
			if(hasDeclared > 0) encInstr.add(new Instruction("SUB sp, sp, #" + hasDeclared + "\n"));
			for(Instruction in : currentList){
				//for newly created scopedInstruction
				if(in.isScoped() && (in.scopeDepth() == 0)) in.addScopeDepth(hasDeclared);
				encInstr.add(in);
			}
			if(hasDeclared > 0) encInstr.add(new Instruction("ADD sp, sp, #" + hasDeclared + "\n"));
		}
		currentList = encInstr;
		currentStackMap = encStackMap;
		stackTotal = encStackCount;

		if (!(controlFlowTrue || controlFlowFalse)) {
			currentList.add(new Instruction("B L" + (currentIfLable+1) + "\n"));
			//backend - before visit else-stat
			currentList.add(new Instruction("L"+ currentIfLable +":\n"));
		}
		
		encStackCount = stackTotal;
		stackTotal = 0;
		encStackMap = currentStackMap;
		scopedStackMap = new HashMap<>();
		currentStackMap = scopedStackMap;
		encInstr = currentList;
		scopedInstr = new ArrayList<Instruction>();
		currentList = scopedInstr;
		//
		if (ctx.stat(1) != null) {
			visit(ctx.stat(1));
		}
		visit(ctx.stat_return());
		//backend - after visit else-stat
		//locating variables from outer scope correctly when there is a change in stack pointer
		hasDeclared = stackTotal;
		currentStackMap.put("total", stackTotal);
		for(Instruction instr: currentList) {
			if (instr instanceof Instruction_Return){
				// to add to stackCount and propagate the instruction up 1 layer, to keep accumulating stackCount to do ADD sp sp correctly
				((Instruction_Return) instr).addStackCount(currentStackMap.get("total"));
			}
			if (instr.toDeclare()) {
				stackTotal = instr.allocateStackPos(stackTotal, currentStackMap);
			}
			if (instr.needsVarPos() && !(instr instanceof Instruction_Return)) {
				instr.varsToPos(currentStackMap, hasDeclared);
			}
		}
		
		if (!controlFlowTrue) {
			//adding to encInstrList
			if(hasDeclared > 0) encInstr.add(new Instruction("SUB sp, sp, #" + hasDeclared + "\n"));
			for(Instruction in : currentList){
				//for newly created scopedInstruction
				if(in.isScoped() && (in.scopeDepth() == 0)) in.addScopeDepth(hasDeclared);
				encInstr.add(in);
			}
			if(hasDeclared > 0) encInstr.add(new Instruction("ADD sp, sp, #" + hasDeclared + "\n"));
		}
		currentList = encInstr;
		currentStackMap = encStackMap;
		stackTotal = encStackCount;

		if (!(controlFlowTrue || controlFlowFalse)) {
		currentList.add(new Instruction("L"+ (currentIfLable+1) +":\n"));
		}

		if (!SharedMethods.assignCompat(ctx.if_layers().typename, ctx.stat_return().typename)){
			System.exit(200);
		}
		ctx.typename = ctx.stat_return().typename;

		currentTable = currentTable.encSymTable;
		controlFlowTrue = false;
		controlFlowFalse = false;
		return null;
	}
	
	//---------while-----------------
	
	@Override public Info visitStat_while(@NotNull WaccParser.Stat_whileContext ctx) { 
	   	if (prints) System.out.println("visitStat_while");
	   	
	  //EXTENSION - short circuiting
	  		if (ctx.expr().getText().replaceAll("[//(//)]", "").equals(new String("true"))) {
	  			if (prints) System.out.println("control flow true");
	  			controlFlowTrue = true;
	  		}
	  		
	  		if (ctx.expr().getText().replaceAll("[//(//)]", "").equals(new String("false"))) {
	  			if (prints) System.out.println("control flow false");
	  			controlFlowFalse = true;
	  		}
	  	
	  	//---------------------------------------------------
    	whileCount++;
    	
    	if (!controlFlowFalse) { //if while condition is false there's no need of any branching
    		
    		if (!controlFlowTrue) {
		    	Instruction BLOinstr = new Instruction("B LW" + (whileCount * 2) + "\n");
		    	currentList.add(BLOinstr);
    		}
    		
	    	currentList.add(new Instruction("LW" + ((whileCount * 2) + 1) + ":\n"));
	    	int encStackTotal = stackTotal;
	//    	List<Instruction> encWhileList = new ArrayList<Instruction>();
	    	stackTotal = 0;
	
	    	
			Map<String, Integer> encStackMap = currentStackMap;
			Map<String,Integer> scopedStackMap = new HashMap<>();
			currentStackMap = scopedStackMap;
			List<Instruction> encInstr = currentList;
			List<Instruction> scopedInstr = new ArrayList<Instruction>();
			currentList = scopedInstr;
			int encWhileCount = whileCount;
			
			visit(ctx.stat());
			
			//--------------------------
			int hasDeclared = stackTotal;
			currentStackMap.put("total", stackTotal);
	
			for(Instruction instr: currentList) {
				if (instr instanceof Instruction_Return){
					// to add to stackCount and propagate the instruction up 1 layer, to keep accumulating stackCount to do ADD sp sp correctly
					((Instruction_Return) instr).addStackCount(currentStackMap.get("total"));
				}
				if (instr.toDeclare()) {
					stackTotal = instr.allocateStackPos(stackTotal, currentStackMap);
				}
				if (instr.needsVarPos() && !(instr instanceof Instruction_Return)) {
					// variable total is propagated up the if scopes
					instr.varsToPos(currentStackMap, hasDeclared);
				}
			}
			//adding to encInstrList
			if(hasDeclared > 0) encInstr.add(new Instruction("SUB sp, sp, #" + hasDeclared + "\n"));
			for(Instruction in : currentList){
				//for newly created scopedInstruction
				if(in.isScoped() && (in.scopeDepth() == 0)) in.addScopeDepth(hasDeclared);
				encInstr.add(in);
			}
			if(hasDeclared > 0) encInstr.add(new Instruction("ADD sp, sp, #" + hasDeclared + "\n"));
			currentList = encInstr;
			currentStackMap = encStackMap;
			stackTotal = encStackTotal;
			whileCount = encWhileCount;
			//----------------------------
	
			if (controlFlowTrue) {
				currentList.add(new Instruction("B LW" + (whileCount * 2 + 1) + "\n"));
				infiniteLoop = true; //stops printInstructions() from pritning typical footer

			} else {
				currentList.add(new Instruction("LW" + (whileCount * 2) + ":\n"));
			}
				visit(ctx.expr());
				
			if (!controlFlowTrue) {
				Instruction compareAndEqual = new Instruction("CMP r" + regCount + ", #1\nBEQ LW" + ((whileCount * 2) + 1) + "\n");
				currentList.add(compareAndEqual);
			}
			
			if(!(SharedMethods.assignCompat(ctx.expr().typename, new BOOL()))){
				System.out.print("if condition is not of type bool");
				System.exit(200);
			}
    	}
    	controlFlowTrue = false;
		controlFlowFalse = false;
		return null; 
	}


}
