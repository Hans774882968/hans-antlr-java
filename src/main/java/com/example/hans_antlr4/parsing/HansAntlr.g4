grammar HansAntlr;

@header {
package com.example.hans_antlr4.parsing;
}

// compilationUnit: root rule
compilationUnit: statements EOF;
statements: statement*;
block: '{' statements '}';
statement:
	variable
	| print
	| expressionStatement
	| block
	| ifStatement
	| rangedForStatement
	| standardForStatement
	| breakStatement
	| continueStatement;
variable: VARIABLE Identifier EQUALS expression;
expressionStatement: expression;
ifStatement:
	'if' ('(')? expression (')')? trueStatement = statement (
		'else' falseStatement = statement
	)?;

rangedForStatement:
	'for' ('(')? rangedForConditions (')')? statement;
rangedForConditions:
	iterator = variableReference ':' startExpr = expression range = 'to' endExpr = expression;
standardForStatement:
	'for' ('(')? standardForInit? ';' expression? ';' expressionStatement? (
		')'
	)? statement;
standardForInit: variable | expressionStatement;
breakStatement: 'break';
continueStatement: 'continue';

expression:
	variableReference								# VarReference
	| value											# ValueExpr
	| '(' expression ')'							# BRACKET
	| UNARY = ('+' | '-' | '~') expression			# UNARY
	| expression POW expression						# POW
	| expression MULTIPLICATIVE expression			# MULTIPLICATIVE
	| expression ADDITIVE = ('+' | '-') expression	# ADDITIVE
	| expression SHIFT expression					# SHIFT
	| expression RELATIONAL expression				# RELATIONAL
	| expression EQUALITY expression				# EQUALITY
	| expression AND expression						# AND
	| expression XOR expression						# XOR
	| expression OR expression						# OR
	| <assoc = right> variableReference AssignmentOperator = (
		'='
		| '**='
		| '*='
		| '/='
		| '%='
		| '+='
		| '-='
		| '<<='
		| '>>='
		| '>>>='
		| '&='
		| '^='
		| '|='
	) expression # ASSIGNMENT;
variableReference: Identifier;

print: PRINT expression;
value: NUMBER | STRING | BOOL;

// hant TOKENS
POW: '**';
MULTIPLICATIVE: '*' | '/' | '%';
SHIFT: '<<' | '>>' | '>>>';
RELATIONAL: '<' | '<=' | '>' | '>=';
EQUALITY: '==' | '!=';
AND: '&';
XOR: '^';
OR: '|';

// keywords 应定义在 Identifier 之前
VARIABLE: 'var';
PRINT: 'print';
EQUALS: '=';
NUMBER:
	IntegerOrDecimalLiteral
	| HexIntegerLiteral
	| OctalIntegerLiteral
	| BinaryIntegerLiteral;
IntegerOrDecimalLiteral: [0-9.]+ [lLfFdD]?;
HexIntegerLiteral: '0' [xX] HexDigit+ [lL]?;
OctalIntegerLiteral: '0' [oO] [0-7]+ [lL]?;
BinaryIntegerLiteral: '0' [bB] [01]+ [lL]?;
BOOL: 'true' | 'false';
// must be anything in quotes。注意，原作者给出的规则`STRING: '"' .* '"';`中的正则表达式是贪婪模式，我改成了非贪婪模式
STRING: '"' .*? '"';

Identifier: IdentifierStart IdentifierPart*;
fragment IdentifierStart:
	[\p{L}]
	| [$_]
	| '\\' UnicodeEscapeSequence;
fragment UnicodeEscapeSequence:
	'u' HexDigit HexDigit HexDigit HexDigit;
fragment HexDigit: [0-9a-fA-F];
fragment IdentifierPart:
	IdentifierStart
	| [\p{Mn}]
	| [\p{Nd}]
	| [\p{Pc}]
	| '\u200C'
	| '\u200D';

WS: [ \t\n\r]+ -> skip; // special TOKEN for skipping whitespaces
// 支持注释
COMMENT: '/*' .*? '*/' -> channel(HIDDEN);
LINE_COMMENT: '//' ~[\r\n]* -> channel(HIDDEN);