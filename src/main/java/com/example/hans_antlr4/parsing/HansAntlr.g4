grammar HansAntlr;

@header {
package com.example.hans_antlr4.parsing;
}

// compilationUnit: root rule
compilationUnit: statements EOF;
statements: statement*;
block: '{' statements '}';
statement: block | variable | ifStatement | print;
variable: VARIABLE Identifier EQUALS expression;
ifStatement:
	'if' ('(')? expression (')')? trueStatement = statement (
		'else' falseStatement = statement
	)?;

expression:
	variableReference								# VarReference
	| value											# ValueExpr
	| '(' expression POW expression ')'				# POW
	| expression POW expression						# POW
	| '(' expression MULTIPLICATIVE expression ')'	# MULTIPLICATIVE
	| expression MULTIPLICATIVE expression			# MULTIPLICATIVE
	| '(' expression ADDITIVE expression ')'		# ADDITIVE
	| expression ADDITIVE expression				# ADDITIVE
	| '(' expression SHIFT expression ')'			# SHIFT
	| expression SHIFT expression					# SHIFT
	| '(' expression AND expression ')'				# AND
	| expression AND expression						# AND
	| '(' expression XOR expression ')'				# XOR
	| expression XOR expression						# XOR
	| '(' expression OR expression ')'				# OR
	| expression OR expression						# OR;
variableReference: Identifier;

print: PRINT expression;
value: op = NUMBER | op = STRING;

// hant TOKENS
POW: '**';
MULTIPLICATIVE: '*' | '/' | '%';
ADDITIVE: '+' | '-';
SHIFT: '<<' | '>>' | '>>>';
AND: '&';
XOR: '^';
OR: '|';

VARIABLE: 'var';
PRINT: 'print';
EQUALS: '=';
NUMBER: [0-9]+;
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