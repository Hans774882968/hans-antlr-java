grammar HansAntlr;

@header {
package com.example.hans_antlr4.parsing;
}

// RULES
compilationUnit: statements EOF;
// root rule - our code consist consist only of variables and prints (see definition below)
statements: (variable | print)*;
variable: VARIABLE Identifier EQUALS expression;
// requires VAR token followed by ID token followed by EQUALS TOKEN ...

expression:
	variableReference						# VarReference
	| value									# ValueExpr
	| '(' expression '**' expression ')'	# POW
	| expression '**' expression			# POW
	| '(' expression '*' expression ')'		# MULTIPLY
	| expression '*' expression				# MULTIPLY
	| '(' expression '/' expression ')'		# DIVIDE
	| expression '/' expression				# DIVIDE
	| '(' expression '+' expression ')'		# ADD
	| expression '+' expression				# ADD
	| '(' expression '-' expression ')'		# SUBTRACT
	| expression '-' expression				# SUBTRACT;
variableReference: Identifier;

print:
	PRINT expression; // print statement must consist of 'print' keyword and ID
value:
	op = NUMBER
	| op = STRING; // must be NUMBER or STRING value (defined below)

// TOKENS
VARIABLE: 'var'; // VARIABLE TOKEN must match exactly 'var'
PRINT: 'print';
EQUALS: '='; // must be '='
NUMBER: [0-9]+; // must consist only of digits
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