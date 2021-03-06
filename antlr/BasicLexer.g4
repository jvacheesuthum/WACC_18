lexer grammar BasicLexer;

//operators
PLUS: '+' ;
MINUS: '-' ;
PLUSPLUS: '++';


//brackets
OPEN_PARENTHESES : '(' ;
CLOSE_PARENTHESES : ')' ;

//numbers
fragment DIGIT : '0'..'9' ; 

INTEGER: DIGIT+ ;

fragment HASH : '#';
COMMENT: HASH (INTEGER)* EOL -> skip ;
fragment EOL: '\r'? '\n' | '\r';

//carriage return
CR: '\r' ;


