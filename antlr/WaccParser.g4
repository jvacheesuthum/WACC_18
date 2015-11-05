parser grammar WaccParser;

options {
  tokenVocab=WaccLexer;
}

//comment? how to ignore comments

ident: VARIABLE;

pair_liter: NUL;

array_liter: OPEN_SQUARE_BRACKET (expr (COMMA expr)?) CLOSE_SQUARE_BRACKET;

str_liter: DOUBLE_QUOTATION (CHARACTER)* DOUBLE_QUOTATION ;

char_liter: SINGLE_QUOTATION CHARACTER SINGLE_QUOTATION ;

bool_liter: TRUE | FALSE ;

int_sign: PLUS | MINUS ;

int_liter: (int_sign)? (INTEGER)+ ;

array_elem: ident (OPEN_SQUARE_BRACKET expr CLOSE_SQUARE_BRACKET)+ ;

binary_oper:
| MULTIPLY
| DIVIDE
| MOD
| PLUS
| MINUS
| GREATER
| GREATER_EQUAL
| LESS
| LESS_EQUAL
| IS_EQUAL
| NOT_EQUAL
| AND
| OR
;

unary_oper:
| NOT
| MINUS
| LEN
| ORD
| CHR
;

expr:
| int_liter
| bool_liter
| char_liter
| str_liter
| pair_liter
| ident
| array_elem
| unary_oper expr
| expr binary_oper expr
| OPEN_PARENTHESES expr CLOSE_PARENTHESES
;

pair_elem_type:
| base_type
| array_type
| PAIR
;

pair_type:
| PAIR OPEN_PARENTHESES pair_elem_type COMMA pair_elem_type CLOSE_PARENTHESES
;

array_type:
| type OPEN_SQUARE_BRACKET CLOSE_SQUARE_BRACKET
;

base_type:
| INT 
| BOOL
| CHAR 
| STRING
;

type:
| base_type
| array_type
| pair_type
;

pair_elem:
| FST expr
| SND expr
;

arg_list: expr (COMMA expr)* ;

assign_rhs:
| expr
| array_liter
| NEWPAIR OPEN_PARENTHESES expr COMMA expr CLOSE_PARENTHESES
| pair_elem
| CALL ident OPEN_PARENTHESES (arg_list)? CLOSE_PARENTHESES
;

assign_lhs:
| ident 
| array_elem
| pair_elem
;

stat: 
| SKIP
| type ident EQUAL_ASSIGN assign_rhs
| assign_lhs EQUAL_ASSIGN assign_rhs
| READ assign_lhs 
| FREE expr
| RETURN expr
| EXIT expr 
| PRINT expr
| PRINTLN expr 
| IF expr THEN stat ELSE stat FI
| WHILE expr DO stat DONE 
| BEGIN stat END 
| stat SEMI_COLON stat
;

param: type ident ;

param_list: param (COMMA param)* ;

func: type ident OPEN_PARENTHESES (param_list)? CLOSE_PARENTHESES IS stat END ;

// EOF indicates that the program must consume to the end of the input.
program: BEGIN (func)* stat END EOF;
