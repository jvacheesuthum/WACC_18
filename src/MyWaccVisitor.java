import SemanticAnalyser.*;
import antlr.WaccParser;
import antlr.WaccParser.ExprContext;
import antlr.WaccParser.ParamContext;
import antlr.WaccParser.StatContext;
import antlr.WaccParserBaseVisitor;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
//import sun.jvm.hotspot.debugger.cdbg.Sym;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyWaccVisitor<T> extends WaccParserBaseVisitor<T> {
    SymbolTable currentTable = new SymbolTable(null);
    
    public MyWaccVisitor() {
        currentTable.add("int",new TYPE());
        currentTable.add("char",new TYPE());
        currentTable.add("bool",new TYPE());
        currentTable.add("string", new TYPE());
        currentTable.add("array", new TYPE());
        currentTable.add("pair", new TYPE());
    }


    @Override 
    public T visitStat_stat(@NotNull WaccParser.Stat_statContext ctx) {

        WaccParser.StatContext first = ctx.stat(0);  // assuming parameter 0 returns first stat
        WaccParser.StatContext second = ctx.stat(1); // assuming parameter 1 return second stat
        visit(first);
        visit(second); //but we need to return
        ctx.typename = second.typename;
        //or
/*        List<WaccParser.StatContext> stats = ctx.stat();
    	for (StatContext s : stats){
    		visit(s);

    	}
  */  	
    	return null;
        //or
        //return visitChildren(ctx);
    }

    @Override 
    public T visitStat_assign(@NotNull WaccParser.Stat_assignContext ctx) {
    	System.out.println("visitStat_assign");
        WaccParser.Assign_lhsContext lhs = ctx.assign_lhs();
        WaccParser.Assign_rhsContext rhs = ctx.assign_rhs();

        visit(lhs);    

        visit(rhs);
        
        if(lhs.typename == null){
          System.out.println("assign to unknown");
          System.exit(200);
        }
        if(rhs.typename == null){
          System.out.println("assigning unknown");
          System.exit(200);
        }
        
        if (!SharedMethods.assignCompat(lhs.typename, rhs.typename)) {
//        	throw new Error("Assign not of the same type");
        	System.exit(200);
        }
        
    	return null;
    }

    @Override 
    public T visitStat_declare(@NotNull WaccParser.Stat_declareContext ctx) {
    	System.out.println("visitStat_declare");
//      WaccParser.TypeContext type = ctx.type();
//      WaccParser.IdentContext id  = ctx.ident();
//      WaccParser.Assign_rhsContext rhs = ctx.assign_rhs();
//
//      DeclarationAST D = new DeclarationAST(currentTable);
//      D.check();
  	
      //check for assign because we in wacc we do declare and assign at the same time
  	
      WaccParser.Assign_rhsContext rhs = ctx.assign_rhs();
      visit(rhs);
      System.out.println("SEP: ");
      visit(ctx.type());
      System.out.println("After visit declare lhs and rhs");

      System.out.println("declare rhs: " + rhs.typename);
      System.out.println("declare lhs: " + ctx.type().typename);
      
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
    	  System.out.println("var already declared");
      	  System.exit(200);
      }

      VARIABLE var = new VARIABLE(rhs.typename);
      currentTable.add(ctx.ident().getText(), var);

  	  return null;
    }

    @Override
    public T visitFunc(@NotNull WaccParser.FuncContext ctx) {
    	System.out.println("visitFunc");
		IDENTIFIER id = currentTable.lookupAllFunc(ctx.ident().getText());
		if(id != null) System.exit(200);

		visit(ctx.type());

		TYPE returntypename = ctx.type().typename;

		SymbolTable newST = new SymbolTable(currentTable);
		

		//currentTable = newST;
		ctx.funObj = new FUNCTION(returntypename);
		currentTable.funcadd(ctx.ident().getText(), ctx.funObj);
		ctx.funObj.symtab = newST;
		
		if(ctx.param_list() != null){
			currentTable = newST;
			visit(ctx.param_list());

			List <ParamContext> params = ctx.param_list().param();
			for(ParamContext p : params){
				ctx.funObj.formals.add(p.paramObj);
			}
			System.out.println("Before stat");
			visit(ctx.stat());
			visit(ctx.stat_return());

	//		System.out.println("typename: " + returntypename.getClass().toString());
//			System.out.println("typename: " + ctx.stat().typename.getClass().toString());
			if(!SharedMethods.assignCompat(ctx.stat_return().typename, returntypename)) {//throw new Error("statement return type not match function return type!");
	        	System.exit(200);
			}
			currentTable = currentTable.encSymTable;
		}
		else{

			currentTable = newST;

			if (!(ctx.stat() == null)){
				visit(ctx.stat());
			}
			visit(ctx.stat_return());

			if(!SharedMethods.assignCompat(ctx.stat_return().typename, returntypename)) {//throw new Error("statement return type not match function return type");
			System.out.println("typename STAT = " + ctx.stat().typename);

				System.exit(200);
			}
			
			currentTable = currentTable.encSymTable;
		}
		return null;
    }

	@Override public T visitAssign_rhs_call(@NotNull WaccParser.Assign_rhs_callContext ctx) {
    	System.out.println("visitAssign_rhs_call");
		String funcname = ctx.ident().getText();
		List<ExprContext> actuals = ctx.arg_list().expr();

		IDENTIFIER F = currentTable.lookupAllFunc(funcname);

		if (F == null) {
        	System.exit(200); //throw new Error("unknown function" + funcname);
		}
		if (!(F instanceof FUNCTION)) {
        	System.exit(200); //throw new Error(funcname + "is not a function");
		}
		if (((FUNCTION) F).formals.size() != actuals.size()) {
        	System.exit(200);//throw new Error ("wrong number of parameters");
		}

		for(int i = 0; i < actuals.size(); i++){
			ExprContext each = actuals.get(i);
			visit(each);

			if (!SharedMethods.assignCompat(((FUNCTION) F).formals.get(i).TYPE(), each.typename)){
	        	System.exit(200);//throw new Error("type of func param " + i + " incompatible with declaration");
			}
		}
		FUNCTION fun = (FUNCTION) F;
		ctx.typename = fun.returntype;
		//ctx.funcObj = F; <- do we need this line?

		return null;
	}

	@Override public T visitAssign_rhs_call_empty(@NotNull WaccParser.Assign_rhs_call_emptyContext ctx) {
    	System.out.println("visitAssign_rhs_	@Override public T visitAtom_char(@NotNull WaccParser.Atom_charContext ctx) { return visitChildren(ctx); }call_empty");
		String funcname = ctx.ident().getText();
		IDENTIFIER F = currentTable.lookupAllFunc(funcname);

		if (F == null) {
        	System.exit(200);//throw new Error("unknown function" + funcname);
		}
		if (!(F instanceof FUNCTION)) {
        	System.exit(200);//throw new Error(funcname + "is not a function");
		}
		if (((FUNCTION) F).formals.size() != 0) {
        	System.exit(200);//throw new Error ("wrong number of parameters");
		}

		//ctx.funObj = F; <- do we need this line?
		FUNCTION fun = (FUNCTION) F;
		ctx.typename = fun.returntype;
		return null;
	}


	@Override public T visitPair_liter(@NotNull WaccParser.Pair_literContext ctx) { 
    	System.out.println("visitPair_liter");
		//ctx.typename = null;
		return null;
	}

	@Override public T visitParam(@NotNull WaccParser.ParamContext ctx) {
    	System.out.println("visitParam");
		visit(ctx.type());

		String param_name = ctx.ident().getText();
		PARAM p = new PARAM(ctx.type().typename);
		currentTable.add(param_name, p);
		ctx.paramObj = p;

		return null;
	}

	@Override public T visitStat_if(@NotNull WaccParser.Stat_ifContext ctx) { 
    	System.out.println("visitStat_if");
		List<StatContext> stats = ctx.stat();
		visit(ctx.expr());
		System.out.println("expr = "+ ctx.expr().toString());
		if ((ctx.expr().typename != currentTable.lookup("bool")) &&
				!(ctx.expr().typename instanceof BOOL)){
        	System.exit(200);//throw new Error("If condition is not of type bool.");
		}
		for (StatContext s : stats){
			visit(s);
		}
		ctx.typename = stats.get(0).typename;
		return null;
	}

	@Override public T visitStat_read(@NotNull WaccParser.Stat_readContext ctx) { 
    	System.out.println("visitStat_read");
		
		visit(ctx.assign_lhs());
		if(ctx.assign_lhs().typename instanceof NULL) {
			return null;
		}

		//a read statement can only target a program variable, an array element or a pair element
//		if ((!(ctx.assign_lhs().typename instanceof ARRAY_TYPE)) &&
	//	(!(ctx.assign_lhs().typename instanceof PAIR_TYPE)) && 
		if((!(ctx.assign_lhs().typename instanceof INT)) &&
		(!(ctx.assign_lhs().typename instanceof CHAR)))
        	System.exit(200);//throw new Error("cannot read into type " + ctx.assign_lhs().typename.toString() + "PAIR or ARRAY expected.");
		//check std input that its only char / int input
		//if !(ctx.READ().getClass() instanceof char / int) throw Error("input has to be only char/int")
		//check if the types of 2 sides match

		return null;
	}

	@Override 
	public T visitType_pairtype(@NotNull WaccParser.Type_pairtypeContext ctx) { 
    	System.out.println("visitType_pairtype");
		visit(ctx.pair_type());
		ctx.typename = ctx.pair_type().typename;
		return null;
	}
	
	@Override 
	public T visitType_arraytype(@NotNull WaccParser.Type_arraytypeContext ctx) { 
    	System.out.println("visitType_arraytype");
		  visit(ctx.array_type());
    	ctx.typename = ctx.array_type().typename;
		  //ctx.typename = new ARRAY_TYPE(ctx.array_type().typename);
		return null;
	}
	
	@Override 
	public T visitType_basetype(@NotNull WaccParser.Type_basetypeContext ctx) {
    	System.out.println("visitType_basetype");
		visit(ctx.base_type());
		ctx.typename = ctx.base_type().typename;
		//ctx.typename = new ARRAY_TYPE(ctx.base_type().typename);
		
		return null;
	}

	@Override public T visitStat_exit(@NotNull WaccParser.Stat_exitContext ctx) {
    	System.out.println("visitStat_exit");
		visit(ctx.expr());
		ctx.typename = ctx.expr().typename;
		if(!SharedMethods.assignCompat(ctx.typename, new INT())) {
			System.exit(200);
		}
		
		return null; 
	}

	public T visitUnary_oper(@NotNull WaccParser.Unary_operContext ctx) { 
    	System.out.println("visitUnary_oper");
		return visitChildren(ctx);
	}

	@Override public T visitStat_while(@NotNull WaccParser.Stat_whileContext ctx) { 
    	System.out.println("visitStat_while");
		visit(ctx.expr());

		if ((ctx.expr().typename != currentTable.lookup("bool")) &&
				!(ctx.expr().typename instanceof BOOL)){

        	System.exit(200);//throw new Error("while condition is not of type bool.");
		}

		visit(ctx.stat());

		return null; 
	}

	//put type into ident according to the symbol table
	@Override public T visitIdent(@NotNull WaccParser.IdentContext ctx) {
    	/*
		System.out.println("visitIdent");
		IDENTIFIER type = currentTable.lookup(ctx.getText());
		VARIABLE var = new VARIABLE((TYPE) type);
		ctx.typename = var.TYPE();
		return null;
		
		*/

		System.out.println("visitIdent");
		if(ctx.getText().equals("null")) {
			ctx.typename = new NULL();
			return null;
		}
		IDENTIFIER id = currentTable.lookupAll(ctx.getText());
		if(id == null) System.out.println("visitIndent: LHS IS NULLLLL");	//REMOVE
		if(id instanceof VARIABLE){
			ctx.typename = ((VARIABLE) id).TYPE();
		}
		else{
//			System.out.println("something is wronmg: ");
//			System.exit(200);
		}
		
		return null;
	
	}
	
	@Override public T visitAssign_lhs_ident(@NotNull WaccParser.Assign_lhs_identContext ctx) { 
    	System.out.println("visitAssign_lhs_ident");

		IDENTIFIER id = currentTable.lookupAll(ctx.getText());


		if(id == null) System.out.println("visitAssign_lhs_indent: LHS IS NULLLLL");	////REMOVE
		if(id instanceof VARIABLE){

			ctx.typename = ((VARIABLE) id).TYPE();
		}
		else{
//			System.out.println("something is wronmg");
//			System.exit(200);
		}
	
		return null;
}
	
	@Override public T visitAssign_lhs_array(@NotNull WaccParser.Assign_lhs_arrayContext ctx) {
    	System.out.println("visitAssign_lhs_array");
		visit(ctx.array_elem().ident());
		ctx.typename = ctx.array_elem().ident().typename;
		
		//IDENTIFIER x = currentTable.lookup(ctx.array_elem().ident().getText());
		//ARRAY_TYPE xx = (ARRAY_TYPE) x;
		//ctx.typename = xx.TYPE();
		return null;
	}
	
	@Override 
	public T visitAssign_lhs_pair(@NotNull WaccParser.Assign_lhs_pairContext ctx) { 
    	System.out.println("visitAssign_lhs_pair");

		visit(ctx.pair_elem());
		ctx.typename = ctx.pair_elem().typename;
		return null;
	}

	@Override public T visitStat_return(@NotNull WaccParser.Stat_returnContext ctx) { 
    	System.out.println("visitStat_return");
		visit(ctx.expr());
		ctx.typename = ctx.expr().typename;
		if(currentTable.encSymTable == null) {
			System.exit(200);
		}
		return null; 
		
	}

	@Override 
	public T visitArray_type_array(@NotNull WaccParser.Array_type_arrayContext ctx) { 
    	System.out.println("visitArray_type_array");
		visit(ctx.array_type());
		
		ctx.typename = new ARRAY_TYPE(ctx.array_type().typename);

		return null;
	}
	
	@Override 
	public T visitArray_type_base(@NotNull WaccParser.Array_type_baseContext ctx) { 
    	System.out.println("visitArray_type_base");
		visit(ctx.base_type());
		//ctx.typename = ctx.base_type().typename;
		
		ctx.typename = new ARRAY_TYPE(ctx.base_type().typename);
		return null;
	}
	
	@Override 
	public T visitArray_type_pair(@NotNull WaccParser.Array_type_pairContext ctx) { 
    	System.out.println("visitArray_type_pair");
		visit(ctx.pair_type());
		//ctx.typename = ctx.pair_type().typename;
		
		ctx.typename = new ARRAY_TYPE(ctx.pair_type().typename);
		return null;
	}
