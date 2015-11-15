import SemanticAnalyser.*;
import antlr.WaccParser;
import antlr.WaccParser.ExprContext;
import antlr.WaccParser.ParamContext;
import antlr.WaccParser.StatContext;
import antlr.WaccParserBaseVisitor;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
//import sun.jvm.hotspot.debugger.cdbg.Sym;


import java.util.ArrayList;
import java.util.List;

public class MyWaccVisitor<T> extends WaccParserBaseVisitor<T> {
    SymbolTable currentTable = new SymbolTable(null);
//    currentTable.add("int",new TYPE());


    @Override 
    public T visitStat_stat(@NotNull WaccParser.Stat_statContext ctx) {
        //WaccParser.StatContext first = ctx.stat(0);  // assuming parameter 0 returns first stat
        //WaccParser.StatContext second = ctx.stat(1); // assuming parameter 1 return second stat
        //visit(first);
        //visit(second); //but we need to return

        //or
        List<WaccParser.StatContext> stats = ctx.stat();
    	for (StatContext s : stats){
    		visit(s);
    	}
    	
    	return null;
        //or
        //return visitChildren(ctx);
    }

    @Override 
    public T visitStat_assign(@NotNull WaccParser.Stat_assignContext ctx) {
        WaccParser.Assign_lhsContext lhs = ctx.assign_lhs();
        WaccParser.Assign_rhsContext rhs = ctx.assign_rhs();

        visit(lhs);
        visit(rhs);
        
        //assignCompat(rhs.typename,lhs.typename);  
        
    	return null;
    }

    @Override 
    public T visitStat_declare(@NotNull WaccParser.Stat_declareContext ctx) {
//      WaccParser.TypeContext type = ctx.type();
//      WaccParser.IdentContext id  = ctx.ident();
//      WaccParser.Assign_rhsContext rhs = ctx.assign_rhs();
//
//      DeclarationAST D = new DeclarationAST(currentTable);
//      D.check();
  	
      //check for assign because we in wacc we do declare and assign at the same time
  	
      WaccParser.Assign_rhsContext rhs = ctx.assign_rhs();
      visit(rhs);
      //assignCompat(ctx.type().typename, rhs.typename);
      if (currentTable.lookup(ctx.ident().getText()) == null) {
    	  throw new Error("Variable already declared");
      }
      currentTable.add(ctx.ident().getText(), rhs.typename);
	
  	return null;
    }

    @Override
    public T visitFunc(@NotNull WaccParser.FuncContext ctx) {

		IDENTIFIER id = currentTable.lookup(ctx.ident().getText());
		if(id != null) throw new Error();

		visit(ctx.type());
		TYPE returntypename = ctx.type().typename;

		SymbolTable newST = new SymbolTable(currentTable);
		currentTable = newST;
		ctx.funObj = new FUNCTION(returntypename);
		currentTable.add(ctx.ident().getText(), ctx.funObj);

		ctx.funObj.symtab = newST;
		visit(ctx.param_list());

		List <ParamContext> params = ctx.param_list().param();
		for(ParamContext p : params){
			ctx.funObj.formals.add(p.paramObj);
		}

		visit(ctx.stat());
		if(returntypename != ctx.stat().typename) throw new Error("statement return type not match function return type");

		currentTable = currentTable.encSymTable;

		return null;
    }

	@Override 
	public T visitAssign_rhs_call(@NotNull WaccParser.Assign_rhs_callContext ctx) {
		//visit(ctx.ident());
		//ctx.typename = ctx.ident().typename;
		if(currentTable.lookup(ctx.ident().getText()) == null) {
			throw new Error("Invalid function");
		}
		FUNCTION func = (FUNCTION) currentTable.lookup(ctx.ident().getText());
	    List<PARAM> parameters = func.formals;

		List<ParseTree> args = ctx.arg_list().children;
		
		for (ParseTree arg : args) {
			visit(arg);
			
		}
		
		TYPE paramType, argType;
		for(int i = 0; i < parameters.size(); i++) {
			paramType = parameters.get(i).TYPE();
			visit(args.get(i));
		}

		return visitChildren(ctx);
	}


	@Override public T visitPair_liter(@NotNull WaccParser.Pair_literContext ctx) { 
		//ctx.typename = null;
		return null;
	}

	@Override public T visitParam(@NotNull WaccParser.ParamContext ctx) {
		visit(ctx.type());

		String param_name = ctx.ident().getText();
		PARAM p = new PARAM(ctx.type().typename);
		currentTable.add(param_name, p);
		ctx.paramObj = p;

		return null;
	}

