import SemanticAnalyser.*;
import antlr.WaccParser;
import antlr.WaccParserBaseVisitor;
import org.antlr.v4.runtime.misc.NotNull;


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
        //List<WaccParser.StatContext> stats = ctx.stat();
        //return visit(stats); // assuming visit can take in list

        //or
        return visitChildren(ctx);
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
    
    @Override public T visitAssign_rhs_call(@NotNull WaccParser.Assign_rhs_callContext ctx) { 
    	visit(ctx.ident());
    	//ctx.typename = ctx.ident().typename;
    	
    	return visitChildren(ctx); 
    }

    @Override 
    public T visitStat_declare(@NotNull WaccParser.Stat_declareContext ctx) {
//        WaccParser.TypeContext type = ctx.type();
//        WaccParser.IdentContext id  = ctx.ident();
//        WaccParser.Assign_rhsContext rhs = ctx.assign_rhs();
//
//        DeclarationAST D = new DeclarationAST(currentTable);
//        D.check();
    	System.out.println("HELLO I AM HERE");
        //check for assign because we in wacc we do declare and assign at the same time
    	
    	
    	
    	return visitChildren(ctx);

    }

    @Override
    public T visitFunc(@NotNull WaccParser.FuncContext ctx) {
        return visitChildren(ctx);
    }
    
	@Override public T visitPair_liter(@NotNull WaccParser.Pair_literContext ctx) { return visitChildren(ctx); }

	@Override public T visitParam(@NotNull WaccParser.ParamContext ctx) { return visitChildren(ctx); }

	@Override public T visitStat_if(@NotNull WaccParser.Stat_ifContext ctx) { return visitChildren(ctx); }

	@Override public T visitStat_read(@NotNull WaccParser.Stat_readContext ctx) { return visitChildren(ctx); }

	@Override public T visitType(@NotNull WaccParser.TypeContext ctx) { return visitChildren(ctx); }

	@Override public T visitStat_exit(@NotNull WaccParser.Stat_exitContext ctx) { return visitChildren(ctx); }

	@Override public T visitStat_while(@NotNull WaccParser.Stat_whileContext ctx) { return visitChildren(ctx); }

	@Override public T visitIdent(@NotNull WaccParser.IdentContext ctx) {
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

	@Override public T visitStat_return(@NotNull WaccParser.Stat_returnContext ctx) { return visitChildren(ctx); }

	@Override public T visitArray_type(@NotNull WaccParser.Array_typeContext ctx) { return visitChildren(ctx); }

	@Override public T visitPair_elem(@NotNull WaccParser.Pair_elemContext ctx) { return visitChildren(ctx); }

	@Override public T visitStat_skip(@NotNull WaccParser.Stat_skipContext ctx) { return visitChildren(ctx); }

	@Override public T visitBase_type(@NotNull WaccParser.Base_typeContext ctx) { System.out.println("HELLO THIS IS BASE"); return visitChildren(ctx); }

	@Override public T visitPair_type(@NotNull WaccParser.Pair_typeContext ctx) { return visitChildren(ctx); }

	@Override public T visitInt_sign(@NotNull WaccParser.Int_signContext ctx) { return visitChildren(ctx); }

	@Override public T visitStr_liter(@NotNull WaccParser.Str_literContext ctx) { return visitChildren(ctx); }

	@Override public T visitBool_liter(@NotNull WaccParser.Bool_literContext ctx) { return visitChildren(ctx); }

	@Override public T visitParam_list(@NotNull WaccParser.Param_listContext ctx) { return visitChildren(ctx); }

	@Override public T visitStat_begin_end(@NotNull WaccParser.Stat_begin_endContext ctx) { return visitChildren(ctx); }

	@Override public T visitStat_free(@NotNull WaccParser.Stat_freeContext ctx) { return visitChildren(ctx); }

	@Override public T visitArg_list(@NotNull WaccParser.Arg_listContext ctx) { return visitChildren(ctx); }

	@Override public T visitArray_elem(@NotNull WaccParser.Array_elemContext ctx) { return visitChildren(ctx); }

	@Override public T visitProgram(@NotNull WaccParser.ProgramContext ctx) { return visitChildren(ctx); }

	@Override public T visitChar_liter(@NotNull WaccParser.Char_literContext ctx) { return visitChildren(ctx); }

	@Override public T visitPair_elem_type(@NotNull WaccParser.Pair_elem_typeContext ctx) { return visitChildren(ctx); }

	@Override public T visitArray_liter(@NotNull WaccParser.Array_literContext ctx) { return visitChildren(ctx); }

	@Override public T visitStat_print(@NotNull WaccParser.Stat_printContext ctx) { return visitChildren(ctx); }

	@Override public T visitInt_liter(@NotNull WaccParser.Int_literContext ctx) { return visitChildren(ctx); }

	@Override public T visitStat_println(@NotNull WaccParser.Stat_printlnContext ctx) { return visitChildren(ctx); }
	
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