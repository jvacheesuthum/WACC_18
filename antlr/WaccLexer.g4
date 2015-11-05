lexer grammar WaccLexer;

//NULL: 

COMMA: ',' ;

TRUE: 'true'
FALSE: 'false'


//quotations
SINGLE_QUOTATION: ''' ;
DOUBLE_QUOTATION: '"' ;

//operators
MULTIPLY: '*' ;
DIVIDE: '/' ;
MOD: '%' ;
PLUS: '+' ;
MINUS: '-' ;
GREATER: '>' ;
GREATER_EQUAL: '>=' ;
LESS: '<' ;
LESS_EQUAL: '<=' ;
IS_EQUAL: '==' ;
NOT_EQUAL: '!=' ;
AND: '&&' ;
OR: '||' ;

NOT: '!' ;
LEN: 'len' ;
ORD: 'ord' ;
CHR: 'chr' ;


//brackets
OPEN_PARENTHESES : '(' ;
CLOSE_PARENTHESES : ')' ;
OPEN_SQUARE_BRACKET : '[' ;
CLOSE_SQUARE_BRACKET : ']' ;

PAIR: 'pair';


//numbers
fragment DIGIT : '0'..'9' ; 

INTEGER: DIGIT+ ;

//ident

//CHARACTER: 

//ESCAPTED_CHAR

//COMMENT