	@Override public T visitStat_if(@NotNull WaccParser.Stat_ifContext ctx) { 
		ExprContext ifcont = ctx.expr();
		List<StatContext> stats = ctx.stat();
		visit(ifcont);
		for (StatContext s : stats){
			visit(s);
		}
		return null;
	}

	@Override public T visitStat_read(@NotNull WaccParser.Stat_readContext ctx) { 
		
		visit(ctx.assign_lhs());
		//a read statement can only target a program variable, an array element or a pair element
		if ((!(ctx.assign_lhs().typename instanceof ARRAY_TYPE)) ||
		(!(ctx.assign_lhs().typename instanceof PAIR_TYPE)))
		throw new Error("cannot read into type " + ctx.assign_lhs().typename.toString() + "PAIR or ARRAY expected.");
		//check std input that its only char / int input
		//if !(ctx.READ().getClass() instanceof char / int) throw Error("input has to be only char/int")
		//check if the types of 2 sides match
		return null;
	}

	@Override 
	public T visitType_pairtype(@NotNull WaccParser.Type_pairtypeContext ctx) { 
		visit(ctx.pair_type());
		ctx.typename = ctx.pair_type().typename;
		return null;
	}
	
	@Override 
	public T visitType_arraytype(@NotNull WaccParser.Type_arraytypeContext ctx) { 
		visit(ctx.array_type());
		ctx.typename = ctx.array_type().typename;
		return null;
	}
	
	@Override 
	public T visitType_basetype(@NotNull WaccParser.Type_basetypeContext ctx) {
		visit(ctx.base_type());
		ctx.typename = ctx.base_type().typename;
		
		return null;
	}

	@Override public T visitStat_exit(@NotNull WaccParser.Stat_exitContext ctx) {
		visit(ctx.expr());
		ctx.typename = ctx.expr().typename;
		return null; 
	}

	public T visitUnary_oper(@NotNull WaccParser.Unary_operContext ctx) { return visitChildren(ctx); }

	@Override public T visitStat_while(@NotNull WaccParser.Stat_whileContext ctx) { 
		visit(ctx.expr());
		visit(ctx.stat());
		return null; 
	}

	//put type into ident according to the symbol table
	@Override public T visitIdent(@NotNull WaccParser.IdentContext ctx) {
		IDENTIFIER type = currentTable.lookup(ctx.getText());
		VARIABLE var = (VARIABLE) type;
		ctx.typename = var.TYPE();
		return null;
	}
	
	@Override public T visitAssign_lhs_ident(@NotNull WaccParser.Assign_lhs_identContext ctx) { 
		IDENTIFIER type = currentTable.lookup(ctx.getText());
		VARIABLE var = (VARIABLE) type;
		ctx.typename = var.TYPE();
		return null;
}
	
	@Override public T visitAssign_lhs_array(@NotNull WaccParser.Assign_lhs_arrayContext ctx) {
		visit(ctx.array_elem().ident());
		ctx.typename = ctx.array_elem().ident().typename;
		
		//IDENTIFIER x = currentTable.lookup(ctx.array_elem().ident().getText());
		//ARRAY_TYPE xx = (ARRAY_TYPE) x;
		//ctx.typename = xx.TYPE();
		return null;
	}
	
	@Override 
	public T visitAssign_lhs_pair(@NotNull WaccParser.Assign_lhs_pairContext ctx) { 
		visit(ctx.pair_elem());
		ctx.typename = ctx.pair_elem().typename;
		return null;
	}

	@Override public T visitStat_return(@NotNull WaccParser.Stat_returnContext ctx) { 
		visit(ctx.expr());
		ctx.typename = ctx.expr().typename;
		//check if type is returnable -> check with function type
		IDENTIFIER returntype = currentTable.lookup(ctx.getText()); //not sure
		//assignCompat(returntype, ctx.typename);
		return null; 
		
	}

	@Override 
	public T visitArray_type_array(@NotNull WaccParser.Array_type_arrayContext ctx) { 
		visit(ctx.array_type());
		
		ctx.typename = ctx.array_type().typename;
		return null;
	}
	
	@Override 
	public T visitArray_type_base(@NotNull WaccParser.Array_type_baseContext ctx) { 
		visit(ctx.base_type());
		ctx.typename = ctx.base_type().typename;
		return null;
	}
	
	@Override 
	public T visitArray_type_pair(@NotNull WaccParser.Array_type_pairContext ctx) { 
		visit(ctx.pair_type());
		ctx.typename = ctx.pair_type().typename;
		return null;
	}

	@Override 
	public T visitPair_elem(@NotNull WaccParser.Pair_elemContext ctx) {
		visit(ctx.expr());
		ctx.typename = ctx.expr().typename;
		
		return null;
	}
	