/*
	@Override 
	public T visitPair_elem(@NotNull WaccParser.Pair_elemContext ctx) {
    	System.out.println("visitPair_elem");
		visit(ctx.expr());
		ctx.typename = ctx.expr().typename;
		
		return null;
	}
*/
	
	@Override 
	public T visitPair_elem_fst(@NotNull WaccParser.Pair_elem_fstContext ctx) { 
		System.out.println("visitPair_elem_fst");

		visit(ctx.expr());
		if(ctx.expr().typename instanceof NULL) {
			ctx.typename = new NULL();
			return null;
		}
		PAIR_TYPE pair = (PAIR_TYPE) ctx.expr().typename;
		ctx.typename = pair.firstType();
		return null; 
	}
	
	@Override 
	public T visitPair_elem_snd(@NotNull WaccParser.Pair_elem_sndContext ctx) {
		System.out.println("visitPair_elem_snd");
		visit(ctx.expr());
//		ctx.typename = ctx.expr().typename;
		if(ctx.expr().typename instanceof NULL) {
			ctx.typename = new NULL();
			return null;
		}
		PAIR_TYPE pair = (PAIR_TYPE) ctx.expr().typename;
		ctx.typename = pair.secondType();
		return null; 
	}
	
	//assign rhs ------------------------
	
	@Override 
	public T visitAssign_rhs_newpair(@NotNull WaccParser.Assign_rhs_newpairContext ctx) { 
    	System.out.println("visitAssign_rhs_newpair");
		visit(ctx.expr(0));
		visit(ctx.expr(1));
		if(ctx.expr(0).typename == null) {
			ctx.expr(0).typename = new NULL();
		}
		if(ctx.expr(1).typename == null) {
			ctx.expr(1).typename = new NULL();
		}
		ctx.typename = new PAIR_TYPE(ctx.expr(0).typename, ctx.expr(1).typename);
		return null;
	}
	
	@Override public T visitAssign_rhs_expr(@NotNull WaccParser.Assign_rhs_exprContext ctx) { 
    	System.out.println("visitAssign_rhs_expr");
		visit(ctx.expr());
		ctx.typename = ctx.expr().typename;
		return null;
	}
	
	@Override public T visitAssign_rhs_ar_liter(@NotNull WaccParser.Assign_rhs_ar_literContext ctx) { 
    	System.out.println("visitAssign_rhs_ar_liter");
		visit(ctx.array_liter());
		ctx.typename = new ARRAY_TYPE(ctx.array_liter().typename);
		return null;
	}
	
	@Override public T visitAssign_rhs_pair_elem(@NotNull WaccParser.Assign_rhs_pair_elemContext ctx) { 
    	System.out.println("visitAssign_rhs_pair_elem");
		visit(ctx.pair_elem());
		ctx.typename = ctx.pair_elem().typename;
		return null;
	}
	
	//-------------------------------------------------
	@Override public T visitStat_skip(@NotNull WaccParser.Stat_skipContext ctx) {
    	System.out.println("visitStat_skip");
		ctx.typename = null;
		return null; 
	}
	
	@Override 
	public T visitBase_type_int(@NotNull WaccParser.Base_type_intContext ctx) { 
    	System.out.println("visitBase_type_int");
//		ctx.typename = (TYPE) currentTable.lookup("int");
    	ctx.typename = new INT();
		return null;
	}
	
	@Override 
	public T visitBase_type_char(@NotNull WaccParser.Base_type_charContext ctx) {
    	System.out.println("visitBase_type_char");
		ctx.typename = new CHAR();
		return null; 
	}
	
	@Override 
	public T visitBase_type_string(@NotNull WaccParser.Base_type_stringContext ctx) { 
    	System.out.println("visitBase_type_string");
		ctx.typename = new STRING();
		return null;
	}
	
	@Override 
	public T visitBase_type_bool(@NotNull WaccParser.Base_type_boolContext ctx) { 
    	System.out.println("visitBase_type_bool");
		ctx.typename = new BOOL();
		return null;
	}

	@Override public T visitPair_type(@NotNull WaccParser.Pair_typeContext ctx) {
    	System.out.println("visitPair_type");
    	System.out.println("Pair elem1: " + ctx.pair_elem_type(0).typename);
    	System.out.println("Pair elem2: " + ctx.pair_elem_type(1).typename);
		visit(ctx.pair_elem_type(0));
		visit(ctx.pair_elem_type(1));

		ctx.typename = new PAIR_TYPE(ctx.pair_elem_type(0).typename, ctx.pair_elem_type(1).typename);
		return null;
	}

	@Override public T visitInt_sign(@NotNull WaccParser.Int_signContext ctx) { return visitChildren(ctx); }

	@Override public T visitStr_liter(@NotNull WaccParser.Str_literContext ctx) { return visitChildren(ctx); }

	@Override public T visitBool_liter(@NotNull WaccParser.Bool_literContext ctx) { return visitChildren(ctx); }

	@Override public T visitParam_list(@NotNull WaccParser.Param_listContext ctx) { 
		List<ParamContext> pctx = ctx.param();
		for (ParamContext p : pctx){
			visit(p);
		}
		//what about typename for paramlist??
		return null;
	}

	@Override public T visitStat_begin_end(@NotNull WaccParser.Stat_begin_endContext ctx) {
		System.out.println("visitStat_begin_end");
		SymbolTable table = new SymbolTable(currentTable);
		currentTable = table;

//		SymbolTable temp = currentTable;
//		SymbolTable table = new SymbolTable(null);
//		currentTable = table;
		visit(ctx.stat());
//		currentTable = temp;
//		currentTable.encSymTable = null;
		currentTable = table.encSymTable;
		return null; 
	}

	@Override public T visitStat_free(@NotNull WaccParser.Stat_freeContext ctx) {
		System.out.println("visitStat_free");
		visit(ctx.expr());
		ctx.typename = ctx.expr().typename;
		if(ctx.typename instanceof NULL) {

			return null;
		}
		if (!(ctx.typename instanceof PAIR_TYPE) && !(ctx.typename instanceof ARRAY_TYPE)){

        	System.exit(200);//throw new Error("Cannot free TYPE " + ctx.typename.toString() + ", ARRAY_TYPE or PAIR_TYPE expected.");
		}

		return null; 
	}

	@Override public T visitArg_list(@NotNull WaccParser.Arg_listContext ctx) {
		List<ExprContext> list = ctx.expr();
		for (ExprContext e : list){
			visit(e);
		}
		return null; 
	}

	@Override public T visitArray_elem(@NotNull WaccParser.Array_elemContext ctx) { return visitChildren(ctx); }

	@Override public T visitProgram(@NotNull WaccParser.ProgramContext ctx) { 
		visitChildren(ctx);
		//visit(ctx.func(0));
		//visit(ctx.stat());
		return null; 
	}

	@Override public T visitChar_liter(@NotNull WaccParser.Char_literContext ctx) { return visitChildren(ctx); }

