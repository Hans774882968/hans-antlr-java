// Generated from C:\java_project\hans-antlr-java\src\main\java\com\example\hans_antlr4\parsing\HansAntlrParser.g4 by ANTLR 4.13.0

package com.example.hans_antlr4.parsing;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({ "all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue" })
public class HansAntlrParser extends Parser {
	static {
		RuntimeMetaData.checkVersion("4.13.0", RuntimeMetaData.VERSION);
	}

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
	public static final int OpenBrace = 1, CloseBrace = 2, OpenBracket = 3, CloseBracket = 4, OpenParen = 5,
			CloseParen = 6, Plus = 7, Minus = 8, BitNot = 9, Comma = 10, Dot = 11, SemiColon = 12,
			Colon = 13, POW = 14, MULTIPLICATIVE = 15, SHIFT = 16, RELATIONAL = 17, EQUALITY = 18,
			AND = 19, XOR = 20, OR = 21, EQUALS = 22, PowerAssign = 23, MultiplyAssign = 24, DivideAssign = 25,
			ModulusAssign = 26, PlusAssign = 27, MinusAssign = 28, LeftShiftArithmeticAssign = 29,
			RightShiftArithmeticAssign = 30, RightShiftLogicalAssign = 31, BitAndAssign = 32,
			BitXorAssign = 33, BitOrAssign = 34, VARIABLE = 35, PRINT = 36, Return = 37, For = 38,
			To = 39, Break = 40, Continue = 41, New = 42, If = 43, Else = 44, PrintArg = 45, Boolean = 46,
			String = 47, Char = 48, Byte = 49, Short = 50, Int = 51, Long = 52, Float = 53, Double = 54,
			Void = 55, NUMBER = 56, IntegerOrDecimalLiteral = 57, HexIntegerLiteral = 58,
			OctalIntegerLiteral = 59, BinaryIntegerLiteral = 60, BOOL = 61, STRING = 62, Identifier = 63,
			WS = 64, COMMENT = 65, LINE_COMMENT = 66, BackTick = 67, TemplateStringStartExpression = 68,
			TemplateStringAtom = 69;
	public static final int RULE_compilationUnit = 0, RULE_globalVariable = 1, RULE_function = 2,
			RULE_functionDeclaration = 3, RULE_functionName = 4, RULE_functionParameterList = 5,
			RULE_functionParameter = 6, RULE_type = 7, RULE_primitiveType = 8, RULE_classType = 9,
			RULE_qualifiedName = 10, RULE_primitiveTypeName = 11, RULE_statements = 12,
			RULE_block = 13, RULE_statement = 14, RULE_variable = 15, RULE_varDefUnit = 16,
			RULE_returnStatement = 17, RULE_expressionStatement = 18, RULE_ifStatement = 19,
			RULE_rangedForStatement = 20, RULE_rangedForConditions = 21, RULE_standardForStatement = 22,
			RULE_standardForInit = 23, RULE_standardForUpdate = 24, RULE_breakStatement = 25,
			RULE_continueStatement = 26, RULE_expression = 27, RULE_argumentList = 28,
			RULE_variableReference = 29, RULE_print = 30, RULE_value = 31, RULE_templateStringLiteral = 32,
			RULE_templateStringAtom = 33, RULE_arrayLiteral = 34;

