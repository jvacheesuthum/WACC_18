// Generated from ./WaccParser.g4 by ANTLR 4.4
package antlr;
import SemanticAnalyser.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link WaccParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface WaccParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link WaccParser#pair_liter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair_liter(@NotNull WaccParser.Pair_literContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(@NotNull WaccParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stat_declare}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_declare(@NotNull WaccParser.Stat_declareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign_lhs_pair}
	 * labeled alternative in {@link WaccParser#assign_lhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_lhs_pair(@NotNull WaccParser.Assign_lhs_pairContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stat_if}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_if(@NotNull WaccParser.Stat_ifContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stat_read}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_read(@NotNull WaccParser.Stat_readContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(@NotNull WaccParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stat_assign}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_assign(@NotNull WaccParser.Stat_assignContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull WaccParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stat_exit}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_exit(@NotNull WaccParser.Stat_exitContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#unary_oper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_oper(@NotNull WaccParser.Unary_operContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign_lhs_ident}
	 * labeled alternative in {@link WaccParser#assign_lhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_lhs_ident(@NotNull WaccParser.Assign_lhs_identContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stat_while}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_while(@NotNull WaccParser.Stat_whileContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdent(@NotNull WaccParser.IdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(@NotNull WaccParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stat_return}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_return(@NotNull WaccParser.Stat_returnContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#array_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_type(@NotNull WaccParser.Array_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#pair_elem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair_elem(@NotNull WaccParser.Pair_elemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stat_skip}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_skip(@NotNull WaccParser.Stat_skipContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stat_stat}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_stat(@NotNull WaccParser.Stat_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#base_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBase_type(@NotNull WaccParser.Base_typeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign_rhs_expr}
	 * labeled alternative in {@link WaccParser#assign_rhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_rhs_expr(@NotNull WaccParser.Assign_rhs_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign_rhs_ar_liter}
	 * labeled alternative in {@link WaccParser#assign_rhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_rhs_ar_liter(@NotNull WaccParser.Assign_rhs_ar_literContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#pair_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair_type(@NotNull WaccParser.Pair_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#int_sign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt_sign(@NotNull WaccParser.Int_signContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#str_liter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStr_liter(@NotNull WaccParser.Str_literContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#bool_liter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_liter(@NotNull WaccParser.Bool_literContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#param_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_list(@NotNull WaccParser.Param_listContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stat_begin_end}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_begin_end(@NotNull WaccParser.Stat_begin_endContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign_lhs_array}
	 * labeled alternative in {@link WaccParser#assign_lhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_lhs_array(@NotNull WaccParser.Assign_lhs_arrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stat_free}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_free(@NotNull WaccParser.Stat_freeContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#arg_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg_list(@NotNull WaccParser.Arg_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#array_elem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_elem(@NotNull WaccParser.Array_elemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign_rhs_call_empty}
	 * labeled alternative in {@link WaccParser#assign_rhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_rhs_call_empty(@NotNull WaccParser.Assign_rhs_call_emptyContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull WaccParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#binary_oper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary_oper(@NotNull WaccParser.Binary_operContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#char_liter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChar_liter(@NotNull WaccParser.Char_literContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#pair_elem_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair_elem_type(@NotNull WaccParser.Pair_elem_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#array_liter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_liter(@NotNull WaccParser.Array_literContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign_rhs_newpair}
	 * labeled alternative in {@link WaccParser#assign_rhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_rhs_newpair(@NotNull WaccParser.Assign_rhs_newpairContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stat_print}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_print(@NotNull WaccParser.Stat_printContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#int_liter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt_liter(@NotNull WaccParser.Int_literContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stat_println}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_println(@NotNull WaccParser.Stat_printlnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign_rhs_call}
	 * labeled alternative in {@link WaccParser#assign_rhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_rhs_call(@NotNull WaccParser.Assign_rhs_callContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign_rhs_pair_elem}
	 * labeled alternative in {@link WaccParser#assign_rhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_rhs_pair_elem(@NotNull WaccParser.Assign_rhs_pair_elemContext ctx);
}