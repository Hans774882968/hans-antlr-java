parser grammar HansAntlrParser;

options {
	tokenVocab = HansAntlrLexer;
}

@header {
package com.example.hans_antlr4.parsing;
}

// compilationUnit: root rule
compilationUnit: (function | globalVariable)* EOF;

globalVariable: variable SemiColon?;

function: functionDeclaration block;
functionDeclaration: (type)? functionName (
		OpenParen functionParameterList? CloseParen
	)?;
functionName: Identifier;
functionParameterList:
	functionParameter (Comma functionParameter)*;
functionParameter: type Identifier;
type: primitiveType | classType;
primitiveType:
	Boolean ('[' ']')*
	| String ('[' ']')*
	| Char ('[' ']')*
	| Byte ('[' ']')*
	| Short ('[' ']')*
	| Int ('[' ']')*
	| Long ('[' ']')*
	| Float ('[' ']')*
	| Double ('[' ']')*
	| Void ('[' ']')*;
classType: qualifiedName ('[' ']')*;
qualifiedName: Identifier (Dot Identifier)*;
primitiveTypeName:
	Boolean
	| String
	| Char
	| Byte
	| Short
	| Int
	| Long
	| Float
	| Double
	| Void;

statements: (statement SemiColon?)*;
block: OpenBrace statements CloseBrace;
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
variable: VARIABLE varDefUnit (',' varDefUnit)*;
varDefUnit: Identifier EQUALS expression;
returnStatement:
	Return expression	# ReturnWithValue
	| Return			# ReturnVoid;
expressionStatement: expression;
ifStatement:
	If (OpenParen)? expression (CloseParen)? trueStatement = statement (
		Else falseStatement = statement
	)?;

rangedForStatement:
	For (OpenParen)? rangedForConditions (CloseParen)? statement;
rangedForConditions:
	iterator = variableReference Colon startExpr = expression range = To endExpr = expression;
standardForStatement:
	For (OpenParen)? standardForInit? SemiColon expression? SemiColon standardForUpdate? (
		CloseParen
	)? statement;
standardForInit: variable | print | expressionStatement;
standardForUpdate: variable | print | expressionStatement;
breakStatement: Break;
continueStatement: Continue;

expression:
	functionName OpenParen argumentList CloseParen							# FunctionCall
	| owner = expression Dot functionName OpenParen argumentList CloseParen	# FunctionCall
	| New qualifiedName OpenParen argumentList CloseParen					# ConstructorCall
	| New (primitiveTypeName | qualifiedName) (
		OpenBracket expression CloseBracket
	)+															# ArrayDeclaration
	| array = expression (OpenBracket expression CloseBracket)+	# ArrayAccess
	| expression Dot Identifier									# ClazzFieldReference
	| variableReference											# VarReference
	| value														# ValueExpr
	| arrayLiteral												# ArrLiteral
	| templateStringLiteral										# TemplateLiteral
	| OpenParen expression CloseParen							# BRACKET
	| UNARY = (Plus | Minus | BitNot) expression				# UNARY
	| expression POW expression									# POW
	| expression MULTIPLICATIVE expression						# MULTIPLICATIVE
	| expression ADDITIVE = (Plus | Minus) expression			# ADDITIVE
	| expression SHIFT expression								# SHIFT
	| expression RELATIONAL expression							# RELATIONAL
	| expression EQUALITY expression							# EQUALITY
	| expression AND expression									# AND
	| expression XOR expression									# XOR
	| expression OR expression									# OR
	| <assoc = right> leftHandSide = expression AssignmentOperator = (
		EQUALS
		| PowerAssign
		| MultiplyAssign
		| DivideAssign
		| ModulusAssign
		| PlusAssign
		| MinusAssign
		| LeftShiftArithmeticAssign
		| RightShiftArithmeticAssign
		| RightShiftLogicalAssign
		| BitAndAssign
		| BitXorAssign
		| BitOrAssign
	) rightHandSide = expression # ASSIGNMENT;
argumentList: expression? (Comma expression)*;

variableReference: Identifier;

print: PRINT PrintArg? expression;

value: NUMBER | STRING | BOOL;

templateStringLiteral: BackTick templateStringAtom* BackTick;
templateStringAtom:
	TemplateStringAtom
	| TemplateStringStartExpression expression CloseBrace;

arrayLiteral: '[' expression (',' expression)* ']';