	//assign rhs ------------------------
	
	@Override 
	public T visitAssign_rhs_newpair(@NotNull WaccParser.Assign_rhs_newpairContext ctx) { 
		visit(ctx.expr(0));
		visit(ctx.expr(1));
		ctx.typename = new PAIR_TYPE(ctx.expr(0).typename, ctx.expr(1).typename);
				
		return null;
	}
	
	@Override public T visitAssign_rhs_expr(@NotNull WaccParser.Assign_rhs_exprContext ctx) { 
		visit(ctx.expr());
		ctx.typename = ctx.expr().typename;
		return null;
	}
	
	@Override public T visitAssign_rhs_ar_liter(@NotNull WaccParser.Assign_rhs_ar_literContext ctx) { 
		visit(ctx.array_liter());
		//ctx.typename = ctx.array_liter().typename;
		return null;
	}
	
	@Override public T visitAssign_rhs_pair_elem(@NotNull WaccParser.Assign_rhs_pair_elemContext ctx) { 
		visit(ctx.pair_elem());
		ctx.typename = ctx.pair_elem().typename;
		return null;
	}
	
	//-------------------------------------------------
	@Override public T visitStat_skip(@NotNull WaccParser.Stat_skipContext ctx) {
		ctx.typename = null;
		return null; 
	}
	
	@Override 
	public T visitBase_type_int(@NotNull WaccParser.Base_type_intContext ctx) { 
		ctx.typename = new INT();
		return null;
	}
	
	@Override 
	public T visitBase_type_char(@NotNull WaccParser.Base_type_charContext ctx) {
		ctx.typename = new CHAR();
		return null; 
	}
	
	@Override 
	public T visitBase_type_string(@NotNull WaccParser.Base_type_stringContext ctx) { 
		ctx.typename = new STRING();
		return null;
	}
	
	@Override 
	public T visitBase_type_bool(@NotNull WaccParser.Base_type_boolContext ctx) { 
		ctx.typename = new BOOL();
		return null;
	}

	@Override public T visitPair_type(@NotNull WaccParser.Pair_typeContext ctx) {
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
		//new scope created so maybe new symboltable?
		visit(ctx.stat());
		return null; 
	}

	@Override public T visitStat_free(@NotNull WaccParser.Stat_freeContext ctx) {
		visit(ctx.expr());
		ctx.typename = ctx.expr().typename;
		if (!(ctx.typename instanceof PAIR_TYPE) || !(ctx.typename instanceof ARRAY_TYPE))
			throw new Error("Cannot free TYPE " + ctx.typename.toString() + ", ARRAY_TYPE or PAIR_TYPE expected.");
		return null; 
	}

	@Override public T visitArg_list(@NotNull WaccParser.Arg_listContext ctx) { return visitChildren(ctx); }

	@Override public T visitArray_elem(@NotNull WaccParser.Array_elemContext ctx) { return visitChildren(ctx); }

	@Override public T visitProgram(@NotNull WaccParser.ProgramContext ctx) { return visitChildren(ctx); }

	@Override public T visitChar_liter(@NotNull WaccParser.Char_literContext ctx) { return visitChildren(ctx); }

/*
	@Override public T visitPair_elem_type(@NotNull WaccParser.Pair_elem_typeContext ctx) {
		ctx.typename = ctx.base_type().typename;
		return null;
	}
*/
	
	@Override 
	public T visitPair_elem_base_type(@NotNull WaccParser.Pair_elem_base_typeContext ctx) { 
		visit(ctx.base_type());
		ctx.typename = ctx.base_type().typename;
		return null;
	}
	
	@Override 
	public T visitPair_elem_array_type(@NotNull WaccParser.Pair_elem_array_typeContext ctx) { 
		visit(ctx.array_type());
		ctx.typename = ctx.array_type().typename;
		return null;
	}
	
	@Override 
	public T visitPair(@NotNull WaccParser.PairContext ctx) { 
		//ctx.typename = new PAIR_TYPE(null, null);  <----not sure
		return null;
	}
	
	@Override public T visitArray_liter(@NotNull WaccParser.Array_literContext ctx) {
		List<ExprContext> list = ctx.expr();
		if (list.isEmpty()){
			ctx.typename = null;
		} else {
			for (ExprContext e : list){
				if (!(e.typename.equals(ctx.expr().get(0).typename))){
				throw new Error("Array elem not the same type.");
				}
			}
			ctx.typename = ctx.expr().get(0).typename;
		}
		return null;
	}

