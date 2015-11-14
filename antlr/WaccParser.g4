parser grammar WaccParser;
@parser::header{
  import SemanticAnalyser.*;
 }


options {
  tokenVocab=WaccLexer;
}

ident
locals[TYPE typename]
: VARIABLE;

pair_liter: NUL;

array_liter: OPEN_SQUARE_BRACKET (expr (COMMA expr)?) CLOSE_SQUARE_BRACKET;

str_liter: DOUBLE_QUOTATION (CHARACTER)* DOUBLE_QUOTATION ;

char_liter: SINGLE_QUOTATION CHARACTER SINGLE_QUOTATION ;

bool_liter: TRUE | FALSE ;

int_sign: PLUS | MINUS ;

int_liter: (int_sign)? (INTEGER)+ ;

array_elem: ident (OPEN_SQUARE_BRACKET expr CLOSE_SQUARE_BRACKET)+ ;

binary_oper
locals[TYPE argtype, TYPE returntype]
: MULTIPLY #bin_math
| DIVIDE #bin_math
| MOD #bin_math
| PLUS #bin_math
| MINUS #bin_math
| GREATER #bin_compare
| GREATER_EQUAL #bin_compare
| LESS #bin_compare
| LESS_EQUAL #bin_compare
| IS_EQUAL #bin_bool
| NOT_EQUAL #bin_bool
| AND #bin_logic
| OR #bin_logic
;

unary_oper
locals[TYPE argtype, TYPE returntype]
: NOT #unary_not
| MINUS #unary_minus
| LEN #unary_len
| ORD #unary_ord
| CHR #unary_chr
;

expr
locals[TYPE typename]
: int_liter #expr_int
| bool_liter #expr_bool
| char_liter #expr_char
| str_liter #expr_str
| pair_liter #expr_pair
| ident #expr_ident
| array_elem #expr_array_elem
| unary_oper expr #expr_unary
| expr binary_oper expr #expr_binary
| OPEN_PARENTHESES expr CLOSE_PARENTHESES #expr_brackets
;

pair_elem_type
locals[TYPE typename]
: base_type   #pair_elem_base_type
| array_type  #pair_elem_array_type
| PAIR        #pair
;

pair_type
locals[TYPE typename]
: PAIR OPEN_PARENTHESES pair_elem_type COMMA pair_elem_type CLOSE_PARENTHESES
;

//array_type:
//| type OPEN_SQUARE_BRACKET CLOSE_SQUARE_BRACKET
//;
// fixing mutually recursive (this below is 'direct left recursive')
array_type
locals[TYPE typename]
: array_type OPEN_SQUARE_BRACKET CLOSE_SQUARE_BRACKET
| base_type OPEN_SQUARE_BRACKET CLOSE_SQUARE_BRACKET 
| pair_type OPEN_SQUARE_BRACKET CLOSE_SQUARE_BRACKET
;

base_type
locals[TYPE typename]
: INT 
| BOOL
| CHAR 
| STRING
;

type
locals[TYPE typename]
: base_type
| array_type
| pair_type
;

pair_elem
locals[TYPE typename]
: FST expr
| SND expr
;

arg_list: expr (COMMA expr)* ;

assign_rhs
locals[TYPE typename]
: expr	#assign_rhs_expr
| array_liter	#assign_rhs_ar_liter
| NEWPAIR OPEN_PARENTHESES expr COMMA expr CLOSE_PARENTHESES	#assign_rhs_newpair
| pair_elem		#assign_rhs_pair_elem
| CALL ident OPEN_PARENTHESES arg_list CLOSE_PARENTHESES	#assign_rhs_call
| CALL ident OPEN_PARENTHESES CLOSE_PARENTHESES				#assign_rhs_call_empty
;

assign_lhs
locals[TYPE typename]
: ident #assign_lhs_ident
| array_elem	#assign_lhs_array
| pair_elem		#assign_lhs_pair
;

stat
locals[TYPE typename]
: SKIP				#stat_skip
| type ident EQUAL_ASSIGN assign_rhs	#stat_declare
| assign_lhs EQUAL_ASSIGN assign_rhs	#stat_assign
| READ assign_lhs 			#stat_read
| FREE expr				#stat_free
| RETURN expr				#stat_return
| EXIT expr 				#stat_exit
| PRINT expr				#stat_print
| PRINTLN expr 				#stat_println
| IF expr THEN stat ELSE stat FI	#stat_if
| WHILE expr DO stat DONE 		#stat_while
| BEGIN stat END 			#stat_begin_end
| stat SEMI_COLON stat			#stat_stat
;


param
locals[PARAM paramObj]
: type ident ;

param_list: param (COMMA param)* ;

func
locals[FUNCTION funObj]
: type ident OPEN_PARENTHESES (param_list)? CLOSE_PARENTHESES IS stat END ;

// EOF indicates that the program must consume to the end of the input.
program: BEGIN (func)* stat END EOF;