	private static String[] makeRuleNames() {
		return new String[] {
				"compilationUnit", "globalVariable", "function", "functionDeclaration",
				"functionName", "functionParameterList", "functionParameter", "type",
				"primitiveType", "classType", "qualifiedName", "primitiveTypeName", "statements",
				"block", "statement", "variable", "varDefUnit", "returnStatement", "expressionStatement",
				"ifStatement", "rangedForStatement", "rangedForConditions", "standardForStatement",
				"standardForInit", "standardForUpdate", "breakStatement", "continueStatement",
				"expression", "argumentList", "variableReference", "print", "value",
				"templateStringLiteral", "templateStringAtom", "arrayLiteral"
		};
	}

	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
				null, "'{'", "'}'", "'['", "']'", "'('", "')'", "'+'", "'-'", "'~'",
				"','", "'.'", "';'", "':'", "'**'", null, null, null, null, "'&'", "'^'",
				"'|'", "'='", "'**='", "'*='", "'/='", "'%='", "'+='", "'-='", "'<<='",
				"'>>='", "'>>>='", "'&='", "'^='", "'|='", "'var'", "'print'", "'return'",
				"'for'", "'to'", "'break'", "'continue'", "'new'", "'if'", "'else'",
				"'\\n'", "'boolean'", "'string'", "'char'", "'byte'", "'short'", "'int'",
				"'long'", "'float'", "'double'", "'void'", null, null, null, null, null,
				null, null, null, null, null, null, null, "'${'"
		};
	}

	private static final String[] _LITERAL_NAMES = makeLiteralNames();

	private static String[] makeSymbolicNames() {
		return new String[] {
				null, "OpenBrace", "CloseBrace", "OpenBracket", "CloseBracket", "OpenParen",
				"CloseParen", "Plus", "Minus", "BitNot", "Comma", "Dot", "SemiColon",
				"Colon", "POW", "MULTIPLICATIVE", "SHIFT", "RELATIONAL", "EQUALITY",
				"AND", "XOR", "OR", "EQUALS", "PowerAssign", "MultiplyAssign", "DivideAssign",
				"ModulusAssign", "PlusAssign", "MinusAssign", "LeftShiftArithmeticAssign",
				"RightShiftArithmeticAssign", "RightShiftLogicalAssign", "BitAndAssign",
				"BitXorAssign", "BitOrAssign", "VARIABLE", "PRINT", "Return", "For",
				"To", "Break", "Continue", "New", "If", "Else", "PrintArg", "Boolean",
				"String", "Char", "Byte", "Short", "Int", "Long", "Float", "Double",
				"Void", "NUMBER", "IntegerOrDecimalLiteral", "HexIntegerLiteral", "OctalIntegerLiteral",
				"BinaryIntegerLiteral", "BOOL", "STRING", "Identifier", "WS", "COMMENT",
				"LINE_COMMENT", "BackTick", "TemplateStringStartExpression", "TemplateStringAtom"
		};
	}

	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() {
		return "HansAntlrParser.g4";
	}

	@Override
	public String[] getRuleNames() {
		return ruleNames;
	}

	@Override
	public String getSerializedATN() {
		return _serializedATN;
	}

	@Override
	public ATN getATN() {
		return _ATN;
	}

	public HansAntlrParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompilationUnitContext extends ParserRuleContext {
		public TerminalNode EOF() {
			return getToken(HansAntlrParser.EOF, 0);
		}

		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}

		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class, i);
		}

		public List<GlobalVariableContext> globalVariable() {
			return getRuleContexts(GlobalVariableContext.class);
		}

		public GlobalVariableContext globalVariable(int i) {
			return getRuleContext(GlobalVariableContext.class, i);
		}

		public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_compilationUnit;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitCompilationUnit(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compilationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -9151384777201287168L) != 0)) {
					{
						setState(72);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
							case Boolean:
							case String:
							case Char:
							case Byte:
							case Short:
							case Int:
							case Long:
							case Float:
							case Double:
							case Void:
							case Identifier: {
								setState(70);
								function();
							}
								break;
							case VARIABLE: {
								setState(71);
								globalVariable();
							}
								break;
							default:
								throw new NoViableAltException(this);
						}
					}
					setState(76);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(77);
				match(EOF);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GlobalVariableContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class, 0);
		}

		public TerminalNode SemiColon() {
			return getToken(HansAntlrParser.SemiColon, 0);
		}

		public GlobalVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_globalVariable;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitGlobalVariable(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final GlobalVariableContext globalVariable() throws RecognitionException {
		GlobalVariableContext _localctx = new GlobalVariableContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_globalVariable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(79);
				variable();
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == SemiColon) {
					{
						setState(80);
						match(SemiColon);
					}
				}

			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionContext extends ParserRuleContext {
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class, 0);
		}

		public BlockContext block() {
			return getRuleContext(BlockContext.class, 0);
		}

		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_function;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitFunction(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(83);
				functionDeclaration();
				setState(84);
				block();
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclarationContext extends ParserRuleContext {
		public FunctionNameContext functionName() {
			return getRuleContext(FunctionNameContext.class, 0);
		}

		public TypeContext type() {
			return getRuleContext(TypeContext.class, 0);
		}

		public TerminalNode OpenParen() {
			return getToken(HansAntlrParser.OpenParen, 0);
		}

		public TerminalNode CloseParen() {
			return getToken(HansAntlrParser.CloseParen, 0);
		}

		public FunctionParameterListContext functionParameterList() {
			return getRuleContext(FunctionParameterListContext.class, 0);
		}

		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_functionDeclaration;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitFunctionDeclaration(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(87);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 3, _ctx)) {
					case 1: {
						setState(86);
						type();
					}
						break;
				}
				setState(89);
				functionName();
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == OpenParen) {
					{
						setState(90);
						match(OpenParen);
						setState(92);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -9151384811561025536L) != 0)) {
							{
								setState(91);
								functionParameterList();
							}
						}

						setState(94);
						match(CloseParen);
					}
				}

			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionNameContext extends ParserRuleContext {
		public TerminalNode Identifier() {
			return getToken(HansAntlrParser.Identifier, 0);
		}

		public FunctionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_functionName;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitFunctionName(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final FunctionNameContext functionName() throws RecognitionException {
		FunctionNameContext _localctx = new FunctionNameContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_functionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(97);
				match(Identifier);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionParameterListContext extends ParserRuleContext {
		public List<FunctionParameterContext> functionParameter() {
			return getRuleContexts(FunctionParameterContext.class);
		}

		public FunctionParameterContext functionParameter(int i) {
			return getRuleContext(FunctionParameterContext.class, i);
		}

		public List<TerminalNode> Comma() {
			return getTokens(HansAntlrParser.Comma);
		}

		public TerminalNode Comma(int i) {
			return getToken(HansAntlrParser.Comma, i);
		}

		public FunctionParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_functionParameterList;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitFunctionParameterList(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final FunctionParameterListContext functionParameterList() throws RecognitionException {
		FunctionParameterListContext _localctx = new FunctionParameterListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functionParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(99);
				functionParameter();
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la == Comma) {
					{
						{
							setState(100);
							match(Comma);
							setState(101);
							functionParameter();
						}
					}
					setState(106);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionParameterContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class, 0);
		}

		public TerminalNode Identifier() {
			return getToken(HansAntlrParser.Identifier, 0);
		}

		public FunctionParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_functionParameter;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitFunctionParameter(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final FunctionParameterContext functionParameter() throws RecognitionException {
		FunctionParameterContext _localctx = new FunctionParameterContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_functionParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(107);
				type();
				setState(108);
				match(Identifier);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class, 0);
		}

		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class, 0);
		}

		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_type;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitType(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		try {
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case Boolean:
				case String:
				case Char:
				case Byte:
				case Short:
				case Int:
				case Long:
				case Float:
				case Double:
				case Void:
					enterOuterAlt(_localctx, 1); {
					setState(110);
					primitiveType();
				}
					break;
				case Identifier:
					enterOuterAlt(_localctx, 2); {
					setState(111);
					classType();
				}
					break;
				default:
					throw new NoViableAltException(this);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimitiveTypeContext extends ParserRuleContext {
		public TerminalNode Boolean() {
			return getToken(HansAntlrParser.Boolean, 0);
		}

		public List<TerminalNode> OpenBracket() {
			return getTokens(HansAntlrParser.OpenBracket);
		}

		public TerminalNode OpenBracket(int i) {
			return getToken(HansAntlrParser.OpenBracket, i);
		}

		public List<TerminalNode> CloseBracket() {
			return getTokens(HansAntlrParser.CloseBracket);
		}

		public TerminalNode CloseBracket(int i) {
			return getToken(HansAntlrParser.CloseBracket, i);
		}

		public TerminalNode String() {
			return getToken(HansAntlrParser.String, 0);
		}

		public TerminalNode Char() {
			return getToken(HansAntlrParser.Char, 0);
		}

		public TerminalNode Byte() {
			return getToken(HansAntlrParser.Byte, 0);
		}

		public TerminalNode Short() {
			return getToken(HansAntlrParser.Short, 0);
		}

		public TerminalNode Int() {
			return getToken(HansAntlrParser.Int, 0);
		}

		public TerminalNode Long() {
			return getToken(HansAntlrParser.Long, 0);
		}

		public TerminalNode Float() {
			return getToken(HansAntlrParser.Float, 0);
		}

		public TerminalNode Double() {
			return getToken(HansAntlrParser.Double, 0);
		}

		public TerminalNode Void() {
			return getToken(HansAntlrParser.Void, 0);
		}

		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_primitiveType;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitPrimitiveType(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_primitiveType);
		int _la;
		try {
			setState(194);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case Boolean:
					enterOuterAlt(_localctx, 1); {
					setState(114);
					match(Boolean);
					setState(119);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la == OpenBracket) {
						{
							{
								setState(115);
								match(OpenBracket);
								setState(116);
								match(CloseBracket);
							}
						}
						setState(121);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
				}
					break;
				case String:
					enterOuterAlt(_localctx, 2); {
					setState(122);
					match(String);
					setState(127);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la == OpenBracket) {
						{
							{
								setState(123);
								match(OpenBracket);
								setState(124);
								match(CloseBracket);
							}
						}
						setState(129);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
				}
					break;
				case Char:
					enterOuterAlt(_localctx, 3); {
					setState(130);
					match(Char);
					setState(135);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la == OpenBracket) {
						{
							{
								setState(131);
								match(OpenBracket);
								setState(132);
								match(CloseBracket);
							}
						}
						setState(137);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
				}
					break;
				case Byte:
					enterOuterAlt(_localctx, 4); {
					setState(138);
					match(Byte);
					setState(143);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la == OpenBracket) {
						{
							{
								setState(139);
								match(OpenBracket);
								setState(140);
								match(CloseBracket);
							}
						}
						setState(145);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
				}
					break;
				case Short:
					enterOuterAlt(_localctx, 5); {
					setState(146);
					match(Short);
					setState(151);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la == OpenBracket) {
						{
							{
								setState(147);
								match(OpenBracket);
								setState(148);
								match(CloseBracket);
							}
						}
						setState(153);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
				}
					break;
				case Int:
					enterOuterAlt(_localctx, 6); {
					setState(154);
					match(Int);
					setState(159);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la == OpenBracket) {
						{
							{
								setState(155);
								match(OpenBracket);
								setState(156);
								match(CloseBracket);
							}
						}
						setState(161);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
				}
					break;
				case Long:
					enterOuterAlt(_localctx, 7); {
					setState(162);
					match(Long);
					setState(167);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la == OpenBracket) {
						{
							{
								setState(163);
								match(OpenBracket);
								setState(164);
								match(CloseBracket);
							}
						}
						setState(169);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
				}
					break;
				case Float:
					enterOuterAlt(_localctx, 8); {
					setState(170);
					match(Float);
					setState(175);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la == OpenBracket) {
						{
							{
								setState(171);
								match(OpenBracket);
								setState(172);
								match(CloseBracket);
							}
						}
						setState(177);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
				}
					break;
				case Double:
					enterOuterAlt(_localctx, 9); {
					setState(178);
					match(Double);
					setState(183);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la == OpenBracket) {
						{
							{
								setState(179);
								match(OpenBracket);
								setState(180);
								match(CloseBracket);
							}
						}
						setState(185);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
				}
					break;
				case Void:
					enterOuterAlt(_localctx, 10); {
					setState(186);
					match(Void);
					setState(191);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la == OpenBracket) {
						{
							{
								setState(187);
								match(OpenBracket);
								setState(188);
								match(CloseBracket);
							}
						}
						setState(193);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
				}
					break;
				default:
					throw new NoViableAltException(this);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassTypeContext extends ParserRuleContext {
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class, 0);
		}

		public List<TerminalNode> OpenBracket() {
			return getTokens(HansAntlrParser.OpenBracket);
		}

		public TerminalNode OpenBracket(int i) {
			return getToken(HansAntlrParser.OpenBracket, i);
		}

		public List<TerminalNode> CloseBracket() {
			return getTokens(HansAntlrParser.CloseBracket);
		}

		public TerminalNode CloseBracket(int i) {
			return getToken(HansAntlrParser.CloseBracket, i);
		}

		public ClassTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_classType;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitClassType(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final ClassTypeContext classType() throws RecognitionException {
		ClassTypeContext _localctx = new ClassTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_classType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(196);
				qualifiedName();
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la == OpenBracket) {
					{
						{
							setState(197);
							match(OpenBracket);
							setState(198);
							match(CloseBracket);
						}
					}
					setState(203);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QualifiedNameContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() {
			return getTokens(HansAntlrParser.Identifier);
		}

		public TerminalNode Identifier(int i) {
			return getToken(HansAntlrParser.Identifier, i);
		}

		public List<TerminalNode> Dot() {
			return getTokens(HansAntlrParser.Dot);
		}

		public TerminalNode Dot(int i) {
			return getToken(HansAntlrParser.Dot, i);
		}

		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_qualifiedName;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitQualifiedName(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_qualifiedName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(204);
				match(Identifier);
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la == Dot) {
					{
						{
							setState(205);
							match(Dot);
							setState(206);
							match(Identifier);
						}
					}
					setState(211);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimitiveTypeNameContext extends ParserRuleContext {
		public TerminalNode Boolean() {
			return getToken(HansAntlrParser.Boolean, 0);
		}

		public TerminalNode String() {
			return getToken(HansAntlrParser.String, 0);
		}

		public TerminalNode Char() {
			return getToken(HansAntlrParser.Char, 0);
		}

		public TerminalNode Byte() {
			return getToken(HansAntlrParser.Byte, 0);
		}

		public TerminalNode Short() {
			return getToken(HansAntlrParser.Short, 0);
		}

		public TerminalNode Int() {
			return getToken(HansAntlrParser.Int, 0);
		}

		public TerminalNode Long() {
			return getToken(HansAntlrParser.Long, 0);
		}

		public TerminalNode Float() {
			return getToken(HansAntlrParser.Float, 0);
		}

		public TerminalNode Double() {
			return getToken(HansAntlrParser.Double, 0);
		}

		public TerminalNode Void() {
			return getToken(HansAntlrParser.Void, 0);
		}

		public PrimitiveTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_primitiveTypeName;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitPrimitiveTypeName(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeNameContext primitiveTypeName() throws RecognitionException {
		PrimitiveTypeNameContext _localctx = new PrimitiveTypeNameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_primitiveTypeName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(212);
				_la = _input.LA(1);
				if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 71987225293750272L) != 0))) {
					_errHandler.recoverInline(this);
				} else {
					if (_input.LA(1) == Token.EOF)
						matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}

		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class, i);
		}

		public List<TerminalNode> SemiColon() {
			return getTokens(HansAntlrParser.SemiColon);
		}

		public TerminalNode SemiColon(int i) {
			return getToken(HansAntlrParser.SemiColon, i);
		}

		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_statements;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitStatements(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2233768407105272918L) != 0) || _la == BackTick) {
					{
						{
							setState(214);
							statement();
							setState(216);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (_la == SemiColon) {
								{
									setState(215);
									match(SemiColon);
								}
							}

						}
					}
					setState(222);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode OpenBrace() {
			return getToken(HansAntlrParser.OpenBrace, 0);
		}

		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class, 0);
		}

		public TerminalNode CloseBrace() {
			return getToken(HansAntlrParser.CloseBrace, 0);
		}

		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_block;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitBlock(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(223);
				match(OpenBrace);
				setState(224);
				statements();
				setState(225);
				match(CloseBrace);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class, 0);
		}

		public PrintContext print() {
			return getRuleContext(PrintContext.class, 0);
		}

		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class, 0);
		}

		public BlockContext block() {
			return getRuleContext(BlockContext.class, 0);
		}

		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class, 0);
		}

		public RangedForStatementContext rangedForStatement() {
			return getRuleContext(RangedForStatementContext.class, 0);
		}

		public StandardForStatementContext standardForStatement() {
			return getRuleContext(StandardForStatementContext.class, 0);
		}

		public BreakStatementContext breakStatement() {
			return getRuleContext(BreakStatementContext.class, 0);
		}

		public ContinueStatementContext continueStatement() {
			return getRuleContext(ContinueStatementContext.class, 0);
		}

		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class, 0);
		}

		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_statement;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitStatement(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_statement);
		try {
			setState(237);
			_errHandler.sync(this);
			switch (getInterpreter().adaptivePredict(_input, 23, _ctx)) {
				case 1:
					enterOuterAlt(_localctx, 1); {
					setState(227);
					variable();
				}
					break;
				case 2:
					enterOuterAlt(_localctx, 2); {
					setState(228);
					print();
				}
					break;
				case 3:
					enterOuterAlt(_localctx, 3); {
					setState(229);
					returnStatement();
				}
					break;
				case 4:
					enterOuterAlt(_localctx, 4); {
					setState(230);
					block();
				}
					break;
				case 5:
					enterOuterAlt(_localctx, 5); {
					setState(231);
					ifStatement();
				}
					break;
				case 6:
					enterOuterAlt(_localctx, 6); {
					setState(232);
					rangedForStatement();
				}
					break;
				case 7:
					enterOuterAlt(_localctx, 7); {
					setState(233);
					standardForStatement();
				}
					break;
				case 8:
					enterOuterAlt(_localctx, 8); {
					setState(234);
					breakStatement();
				}
					break;
				case 9:
					enterOuterAlt(_localctx, 9); {
					setState(235);
					continueStatement();
				}
					break;
				case 10:
					enterOuterAlt(_localctx, 10); {
					setState(236);
					expressionStatement();
				}
					break;
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableContext extends ParserRuleContext {
		public TerminalNode VARIABLE() {
			return getToken(HansAntlrParser.VARIABLE, 0);
		}

		public List<VarDefUnitContext> varDefUnit() {
			return getRuleContexts(VarDefUnitContext.class);
		}

		public VarDefUnitContext varDefUnit(int i) {
			return getRuleContext(VarDefUnitContext.class, i);
		}

		public List<TerminalNode> Comma() {
			return getTokens(HansAntlrParser.Comma);
		}

		public TerminalNode Comma(int i) {
			return getToken(HansAntlrParser.Comma, i);
		}

		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_variable;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitVariable(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(239);
				match(VARIABLE);
				setState(240);
				varDefUnit();
				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la == Comma) {
					{
						{
							setState(241);
							match(Comma);
							setState(242);
							varDefUnit();
						}
					}
					setState(247);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarDefUnitContext extends ParserRuleContext {
		public TerminalNode Identifier() {
			return getToken(HansAntlrParser.Identifier, 0);
		}

		public TerminalNode EQUALS() {
			return getToken(HansAntlrParser.EQUALS, 0);
		}

		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class, 0);
		}

		public VarDefUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_varDefUnit;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitVarDefUnit(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final VarDefUnitContext varDefUnit() throws RecognitionException {
		VarDefUnitContext _localctx = new VarDefUnitContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_varDefUnit);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(248);
				match(Identifier);
				setState(249);
				match(EQUALS);
				setState(250);
				expression(0);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatementContext extends ParserRuleContext {
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_returnStatement;
		}

		public ReturnStatementContext() {
		}

		public void copyFrom(ReturnStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnVoidContext extends ReturnStatementContext {
		public TerminalNode Return() {
			return getToken(HansAntlrParser.Return, 0);
		}

		public ReturnVoidContext(ReturnStatementContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitReturnVoid(this);
			else
				return visitor.visitChildren(this);
		}
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnWithValueContext extends ReturnStatementContext {
		public TerminalNode Return() {
			return getToken(HansAntlrParser.Return, 0);
		}

		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class, 0);
		}

		public ReturnWithValueContext(ReturnStatementContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitReturnWithValue(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_returnStatement);
		try {
			setState(255);
			_errHandler.sync(this);
			switch (getInterpreter().adaptivePredict(_input, 25, _ctx)) {
				case 1:
					_localctx = new ReturnWithValueContext(_localctx);
					enterOuterAlt(_localctx, 1); {
					setState(252);
					match(Return);
					setState(253);
					expression(0);
				}
					break;
				case 2:
					_localctx = new ReturnVoidContext(_localctx);
					enterOuterAlt(_localctx, 2); {
					setState(254);
					match(Return);
				}
					break;
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class, 0);
		}

		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_expressionStatement;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitExpressionStatement(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(257);
				expression(0);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public StatementContext trueStatement;
		public StatementContext falseStatement;

		public TerminalNode If() {
			return getToken(HansAntlrParser.If, 0);
		}

		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class, 0);
		}

		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}

		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class, i);
		}

		public TerminalNode OpenParen() {
			return getToken(HansAntlrParser.OpenParen, 0);
		}

		public TerminalNode CloseParen() {
			return getToken(HansAntlrParser.CloseParen, 0);
		}

		public TerminalNode Else() {
			return getToken(HansAntlrParser.Else, 0);
		}

		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_ifStatement;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitIfStatement(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(259);
				match(If);
				setState(261);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 26, _ctx)) {
					case 1: {
						setState(260);
						match(OpenParen);
					}
						break;
				}
				setState(263);
				expression(0);
				setState(265);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == CloseParen) {
					{
						setState(264);
						match(CloseParen);
					}
				}

				setState(267);
				((IfStatementContext) _localctx).trueStatement = statement();
				setState(270);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 28, _ctx)) {
					case 1: {
						setState(268);
						match(Else);
						setState(269);
						((IfStatementContext) _localctx).falseStatement = statement();
					}
						break;
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RangedForStatementContext extends ParserRuleContext {
		public TerminalNode For() {
			return getToken(HansAntlrParser.For, 0);
		}

		public RangedForConditionsContext rangedForConditions() {
			return getRuleContext(RangedForConditionsContext.class, 0);
		}

		public StatementContext statement() {
			return getRuleContext(StatementContext.class, 0);
		}

		public TerminalNode OpenParen() {
			return getToken(HansAntlrParser.OpenParen, 0);
		}

		public TerminalNode CloseParen() {
			return getToken(HansAntlrParser.CloseParen, 0);
		}

		public RangedForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_rangedForStatement;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitRangedForStatement(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final RangedForStatementContext rangedForStatement() throws RecognitionException {
		RangedForStatementContext _localctx = new RangedForStatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_rangedForStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(272);
				match(For);
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == OpenParen) {
					{
						setState(273);
						match(OpenParen);
					}
				}

				setState(276);
				rangedForConditions();
				setState(278);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == CloseParen) {
					{
						setState(277);
						match(CloseParen);
					}
				}

				setState(280);
				statement();
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RangedForConditionsContext extends ParserRuleContext {
		public VariableReferenceContext iterator;
		public ExpressionContext startExpr;
		public Token range;
		public ExpressionContext endExpr;

		public TerminalNode Colon() {
			return getToken(HansAntlrParser.Colon, 0);
		}

		public VariableReferenceContext variableReference() {
			return getRuleContext(VariableReferenceContext.class, 0);
		}

		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}

		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class, i);
		}

		public TerminalNode To() {
			return getToken(HansAntlrParser.To, 0);
		}

		public RangedForConditionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_rangedForConditions;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitRangedForConditions(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final RangedForConditionsContext rangedForConditions() throws RecognitionException {
		RangedForConditionsContext _localctx = new RangedForConditionsContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_rangedForConditions);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(282);
				((RangedForConditionsContext) _localctx).iterator = variableReference();
				setState(283);
				match(Colon);
				setState(284);
				((RangedForConditionsContext) _localctx).startExpr = expression(0);
				setState(285);
				((RangedForConditionsContext) _localctx).range = match(To);
				setState(286);
				((RangedForConditionsContext) _localctx).endExpr = expression(0);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StandardForStatementContext extends ParserRuleContext {
		public TerminalNode For() {
			return getToken(HansAntlrParser.For, 0);
		}

		public List<TerminalNode> SemiColon() {
			return getTokens(HansAntlrParser.SemiColon);
		}

		public TerminalNode SemiColon(int i) {
			return getToken(HansAntlrParser.SemiColon, i);
		}

		public StatementContext statement() {
			return getRuleContext(StatementContext.class, 0);
		}

		public TerminalNode OpenParen() {
			return getToken(HansAntlrParser.OpenParen, 0);
		}

		public StandardForInitContext standardForInit() {
			return getRuleContext(StandardForInitContext.class, 0);
		}

		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class, 0);
		}

		public StandardForUpdateContext standardForUpdate() {
			return getRuleContext(StandardForUpdateContext.class, 0);
		}

		public TerminalNode CloseParen() {
			return getToken(HansAntlrParser.CloseParen, 0);
		}

		public StandardForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_standardForStatement;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitStandardForStatement(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final StandardForStatementContext standardForStatement() throws RecognitionException {
		StandardForStatementContext _localctx = new StandardForStatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_standardForStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(288);
				match(For);
				setState(290);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 31, _ctx)) {
					case 1: {
						setState(289);
						match(OpenParen);
					}
						break;
				}
				setState(293);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2233780914050038872L) != 0) || _la == BackTick) {
					{
						setState(292);
						standardForInit();
					}
				}

				setState(295);
				match(SemiColon);
				setState(297);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2233781017129253976L) != 0) || _la == BackTick) {
					{
						setState(296);
						expression(0);
					}
				}

				setState(299);
				match(SemiColon);
				setState(301);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 34, _ctx)) {
					case 1: {
						setState(300);
						standardForUpdate();
					}
						break;
				}
				setState(304);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == CloseParen) {
					{
						setState(303);
						match(CloseParen);
					}
				}

				setState(306);
				statement();
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StandardForInitContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class, 0);
		}

		public PrintContext print() {
			return getRuleContext(PrintContext.class, 0);
		}

		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class, 0);
		}

		public StandardForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_standardForInit;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitStandardForInit(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final StandardForInitContext standardForInit() throws RecognitionException {
		StandardForInitContext _localctx = new StandardForInitContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_standardForInit);
		try {
			setState(311);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case VARIABLE:
					enterOuterAlt(_localctx, 1); {
					setState(308);
					variable();
				}
					break;
				case PRINT:
					enterOuterAlt(_localctx, 2); {
					setState(309);
					print();
				}
					break;
				case OpenBracket:
				case OpenParen:
				case Plus:
				case Minus:
				case BitNot:
				case New:
				case NUMBER:
				case BOOL:
				case STRING:
				case Identifier:
				case BackTick:
					enterOuterAlt(_localctx, 3); {
					setState(310);
					expressionStatement();
				}
					break;
				default:
					throw new NoViableAltException(this);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StandardForUpdateContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class, 0);
		}

		public PrintContext print() {
			return getRuleContext(PrintContext.class, 0);
		}

		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class, 0);
		}

		public StandardForUpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_standardForUpdate;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitStandardForUpdate(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final StandardForUpdateContext standardForUpdate() throws RecognitionException {
		StandardForUpdateContext _localctx = new StandardForUpdateContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_standardForUpdate);
		try {
			setState(316);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case VARIABLE:
					enterOuterAlt(_localctx, 1); {
					setState(313);
					variable();
				}
					break;
				case PRINT:
					enterOuterAlt(_localctx, 2); {
					setState(314);
					print();
				}
					break;
				case OpenBracket:
				case OpenParen:
				case Plus:
				case Minus:
				case BitNot:
				case New:
				case NUMBER:
				case BOOL:
				case STRING:
				case Identifier:
				case BackTick:
					enterOuterAlt(_localctx, 3); {
					setState(315);
					expressionStatement();
				}
					break;
				default:
					throw new NoViableAltException(this);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BreakStatementContext extends ParserRuleContext {
		public TerminalNode Break() {
			return getToken(HansAntlrParser.Break, 0);
		}

		public BreakStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_breakStatement;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitBreakStatement(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final BreakStatementContext breakStatement() throws RecognitionException {
		BreakStatementContext _localctx = new BreakStatementContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_breakStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(318);
				match(Break);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ContinueStatementContext extends ParserRuleContext {
		public TerminalNode Continue() {
			return getToken(HansAntlrParser.Continue, 0);
		}

		public ContinueStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_continueStatement;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitContinueStatement(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final ContinueStatementContext continueStatement() throws RecognitionException {
		ContinueStatementContext _localctx = new ContinueStatementContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_continueStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(320);
				match(Continue);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_expression;
		}

		public ExpressionContext() {
		}

		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RELATIONALContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}

		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class, i);
		}

		public TerminalNode RELATIONAL() {
			return getToken(HansAntlrParser.RELATIONAL, 0);
		}

		public RELATIONALContext(ExpressionContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitRELATIONAL(this);
			else
				return visitor.visitChildren(this);
		}
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayDeclarationContext extends ExpressionContext {
		public TerminalNode New() {
			return getToken(HansAntlrParser.New, 0);
		}

		public PrimitiveTypeNameContext primitiveTypeName() {
			return getRuleContext(PrimitiveTypeNameContext.class, 0);
		}

		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class, 0);
		}

		public List<TerminalNode> OpenBracket() {
			return getTokens(HansAntlrParser.OpenBracket);
		}

		public TerminalNode OpenBracket(int i) {
			return getToken(HansAntlrParser.OpenBracket, i);
		}

		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}

		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class, i);
		}

		public List<TerminalNode> CloseBracket() {
			return getTokens(HansAntlrParser.CloseBracket);
		}

		public TerminalNode CloseBracket(int i) {
			return getToken(HansAntlrParser.CloseBracket, i);
		}

		public ArrayDeclarationContext(ExpressionContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitArrayDeclaration(this);
			else
				return visitor.visitChildren(this);
		}
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueExprContext extends ExpressionContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class, 0);
		}

		public ValueExprContext(ExpressionContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitValueExpr(this);
			else
				return visitor.visitChildren(this);
		}
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ORContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}

		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class, i);
		}

		public TerminalNode OR() {
			return getToken(HansAntlrParser.OR, 0);
		}

		public ORContext(ExpressionContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitOR(this);
			else
				return visitor.visitChildren(this);
		}
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ADDITIVEContext extends ExpressionContext {
		public Token ADDITIVE;

		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}

		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class, i);
		}

		public TerminalNode Plus() {
			return getToken(HansAntlrParser.Plus, 0);
		}

		public TerminalNode Minus() {
			return getToken(HansAntlrParser.Minus, 0);
		}

		public ADDITIVEContext(ExpressionContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitADDITIVE(this);
			else
				return visitor.visitChildren(this);
		}
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClazzFieldReferenceContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class, 0);
		}

		public TerminalNode Dot() {
			return getToken(HansAntlrParser.Dot, 0);
		}

		public TerminalNode Identifier() {
			return getToken(HansAntlrParser.Identifier, 0);
		}

		public ClazzFieldReferenceContext(ExpressionContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitClazzFieldReference(this);
			else
				return visitor.visitChildren(this);
		}
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SHIFTContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}

		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class, i);
		}

		public TerminalNode SHIFT() {
			return getToken(HansAntlrParser.SHIFT, 0);
		}

		public SHIFTContext(ExpressionContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitSHIFT(this);
			else
				return visitor.visitChildren(this);
		}
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayAccessContext extends ExpressionContext {
		public ExpressionContext array;

		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}

		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class, i);
		}

		public List<TerminalNode> OpenBracket() {
			return getTokens(HansAntlrParser.OpenBracket);
		}

		public TerminalNode OpenBracket(int i) {
			return getToken(HansAntlrParser.OpenBracket, i);
		}

		public List<TerminalNode> CloseBracket() {
			return getTokens(HansAntlrParser.CloseBracket);
		}

		public TerminalNode CloseBracket(int i) {
			return getToken(HansAntlrParser.CloseBracket, i);
		}

		public ArrayAccessContext(ExpressionContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitArrayAccess(this);
			else
				return visitor.visitChildren(this);
		}
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarReferenceContext extends ExpressionContext {
		public VariableReferenceContext variableReference() {
			return getRuleContext(VariableReferenceContext.class, 0);
		}

		public VarReferenceContext(ExpressionContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitVarReference(this);
			else
				return visitor.visitChildren(this);
		}
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrLiteralContext extends ExpressionContext {
		public ArrayLiteralContext arrayLiteral() {
			return getRuleContext(ArrayLiteralContext.class, 0);
		}

		public ArrLiteralContext(ExpressionContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitArrLiteral(this);
			else
				return visitor.visitChildren(this);
		}
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BRACKETContext extends ExpressionContext {
		public TerminalNode OpenParen() {
			return getToken(HansAntlrParser.OpenParen, 0);
		}

		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class, 0);
		}

		public TerminalNode CloseParen() {
			return getToken(HansAntlrParser.CloseParen, 0);
		}

		public BRACKETContext(ExpressionContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitBRACKET(this);
			else
				return visitor.visitChildren(this);
		}
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MULTIPLICATIVEContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}

		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class, i);
		}

		public TerminalNode MULTIPLICATIVE() {
			return getToken(HansAntlrParser.MULTIPLICATIVE, 0);
		}

		public MULTIPLICATIVEContext(ExpressionContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitMULTIPLICATIVE(this);
			else
				return visitor.visitChildren(this);
		}
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TemplateLiteralContext extends ExpressionContext {
		public TemplateStringLiteralContext templateStringLiteral() {
			return getRuleContext(TemplateStringLiteralContext.class, 0);
		}

		public TemplateLiteralContext(ExpressionContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitTemplateLiteral(this);
			else
				return visitor.visitChildren(this);
		}
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EQUALITYContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}

		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class, i);
		}

		public TerminalNode EQUALITY() {
			return getToken(HansAntlrParser.EQUALITY, 0);
		}

		public EQUALITYContext(ExpressionContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitEQUALITY(this);
			else
				return visitor.visitChildren(this);
		}
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ANDContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}

		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class, i);
		}

		public TerminalNode AND() {
			return getToken(HansAntlrParser.AND, 0);
		}

		public ANDContext(ExpressionContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitAND(this);
			else
				return visitor.visitChildren(this);
		}
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ASSIGNMENTContext extends ExpressionContext {
		public ExpressionContext leftHandSide;
		public Token AssignmentOperator;
		public ExpressionContext rightHandSide;

		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}

		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class, i);
		}

		public TerminalNode EQUALS() {
			return getToken(HansAntlrParser.EQUALS, 0);
		}

		public TerminalNode PowerAssign() {
			return getToken(HansAntlrParser.PowerAssign, 0);
		}

		public TerminalNode MultiplyAssign() {
			return getToken(HansAntlrParser.MultiplyAssign, 0);
		}

		public TerminalNode DivideAssign() {
			return getToken(HansAntlrParser.DivideAssign, 0);
		}

		public TerminalNode ModulusAssign() {
			return getToken(HansAntlrParser.ModulusAssign, 0);
		}

		public TerminalNode PlusAssign() {
			return getToken(HansAntlrParser.PlusAssign, 0);
		}

		public TerminalNode MinusAssign() {
			return getToken(HansAntlrParser.MinusAssign, 0);
		}

		public TerminalNode LeftShiftArithmeticAssign() {
			return getToken(HansAntlrParser.LeftShiftArithmeticAssign, 0);
		}

		public TerminalNode RightShiftArithmeticAssign() {
			return getToken(HansAntlrParser.RightShiftArithmeticAssign, 0);
		}

		public TerminalNode RightShiftLogicalAssign() {
			return getToken(HansAntlrParser.RightShiftLogicalAssign, 0);
		}

		public TerminalNode BitAndAssign() {
			return getToken(HansAntlrParser.BitAndAssign, 0);
		}

		public TerminalNode BitXorAssign() {
			return getToken(HansAntlrParser.BitXorAssign, 0);
		}

		public TerminalNode BitOrAssign() {
			return getToken(HansAntlrParser.BitOrAssign, 0);
		}

		public ASSIGNMENTContext(ExpressionContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitASSIGNMENT(this);
			else
				return visitor.visitChildren(this);
		}
	}

	@SuppressWarnings("CheckReturnValue")
	public static class POWContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}

		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class, i);
		}

		public TerminalNode POW() {
			return getToken(HansAntlrParser.POW, 0);
		}

		public POWContext(ExpressionContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitPOW(this);
			else
				return visitor.visitChildren(this);
		}
	}

	@SuppressWarnings("CheckReturnValue")
	public static class XORContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}

		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class, i);
		}

		public TerminalNode XOR() {
			return getToken(HansAntlrParser.XOR, 0);
		}

		public XORContext(ExpressionContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitXOR(this);
			else
				return visitor.visitChildren(this);
		}
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallContext extends ExpressionContext {
		public ExpressionContext owner;

		public FunctionNameContext functionName() {
			return getRuleContext(FunctionNameContext.class, 0);
		}

		public TerminalNode OpenParen() {
			return getToken(HansAntlrParser.OpenParen, 0);
		}

		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class, 0);
		}

		public TerminalNode CloseParen() {
			return getToken(HansAntlrParser.CloseParen, 0);
		}

		public TerminalNode Dot() {
			return getToken(HansAntlrParser.Dot, 0);
		}

		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class, 0);
		}

		public FunctionCallContext(ExpressionContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitFunctionCall(this);
			else
				return visitor.visitChildren(this);
		}
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstructorCallContext extends ExpressionContext {
		public TerminalNode New() {
			return getToken(HansAntlrParser.New, 0);
		}

		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class, 0);
		}

		public TerminalNode OpenParen() {
			return getToken(HansAntlrParser.OpenParen, 0);
		}

		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class, 0);
		}

		public TerminalNode CloseParen() {
			return getToken(HansAntlrParser.CloseParen, 0);
		}

		public ConstructorCallContext(ExpressionContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitConstructorCall(this);
			else
				return visitor.visitChildren(this);
		}
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UNARYContext extends ExpressionContext {
		public Token UNARY;

		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class, 0);
		}

		public TerminalNode Plus() {
			return getToken(HansAntlrParser.Plus, 0);
		}

		public TerminalNode Minus() {
			return getToken(HansAntlrParser.Minus, 0);
		}

		public TerminalNode BitNot() {
			return getToken(HansAntlrParser.BitNot, 0);
		}

		public UNARYContext(ExpressionContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitUNARY(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
				setState(357);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 40, _ctx)) {
					case 1: {
						_localctx = new FunctionCallContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;

						setState(323);
						functionName();
						setState(324);
						match(OpenParen);
						setState(325);
						argumentList();
						setState(326);
						match(CloseParen);
					}
						break;
					case 2: {
						_localctx = new ConstructorCallContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(328);
						match(New);
						setState(329);
						qualifiedName();
						setState(330);
						match(OpenParen);
						setState(331);
						argumentList();
						setState(332);
						match(CloseParen);
					}
						break;
					case 3: {
						_localctx = new ArrayDeclarationContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(334);
						match(New);
						setState(337);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
							case Boolean:
							case String:
							case Char:
							case Byte:
							case Short:
							case Int:
							case Long:
							case Float:
							case Double:
							case Void: {
								setState(335);
								primitiveTypeName();
							}
								break;
							case Identifier: {
								setState(336);
								qualifiedName();
							}
								break;
							default:
								throw new NoViableAltException(this);
						}
						setState(343);
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
								case 1: {
									{
										setState(339);
										match(OpenBracket);
										setState(340);
										expression(0);
										setState(341);
										match(CloseBracket);
									}
								}
									break;
								default:
									throw new NoViableAltException(this);
							}
							setState(345);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input, 39, _ctx);
						} while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
					}
						break;
					case 4: {
						_localctx = new VarReferenceContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(347);
						variableReference();
					}
						break;
					case 5: {
						_localctx = new ValueExprContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(348);
						value();
					}
						break;
					case 6: {
						_localctx = new ArrLiteralContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(349);
						arrayLiteral();
					}
						break;
					case 7: {
						_localctx = new TemplateLiteralContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(350);
						templateStringLiteral();
					}
						break;
					case 8: {
						_localctx = new BRACKETContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(351);
						match(OpenParen);
						setState(352);
						expression(0);
						setState(353);
						match(CloseParen);
					}
						break;
					case 9: {
						_localctx = new UNARYContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(355);
						((UNARYContext) _localctx).UNARY = _input.LT(1);
						_la = _input.LA(1);
						if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 896L) != 0))) {
							((UNARYContext) _localctx).UNARY = (Token) _errHandler.recoverInline(this);
						} else {
							if (_input.LA(1) == Token.EOF)
								matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(356);
						expression(11);
					}
						break;
				}
				_ctx.stop = _input.LT(-1);
				setState(410);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input, 43, _ctx);
				while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
					if (_alt == 1) {
						if (_parseListeners != null)
							triggerExitRuleEvent();
						_prevctx = _localctx;
						{
							setState(408);
							_errHandler.sync(this);
							switch (getInterpreter().adaptivePredict(_input, 42, _ctx)) {
								case 1: {
									_localctx = new POWContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(359);
									if (!(precpred(_ctx, 10)))
										throw new FailedPredicateException(this, "precpred(_ctx, 10)");
									setState(360);
									match(POW);
									setState(361);
									expression(11);
								}
									break;
								case 2: {
									_localctx = new MULTIPLICATIVEContext(
											new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(362);
									if (!(precpred(_ctx, 9)))
										throw new FailedPredicateException(this, "precpred(_ctx, 9)");
									setState(363);
									match(MULTIPLICATIVE);
									setState(364);
									expression(10);
								}
									break;
								case 3: {
									_localctx = new ADDITIVEContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(365);
									if (!(precpred(_ctx, 8)))
										throw new FailedPredicateException(this, "precpred(_ctx, 8)");
									setState(366);
									((ADDITIVEContext) _localctx).ADDITIVE = _input.LT(1);
									_la = _input.LA(1);
									if (!(_la == Plus || _la == Minus)) {
										((ADDITIVEContext) _localctx).ADDITIVE = (Token) _errHandler
												.recoverInline(this);
									} else {
										if (_input.LA(1) == Token.EOF)
											matchedEOF = true;
										_errHandler.reportMatch(this);
										consume();
									}
									setState(367);
									expression(9);
								}
									break;
								case 4: {
									_localctx = new SHIFTContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(368);
									if (!(precpred(_ctx, 7)))
										throw new FailedPredicateException(this, "precpred(_ctx, 7)");
									setState(369);
									match(SHIFT);
									setState(370);
									expression(8);
								}
									break;
								case 5: {
									_localctx = new RELATIONALContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(371);
									if (!(precpred(_ctx, 6)))
										throw new FailedPredicateException(this, "precpred(_ctx, 6)");
									setState(372);
									match(RELATIONAL);
									setState(373);
									expression(7);
								}
									break;
								case 6: {
									_localctx = new EQUALITYContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(374);
									if (!(precpred(_ctx, 5)))
										throw new FailedPredicateException(this, "precpred(_ctx, 5)");
									setState(375);
									match(EQUALITY);
									setState(376);
									expression(6);
								}
									break;
								case 7: {
									_localctx = new ANDContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(377);
									if (!(precpred(_ctx, 4)))
										throw new FailedPredicateException(this, "precpred(_ctx, 4)");
									setState(378);
									match(AND);
									setState(379);
									expression(5);
								}
									break;
								case 8: {
									_localctx = new XORContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(380);
									if (!(precpred(_ctx, 3)))
										throw new FailedPredicateException(this, "precpred(_ctx, 3)");
									setState(381);
									match(XOR);
									setState(382);
									expression(4);
								}
									break;
								case 9: {
									_localctx = new ORContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(383);
									if (!(precpred(_ctx, 2)))
										throw new FailedPredicateException(this, "precpred(_ctx, 2)");
									setState(384);
									match(OR);
									setState(385);
									expression(3);
								}
									break;
								case 10: {
									_localctx = new ASSIGNMENTContext(new ExpressionContext(_parentctx, _parentState));
									((ASSIGNMENTContext) _localctx).leftHandSide = _prevctx;
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(386);
									if (!(precpred(_ctx, 1)))
										throw new FailedPredicateException(this, "precpred(_ctx, 1)");
									setState(387);
									((ASSIGNMENTContext) _localctx).AssignmentOperator = _input.LT(1);
									_la = _input.LA(1);
									if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 34355544064L) != 0))) {
										((ASSIGNMENTContext) _localctx).AssignmentOperator = (Token) _errHandler
												.recoverInline(this);
									} else {
										if (_input.LA(1) == Token.EOF)
											matchedEOF = true;
										_errHandler.reportMatch(this);
										consume();
									}
									setState(388);
									((ASSIGNMENTContext) _localctx).rightHandSide = expression(1);
								}
									break;
								case 11: {
									_localctx = new FunctionCallContext(
											new ExpressionContext(_parentctx, _parentState));
									((FunctionCallContext) _localctx).owner = _prevctx;
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(389);
									if (!(precpred(_ctx, 21)))
										throw new FailedPredicateException(this, "precpred(_ctx, 21)");
									setState(390);
									match(Dot);
									setState(391);
									functionName();
									setState(392);
									match(OpenParen);
									setState(393);
									argumentList();
									setState(394);
									match(CloseParen);
								}
									break;
								case 12: {
									_localctx = new ArrayAccessContext(new ExpressionContext(_parentctx, _parentState));
									((ArrayAccessContext) _localctx).array = _prevctx;
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(396);
									if (!(precpred(_ctx, 18)))
										throw new FailedPredicateException(this, "precpred(_ctx, 18)");
									setState(401);
									_errHandler.sync(this);
									_alt = 1;
									do {
										switch (_alt) {
											case 1: {
												{
													setState(397);
													match(OpenBracket);
													setState(398);
													expression(0);
													setState(399);
													match(CloseBracket);
												}
											}
												break;
											default:
												throw new NoViableAltException(this);
										}
										setState(403);
										_errHandler.sync(this);
										_alt = getInterpreter().adaptivePredict(_input, 41, _ctx);
									} while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
								}
									break;
								case 13: {
									_localctx = new ClazzFieldReferenceContext(
											new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(405);
									if (!(precpred(_ctx, 17)))
										throw new FailedPredicateException(this, "precpred(_ctx, 17)");
									setState(406);
									match(Dot);
									setState(407);
									match(Identifier);
								}
									break;
							}
						}
					}
					setState(412);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 43, _ctx);
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}

		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class, i);
		}

		public List<TerminalNode> Comma() {
			return getTokens(HansAntlrParser.Comma);
		}

		public TerminalNode Comma(int i) {
			return getToken(HansAntlrParser.Comma, i);
		}

		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_argumentList;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitArgumentList(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(414);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2233781017129253976L) != 0) || _la == BackTick) {
					{
						setState(413);
						expression(0);
					}
				}

				setState(420);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la == Comma) {
					{
						{
							setState(416);
							match(Comma);
							setState(417);
							expression(0);
						}
					}
					setState(422);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableReferenceContext extends ParserRuleContext {
		public TerminalNode Identifier() {
			return getToken(HansAntlrParser.Identifier, 0);
		}

		public VariableReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_variableReference;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitVariableReference(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final VariableReferenceContext variableReference() throws RecognitionException {
		VariableReferenceContext _localctx = new VariableReferenceContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_variableReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(423);
				match(Identifier);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrintContext extends ParserRuleContext {
		public TerminalNode PRINT() {
			return getToken(HansAntlrParser.PRINT, 0);
		}

		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class, 0);
		}

		public TerminalNode PrintArg() {
			return getToken(HansAntlrParser.PrintArg, 0);
		}

		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_print;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitPrint(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_print);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(425);
				match(PRINT);
				setState(427);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == PrintArg) {
					{
						setState(426);
						match(PrintArg);
					}
				}

				setState(429);
				expression(0);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueContext extends ParserRuleContext {
		public TerminalNode NUMBER() {
			return getToken(HansAntlrParser.NUMBER, 0);
		}

		public TerminalNode STRING() {
			return getToken(HansAntlrParser.STRING, 0);
		}

		public TerminalNode BOOL() {
			return getToken(HansAntlrParser.BOOL, 0);
		}

		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_value;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitValue(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(431);
				_la = _input.LA(1);
				if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 6989586621679009792L) != 0))) {
					_errHandler.recoverInline(this);
				} else {
					if (_input.LA(1) == Token.EOF)
						matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TemplateStringLiteralContext extends ParserRuleContext {
		public List<TerminalNode> BackTick() {
			return getTokens(HansAntlrParser.BackTick);
		}

		public TerminalNode BackTick(int i) {
			return getToken(HansAntlrParser.BackTick, i);
		}

		public List<TemplateStringAtomContext> templateStringAtom() {
			return getRuleContexts(TemplateStringAtomContext.class);
		}

		public TemplateStringAtomContext templateStringAtom(int i) {
			return getRuleContext(TemplateStringAtomContext.class, i);
		}

		public TemplateStringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_templateStringLiteral;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitTemplateStringLiteral(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final TemplateStringLiteralContext templateStringLiteral() throws RecognitionException {
		TemplateStringLiteralContext _localctx = new TemplateStringLiteralContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_templateStringLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(433);
				match(BackTick);
				setState(437);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la == TemplateStringStartExpression || _la == TemplateStringAtom) {
					{
						{
							setState(434);
							templateStringAtom();
						}
					}
					setState(439);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(440);
				match(BackTick);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TemplateStringAtomContext extends ParserRuleContext {
		public TerminalNode TemplateStringAtom() {
			return getToken(HansAntlrParser.TemplateStringAtom, 0);
		}

		public TerminalNode TemplateStringStartExpression() {
			return getToken(HansAntlrParser.TemplateStringStartExpression, 0);
		}

		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class, 0);
		}

		public TerminalNode CloseBrace() {
			return getToken(HansAntlrParser.CloseBrace, 0);
		}

		public TemplateStringAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_templateStringAtom;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitTemplateStringAtom(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final TemplateStringAtomContext templateStringAtom() throws RecognitionException {
		TemplateStringAtomContext _localctx = new TemplateStringAtomContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_templateStringAtom);
		try {
			setState(447);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case TemplateStringAtom:
					enterOuterAlt(_localctx, 1); {
					setState(442);
					match(TemplateStringAtom);
				}
					break;
				case TemplateStringStartExpression:
					enterOuterAlt(_localctx, 2); {
					setState(443);
					match(TemplateStringStartExpression);
					setState(444);
					expression(0);
					setState(445);
					match(CloseBrace);
				}
					break;
				default:
					throw new NoViableAltException(this);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayLiteralContext extends ParserRuleContext {
		public TerminalNode OpenBracket() {
			return getToken(HansAntlrParser.OpenBracket, 0);
		}

		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}

		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class, i);
		}

		public TerminalNode CloseBracket() {
			return getToken(HansAntlrParser.CloseBracket, 0);
		}

		public List<TerminalNode> Comma() {
			return getTokens(HansAntlrParser.Comma);
		}

		public TerminalNode Comma(int i) {
			return getToken(HansAntlrParser.Comma, i);
		}

		public ArrayLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_arrayLiteral;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrParserVisitor)
				return ((HansAntlrParserVisitor<? extends T>) visitor).visitArrayLiteral(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final ArrayLiteralContext arrayLiteral() throws RecognitionException {
		ArrayLiteralContext _localctx = new ArrayLiteralContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_arrayLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(449);
				match(OpenBracket);
				setState(450);
				expression(0);
				setState(455);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la == Comma) {
					{
						{
							setState(451);
							match(Comma);
							setState(452);
							expression(0);
						}
					}
					setState(457);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(458);
				match(CloseBracket);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
			case 27:
				return expression_sempred((ExpressionContext) _localctx, predIndex);
		}
		return true;
	}

	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
			case 0:
				return precpred(_ctx, 10);
			case 1:
				return precpred(_ctx, 9);
			case 2:
				return precpred(_ctx, 8);
			case 3:
				return precpred(_ctx, 7);
			case 4:
				return precpred(_ctx, 6);
			case 5:
				return precpred(_ctx, 5);
			case 6:
				return precpred(_ctx, 4);
			case 7:
				return precpred(_ctx, 3);
			case 8:
				return precpred(_ctx, 2);
			case 9:
				return precpred(_ctx, 1);
			case 10:
				return precpred(_ctx, 21);
			case 11:
				return precpred(_ctx, 18);
			case 12:
				return precpred(_ctx, 17);
		}
		return true;
	}

	public static final String _serializedATN = "\u0004\u0001E\u01cd\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"
			+
			"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002" +
			"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002" +
			"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002" +
			"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f" +
			"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012" +
			"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015" +
			"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018" +
			"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b" +
			"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e" +
			"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0001" +
			"\u0000\u0001\u0000\u0005\u0000I\b\u0000\n\u0000\f\u0000L\t\u0000\u0001" +
			"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0003\u0001R\b\u0001\u0001" +
			"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0003\u0003X\b\u0003\u0001" +
			"\u0003\u0001\u0003\u0001\u0003\u0003\u0003]\b\u0003\u0001\u0003\u0003" +
			"\u0003`\b\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001" +
			"\u0005\u0005\u0005g\b\u0005\n\u0005\f\u0005j\t\u0005\u0001\u0006\u0001" +
			"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0003\u0007q\b\u0007\u0001" +
			"\b\u0001\b\u0001\b\u0005\bv\b\b\n\b\f\by\t\b\u0001\b\u0001\b\u0001\b\u0005" +
			"\b~\b\b\n\b\f\b\u0081\t\b\u0001\b\u0001\b\u0001\b\u0005\b\u0086\b\b\n" +
			"\b\f\b\u0089\t\b\u0001\b\u0001\b\u0001\b\u0005\b\u008e\b\b\n\b\f\b\u0091" +
			"\t\b\u0001\b\u0001\b\u0001\b\u0005\b\u0096\b\b\n\b\f\b\u0099\t\b\u0001" +
			"\b\u0001\b\u0001\b\u0005\b\u009e\b\b\n\b\f\b\u00a1\t\b\u0001\b\u0001\b" +
			"\u0001\b\u0005\b\u00a6\b\b\n\b\f\b\u00a9\t\b\u0001\b\u0001\b\u0001\b\u0005" +
			"\b\u00ae\b\b\n\b\f\b\u00b1\t\b\u0001\b\u0001\b\u0001\b\u0005\b\u00b6\b" +
			"\b\n\b\f\b\u00b9\t\b\u0001\b\u0001\b\u0001\b\u0005\b\u00be\b\b\n\b\f\b" +
			"\u00c1\t\b\u0003\b\u00c3\b\b\u0001\t\u0001\t\u0001\t\u0005\t\u00c8\b\t" +
			"\n\t\f\t\u00cb\t\t\u0001\n\u0001\n\u0001\n\u0005\n\u00d0\b\n\n\n\f\n\u00d3" +
			"\t\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0003\f\u00d9\b\f\u0005\f" +
			"\u00db\b\f\n\f\f\f\u00de\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e" +
			"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e" +
			"\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00ee\b\u000e\u0001\u000f" +
			"\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00f4\b\u000f\n\u000f" +
			"\f\u000f\u00f7\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010" +
			"\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0100\b\u0011\u0001\u0012" +
			"\u0001\u0012\u0001\u0013\u0001\u0013\u0003\u0013\u0106\b\u0013\u0001\u0013" +
			"\u0001\u0013\u0003\u0013\u010a\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013" +
			"\u0003\u0013\u010f\b\u0013\u0001\u0014\u0001\u0014\u0003\u0014\u0113\b" +
			"\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0117\b\u0014\u0001\u0014\u0001" +
			"\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001" +
			"\u0015\u0001\u0016\u0001\u0016\u0003\u0016\u0123\b\u0016\u0001\u0016\u0003" +
			"\u0016\u0126\b\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u012a\b\u0016" +
			"\u0001\u0016\u0001\u0016\u0003\u0016\u012e\b\u0016\u0001\u0016\u0003\u0016" +
			"\u0131\b\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017" +
			"\u0003\u0017\u0138\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018" +
			"\u013d\b\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b" +
			"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b" +
			"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b" +
			"\u0001\u001b\u0001\u001b\u0003\u001b\u0152\b\u001b\u0001\u001b\u0001\u001b" +
			"\u0001\u001b\u0001\u001b\u0004\u001b\u0158\b\u001b\u000b\u001b\f\u001b" +
			"\u0159\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001" +
			"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u0166" +
			"\b\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001" +
			"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001" +
			"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001" +
			"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001" +
			"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001" +
			"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001" +
			"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001" +
			"\u001b\u0004\u001b\u0192\b\u001b\u000b\u001b\f\u001b\u0193\u0001\u001b" +
			"\u0001\u001b\u0001\u001b\u0005\u001b\u0199\b\u001b\n\u001b\f\u001b\u019c" +
			"\t\u001b\u0001\u001c\u0003\u001c\u019f\b\u001c\u0001\u001c\u0001\u001c" +
			"\u0005\u001c\u01a3\b\u001c\n\u001c\f\u001c\u01a6\t\u001c\u0001\u001d\u0001" +
			"\u001d\u0001\u001e\u0001\u001e\u0003\u001e\u01ac\b\u001e\u0001\u001e\u0001" +
			"\u001e\u0001\u001f\u0001\u001f\u0001 \u0001 \u0005 \u01b4\b \n \f \u01b7" +
			"\t \u0001 \u0001 \u0001!\u0001!\u0001!\u0001!\u0001!\u0003!\u01c0\b!\u0001" +
			"\"\u0001\"\u0001\"\u0001\"\u0005\"\u01c6\b\"\n\"\f\"\u01c9\t\"\u0001\"" +
			"\u0001\"\u0001\"\u0000\u00016#\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010" +
			"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BD\u0000\u0005" +
			"\u0001\u0000.7\u0001\u0000\u0007\t\u0001\u0000\u0007\b\u0001\u0000\u0016" +
			"\"\u0002\u000088=>\u01ff\u0000J\u0001\u0000\u0000\u0000\u0002O\u0001\u0000" +
			"\u0000\u0000\u0004S\u0001\u0000\u0000\u0000\u0006W\u0001\u0000\u0000\u0000" +
			"\ba\u0001\u0000\u0000\u0000\nc\u0001\u0000\u0000\u0000\fk\u0001\u0000" +
			"\u0000\u0000\u000ep\u0001\u0000\u0000\u0000\u0010\u00c2\u0001\u0000\u0000" +
			"\u0000\u0012\u00c4\u0001\u0000\u0000\u0000\u0014\u00cc\u0001\u0000\u0000" +
			"\u0000\u0016\u00d4\u0001\u0000\u0000\u0000\u0018\u00dc\u0001\u0000\u0000" +
			"\u0000\u001a\u00df\u0001\u0000\u0000\u0000\u001c\u00ed\u0001\u0000\u0000" +
			"\u0000\u001e\u00ef\u0001\u0000\u0000\u0000 \u00f8\u0001\u0000\u0000\u0000" +
			"\"\u00ff\u0001\u0000\u0000\u0000$\u0101\u0001\u0000\u0000\u0000&\u0103" +
			"\u0001\u0000\u0000\u0000(\u0110\u0001\u0000\u0000\u0000*\u011a\u0001\u0000" +
			"\u0000\u0000,\u0120\u0001\u0000\u0000\u0000.\u0137\u0001\u0000\u0000\u0000" +
			"0\u013c\u0001\u0000\u0000\u00002\u013e\u0001\u0000\u0000\u00004\u0140" +
			"\u0001\u0000\u0000\u00006\u0165\u0001\u0000\u0000\u00008\u019e\u0001\u0000" +
			"\u0000\u0000:\u01a7\u0001\u0000\u0000\u0000<\u01a9\u0001\u0000\u0000\u0000" +
			">\u01af\u0001\u0000\u0000\u0000@\u01b1\u0001\u0000\u0000\u0000B\u01bf" +
			"\u0001\u0000\u0000\u0000D\u01c1\u0001\u0000\u0000\u0000FI\u0003\u0004" +
			"\u0002\u0000GI\u0003\u0002\u0001\u0000HF\u0001\u0000\u0000\u0000HG\u0001" +
			"\u0000\u0000\u0000IL\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000" +
			"JK\u0001\u0000\u0000\u0000KM\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000" +
			"\u0000MN\u0005\u0000\u0000\u0001N\u0001\u0001\u0000\u0000\u0000OQ\u0003" +
			"\u001e\u000f\u0000PR\u0005\f\u0000\u0000QP\u0001\u0000\u0000\u0000QR\u0001" +
			"\u0000\u0000\u0000R\u0003\u0001\u0000\u0000\u0000ST\u0003\u0006\u0003" +
			"\u0000TU\u0003\u001a\r\u0000U\u0005\u0001\u0000\u0000\u0000VX\u0003\u000e" +
			"\u0007\u0000WV\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XY\u0001" +
			"\u0000\u0000\u0000Y_\u0003\b\u0004\u0000Z\\\u0005\u0005\u0000\u0000[]" +
			"\u0003\n\u0005\u0000\\[\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000" +
			"]^\u0001\u0000\u0000\u0000^`\u0005\u0006\u0000\u0000_Z\u0001\u0000\u0000" +
			"\u0000_`\u0001\u0000\u0000\u0000`\u0007\u0001\u0000\u0000\u0000ab\u0005" +
			"?\u0000\u0000b\t\u0001\u0000\u0000\u0000ch\u0003\f\u0006\u0000de\u0005" +
			"\n\u0000\u0000eg\u0003\f\u0006\u0000fd\u0001\u0000\u0000\u0000gj\u0001" +
			"\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000" +
			"i\u000b\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000kl\u0003\u000e" +
			"\u0007\u0000lm\u0005?\u0000\u0000m\r\u0001\u0000\u0000\u0000nq\u0003\u0010" +
			"\b\u0000oq\u0003\u0012\t\u0000pn\u0001\u0000\u0000\u0000po\u0001\u0000" +
			"\u0000\u0000q\u000f\u0001\u0000\u0000\u0000rw\u0005.\u0000\u0000st\u0005" +
			"\u0003\u0000\u0000tv\u0005\u0004\u0000\u0000us\u0001\u0000\u0000\u0000" +
			"vy\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000" +
			"\u0000x\u00c3\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000\u0000z\u007f" +
			"\u0005/\u0000\u0000{|\u0005\u0003\u0000\u0000|~\u0005\u0004\u0000\u0000" +
			"}{\u0001\u0000\u0000\u0000~\u0081\u0001\u0000\u0000\u0000\u007f}\u0001" +
			"\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u00c3\u0001" +
			"\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0082\u0087\u0005" +
			"0\u0000\u0000\u0083\u0084\u0005\u0003\u0000\u0000\u0084\u0086\u0005\u0004" +
			"\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0086\u0089\u0001\u0000" +
			"\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000" +
			"\u0000\u0000\u0088\u00c3\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000" +
			"\u0000\u0000\u008a\u008f\u00051\u0000\u0000\u008b\u008c\u0005\u0003\u0000" +
			"\u0000\u008c\u008e\u0005\u0004\u0000\u0000\u008d\u008b\u0001\u0000\u0000" +
			"\u0000\u008e\u0091\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000" +
			"\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u00c3\u0001\u0000\u0000" +
			"\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0092\u0097\u00052\u0000\u0000" +
			"\u0093\u0094\u0005\u0003\u0000\u0000\u0094\u0096\u0005\u0004\u0000\u0000" +
			"\u0095\u0093\u0001\u0000\u0000\u0000\u0096\u0099\u0001\u0000\u0000\u0000" +
			"\u0097\u0095\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000" +
			"\u0098\u00c3\u0001\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000" +
			"\u009a\u009f\u00053\u0000\u0000\u009b\u009c\u0005\u0003\u0000\u0000\u009c" +
			"\u009e\u0005\u0004\u0000\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009e" +
			"\u00a1\u0001\u0000\u0000\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u009f" +
			"\u00a0\u0001\u0000\u0000\u0000\u00a0\u00c3\u0001\u0000\u0000\u0000\u00a1" +
			"\u009f\u0001\u0000\u0000\u0000\u00a2\u00a7\u00054\u0000\u0000\u00a3\u00a4" +
			"\u0005\u0003\u0000\u0000\u00a4\u00a6\u0005\u0004\u0000\u0000\u00a5\u00a3" +
			"\u0001\u0000\u0000\u0000\u00a6\u00a9\u0001\u0000\u0000\u0000\u00a7\u00a5" +
			"\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00c3" +
			"\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00aa\u00af" +
			"\u00055\u0000\u0000\u00ab\u00ac\u0005\u0003\u0000\u0000\u00ac\u00ae\u0005" +
			"\u0004\u0000\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ae\u00b1\u0001" +
			"\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00af\u00b0\u0001" +
			"\u0000\u0000\u0000\u00b0\u00c3\u0001\u0000\u0000\u0000\u00b1\u00af\u0001" +
			"\u0000\u0000\u0000\u00b2\u00b7\u00056\u0000\u0000\u00b3\u00b4\u0005\u0003" +
			"\u0000\u0000\u00b4\u00b6\u0005\u0004\u0000\u0000\u00b5\u00b3\u0001\u0000" +
			"\u0000\u0000\u00b6\u00b9\u0001\u0000\u0000\u0000\u00b7\u00b5\u0001\u0000" +
			"\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u00c3\u0001\u0000" +
			"\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00ba\u00bf\u00057\u0000" +
			"\u0000\u00bb\u00bc\u0005\u0003\u0000\u0000\u00bc\u00be\u0005\u0004\u0000" +
			"\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00be\u00c1\u0001\u0000\u0000" +
			"\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000" +
			"\u0000\u00c0\u00c3\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000" +
			"\u0000\u00c2r\u0001\u0000\u0000\u0000\u00c2z\u0001\u0000\u0000\u0000\u00c2" +
			"\u0082\u0001\u0000\u0000\u0000\u00c2\u008a\u0001\u0000\u0000\u0000\u00c2" +
			"\u0092\u0001\u0000\u0000\u0000\u00c2\u009a\u0001\u0000\u0000\u0000\u00c2" +
			"\u00a2\u0001\u0000\u0000\u0000\u00c2\u00aa\u0001\u0000\u0000\u0000\u00c2" +
			"\u00b2\u0001\u0000\u0000\u0000\u00c2\u00ba\u0001\u0000\u0000\u0000\u00c3" +
			"\u0011\u0001\u0000\u0000\u0000\u00c4\u00c9\u0003\u0014\n\u0000\u00c5\u00c6" +
			"\u0005\u0003\u0000\u0000\u00c6\u00c8\u0005\u0004\u0000\u0000\u00c7\u00c5" +
			"\u0001\u0000\u0000\u0000\u00c8\u00cb\u0001\u0000\u0000\u0000\u00c9\u00c7" +
			"\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca\u0013" +
			"\u0001\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cc\u00d1" +
			"\u0005?\u0000\u0000\u00cd\u00ce\u0005\u000b\u0000\u0000\u00ce\u00d0\u0005" +
			"?\u0000\u0000\u00cf\u00cd\u0001\u0000\u0000\u0000\u00d0\u00d3\u0001\u0000" +
			"\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d1\u00d2\u0001\u0000" +
			"\u0000\u0000\u00d2\u0015\u0001\u0000\u0000\u0000\u00d3\u00d1\u0001\u0000" +
			"\u0000\u0000\u00d4\u00d5\u0007\u0000\u0000\u0000\u00d5\u0017\u0001\u0000" +
			"\u0000\u0000\u00d6\u00d8\u0003\u001c\u000e\u0000\u00d7\u00d9\u0005\f\u0000" +
			"\u0000\u00d8\u00d7\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000" +
			"\u0000\u00d9\u00db\u0001\u0000\u0000\u0000\u00da\u00d6\u0001\u0000\u0000" +
			"\u0000\u00db\u00de\u0001\u0000\u0000\u0000\u00dc\u00da\u0001\u0000\u0000" +
			"\u0000\u00dc\u00dd\u0001\u0000\u0000\u0000\u00dd\u0019\u0001\u0000\u0000" +
			"\u0000\u00de\u00dc\u0001\u0000\u0000\u0000\u00df\u00e0\u0005\u0001\u0000" +
			"\u0000\u00e0\u00e1\u0003\u0018\f\u0000\u00e1\u00e2\u0005\u0002\u0000\u0000" +
			"\u00e2\u001b\u0001\u0000\u0000\u0000\u00e3\u00ee\u0003\u001e\u000f\u0000" +
			"\u00e4\u00ee\u0003<\u001e\u0000\u00e5\u00ee\u0003\"\u0011\u0000\u00e6" +
			"\u00ee\u0003\u001a\r\u0000\u00e7\u00ee\u0003&\u0013\u0000\u00e8\u00ee" +
			"\u0003(\u0014\u0000\u00e9\u00ee\u0003,\u0016\u0000\u00ea\u00ee\u00032" +
			"\u0019\u0000\u00eb\u00ee\u00034\u001a\u0000\u00ec\u00ee\u0003$\u0012\u0000" +
			"\u00ed\u00e3\u0001\u0000\u0000\u0000\u00ed\u00e4\u0001\u0000\u0000\u0000" +
			"\u00ed\u00e5\u0001\u0000\u0000\u0000\u00ed\u00e6\u0001\u0000\u0000\u0000" +
			"\u00ed\u00e7\u0001\u0000\u0000\u0000\u00ed\u00e8\u0001\u0000\u0000\u0000" +
			"\u00ed\u00e9\u0001\u0000\u0000\u0000\u00ed\u00ea\u0001\u0000\u0000\u0000" +
			"\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ed\u00ec\u0001\u0000\u0000\u0000" +
			"\u00ee\u001d\u0001\u0000\u0000\u0000\u00ef\u00f0\u0005#\u0000\u0000\u00f0" +
			"\u00f5\u0003 \u0010\u0000\u00f1\u00f2\u0005\n\u0000\u0000\u00f2\u00f4" +
			"\u0003 \u0010\u0000\u00f3\u00f1\u0001\u0000\u0000\u0000\u00f4\u00f7\u0001" +
			"\u0000\u0000\u0000\u00f5\u00f3\u0001\u0000\u0000\u0000\u00f5\u00f6\u0001" +
			"\u0000\u0000\u0000\u00f6\u001f\u0001\u0000\u0000\u0000\u00f7\u00f5\u0001" +
			"\u0000\u0000\u0000\u00f8\u00f9\u0005?\u0000\u0000\u00f9\u00fa\u0005\u0016" +
			"\u0000\u0000\u00fa\u00fb\u00036\u001b\u0000\u00fb!\u0001\u0000\u0000\u0000" +
			"\u00fc\u00fd\u0005%\u0000\u0000\u00fd\u0100\u00036\u001b\u0000\u00fe\u0100" +
			"\u0005%\u0000\u0000\u00ff\u00fc\u0001\u0000\u0000\u0000\u00ff\u00fe\u0001" +
			"\u0000\u0000\u0000\u0100#\u0001\u0000\u0000\u0000\u0101\u0102\u00036\u001b" +
			"\u0000\u0102%\u0001\u0000\u0000\u0000\u0103\u0105\u0005+\u0000\u0000\u0104" +
			"\u0106\u0005\u0005\u0000\u0000\u0105\u0104\u0001\u0000\u0000\u0000\u0105" +
			"\u0106\u0001\u0000\u0000\u0000\u0106\u0107\u0001\u0000\u0000\u0000\u0107" +
			"\u0109\u00036\u001b\u0000\u0108\u010a\u0005\u0006\u0000\u0000\u0109\u0108" +
			"\u0001\u0000\u0000\u0000\u0109\u010a\u0001\u0000\u0000\u0000\u010a\u010b" +
			"\u0001\u0000\u0000\u0000\u010b\u010e\u0003\u001c\u000e\u0000\u010c\u010d" +
			"\u0005,\u0000\u0000\u010d\u010f\u0003\u001c\u000e\u0000\u010e\u010c\u0001" +
			"\u0000\u0000\u0000\u010e\u010f\u0001\u0000\u0000\u0000\u010f\'\u0001\u0000" +
			"\u0000\u0000\u0110\u0112\u0005&\u0000\u0000\u0111\u0113\u0005\u0005\u0000" +
			"\u0000\u0112\u0111\u0001\u0000\u0000\u0000\u0112\u0113\u0001\u0000\u0000" +
			"\u0000\u0113\u0114\u0001\u0000\u0000\u0000\u0114\u0116\u0003*\u0015\u0000" +
			"\u0115\u0117\u0005\u0006\u0000\u0000\u0116\u0115\u0001\u0000\u0000\u0000" +
			"\u0116\u0117\u0001\u0000\u0000\u0000\u0117\u0118\u0001\u0000\u0000\u0000" +
			"\u0118\u0119\u0003\u001c\u000e\u0000\u0119)\u0001\u0000\u0000\u0000\u011a" +
			"\u011b\u0003:\u001d\u0000\u011b\u011c\u0005\r\u0000\u0000\u011c\u011d" +
			"\u00036\u001b\u0000\u011d\u011e\u0005\'\u0000\u0000\u011e\u011f\u0003" +
			"6\u001b\u0000\u011f+\u0001\u0000\u0000\u0000\u0120\u0122\u0005&\u0000" +
			"\u0000\u0121\u0123\u0005\u0005\u0000\u0000\u0122\u0121\u0001\u0000\u0000" +
			"\u0000\u0122\u0123\u0001\u0000\u0000\u0000\u0123\u0125\u0001\u0000\u0000" +
			"\u0000\u0124\u0126\u0003.\u0017\u0000\u0125\u0124\u0001\u0000\u0000\u0000" +
			"\u0125\u0126\u0001\u0000\u0000\u0000\u0126\u0127\u0001\u0000\u0000\u0000" +
			"\u0127\u0129\u0005\f\u0000\u0000\u0128\u012a\u00036\u001b\u0000\u0129" +
			"\u0128\u0001\u0000\u0000\u0000\u0129\u012a\u0001\u0000\u0000\u0000\u012a" +
			"\u012b\u0001\u0000\u0000\u0000\u012b\u012d\u0005\f\u0000\u0000\u012c\u012e" +
			"\u00030\u0018\u0000\u012d\u012c\u0001\u0000\u0000\u0000\u012d\u012e\u0001" +
			"\u0000\u0000\u0000\u012e\u0130\u0001\u0000\u0000\u0000\u012f\u0131\u0005" +
			"\u0006\u0000\u0000\u0130\u012f\u0001\u0000\u0000\u0000\u0130\u0131\u0001" +
			"\u0000\u0000\u0000\u0131\u0132\u0001\u0000\u0000\u0000\u0132\u0133\u0003" +
			"\u001c\u000e\u0000\u0133-\u0001\u0000\u0000\u0000\u0134\u0138\u0003\u001e" +
			"\u000f\u0000\u0135\u0138\u0003<\u001e\u0000\u0136\u0138\u0003$\u0012\u0000" +
			"\u0137\u0134\u0001\u0000\u0000\u0000\u0137\u0135\u0001\u0000\u0000\u0000" +
			"\u0137\u0136\u0001\u0000\u0000\u0000\u0138/\u0001\u0000\u0000\u0000\u0139" +
			"\u013d\u0003\u001e\u000f\u0000\u013a\u013d\u0003<\u001e\u0000\u013b\u013d" +
			"\u0003$\u0012\u0000\u013c\u0139\u0001\u0000\u0000\u0000\u013c\u013a\u0001" +
			"\u0000\u0000\u0000\u013c\u013b\u0001\u0000\u0000\u0000\u013d1\u0001\u0000" +
			"\u0000\u0000\u013e\u013f\u0005(\u0000\u0000\u013f3\u0001\u0000\u0000\u0000" +
			"\u0140\u0141\u0005)\u0000\u0000\u01415\u0001\u0000\u0000\u0000\u0142\u0143" +
			"\u0006\u001b\uffff\uffff\u0000\u0143\u0144\u0003\b\u0004\u0000\u0144\u0145" +
			"\u0005\u0005\u0000\u0000\u0145\u0146\u00038\u001c\u0000\u0146\u0147\u0005" +
			"\u0006\u0000\u0000\u0147\u0166\u0001\u0000\u0000\u0000\u0148\u0149\u0005" +
			"*\u0000\u0000\u0149\u014a\u0003\u0014\n\u0000\u014a\u014b\u0005\u0005" +
			"\u0000\u0000\u014b\u014c\u00038\u001c\u0000\u014c\u014d\u0005\u0006\u0000" +
			"\u0000\u014d\u0166\u0001\u0000\u0000\u0000\u014e\u0151\u0005*\u0000\u0000" +
			"\u014f\u0152\u0003\u0016\u000b\u0000\u0150\u0152\u0003\u0014\n\u0000\u0151" +
			"\u014f\u0001\u0000\u0000\u0000\u0151\u0150\u0001\u0000\u0000\u0000\u0152" +
			"\u0157\u0001\u0000\u0000\u0000\u0153\u0154\u0005\u0003\u0000\u0000\u0154" +
			"\u0155\u00036\u001b\u0000\u0155\u0156\u0005\u0004\u0000\u0000\u0156\u0158" +
			"\u0001\u0000\u0000\u0000\u0157\u0153\u0001\u0000\u0000\u0000\u0158\u0159" +
			"\u0001\u0000\u0000\u0000\u0159\u0157\u0001\u0000\u0000\u0000\u0159\u015a" +
			"\u0001\u0000\u0000\u0000\u015a\u0166\u0001\u0000\u0000\u0000\u015b\u0166" +
			"\u0003:\u001d\u0000\u015c\u0166\u0003>\u001f\u0000\u015d\u0166\u0003D" +
			"\"\u0000\u015e\u0166\u0003@ \u0000\u015f\u0160\u0005\u0005\u0000\u0000" +
			"\u0160\u0161\u00036\u001b\u0000\u0161\u0162\u0005\u0006\u0000\u0000\u0162" +
			"\u0166\u0001\u0000\u0000\u0000\u0163\u0164\u0007\u0001\u0000\u0000\u0164" +
			"\u0166\u00036\u001b\u000b\u0165\u0142\u0001\u0000\u0000\u0000\u0165\u0148" +
			"\u0001\u0000\u0000\u0000\u0165\u014e\u0001\u0000\u0000\u0000\u0165\u015b" +
			"\u0001\u0000\u0000\u0000\u0165\u015c\u0001\u0000\u0000\u0000\u0165\u015d" +
			"\u0001\u0000\u0000\u0000\u0165\u015e\u0001\u0000\u0000\u0000\u0165\u015f" +
			"\u0001\u0000\u0000\u0000\u0165\u0163\u0001\u0000\u0000\u0000\u0166\u019a" +
			"\u0001\u0000\u0000\u0000\u0167\u0168\n\n\u0000\u0000\u0168\u0169\u0005" +
			"\u000e\u0000\u0000\u0169\u0199\u00036\u001b\u000b\u016a\u016b\n\t\u0000" +
			"\u0000\u016b\u016c\u0005\u000f\u0000\u0000\u016c\u0199\u00036\u001b\n" +
			"\u016d\u016e\n\b\u0000\u0000\u016e\u016f\u0007\u0002\u0000\u0000\u016f" +
			"\u0199\u00036\u001b\t\u0170\u0171\n\u0007\u0000\u0000\u0171\u0172\u0005" +
			"\u0010\u0000\u0000\u0172\u0199\u00036\u001b\b\u0173\u0174\n\u0006\u0000" +
			"\u0000\u0174\u0175\u0005\u0011\u0000\u0000\u0175\u0199\u00036\u001b\u0007" +
			"\u0176\u0177\n\u0005\u0000\u0000\u0177\u0178\u0005\u0012\u0000\u0000\u0178" +
			"\u0199\u00036\u001b\u0006\u0179\u017a\n\u0004\u0000\u0000\u017a\u017b" +
			"\u0005\u0013\u0000\u0000\u017b\u0199\u00036\u001b\u0005\u017c\u017d\n" +
			"\u0003\u0000\u0000\u017d\u017e\u0005\u0014\u0000\u0000\u017e\u0199\u0003" +
			"6\u001b\u0004\u017f\u0180\n\u0002\u0000\u0000\u0180\u0181\u0005\u0015" +
			"\u0000\u0000\u0181\u0199\u00036\u001b\u0003\u0182\u0183\n\u0001\u0000" +
			"\u0000\u0183\u0184\u0007\u0003\u0000\u0000\u0184\u0199\u00036\u001b\u0001" +
			"\u0185\u0186\n\u0015\u0000\u0000\u0186\u0187\u0005\u000b\u0000\u0000\u0187" +
			"\u0188\u0003\b\u0004\u0000\u0188\u0189\u0005\u0005\u0000\u0000\u0189\u018a" +
			"\u00038\u001c\u0000\u018a\u018b\u0005\u0006\u0000\u0000\u018b\u0199\u0001" +
			"\u0000\u0000\u0000\u018c\u0191\n\u0012\u0000\u0000\u018d\u018e\u0005\u0003" +
			"\u0000\u0000\u018e\u018f\u00036\u001b\u0000\u018f\u0190\u0005\u0004\u0000" +
			"\u0000\u0190\u0192\u0001\u0000\u0000\u0000\u0191\u018d\u0001\u0000\u0000" +
			"\u0000\u0192\u0193\u0001\u0000\u0000\u0000\u0193\u0191\u0001\u0000\u0000" +
			"\u0000\u0193\u0194\u0001\u0000\u0000\u0000\u0194\u0199\u0001\u0000\u0000" +
			"\u0000\u0195\u0196\n\u0011\u0000\u0000\u0196\u0197\u0005\u000b\u0000\u0000" +
			"\u0197\u0199\u0005?\u0000\u0000\u0198\u0167\u0001\u0000\u0000\u0000\u0198" +
			"\u016a\u0001\u0000\u0000\u0000\u0198\u016d\u0001\u0000\u0000\u0000\u0198" +
			"\u0170\u0001\u0000\u0000\u0000\u0198\u0173\u0001\u0000\u0000\u0000\u0198" +
			"\u0176\u0001\u0000\u0000\u0000\u0198\u0179\u0001\u0000\u0000\u0000\u0198" +
			"\u017c\u0001\u0000\u0000\u0000\u0198\u017f\u0001\u0000\u0000\u0000\u0198" +
			"\u0182\u0001\u0000\u0000\u0000\u0198\u0185\u0001\u0000\u0000\u0000\u0198" +
			"\u018c\u0001\u0000\u0000\u0000\u0198\u0195\u0001\u0000\u0000\u0000\u0199" +
			"\u019c\u0001\u0000\u0000\u0000\u019a\u0198\u0001\u0000\u0000\u0000\u019a" +
			"\u019b\u0001\u0000\u0000\u0000\u019b7\u0001\u0000\u0000\u0000\u019c\u019a" +
			"\u0001\u0000\u0000\u0000\u019d\u019f\u00036\u001b\u0000\u019e\u019d\u0001" +
			"\u0000\u0000\u0000\u019e\u019f\u0001\u0000\u0000\u0000\u019f\u01a4\u0001" +
			"\u0000\u0000\u0000\u01a0\u01a1\u0005\n\u0000\u0000\u01a1\u01a3\u00036" +
			"\u001b\u0000\u01a2\u01a0\u0001\u0000\u0000\u0000\u01a3\u01a6\u0001\u0000" +
			"\u0000\u0000\u01a4\u01a2\u0001\u0000\u0000\u0000\u01a4\u01a5\u0001\u0000" +
			"\u0000\u0000\u01a59\u0001\u0000\u0000\u0000\u01a6\u01a4\u0001\u0000\u0000" +
			"\u0000\u01a7\u01a8\u0005?\u0000\u0000\u01a8;\u0001\u0000\u0000\u0000\u01a9" +
			"\u01ab\u0005$\u0000\u0000\u01aa\u01ac\u0005-\u0000\u0000\u01ab\u01aa\u0001" +
			"\u0000\u0000\u0000\u01ab\u01ac\u0001\u0000\u0000\u0000\u01ac\u01ad\u0001" +
			"\u0000\u0000\u0000\u01ad\u01ae\u00036\u001b\u0000\u01ae=\u0001\u0000\u0000" +
			"\u0000\u01af\u01b0\u0007\u0004\u0000\u0000\u01b0?\u0001\u0000\u0000\u0000" +
			"\u01b1\u01b5\u0005C\u0000\u0000\u01b2\u01b4\u0003B!\u0000\u01b3\u01b2" +
			"\u0001\u0000\u0000\u0000\u01b4\u01b7\u0001\u0000\u0000\u0000\u01b5\u01b3" +
			"\u0001\u0000\u0000\u0000\u01b5\u01b6\u0001\u0000\u0000\u0000\u01b6\u01b8" +
			"\u0001\u0000\u0000\u0000\u01b7\u01b5\u0001\u0000\u0000\u0000\u01b8\u01b9" +
			"\u0005C\u0000\u0000\u01b9A\u0001\u0000\u0000\u0000\u01ba\u01c0\u0005E" +
			"\u0000\u0000\u01bb\u01bc\u0005D\u0000\u0000\u01bc\u01bd\u00036\u001b\u0000" +
			"\u01bd\u01be\u0005\u0002\u0000\u0000\u01be\u01c0\u0001\u0000\u0000\u0000" +
			"\u01bf\u01ba\u0001\u0000\u0000\u0000\u01bf\u01bb\u0001\u0000\u0000\u0000" +
			"\u01c0C\u0001\u0000\u0000\u0000\u01c1\u01c2\u0005\u0003\u0000\u0000\u01c2" +
			"\u01c7\u00036\u001b\u0000\u01c3\u01c4\u0005\n\u0000\u0000\u01c4\u01c6" +
			"\u00036\u001b\u0000\u01c5\u01c3\u0001\u0000\u0000\u0000\u01c6\u01c9\u0001" +
			"\u0000\u0000\u0000\u01c7\u01c5\u0001\u0000\u0000\u0000\u01c7\u01c8\u0001" +
			"\u0000\u0000\u0000\u01c8\u01ca\u0001\u0000\u0000\u0000\u01c9\u01c7\u0001" +
			"\u0000\u0000\u0000\u01ca\u01cb\u0005\u0004\u0000\u0000\u01cbE\u0001\u0000" +
			"\u0000\u00002HJQW\\_hpw\u007f\u0087\u008f\u0097\u009f\u00a7\u00af\u00b7" +
			"\u00bf\u00c2\u00c9\u00d1\u00d8\u00dc\u00ed\u00f5\u00ff\u0105\u0109\u010e" +
			"\u0112\u0116\u0122\u0125\u0129\u012d\u0130\u0137\u013c\u0151\u0159\u0165" +
			"\u0193\u0198\u019a\u019e\u01a4\u01ab\u01b5\u01bf\u01c7";
	public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}