grammar Calculator;

expression: integralExpression ((PLUS | MINUS) integralExpression)*;
integralExpression: MINUS INT | INT;

INT: [0-9]+ ;
PLUS: '+' ;
MINUS: '-' ;
WS : [ \t\r\n]+ -> skip ;