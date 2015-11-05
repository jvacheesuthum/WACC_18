parser grammar WaccParser;

options {
  tokenVocab=WaccLexer;
}

//comment?

indent: VARIABLE;

pair-liter: NULL;

array-liter: OPEN_SQUARE_BRACKET (expr (COMMA expr)?) CLOSE_SQUARE_BRACKET;

str-liter: DOUBLE_QUOTATION (CHARACTER)* DOUBLE_QUOTATION ;

char-liter: SINGLE_QUOTATION CHARACTER SINGLE_QUOTATION ;

bool-liter: TRUE | FALSE ;

int-sign: PLUS | MINUS ;

int-liter: (int-sign)? (DIGIT)+ ;

array-elem: indent (OPEN_SQUARE_BRACKET expr CLOSE_SQUARE_BRACKET)+ ;

binary-oper:
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

unary-oper:
| NOT
| MINUS
| LEN
| ORD
| CHR
;

expr:
| int-liter
| bool-liter
| char-liter
| str-liter
| pair-liter
| ident
| array-elem
| unary-open expr
| expr binary-oper expr
| OPEN_PARENTHESES expr CLOSE_PARENTHESES
;

pair-elem-type:
| base-type
| array-type
| PAIR
;

pair-type:
| PAIR OPEN_PARENTHESES pair-elem-type COMMA pair-elem-type CLOSE_PARENTHESES
;

array-type:
| type OPEN_SQUARE_BRACKET CLOSE_SQUARE_BRACKET
;

base-type:
| INT 
| BOOL
| CHAR 
| STRING
;

type:
| base-type
| array-type
| pair-type
;

pair-elem:
| FST expr
| SND expr
;

arg-list: expr (COMMA expr)* ;

assign-rhs:
| expr
| array-liter
| NEWPAIR OPEN_PARENTHESES expr COMMA expr CLOSE_PARENTHESES
| pair-elem
| CALL ident OPEN_PARENTHESES (arg-list)? CLOSE_PARENTHESES
;

assign-lhs:
| ident 
| array-elem
| pair-elem
;

stat: 
| SKIP
| type indent EQUAL_ASSIGN assign-rhs
| assign-lhs EQUAL_ASSIGN assign-rhs
| READ assign-lhs 
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

param-list: param (COMMA param)* ;

func: type ident OPEN_PARENTHESES (param-list)? CLOSE_PARENTHESES IS stat END ;

// EOF indicates that the program must consume to the end of the input.
program: BEGIN (func)* stat END EOF;
