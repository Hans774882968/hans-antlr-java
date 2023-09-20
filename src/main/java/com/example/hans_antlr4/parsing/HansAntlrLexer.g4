lexer grammar HansAntlrLexer;

@header {
package com.example.hans_antlr4.parsing;
}

// hant TOKENS
OpenBrace: '{';
CloseBrace: '}';
OpenBracket: '[';
CloseBracket: ']';
OpenParen: '(';
CloseParen: ')';
Plus: '+';
Minus: '-';
BitNot: '~';
Comma: ',';
Dot: '.';
SemiColon: ';';
Colon: ':';
POW: '**';
MULTIPLICATIVE: '*' | '/' | '%';
SHIFT: '<<' | '>>' | '>>>';
RELATIONAL: '<' | '<=' | '>' | '>=';
EQUALITY: '==' | '!=';
AND: '&';
XOR: '^';
OR: '|';
EQUALS: '=';
PowerAssign: '**=';
MultiplyAssign: '*=';
DivideAssign: '/=';
ModulusAssign: '%=';
PlusAssign: '+=';
MinusAssign: '-=';
LeftShiftArithmeticAssign: '<<=';
RightShiftArithmeticAssign: '>>=';
RightShiftLogicalAssign: '>>>=';
BitAndAssign: '&=';
BitXorAssign: '^=';
BitOrAssign: '|=';

// keywords 应定义在 Identifier 之前
VARIABLE: 'var';
PRINT: 'print';
Return: 'return';
For: 'for';
To: 'to';
Break: 'break';
Continue: 'continue';
New: 'new';
If: 'if';
Else: 'else';
PrintArg: '\\n';
Boolean: 'boolean';
String: 'string';
Char: 'char';
Byte: 'byte';
Short: 'short';
Int: 'int';
Long: 'long';
Float: 'float';
Double: 'double';
Void: 'void';
NUMBER:
	IntegerOrDecimalLiteral
	| HexIntegerLiteral
	| OctalIntegerLiteral
	| BinaryIntegerLiteral;
IntegerOrDecimalLiteral: ([0-9] | [0-9]+ '.'? [0-9]+) [yYlLfFdD]?;
HexIntegerLiteral: '0' [xX] HexDigit+ [yYlL]?;
OctalIntegerLiteral: '0' [oO] [0-7]+ [yYlL]?;
BinaryIntegerLiteral: '0' [bB] [01]+ [yYlL]?;
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