	@Override public T visitStat_print(@NotNull WaccParser.Stat_printContext ctx) {
		visit(ctx.expr());
//		if !(ctx.typename.instanceof(string,char,array,int,bool,pair)) throw 
//		new Error("Cannot print Expression of type" + ctx.typename.toString());
		//have to override tostring in TYPE class
		return null; 
	}

	@Override public T visitInt_liter(@NotNull WaccParser.Int_literContext ctx) { return visitChildren(ctx); }

	@Override public T visitStat_println(@NotNull WaccParser.Stat_printlnContext ctx) {
		visit(ctx.expr());
//		if !(ctx.typename.instanceof(string,char,array,int,bool,pair)) throw 
//		new Error("Cannot print Expression of type" + ctx.typename.toString());
		//have to override tostring in TYPE class
		return null;
	}
	
	@Override public T visitExpr_int(@NotNull WaccParser.Expr_intContext ctx) { ctx.typename = new INT(); return null; }
	
	@Override public T visitExpr_bool(@NotNull WaccParser.Expr_boolContext ctx) { ctx.typename = new BOOL(); return null; }
	
	@Override public T visitExpr_char(@NotNull WaccParser.Expr_charContext ctx) { ctx.typename = new CHAR(); return null; }
	
	@Override public T visitExpr_str(@NotNull WaccParser.Expr_strContext ctx) { ctx.typename = new STRING(); return null; }
	
	@Override public T visitExpr_ident(@NotNull WaccParser.Expr_identContext ctx) {
		visit(ctx.ident());
		ctx.typename = ctx.ident().typename;
		return null;
	}
	
	@Override public T visitExpr_pair(@NotNull WaccParser.Expr_pairContext ctx) { 
		// unimplemented
		return visitChildren(ctx); }
	
	@Override public T visitExpr_array_elem(@NotNull WaccParser.Expr_array_elemContext ctx) {
		visit(ctx.array_elem().ident());
		ctx.typename = ctx.array_elem().ident().typename;
		return null;
	}
	
	@Override public T visitExpr_binary(@NotNull WaccParser.Expr_binaryContext ctx) { 
		visit(ctx.expr(0));
		visit(ctx.expr(1));
		visit(ctx.binary_oper());
		//assignCompat(ctx.expr(0).typename, ctx.expr(1).typename);
		assert ctx.binary_oper().getClass().isAssignableFrom(ctx.expr(0).typename.getClass());
		return null;
	}
	
	@Override public T visitBin_bool(@NotNull WaccParser.Bin_boolContext ctx) { 
		ctx.argtype = new EQUALITY(); ctx.returntype = new BOOL(); return null; }
	
	@Override public T visitBin_math(@NotNull WaccParser.Bin_mathContext ctx) { 
		ctx.argtype = new INT(); ctx.returntype = new INT(); return null; }
	
	@Override public T visitBin_compare(@NotNull WaccParser.Bin_compareContext ctx) { 
		ctx.argtype = new INT(); ctx.returntype = new BOOL(); return null; }
	
	@Override public T visitBin_logic(@NotNull WaccParser.Bin_logicContext ctx) { 
		ctx.argtype = new BOOL(); ctx.returntype = new BOOL(); return null; }
	
	@Override public T visitExpr_unary(@NotNull WaccParser.Expr_unaryContext ctx) { 
		visit(ctx.unary_oper());
		visit(ctx.expr());
		//assignCompat(ctx.unary_oper().argtype, ctx.expr().typename);
		ctx.typename = ctx.unary_oper().returntype;
		return null;
	}
	
	@Override public T visitUnary_not(@NotNull WaccParser.Unary_notContext ctx) { 
		ctx.argtype = new BOOL(); ctx.returntype = new BOOL(); return null; }
	
	@Override public T visitUnary_minus(@NotNull WaccParser.Unary_minusContext ctx) { 
		ctx.argtype = new INT(); ctx.returntype = new INT(); return null; }
	
	@Override public T visitUnary_len(@NotNull WaccParser.Unary_lenContext ctx) { 
		ctx.argtype = new ARRAY_TYPE(); ctx.returntype = new INT(); return null; }
	
	@Override public T visitUnary_chr(@NotNull WaccParser.Unary_chrContext ctx) { 
		ctx.argtype = new INT(); ctx.returntype = new CHAR(); return null; }
	
	@Override public T visitUnary_ord(@NotNull WaccParser.Unary_ordContext ctx) { 
		ctx.argtype = new CHAR(); ctx.returntype = new INT(); return null; }

	@Override public T visitExpr_brackets(@NotNull WaccParser.Expr_bracketsContext ctx) {
		visit(ctx.expr());
		ctx.typename = ctx.expr().typename;
		return null;
	}

}