import SemanticAnalyser.*;
import antlr.WaccParser;
import antlr.WaccParserBaseVisitor;
import com.sun.istack.internal.NotNull;

import java.util.List;

public class MyWaccVisitor<T> extends WaccParserBaseVisitor<T> {
    SymbolTable currentTable = new SymbolTable(null);
    currentTable.add("int",new TYPE());


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

        // blah blah

    }

    @Override 
    public T visitStat_declare(@NotNull WaccParser.Stat_declareContext ctx) {
        WaccParser.TypeContext type = ctx.type();
        WaccParser.IdentContext id  = ctx.ident();
        WaccParser.Assign_rhsContext rhs = ctx.assign_rhs();

        DeclarationAST D = new DeclarationAST(currentTable);
        D.check();

        //check for assign because we in wacc we do declare and assign at the same time


    }

    @Override
    public T visitFunc(@NotNull WaccParser.FuncContext ctx) {
        return visitChildren(ctx);
    }
    
	@Override public T visitPair_liter(@NotNull WaccParser.Pair_literContext ctx) { return visitChildren(ctx); }

	@Override public T visitParam(@NotNull WaccParser.ParamContext ctx) { return visitChildren(ctx); }

	@Override public T visitStat_if(@NotNull WaccParser.Stat_ifContext ctx) { return visitChildren(ctx); }

	@Override public T visitStat_read(@NotNull WaccParser.Stat_readContext ctx) { return visitChildren(ctx); }

	@Override public T visitExpr(@NotNull WaccParser.ExprContext ctx) { return visitChildren(ctx); }

	@Override public T visitType(@NotNull WaccParser.TypeContext ctx) { return visitChildren(ctx); }

	@Override public T visitStat_exit(@NotNull WaccParser.Stat_exitContext ctx) { return visitChildren(ctx); }

	@Override public T visitUnary_oper(@NotNull WaccParser.Unary_operContext ctx) { return visitChildren(ctx); }

	@Override public T visitStat_while(@NotNull WaccParser.Stat_whileContext ctx) { return visitChildren(ctx); }

	@Override public T visitIdent(@NotNull WaccParser.IdentContext ctx) { return visitChildren(ctx); }

	@Override public T visitStat_return(@NotNull WaccParser.Stat_returnContext ctx) { return visitChildren(ctx); }

	@Override public T visitArray_type(@NotNull WaccParser.Array_typeContext ctx) { return visitChildren(ctx); }

	@Override public T visitPair_elem(@NotNull WaccParser.Pair_elemContext ctx) { return visitChildren(ctx); }

	@Override public T visitStat_skip(@NotNull WaccParser.Stat_skipContext ctx) { return visitChildren(ctx); }

	@Override public T visitBase_type(@NotNull WaccParser.Base_typeContext ctx) { return visitChildren(ctx); }

	@Override public T visitPair_type(@NotNull WaccParser.Pair_typeContext ctx) { return visitChildren(ctx); }

	@Override public T visitInt_sign(@NotNull WaccParser.Int_signContext ctx) { return visitChildren(ctx); }

	@Override public T visitStr_liter(@NotNull WaccParser.Str_literContext ctx) { return visitChildren(ctx); }

	@Override public T visitBool_liter(@NotNull WaccParser.Bool_literContext ctx) { return visitChildren(ctx); }

	@Override public T visitAssign_lhs(@NotNull WaccParser.Assign_lhsContext ctx) { return visitChildren(ctx); }

	@Override public T visitParam_list(@NotNull WaccParser.Param_listContext ctx) { return visitChildren(ctx); }

	@Override public T visitStat_begin_end(@NotNull WaccParser.Stat_begin_endContext ctx) { return visitChildren(ctx); }

	@Override public T visitStat_free(@NotNull WaccParser.Stat_freeContext ctx) { return visitChildren(ctx); }

	@Override public T visitArg_list(@NotNull WaccParser.Arg_listContext ctx) { return visitChildren(ctx); }

	@Override public T visitArray_elem(@NotNull WaccParser.Array_elemContext ctx) { return visitChildren(ctx); }

	@Override public T visitProgram(@NotNull WaccParser.ProgramContext ctx) { return visitChildren(ctx); }

	@Override public T visitBinary_oper(@NotNull WaccParser.Binary_operContext ctx) { return visitChildren(ctx); }

	@Override public T visitChar_liter(@NotNull WaccParser.Char_literContext ctx) { return visitChildren(ctx); }

	@Override public T visitPair_elem_type(@NotNull WaccParser.Pair_elem_typeContext ctx) { return visitChildren(ctx); }

	@Override public T visitArray_liter(@NotNull WaccParser.Array_literContext ctx) { return visitChildren(ctx); }

	@Override public T visitAssign_rhs(@NotNull WaccParser.Assign_rhsContext ctx) { return visitChildren(ctx); }

	@Override public T visitStat_print(@NotNull WaccParser.Stat_printContext ctx) { return visitChildren(ctx); }

	@Override public T visitInt_liter(@NotNull WaccParser.Int_literContext ctx) { return visitChildren(ctx); }

	@Override public T visitStat_println(@NotNull WaccParser.Stat_printlnContext ctx) { return visitChildren(ctx); }



}