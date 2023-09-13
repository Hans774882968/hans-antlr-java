grammar HansAntlr;

@header {
package com.example.hans_antlr4.parsing;
}

// compilationUnit: root rule
compilationUnit: functions EOF;

functions: function*;
function: functionDeclaration block;
functionDeclaration: (type)? functionName '(' functionParameterList? ')';
functionName: Identifier;
functionParameterList:
	functionParameter (',' functionParameter)*;
functionParameter: type Identifier;
type: primitiveType | classType;
primitiveType:
	'boolean' ('[' ']')*
	| 'string' ('[' ']')*
	| 'char' ('[' ']')*
	| 'byte' ('[' ']')*
	| 'short' ('[' ']')*
	| 'int' ('[' ']')*
	| 'long' ('[' ']')*
	| 'float' ('[' ']')*
	| 'double' ('[' ']')*
	| 'void' ('[' ']')*;
classType: qualifiedName ('[' ']')*;
qualifiedName: Identifier ('.' Identifier)*;

statements: (statement ';'?)*;
block: '{' statements '}';
statement:
	variable
	| print
	| returnStatement
	| block
	| ifStatement
	| rangedForStatement
	| standardForStatement
	| breakStatement
	| continueStatement
	| expressionStatement;
variable: VARIABLE Identifier EQUALS expression;
returnStatement:
	'return' expression	# ReturnWithValue
	| 'return'			# ReturnVoid;
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
	'for' ('(')? standardForInit? ';' expression? ';' standardForUpdate? (
		')'
	)? statement;
standardForInit: variable | print | expressionStatement;
standardForUpdate: variable | print | expressionStatement;
breakStatement: 'break';
continueStatement: 'continue';

expression:
	functionName '(' argumentList ')'							# FunctionCall
	| owner = expression '.' functionName '(' argumentList ')'	# FunctionCall
	| 'new' qualifiedName '(' argumentList ')'					# ConstructorCall
	| expression '.' Identifier									# ClazzFieldReference
	| variableReference											# VarReference
	| value														# ValueExpr
	| '(' expression ')'										# BRACKET
	| UNARY = ('+' | '-' | '~') expression						# UNARY
	| expression POW expression									# POW
	| expression MULTIPLICATIVE expression						# MULTIPLICATIVE
	| expression ADDITIVE = ('+' | '-') expression				# ADDITIVE
	| expression SHIFT expression								# SHIFT
	| expression RELATIONAL expression							# RELATIONAL
	| expression EQUALITY expression							# EQUALITY
	| expression AND expression									# AND
	| expression XOR expression									# XOR
	| expression OR expression									# OR
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
argumentList: expression? (',' expression)*;

print: PRINT (printArg = '\\n')? expression;

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
IntegerOrDecimalLiteral: ([0-9] | [0-9]+ '.'? [0-9]+) [lLfFdD]?;
HexIntegerLiteral: '0' [xX] HexDigit+ [lL]?;
OctalIntegerLiteral: '0' [oO] [0-7]+ [lL]?;
BinaryIntegerLiteral: '0' [bB] [01]+ [lL]?;
BOOL: 'true' | 'false';

// must be anything in quotes。注意，原作者给出的规则`STRING: '"' .* '"';`中的正则表达式是贪婪模式，我改成了非贪婪模式
STRING: '"' StringCharacter* '"';
fragment StringCharacter: ~["\\\r\n] | EscapeSequence;
fragment EscapeSequence:
	'\\' 'u005c'? [btnfr"'\\]
	| OctalEscape
	| UnicodeEscape;
fragment OctalEscape:
	'\\' 'u005c'? OctalDigit
	| '\\' 'u005c'? OctalDigit OctalDigit
	| '\\' 'u005c'? ZeroToThree OctalDigit OctalDigit;
fragment UnicodeEscape:
	'\\' 'u'+ HexDigit HexDigit HexDigit HexDigit;

Identifier: IdentifierStart IdentifierPart*;
fragment IdentifierStart:
	[\p{L}]
	| [$_]
	| '\\' UnicodeEscapeSequence;
fragment UnicodeEscapeSequence:
	'u' HexDigit HexDigit HexDigit HexDigit;
fragment HexDigit: [0-9a-fA-F];
fragment OctalDigit: [0-7];
fragment ZeroToThree: [0-3];
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