/*
	@Override public T visitPair_elem_type(@NotNull WaccParser.Pair_elem_typeContext ctx) {
		ctx.typename = ctx.base_type().typename;
		return null;
	}
*/
	
	@Override 
	public T visitPair_elem_base_type(@NotNull WaccParser.Pair_elem_base_typeContext ctx) { 
		System.out.println("visitPair_elem_base_type");
		visit(ctx.base_type());
		ctx.typename = ctx.base_type().typename;
		return null;
	}
	
	@Override 
	public T visitPair_elem_array_type(@NotNull WaccParser.Pair_elem_array_typeContext ctx) { 
		System.out.println("visitPair_elem_array_type");
		visit(ctx.array_type());
		ctx.typename = ctx.array_type().typename;
		return null;
	}
	
	@Override 
	public T visitPair(@NotNull WaccParser.PairContext ctx) { 
		System.out.println("visitPair");
		ctx.typename = new PAIR_TYPE(new NULL(), new NULL());  //<----not sure
		return null;
	}
	
	@Override public T visitArray_liter(@NotNull WaccParser.Array_literContext ctx) {
		System.out.println("visitArray_liter");
		List<ExprContext> list = ctx.expr();

		if (list.isEmpty()){
			ctx.typename = null;
		} else {
			
			for (ExprContext e : list){
				visit(e);

//				if (!(e.typename.equals(ctx.expr().get(0).typename))){
				if(!SharedMethods.assignCompat(ctx.expr().get(0).typename, e.typename)){
		        	System.exit(200);//throw new Error("Array elem not the same type.");
				}
			}
			ctx.typename = ctx.expr().get(0).typename;
		}
/*
		ExprContext expr1 = list.get(0);
		ExprContext expr2 = list.get(1);
		visit(expr1);
		visit(expr2);
		if(!SharedMethods.assignCompat(expr1.typename, expr2.typename)){

			throw new Error("Array elem not the same type");
		} */
		return null;
	}

	@Override public T visitStat_print(@NotNull WaccParser.Stat_printContext ctx) {
		System.out.println("visitStat_print");
		visit(ctx.expr());
		if(ctx.expr().typename == null) {
			System.exit(200);
		}
//		if !(ctx.typename.instanceof(string,char,array,int,bool,pair)) throw 
//		new Error("Cannot print Expression of type" + ctx.typename.toString());
		//have to override tostring in TYPE class
		return null; 
	}

	@Override public T visitInt_liter(@NotNull WaccParser.Int_literContext ctx) { 
		List<TerminalNode> list = ctx.INTEGER();
		Iterator<TerminalNode> it = list.iterator();
		String number = "";
		while (it.hasNext()) {
			number = number + it.next().getText();
		}
//		System.out.println("i got the number :" + number);
		try {
		Integer i = Integer.parseInt(number);
		} catch (NumberFormatException e) {
			System.out.println("Number exceed limit");
			System.exit(100);
		}
		return null;
	}

	@Override public T visitStat_println(@NotNull WaccParser.Stat_printlnContext ctx) {
		System.out.println("visitStat_println");
		visit(ctx.expr());
		if(ctx.expr().typename == null) {
			System.exit(200);
		}
//		if !(ctx.typename.instanceof(string,char,array,int,bool,pair)) throw 
//		new Error("Cannot print Expression of type" + ctx.typename.toString());
		//have to override tostring in TYPE class
		return null;
	}
	
	@Override 
	public T visitExpr_int(@NotNull WaccParser.Expr_intContext ctx) { 
		System.out.println("visitExpr_int");
		visit(ctx.int_liter());
		//ctx.typename = (TYPE) currentTable.lookup("int");
		ctx.typename = new INT();
		
		return null; 
	}
	
	@Override 
	public T visitExpr_bool(@NotNull WaccParser.Expr_boolContext ctx) {
		System.out.println("visitExpr_bool");
		ctx.typename = new BOOL();
		return null; 
	}
	
	@Override 
	public T visitExpr_char(@NotNull WaccParser.Expr_charContext ctx) { 
		System.out.println("visitExpr_char");
		ctx.typename = new CHAR();
		return null; 
	}
	
	@Override 
	public T visitExpr_str(@NotNull WaccParser.Expr_strContext ctx) { 
		System.out.println("visitExpr_str");
		ctx.typename = new STRING();		
		return null;
	}
	
	@Override public T visitExpr_ident(@NotNull WaccParser.Expr_identContext ctx) {
		System.out.println("visitExpr_ident");
		visit(ctx.ident());

		ctx.typename = ctx.ident().typename;
		String id = ctx.ident().getText();

		if(ctx.typename == null || ctx.typename instanceof NULL) {
			return null;
		}
		//also check if the ident has been declared

		if (currentTable.lookupAll(id) == null) System.exit(200);//throw new Error(id + "has not been declared");
		// do we have static variable in Wacc language. ^this would not support static var usage in stat in function declaration

		return null;
	}
	
	@Override public T visitExpr_pair(@NotNull WaccParser.Expr_pairContext ctx) { 
		// unimplemented
		ctx.typename = new PAIR_TYPE();
		return null;
	}
	
	@Override public T visitExpr_array_elem(@NotNull WaccParser.Expr_array_elemContext ctx) {
		visit(ctx.array_elem().ident());
		//ctx.typename = ctx.array_elem().ident().typename;
		ARRAY_TYPE ar = (ARRAY_TYPE) ctx.array_elem().ident().typename;
		ctx.typename = ar.TYPE();
		return null;
	}
	
	@Override public T visitExpr_binary(@NotNull WaccParser.Expr_binaryContext ctx) { 
		System.out.println("visitExpr_binary");
		visit(ctx.bin_bool());
		ctx.typename = ctx.bin_bool().returntype;
		return null;
	}
	
	@Override public T visitExpr_bin_bool_bool(@NotNull WaccParser.Expr_bin_bool_boolContext ctx) {
		System.out.println("visitExpr_bin_bool_bool");
		visit(ctx.bin_bool(0));
		visit(ctx.bin_bool(1));
		ctx.returntype = new BOOL();
		ctx.argtype = new BOOL();
		if(!SharedMethods.assignCompat(ctx.bin_bool(0).returntype, ctx.argtype)) {
			System.exit(200);
		}
		if(!SharedMethods.assignCompat(ctx.bin_bool(1).returntype, ctx.argtype)) {
			System.exit(200);
		}
		return null; 
	}
	
	@Override public T visitExpr_bin_bool_math(@NotNull WaccParser.Expr_bin_bool_mathContext ctx) {
		System.out.println("visitExpr_bin_bool_math");
		visit(ctx.math(0));
		visit(ctx.math(1));
		ctx.returntype = new BOOL();
		ctx.argtype = new EQUALITY();
		if(!SharedMethods.assignCompat(ctx.math(0).returntype, ctx.math(1).returntype)) {
			System.exit(200);
		}
		if(!ctx.argtype.getClass().isAssignableFrom(ctx.math(0).getClass())) {
			System.exit(200);
		}
		return null; 
	}
	
	@Override public T visitExpr_bin_math(@NotNull WaccParser.Expr_bin_mathContext ctx) {
		System.out.println("visitExpr_bin_math");
		visit(ctx.math());
		ctx.returntype = ctx.math().returntype;
		return null; 
	}
	
	@Override public T visitExpr_bin_math_math(@NotNull WaccParser.Expr_bin_math_mathContext ctx) {
		System.out.println("visitExpr_bin_math_math");
		visit(ctx.math(0));
		visit(ctx.math(1));
		ctx.returntype = new INT();
		ctx.argtype = new INT();
		if(!SharedMethods.assignCompat(ctx.math(0).returntype, ctx.argtype)) {
			System.exit(200);
		}
		if(!SharedMethods.assignCompat(ctx.math(1).returntype, ctx.argtype)) {
			System.exit(200);
		}
		return null; 
	}
	
	@Override public T visitExpr_bin_math_atom(@NotNull WaccParser.Expr_bin_math_atomContext ctx) {
		System.out.println("visitExpr_bin_math_atom");
		visit(ctx.atom(0));
		visit(ctx.atom(1));
		ctx.returntype = new INT();
		ctx.argtype = new INT();
		if(!SharedMethods.assignCompat(ctx.atom(0).typename, ctx.argtype)) {
			System.exit(200);
		}
		if(!SharedMethods.assignCompat(ctx.atom(1).typename, ctx.argtype)) {
			System.exit(200);
		}
		return null; 
	}
	
	@Override public T visitExpr_bin_atom(@NotNull WaccParser.Expr_bin_atomContext ctx) {
		System.out.println("visitExpr_bin_atom");
		visit(ctx.atom());
		ctx.returntype = ctx.atom().typename;
		return null; 
	}
	
	@Override public T visitAtom_int(@NotNull WaccParser.Atom_intContext ctx) {
		visit(ctx.int_liter());
		ctx.typename = new INT();
		return null;
	}
	
	@Override public T visitAtom_char(@NotNull WaccParser.Atom_charContext ctx) {
		ctx.typename = new CHAR();
		return null;
	}
	
	@Override public T visitAtom_bool(@NotNull WaccParser.Atom_boolContext ctx) {
		ctx.typename = new BOOL();
		return null;
	}
	
	@Override public T visitAtom_ident(@NotNull WaccParser.Atom_identContext ctx) {
		visit(ctx.ident());
		ctx.typename = ctx.ident().typename;
		return null;
	}
	
	@Override public T visitAtom_brackets(@NotNull WaccParser.Atom_bracketsContext ctx) {
		visit(ctx.expr());
		ctx.typename = ctx.expr().typename;
		return null;
	}
	
	
	
	@Override public T visitExpr_unary(@NotNull WaccParser.Expr_unaryContext ctx) {
		System.out.println("visitExpr_unary");
		visit(ctx.unary_oper());
		visit(ctx.expr());
		if(ctx.expr().typename == null) {
			System.exit(200);
		}
		if(!SharedMethods.assignCompat(ctx.unary_oper().argtype, ctx.expr().typename)) {
			System.exit(200);
		}
		ctx.typename = ctx.unary_oper().returntype;
		return null;
	}
	
	@Override public T visitUnary_not(@NotNull WaccParser.Unary_notContext ctx) { 
		System.out.println("Unary_not");
		ctx.argtype = new BOOL(); ctx.returntype = new BOOL(); return null; }
	
	@Override public T visitUnary_minus(@NotNull WaccParser.Unary_minusContext ctx) { 
		System.out.println("Unary_minus");
		ctx.argtype = new INT(); ctx.returntype = new INT(); return null; }
	
	@Override public T visitUnary_len(@NotNull WaccParser.Unary_lenContext ctx) { //ARRAY TYPE CHECK!!!
		System.out.println("Unary_len");
		ctx.argtype = new ARRAY_TYPE(ctx.argtype); ctx.returntype = new INT(); return null; }
	
	@Override public T visitUnary_chr(@NotNull WaccParser.Unary_chrContext ctx) { 
		System.out.println("Unary_chr");
		ctx.argtype = new INT(); ctx.returntype = new CHAR(); return null; }
	
	@Override public T visitUnary_ord(@NotNull WaccParser.Unary_ordContext ctx) { 
		System.out.println("Unary_ord");
		ctx.argtype = new CHAR(); ctx.returntype = new INT(); return null; }

	@Override public T visitExpr_brackets(@NotNull WaccParser.Expr_bracketsContext ctx) {
		System.out.println("Unary_brackets");
		visit(ctx.expr());
		ctx.typename = ctx.expr().typename;
		return null;
	}

}
