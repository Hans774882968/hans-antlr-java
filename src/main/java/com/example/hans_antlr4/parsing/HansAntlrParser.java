// Generated from src\main\java\com\example\hans_antlr4\parsing\HansAntlr.g4 by ANTLR 4.13.0

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
	public static final int T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9,
			T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15, T__15 = 16, T__16 = 17,
			T__17 = 18, T__18 = 19, T__19 = 20, T__20 = 21, T__21 = 22, T__22 = 23, T__23 = 24,
			T__24 = 25, T__25 = 26, T__26 = 27, T__27 = 28, T__28 = 29, T__29 = 30, T__30 = 31,
			T__31 = 32, T__32 = 33, T__33 = 34, T__34 = 35, T__35 = 36, T__36 = 37, T__37 = 38,
			T__38 = 39, T__39 = 40, T__40 = 41, T__41 = 42, T__42 = 43, POW = 44, MULTIPLICATIVE = 45,
			SHIFT = 46, RELATIONAL = 47, EQUALITY = 48, AND = 49, XOR = 50, OR = 51, VARIABLE = 52,
			PRINT = 53, EQUALS = 54, NUMBER = 55, IntegerOrDecimalLiteral = 56, HexIntegerLiteral = 57,
			OctalIntegerLiteral = 58, BinaryIntegerLiteral = 59, BOOL = 60, STRING = 61, Identifier = 62,
			WS = 63, COMMENT = 64, LINE_COMMENT = 65;
	public static final int RULE_compilationUnit = 0, RULE_functions = 1, RULE_function = 2,
			RULE_functionDeclaration = 3,
			RULE_functionName = 4, RULE_functionParameterList = 5, RULE_functionParameter = 6,
			RULE_type = 7, RULE_primitiveType = 8, RULE_classType = 9, RULE_qualifiedName = 10,
			RULE_statements = 11, RULE_block = 12, RULE_statement = 13, RULE_variable = 14,
			RULE_returnStatement = 15, RULE_expressionStatement = 16, RULE_ifStatement = 17,
			RULE_rangedForStatement = 18, RULE_rangedForConditions = 19, RULE_standardForStatement = 20,
			RULE_standardForInit = 21, RULE_standardForUpdate = 22, RULE_breakStatement = 23,
			RULE_continueStatement = 24, RULE_expression = 25, RULE_variableReference = 26,
			RULE_funcCall = 27, RULE_argumentList = 28, RULE_print = 29, RULE_value = 30;

	private static String[] makeRuleNames() {
		return new String[] {
				"compilationUnit", "functions", "function", "functionDeclaration", "functionName",
				"functionParameterList", "functionParameter", "type", "primitiveType",
				"classType", "qualifiedName", "statements", "block", "statement", "variable",
				"returnStatement", "expressionStatement", "ifStatement", "rangedForStatement",
				"rangedForConditions", "standardForStatement", "standardForInit", "standardForUpdate",
				"breakStatement", "continueStatement", "expression", "variableReference",
				"funcCall", "argumentList", "print", "value"
		};
	}

	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
				null, "'('", "')'", "','", "'boolean'", "'['", "']'", "'string'", "'char'",
				"'byte'", "'short'", "'int'", "'long'", "'float'", "'double'", "'void'",
				"'.'", "';'", "'{'", "'}'", "'return'", "'if'", "'else'", "'for'", "':'",
				"'to'", "'break'", "'continue'", "'+'", "'-'", "'~'", "'**='", "'*='",
				"'/='", "'%='", "'+='", "'-='", "'<<='", "'>>='", "'>>>='", "'&='", "'^='",
				"'|='", "'-n'", "'**'", null, null, null, null, "'&'", "'^'", "'|'",
				"'var'", "'print'", "'='"
		};
	}

	private static final String[] _LITERAL_NAMES = makeLiteralNames();

	private static String[] makeSymbolicNames() {
		return new String[] {
				null, null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, "POW", "MULTIPLICATIVE",
				"SHIFT", "RELATIONAL", "EQUALITY", "AND", "XOR", "OR", "VARIABLE", "PRINT",
				"EQUALS", "NUMBER", "IntegerOrDecimalLiteral", "HexIntegerLiteral", "OctalIntegerLiteral",
				"BinaryIntegerLiteral", "BOOL", "STRING", "Identifier", "WS", "COMMENT",
				"LINE_COMMENT"
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
		return "HansAntlr.g4";
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
		public FunctionsContext functions() {
			return getRuleContext(FunctionsContext.class, 0);
		}

		public TerminalNode EOF() {
			return getToken(HansAntlrParser.EOF, 0);
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
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitCompilationUnit(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compilationUnit);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(62);
				functions();
				setState(63);
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
	public static class FunctionsContext extends ParserRuleContext {
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}

		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class, i);
		}

		public FunctionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_functions;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitFunctions(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final FunctionsContext functions() throws RecognitionException {
		FunctionsContext _localctx = new FunctionsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_functions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4611686018427453328L) != 0)) {
					{
						{
							setState(65);
							function();
						}
					}
					setState(70);
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
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitFunction(this);
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
				setState(71);
				functionDeclaration();
				setState(72);
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
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitFunctionDeclaration(this);
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
				setState(75);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 1, _ctx)) {
					case 1: {
						setState(74);
						type();
					}
						break;
				}
				setState(77);
				functionName();
				setState(78);
				match(T__0);
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4611686018427453328L) != 0)) {
					{
						setState(79);
						functionParameterList();
					}
				}

				setState(82);
				match(T__1);
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
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitFunctionName(this);
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
				setState(84);
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

		public FunctionParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_functionParameterList;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitFunctionParameterList(this);
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
				setState(86);
				functionParameter();
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la == T__2) {
					{
						{
							setState(87);
							match(T__2);
							setState(88);
							functionParameter();
						}
					}
					setState(93);
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
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitFunctionParameter(this);
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
				setState(94);
				type();
				setState(95);
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
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitType(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		try {
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case T__3:
				case T__6:
				case T__7:
				case T__8:
				case T__9:
				case T__10:
				case T__11:
				case T__12:
				case T__13:
				case T__14:
					enterOuterAlt(_localctx, 1); {
					setState(97);
					primitiveType();
				}
					break;
				case Identifier:
					enterOuterAlt(_localctx, 2); {
					setState(98);
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
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_primitiveType;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitPrimitiveType(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_primitiveType);
		int _la;
		try {
			setState(181);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case T__3:
					enterOuterAlt(_localctx, 1); {
					setState(101);
					match(T__3);
					setState(106);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la == T__4) {
						{
							{
								setState(102);
								match(T__4);
								setState(103);
								match(T__5);
							}
						}
						setState(108);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
				}
					break;
				case T__6:
					enterOuterAlt(_localctx, 2); {
					setState(109);
					match(T__6);
					setState(114);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la == T__4) {
						{
							{
								setState(110);
								match(T__4);
								setState(111);
								match(T__5);
							}
						}
						setState(116);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
				}
					break;
				case T__7:
					enterOuterAlt(_localctx, 3); {
					setState(117);
					match(T__7);
					setState(122);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la == T__4) {
						{
							{
								setState(118);
								match(T__4);
								setState(119);
								match(T__5);
							}
						}
						setState(124);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
				}
					break;
				case T__8:
					enterOuterAlt(_localctx, 4); {
					setState(125);
					match(T__8);
					setState(130);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la == T__4) {
						{
							{
								setState(126);
								match(T__4);
								setState(127);
								match(T__5);
							}
						}
						setState(132);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
				}
					break;
				case T__9:
					enterOuterAlt(_localctx, 5); {
					setState(133);
					match(T__9);
					setState(138);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la == T__4) {
						{
							{
								setState(134);
								match(T__4);
								setState(135);
								match(T__5);
							}
						}
						setState(140);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
				}
					break;
				case T__10:
					enterOuterAlt(_localctx, 6); {
					setState(141);
					match(T__10);
					setState(146);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la == T__4) {
						{
							{
								setState(142);
								match(T__4);
								setState(143);
								match(T__5);
							}
						}
						setState(148);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
				}
					break;
				case T__11:
					enterOuterAlt(_localctx, 7); {
					setState(149);
					match(T__11);
					setState(154);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la == T__4) {
						{
							{
								setState(150);
								match(T__4);
								setState(151);
								match(T__5);
							}
						}
						setState(156);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
				}
					break;
				case T__12:
					enterOuterAlt(_localctx, 8); {
					setState(157);
					match(T__12);
					setState(162);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la == T__4) {
						{
							{
								setState(158);
								match(T__4);
								setState(159);
								match(T__5);
							}
						}
						setState(164);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
				}
					break;
				case T__13:
					enterOuterAlt(_localctx, 9); {
					setState(165);
					match(T__13);
					setState(170);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la == T__4) {
						{
							{
								setState(166);
								match(T__4);
								setState(167);
								match(T__5);
							}
						}
						setState(172);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
				}
					break;
				case T__14:
					enterOuterAlt(_localctx, 10); {
					setState(173);
					match(T__14);
					setState(178);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la == T__4) {
						{
							{
								setState(174);
								match(T__4);
								setState(175);
								match(T__5);
							}
						}
						setState(180);
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

		public ClassTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_classType;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitClassType(this);
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
				setState(183);
				qualifiedName();
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la == T__4) {
					{
						{
							setState(184);
							match(T__4);
							setState(185);
							match(T__5);
						}
					}
					setState(190);
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

		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_qualifiedName;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitQualifiedName(this);
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
				setState(191);
				match(Identifier);
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la == T__15) {
					{
						{
							setState(192);
							match(T__15);
							setState(193);
							match(Identifier);
						}
					}
					setState(198);
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
	public static class StatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}

		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class, i);
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
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitStatements(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8119990130241175554L) != 0)) {
					{
						{
							setState(199);
							statement();
							setState(201);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (_la == T__16) {
								{
									setState(200);
									match(T__16);
								}
							}

						}
					}
					setState(207);
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
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class, 0);
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
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitBlock(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(208);
				match(T__17);
				setState(209);
				statements();
				setState(210);
				match(T__18);
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
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitStatement(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_statement);
		try {
			setState(222);
			_errHandler.sync(this);
			switch (getInterpreter().adaptivePredict(_input, 20, _ctx)) {
				case 1:
					enterOuterAlt(_localctx, 1); {
					setState(212);
					variable();
				}
					break;
				case 2:
					enterOuterAlt(_localctx, 2); {
					setState(213);
					print();
				}
					break;
				case 3:
					enterOuterAlt(_localctx, 3); {
					setState(214);
					returnStatement();
				}
					break;
				case 4:
					enterOuterAlt(_localctx, 4); {
					setState(215);
					block();
				}
					break;
				case 5:
					enterOuterAlt(_localctx, 5); {
					setState(216);
					ifStatement();
				}
					break;
				case 6:
					enterOuterAlt(_localctx, 6); {
					setState(217);
					rangedForStatement();
				}
					break;
				case 7:
					enterOuterAlt(_localctx, 7); {
					setState(218);
					standardForStatement();
				}
					break;
				case 8:
					enterOuterAlt(_localctx, 8); {
					setState(219);
					breakStatement();
				}
					break;
				case 9:
					enterOuterAlt(_localctx, 9); {
					setState(220);
					continueStatement();
				}
					break;
				case 10:
					enterOuterAlt(_localctx, 10); {
					setState(221);
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

		public TerminalNode Identifier() {
			return getToken(HansAntlrParser.Identifier, 0);
		}

		public TerminalNode EQUALS() {
			return getToken(HansAntlrParser.EQUALS, 0);
		}

		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class, 0);
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
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitVariable(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(224);
				match(VARIABLE);
				setState(225);
				match(Identifier);
				setState(226);
				match(EQUALS);
				setState(227);
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
		public ReturnVoidContext(ReturnStatementContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitReturnVoid(this);
			else
				return visitor.visitChildren(this);
		}
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnWithValueContext extends ReturnStatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class, 0);
		}

		public ReturnWithValueContext(ReturnStatementContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitReturnWithValue(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_returnStatement);
		try {
			setState(232);
			_errHandler.sync(this);
			switch (getInterpreter().adaptivePredict(_input, 21, _ctx)) {
				case 1:
					_localctx = new ReturnWithValueContext(_localctx);
					enterOuterAlt(_localctx, 1); {
					setState(229);
					match(T__19);
					setState(230);
					expression(0);
				}
					break;
				case 2:
					_localctx = new ReturnVoidContext(_localctx);
					enterOuterAlt(_localctx, 2); {
					setState(231);
					match(T__19);
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
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitExpressionStatement(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(234);
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

		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class, 0);
		}

		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}

		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class, i);
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
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitIfStatement(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(236);
				match(T__20);
				setState(238);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 22, _ctx)) {
					case 1: {
						setState(237);
						match(T__0);
					}
						break;
				}
				setState(240);
				expression(0);
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == T__1) {
					{
						setState(241);
						match(T__1);
					}
				}

				setState(244);
				((IfStatementContext) _localctx).trueStatement = statement();
				setState(247);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 24, _ctx)) {
					case 1: {
						setState(245);
						match(T__21);
						setState(246);
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
		public RangedForConditionsContext rangedForConditions() {
			return getRuleContext(RangedForConditionsContext.class, 0);
		}

		public StatementContext statement() {
			return getRuleContext(StatementContext.class, 0);
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
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitRangedForStatement(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final RangedForStatementContext rangedForStatement() throws RecognitionException {
		RangedForStatementContext _localctx = new RangedForStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_rangedForStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(249);
				match(T__22);
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == T__0) {
					{
						setState(250);
						match(T__0);
					}
				}

				setState(253);
				rangedForConditions();
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == T__1) {
					{
						setState(254);
						match(T__1);
					}
				}

				setState(257);
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

		public VariableReferenceContext variableReference() {
			return getRuleContext(VariableReferenceContext.class, 0);
		}

		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}

		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class, i);
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
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitRangedForConditions(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final RangedForConditionsContext rangedForConditions() throws RecognitionException {
		RangedForConditionsContext _localctx = new RangedForConditionsContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_rangedForConditions);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(259);
				((RangedForConditionsContext) _localctx).iterator = variableReference();
				setState(260);
				match(T__23);
				setState(261);
				((RangedForConditionsContext) _localctx).startExpr = expression(0);
				setState(262);
				((RangedForConditionsContext) _localctx).range = match(T__24);
				setState(263);
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
		public StatementContext statement() {
			return getRuleContext(StatementContext.class, 0);
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

		public StandardForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_standardForStatement;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitStandardForStatement(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final StandardForStatementContext standardForStatement() throws RecognitionException {
		StandardForStatementContext _localctx = new StandardForStatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_standardForStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(265);
				match(T__22);
				setState(267);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 27, _ctx)) {
					case 1: {
						setState(266);
						match(T__0);
					}
						break;
				}
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8119990130028052482L) != 0)) {
					{
						setState(269);
						standardForInit();
					}
				}

				setState(272);
				match(T__16);
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8106479331145940994L) != 0)) {
					{
						setState(273);
						expression(0);
					}
				}

				setState(276);
				match(T__16);
				setState(278);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 30, _ctx)) {
					case 1: {
						setState(277);
						standardForUpdate();
					}
						break;
				}
				setState(281);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == T__1) {
					{
						setState(280);
						match(T__1);
					}
				}

				setState(283);
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
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitStandardForInit(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final StandardForInitContext standardForInit() throws RecognitionException {
		StandardForInitContext _localctx = new StandardForInitContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_standardForInit);
		try {
			setState(288);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case VARIABLE:
					enterOuterAlt(_localctx, 1); {
					setState(285);
					variable();
				}
					break;
				case PRINT:
					enterOuterAlt(_localctx, 2); {
					setState(286);
					print();
				}
					break;
				case T__0:
				case T__27:
				case T__28:
				case T__29:
				case NUMBER:
				case BOOL:
				case STRING:
				case Identifier:
					enterOuterAlt(_localctx, 3); {
					setState(287);
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
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitStandardForUpdate(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final StandardForUpdateContext standardForUpdate() throws RecognitionException {
		StandardForUpdateContext _localctx = new StandardForUpdateContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_standardForUpdate);
		try {
			setState(293);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case VARIABLE:
					enterOuterAlt(_localctx, 1); {
					setState(290);
					variable();
				}
					break;
				case PRINT:
					enterOuterAlt(_localctx, 2); {
					setState(291);
					print();
				}
					break;
				case T__0:
				case T__27:
				case T__28:
				case T__29:
				case NUMBER:
				case BOOL:
				case STRING:
				case Identifier:
					enterOuterAlt(_localctx, 3); {
					setState(292);
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
		public BreakStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_breakStatement;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitBreakStatement(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final BreakStatementContext breakStatement() throws RecognitionException {
		BreakStatementContext _localctx = new BreakStatementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_breakStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(295);
				match(T__25);
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
		public ContinueStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_continueStatement;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitContinueStatement(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final ContinueStatementContext continueStatement() throws RecognitionException {
		ContinueStatementContext _localctx = new ContinueStatementContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_continueStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(297);
				match(T__26);
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
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitRELATIONAL(this);
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
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitValueExpr(this);
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
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitOR(this);
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

		public ADDITIVEContext(ExpressionContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitADDITIVE(this);
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
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitSHIFT(this);
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
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitVarReference(this);
			else
				return visitor.visitChildren(this);
		}
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BRACKETContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class, 0);
		}

		public BRACKETContext(ExpressionContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitBRACKET(this);
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
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitMULTIPLICATIVE(this);
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
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitEQUALITY(this);
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
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitAND(this);
			else
				return visitor.visitChildren(this);
		}
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ASSIGNMENTContext extends ExpressionContext {
		public Token AssignmentOperator;

		public VariableReferenceContext variableReference() {
			return getRuleContext(VariableReferenceContext.class, 0);
		}

		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class, 0);
		}

		public TerminalNode EQUALS() {
			return getToken(HansAntlrParser.EQUALS, 0);
		}

		public ASSIGNMENTContext(ExpressionContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitASSIGNMENT(this);
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
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitPOW(this);
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
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitXOR(this);
			else
				return visitor.visitChildren(this);
		}
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallContext extends ExpressionContext {
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class, 0);
		}

		public FunctionCallContext(ExpressionContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitFunctionCall(this);
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

		public UNARYContext(ExpressionContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitUNARY(this);
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
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
				setState(313);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 34, _ctx)) {
					case 1: {
						_localctx = new FunctionCallContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;

						setState(300);
						funcCall();
					}
						break;
					case 2: {
						_localctx = new VarReferenceContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(301);
						variableReference();
					}
						break;
					case 3: {
						_localctx = new ValueExprContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(302);
						value();
					}
						break;
					case 4: {
						_localctx = new BRACKETContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(303);
						match(T__0);
						setState(304);
						expression(0);
						setState(305);
						match(T__1);
					}
						break;
					case 5: {
						_localctx = new UNARYContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(307);
						((UNARYContext) _localctx).UNARY = _input.LT(1);
						_la = _input.LA(1);
						if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 1879048192L) != 0))) {
							((UNARYContext) _localctx).UNARY = (Token) _errHandler.recoverInline(this);
						} else {
							if (_input.LA(1) == Token.EOF)
								matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(308);
						expression(11);
					}
						break;
					case 6: {
						_localctx = new ASSIGNMENTContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(309);
						variableReference();
						setState(310);
						((ASSIGNMENTContext) _localctx).AssignmentOperator = _input.LT(1);
						_la = _input.LA(1);
						if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 18023192455020544L) != 0))) {
							((ASSIGNMENTContext) _localctx).AssignmentOperator = (Token) _errHandler
									.recoverInline(this);
						} else {
							if (_input.LA(1) == Token.EOF)
								matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(311);
						expression(1);
					}
						break;
				}
				_ctx.stop = _input.LT(-1);
				setState(344);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input, 36, _ctx);
				while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
					if (_alt == 1) {
						if (_parseListeners != null)
							triggerExitRuleEvent();
						_prevctx = _localctx;
						{
							setState(342);
							_errHandler.sync(this);
							switch (getInterpreter().adaptivePredict(_input, 35, _ctx)) {
								case 1: {
									_localctx = new POWContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(315);
									if (!(precpred(_ctx, 10)))
										throw new FailedPredicateException(this, "precpred(_ctx, 10)");
									setState(316);
									match(POW);
									setState(317);
									expression(11);
								}
									break;
								case 2: {
									_localctx = new MULTIPLICATIVEContext(
											new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(318);
									if (!(precpred(_ctx, 9)))
										throw new FailedPredicateException(this, "precpred(_ctx, 9)");
									setState(319);
									match(MULTIPLICATIVE);
									setState(320);
									expression(10);
								}
									break;
								case 3: {
									_localctx = new ADDITIVEContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(321);
									if (!(precpred(_ctx, 8)))
										throw new FailedPredicateException(this, "precpred(_ctx, 8)");
									setState(322);
									((ADDITIVEContext) _localctx).ADDITIVE = _input.LT(1);
									_la = _input.LA(1);
									if (!(_la == T__27 || _la == T__28)) {
										((ADDITIVEContext) _localctx).ADDITIVE = (Token) _errHandler
												.recoverInline(this);
									} else {
										if (_input.LA(1) == Token.EOF)
											matchedEOF = true;
										_errHandler.reportMatch(this);
										consume();
									}
									setState(323);
									expression(9);
								}
									break;
								case 4: {
									_localctx = new SHIFTContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(324);
									if (!(precpred(_ctx, 7)))
										throw new FailedPredicateException(this, "precpred(_ctx, 7)");
									setState(325);
									match(SHIFT);
									setState(326);
									expression(8);
								}
									break;
								case 5: {
									_localctx = new RELATIONALContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(327);
									if (!(precpred(_ctx, 6)))
										throw new FailedPredicateException(this, "precpred(_ctx, 6)");
									setState(328);
									match(RELATIONAL);
									setState(329);
									expression(7);
								}
									break;
								case 6: {
									_localctx = new EQUALITYContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(330);
									if (!(precpred(_ctx, 5)))
										throw new FailedPredicateException(this, "precpred(_ctx, 5)");
									setState(331);
									match(EQUALITY);
									setState(332);
									expression(6);
								}
									break;
								case 7: {
									_localctx = new ANDContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(333);
									if (!(precpred(_ctx, 4)))
										throw new FailedPredicateException(this, "precpred(_ctx, 4)");
									setState(334);
									match(AND);
									setState(335);
									expression(5);
								}
									break;
								case 8: {
									_localctx = new XORContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(336);
									if (!(precpred(_ctx, 3)))
										throw new FailedPredicateException(this, "precpred(_ctx, 3)");
									setState(337);
									match(XOR);
									setState(338);
									expression(4);
								}
									break;
								case 9: {
									_localctx = new ORContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(339);
									if (!(precpred(_ctx, 2)))
										throw new FailedPredicateException(this, "precpred(_ctx, 2)");
									setState(340);
									match(OR);
									setState(341);
									expression(3);
								}
									break;
							}
						}
					}
					setState(346);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 36, _ctx);
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
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitVariableReference(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final VariableReferenceContext variableReference() throws RecognitionException {
		VariableReferenceContext _localctx = new VariableReferenceContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_variableReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(347);
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
	public static class FuncCallContext extends ParserRuleContext {
		public FunctionNameContext functionName() {
			return getRuleContext(FunctionNameContext.class, 0);
		}

		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class, 0);
		}

		public FuncCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_funcCall;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitFuncCall(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final FuncCallContext funcCall() throws RecognitionException {
		FuncCallContext _localctx = new FuncCallContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_funcCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(349);
				functionName();
				setState(350);
				match(T__0);
				setState(351);
				argumentList();
				setState(352);
				match(T__1);
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
	public static class ArgumentListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}

		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class, i);
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
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitArgumentList(this);
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
				setState(355);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8106479331145940994L) != 0)) {
					{
						setState(354);
						expression(0);
					}
				}

				setState(361);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la == T__2) {
					{
						{
							setState(357);
							match(T__2);
							setState(358);
							expression(0);
						}
					}
					setState(363);
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
	public static class PrintContext extends ParserRuleContext {
		public Token printArg;

		public TerminalNode PRINT() {
			return getToken(HansAntlrParser.PRINT, 0);
		}

		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class, 0);
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
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitPrint(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_print);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(364);
				match(PRINT);
				setState(366);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == T__42) {
					{
						setState(365);
						((PrintContext) _localctx).printArg = match(T__42);
					}
				}

				setState(368);
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
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitValue(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(370);
				_la = _input.LA(1);
				if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 3494793310839504896L) != 0))) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
			case 25:
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
		}
		return true;
	}

	public static final String _serializedATN = "\u0004\u0001A\u0175\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"
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
			"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0005\u0001C\b\u0001" +
			"\n\u0001\f\u0001F\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003" +
			"\u0003\u0003L\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003" +
			"Q\b\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005" +
			"\u0001\u0005\u0001\u0005\u0005\u0005Z\b\u0005\n\u0005\f\u0005]\t\u0005" +
			"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0003\u0007" +
			"d\b\u0007\u0001\b\u0001\b\u0001\b\u0005\bi\b\b\n\b\f\bl\t\b\u0001\b\u0001" +
			"\b\u0001\b\u0005\bq\b\b\n\b\f\bt\t\b\u0001\b\u0001\b\u0001\b\u0005\by" +
			"\b\b\n\b\f\b|\t\b\u0001\b\u0001\b\u0001\b\u0005\b\u0081\b\b\n\b\f\b\u0084" +
			"\t\b\u0001\b\u0001\b\u0001\b\u0005\b\u0089\b\b\n\b\f\b\u008c\t\b\u0001" +
			"\b\u0001\b\u0001\b\u0005\b\u0091\b\b\n\b\f\b\u0094\t\b\u0001\b\u0001\b" +
			"\u0001\b\u0005\b\u0099\b\b\n\b\f\b\u009c\t\b\u0001\b\u0001\b\u0001\b\u0005" +
			"\b\u00a1\b\b\n\b\f\b\u00a4\t\b\u0001\b\u0001\b\u0001\b\u0005\b\u00a9\b" +
			"\b\n\b\f\b\u00ac\t\b\u0001\b\u0001\b\u0001\b\u0005\b\u00b1\b\b\n\b\f\b" +
			"\u00b4\t\b\u0003\b\u00b6\b\b\u0001\t\u0001\t\u0001\t\u0005\t\u00bb\b\t" +
			"\n\t\f\t\u00be\t\t\u0001\n\u0001\n\u0001\n\u0005\n\u00c3\b\n\n\n\f\n\u00c6" +
			"\t\n\u0001\u000b\u0001\u000b\u0003\u000b\u00ca\b\u000b\u0005\u000b\u00cc" +
			"\b\u000b\n\u000b\f\u000b\u00cf\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f" +
			"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001" +
			"\r\u0001\r\u0003\r\u00df\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001" +
			"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00e9" +
			"\b\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0003\u0011\u00ef" +
			"\b\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00f3\b\u0011\u0001\u0011" +
			"\u0001\u0011\u0001\u0011\u0003\u0011\u00f8\b\u0011\u0001\u0012\u0001\u0012" +
			"\u0003\u0012\u00fc\b\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0100\b" +
			"\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001" +
			"\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0003\u0014\u010c" +
			"\b\u0014\u0001\u0014\u0003\u0014\u010f\b\u0014\u0001\u0014\u0001\u0014" +
			"\u0003\u0014\u0113\b\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0117\b" +
			"\u0014\u0001\u0014\u0003\u0014\u011a\b\u0014\u0001\u0014\u0001\u0014\u0001" +
			"\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0121\b\u0015\u0001\u0016\u0001" +
			"\u0016\u0001\u0016\u0003\u0016\u0126\b\u0016\u0001\u0017\u0001\u0017\u0001" +
			"\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001" +
			"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001" +
			"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u013a\b\u0019\u0001" +
			"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001" +
			"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001" +
			"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001" +
			"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001" +
			"\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u0157\b\u0019\n\u0019\f\u0019" +
			"\u015a\t\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b" +
			"\u0001\u001b\u0001\u001b\u0001\u001c\u0003\u001c\u0164\b\u001c\u0001\u001c" +
			"\u0001\u001c\u0005\u001c\u0168\b\u001c\n\u001c\f\u001c\u016b\t\u001c\u0001" +
			"\u001d\u0001\u001d\u0003\u001d\u016f\b\u001d\u0001\u001d\u0001\u001d\u0001" +
			"\u001e\u0001\u001e\u0001\u001e\u0000\u00012\u001f\u0000\u0002\u0004\u0006" +
			"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,." +
			"02468:<\u0000\u0004\u0001\u0000\u001c\u001e\u0002\u0000\u001f*66\u0001" +
			"\u0000\u001c\u001d\u0002\u000077<=\u019a\u0000>\u0001\u0000\u0000\u0000" +
			"\u0002D\u0001\u0000\u0000\u0000\u0004G\u0001\u0000\u0000\u0000\u0006K" +
			"\u0001\u0000\u0000\u0000\bT\u0001\u0000\u0000\u0000\nV\u0001\u0000\u0000" +
			"\u0000\f^\u0001\u0000\u0000\u0000\u000ec\u0001\u0000\u0000\u0000\u0010" +
			"\u00b5\u0001\u0000\u0000\u0000\u0012\u00b7\u0001\u0000\u0000\u0000\u0014" +
			"\u00bf\u0001\u0000\u0000\u0000\u0016\u00cd\u0001\u0000\u0000\u0000\u0018" +
			"\u00d0\u0001\u0000\u0000\u0000\u001a\u00de\u0001\u0000\u0000\u0000\u001c" +
			"\u00e0\u0001\u0000\u0000\u0000\u001e\u00e8\u0001\u0000\u0000\u0000 \u00ea" +
			"\u0001\u0000\u0000\u0000\"\u00ec\u0001\u0000\u0000\u0000$\u00f9\u0001" +
			"\u0000\u0000\u0000&\u0103\u0001\u0000\u0000\u0000(\u0109\u0001\u0000\u0000" +
			"\u0000*\u0120\u0001\u0000\u0000\u0000,\u0125\u0001\u0000\u0000\u0000." +
			"\u0127\u0001\u0000\u0000\u00000\u0129\u0001\u0000\u0000\u00002\u0139\u0001" +
			"\u0000\u0000\u00004\u015b\u0001\u0000\u0000\u00006\u015d\u0001\u0000\u0000" +
			"\u00008\u0163\u0001\u0000\u0000\u0000:\u016c\u0001\u0000\u0000\u0000<" +
			"\u0172\u0001\u0000\u0000\u0000>?\u0003\u0002\u0001\u0000?@\u0005\u0000" +
			"\u0000\u0001@\u0001\u0001\u0000\u0000\u0000AC\u0003\u0004\u0002\u0000" +
			"BA\u0001\u0000\u0000\u0000CF\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000" +
			"\u0000DE\u0001\u0000\u0000\u0000E\u0003\u0001\u0000\u0000\u0000FD\u0001" +
			"\u0000\u0000\u0000GH\u0003\u0006\u0003\u0000HI\u0003\u0018\f\u0000I\u0005" +
			"\u0001\u0000\u0000\u0000JL\u0003\u000e\u0007\u0000KJ\u0001\u0000\u0000" +
			"\u0000KL\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000MN\u0003\b\u0004" +
			"\u0000NP\u0005\u0001\u0000\u0000OQ\u0003\n\u0005\u0000PO\u0001\u0000\u0000" +
			"\u0000PQ\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RS\u0005\u0002" +
			"\u0000\u0000S\u0007\u0001\u0000\u0000\u0000TU\u0005>\u0000\u0000U\t\u0001" +
			"\u0000\u0000\u0000V[\u0003\f\u0006\u0000WX\u0005\u0003\u0000\u0000XZ\u0003" +
			"\f\u0006\u0000YW\u0001\u0000\u0000\u0000Z]\u0001\u0000\u0000\u0000[Y\u0001" +
			"\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\\u000b\u0001\u0000\u0000" +
			"\u0000][\u0001\u0000\u0000\u0000^_\u0003\u000e\u0007\u0000_`\u0005>\u0000" +
			"\u0000`\r\u0001\u0000\u0000\u0000ad\u0003\u0010\b\u0000bd\u0003\u0012" +
			"\t\u0000ca\u0001\u0000\u0000\u0000cb\u0001\u0000\u0000\u0000d\u000f\u0001" +
			"\u0000\u0000\u0000ej\u0005\u0004\u0000\u0000fg\u0005\u0005\u0000\u0000" +
			"gi\u0005\u0006\u0000\u0000hf\u0001\u0000\u0000\u0000il\u0001\u0000\u0000" +
			"\u0000jh\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000k\u00b6\u0001" +
			"\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000mr\u0005\u0007\u0000\u0000" +
			"no\u0005\u0005\u0000\u0000oq\u0005\u0006\u0000\u0000pn\u0001\u0000\u0000" +
			"\u0000qt\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000rs\u0001\u0000" +
			"\u0000\u0000s\u00b6\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000" +
			"uz\u0005\b\u0000\u0000vw\u0005\u0005\u0000\u0000wy\u0005\u0006\u0000\u0000" +
			"xv\u0001\u0000\u0000\u0000y|\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000" +
			"\u0000z{\u0001\u0000\u0000\u0000{\u00b6\u0001\u0000\u0000\u0000|z\u0001" +
			"\u0000\u0000\u0000}\u0082\u0005\t\u0000\u0000~\u007f\u0005\u0005\u0000" +
			"\u0000\u007f\u0081\u0005\u0006\u0000\u0000\u0080~\u0001\u0000\u0000\u0000" +
			"\u0081\u0084\u0001\u0000\u0000\u0000\u0082\u0080\u0001\u0000\u0000\u0000" +
			"\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u00b6\u0001\u0000\u0000\u0000" +
			"\u0084\u0082\u0001\u0000\u0000\u0000\u0085\u008a\u0005\n\u0000\u0000\u0086" +
			"\u0087\u0005\u0005\u0000\u0000\u0087\u0089\u0005\u0006\u0000\u0000\u0088" +
			"\u0086\u0001\u0000\u0000\u0000\u0089\u008c\u0001\u0000\u0000\u0000\u008a" +
			"\u0088\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b" +
			"\u00b6\u0001\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008d" +
			"\u0092\u0005\u000b\u0000\u0000\u008e\u008f\u0005\u0005\u0000\u0000\u008f" +
			"\u0091\u0005\u0006\u0000\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0091" +
			"\u0094\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0092" +
			"\u0093\u0001\u0000\u0000\u0000\u0093\u00b6\u0001\u0000\u0000\u0000\u0094" +
			"\u0092\u0001\u0000\u0000\u0000\u0095\u009a\u0005\f\u0000\u0000\u0096\u0097" +
			"\u0005\u0005\u0000\u0000\u0097\u0099\u0005\u0006\u0000\u0000\u0098\u0096" +
			"\u0001\u0000\u0000\u0000\u0099\u009c\u0001\u0000\u0000\u0000\u009a\u0098" +
			"\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u00b6" +
			"\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009d\u00a2" +
			"\u0005\r\u0000\u0000\u009e\u009f\u0005\u0005\u0000\u0000\u009f\u00a1\u0005" +
			"\u0006\u0000\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a1\u00a4\u0001" +
			"\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001" +
			"\u0000\u0000\u0000\u00a3\u00b6\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001" +
			"\u0000\u0000\u0000\u00a5\u00aa\u0005\u000e\u0000\u0000\u00a6\u00a7\u0005" +
			"\u0005\u0000\u0000\u00a7\u00a9\u0005\u0006\u0000\u0000\u00a8\u00a6\u0001" +
			"\u0000\u0000\u0000\u00a9\u00ac\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001" +
			"\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00b6\u0001" +
			"\u0000\u0000\u0000\u00ac\u00aa\u0001\u0000\u0000\u0000\u00ad\u00b2\u0005" +
			"\u000f\u0000\u0000\u00ae\u00af\u0005\u0005\u0000\u0000\u00af\u00b1\u0005" +
			"\u0006\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b1\u00b4\u0001" +
			"\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001" +
			"\u0000\u0000\u0000\u00b3\u00b6\u0001\u0000\u0000\u0000\u00b4\u00b2\u0001" +
			"\u0000\u0000\u0000\u00b5e\u0001\u0000\u0000\u0000\u00b5m\u0001\u0000\u0000" +
			"\u0000\u00b5u\u0001\u0000\u0000\u0000\u00b5}\u0001\u0000\u0000\u0000\u00b5" +
			"\u0085\u0001\u0000\u0000\u0000\u00b5\u008d\u0001\u0000\u0000\u0000\u00b5" +
			"\u0095\u0001\u0000\u0000\u0000\u00b5\u009d\u0001\u0000\u0000\u0000\u00b5" +
			"\u00a5\u0001\u0000\u0000\u0000\u00b5\u00ad\u0001\u0000\u0000\u0000\u00b6" +
			"\u0011\u0001\u0000\u0000\u0000\u00b7\u00bc\u0003\u0014\n\u0000\u00b8\u00b9" +
			"\u0005\u0005\u0000\u0000\u00b9\u00bb\u0005\u0006\u0000\u0000\u00ba\u00b8" +
			"\u0001\u0000\u0000\u0000\u00bb\u00be\u0001\u0000\u0000\u0000\u00bc\u00ba" +
			"\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u0013" +
			"\u0001\u0000\u0000\u0000\u00be\u00bc\u0001\u0000\u0000\u0000\u00bf\u00c4" +
			"\u0005>\u0000\u0000\u00c0\u00c1\u0005\u0010\u0000\u0000\u00c1\u00c3\u0005" +
			">\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c3\u00c6\u0001\u0000" +
			"\u0000\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000" +
			"\u0000\u0000\u00c5\u0015\u0001\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000" +
			"\u0000\u0000\u00c7\u00c9\u0003\u001a\r\u0000\u00c8\u00ca\u0005\u0011\u0000" +
			"\u0000\u00c9\u00c8\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000" +
			"\u0000\u00ca\u00cc\u0001\u0000\u0000\u0000\u00cb\u00c7\u0001\u0000\u0000" +
			"\u0000\u00cc\u00cf\u0001\u0000\u0000\u0000\u00cd\u00cb\u0001\u0000\u0000" +
			"\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce\u0017\u0001\u0000\u0000" +
			"\u0000\u00cf\u00cd\u0001\u0000\u0000\u0000\u00d0\u00d1\u0005\u0012\u0000" +
			"\u0000\u00d1\u00d2\u0003\u0016\u000b\u0000\u00d2\u00d3\u0005\u0013\u0000" +
			"\u0000\u00d3\u0019\u0001\u0000\u0000\u0000\u00d4\u00df\u0003\u001c\u000e" +
			"\u0000\u00d5\u00df\u0003:\u001d\u0000\u00d6\u00df\u0003\u001e\u000f\u0000" +
			"\u00d7\u00df\u0003\u0018\f\u0000\u00d8\u00df\u0003\"\u0011\u0000\u00d9" +
			"\u00df\u0003$\u0012\u0000\u00da\u00df\u0003(\u0014\u0000\u00db\u00df\u0003" +
			".\u0017\u0000\u00dc\u00df\u00030\u0018\u0000\u00dd\u00df\u0003 \u0010" +
			"\u0000\u00de\u00d4\u0001\u0000\u0000\u0000\u00de\u00d5\u0001\u0000\u0000" +
			"\u0000\u00de\u00d6\u0001\u0000\u0000\u0000\u00de\u00d7\u0001\u0000\u0000" +
			"\u0000\u00de\u00d8\u0001\u0000\u0000\u0000\u00de\u00d9\u0001\u0000\u0000" +
			"\u0000\u00de\u00da\u0001\u0000\u0000\u0000\u00de\u00db\u0001\u0000\u0000" +
			"\u0000\u00de\u00dc\u0001\u0000\u0000\u0000\u00de\u00dd\u0001\u0000\u0000" +
			"\u0000\u00df\u001b\u0001\u0000\u0000\u0000\u00e0\u00e1\u00054\u0000\u0000" +
			"\u00e1\u00e2\u0005>\u0000\u0000\u00e2\u00e3\u00056\u0000\u0000\u00e3\u00e4" +
			"\u00032\u0019\u0000\u00e4\u001d\u0001\u0000\u0000\u0000\u00e5\u00e6\u0005" +
			"\u0014\u0000\u0000\u00e6\u00e9\u00032\u0019\u0000\u00e7\u00e9\u0005\u0014" +
			"\u0000\u0000\u00e8\u00e5\u0001\u0000\u0000\u0000\u00e8\u00e7\u0001\u0000" +
			"\u0000\u0000\u00e9\u001f\u0001\u0000\u0000\u0000\u00ea\u00eb\u00032\u0019" +
			"\u0000\u00eb!\u0001\u0000\u0000\u0000\u00ec\u00ee\u0005\u0015\u0000\u0000" +
			"\u00ed\u00ef\u0005\u0001\u0000\u0000\u00ee\u00ed\u0001\u0000\u0000\u0000" +
			"\u00ee\u00ef\u0001\u0000\u0000\u0000\u00ef\u00f0\u0001\u0000\u0000\u0000" +
			"\u00f0\u00f2\u00032\u0019\u0000\u00f1\u00f3\u0005\u0002\u0000\u0000\u00f2" +
			"\u00f1\u0001\u0000\u0000\u0000\u00f2\u00f3\u0001\u0000\u0000\u0000\u00f3" +
			"\u00f4\u0001\u0000\u0000\u0000\u00f4\u00f7\u0003\u001a\r\u0000\u00f5\u00f6" +
			"\u0005\u0016\u0000\u0000\u00f6\u00f8\u0003\u001a\r\u0000\u00f7\u00f5\u0001" +
			"\u0000\u0000\u0000\u00f7\u00f8\u0001\u0000\u0000\u0000\u00f8#\u0001\u0000" +
			"\u0000\u0000\u00f9\u00fb\u0005\u0017\u0000\u0000\u00fa\u00fc\u0005\u0001" +
			"\u0000\u0000\u00fb\u00fa\u0001\u0000\u0000\u0000\u00fb\u00fc\u0001\u0000" +
			"\u0000\u0000\u00fc\u00fd\u0001\u0000\u0000\u0000\u00fd\u00ff\u0003&\u0013" +
			"\u0000\u00fe\u0100\u0005\u0002\u0000\u0000\u00ff\u00fe\u0001\u0000\u0000" +
			"\u0000\u00ff\u0100\u0001\u0000\u0000\u0000\u0100\u0101\u0001\u0000\u0000" +
			"\u0000\u0101\u0102\u0003\u001a\r\u0000\u0102%\u0001\u0000\u0000\u0000" +
			"\u0103\u0104\u00034\u001a\u0000\u0104\u0105\u0005\u0018\u0000\u0000\u0105" +
			"\u0106\u00032\u0019\u0000\u0106\u0107\u0005\u0019\u0000\u0000\u0107\u0108" +
			"\u00032\u0019\u0000\u0108\'\u0001\u0000\u0000\u0000\u0109\u010b\u0005" +
			"\u0017\u0000\u0000\u010a\u010c\u0005\u0001\u0000\u0000\u010b\u010a\u0001" +
			"\u0000\u0000\u0000\u010b\u010c\u0001\u0000\u0000\u0000\u010c\u010e\u0001" +
			"\u0000\u0000\u0000\u010d\u010f\u0003*\u0015\u0000\u010e\u010d\u0001\u0000" +
			"\u0000\u0000\u010e\u010f\u0001\u0000\u0000\u0000\u010f\u0110\u0001\u0000" +
			"\u0000\u0000\u0110\u0112\u0005\u0011\u0000\u0000\u0111\u0113\u00032\u0019" +
			"\u0000\u0112\u0111\u0001\u0000\u0000\u0000\u0112\u0113\u0001\u0000\u0000" +
			"\u0000\u0113\u0114\u0001\u0000\u0000\u0000\u0114\u0116\u0005\u0011\u0000" +
			"\u0000\u0115\u0117\u0003,\u0016\u0000\u0116\u0115\u0001\u0000\u0000\u0000" +
			"\u0116\u0117\u0001\u0000\u0000\u0000\u0117\u0119\u0001\u0000\u0000\u0000" +
			"\u0118\u011a\u0005\u0002\u0000\u0000\u0119\u0118\u0001\u0000\u0000\u0000" +
			"\u0119\u011a\u0001\u0000\u0000\u0000\u011a\u011b\u0001\u0000\u0000\u0000" +
			"\u011b\u011c\u0003\u001a\r\u0000\u011c)\u0001\u0000\u0000\u0000\u011d" +
			"\u0121\u0003\u001c\u000e\u0000\u011e\u0121\u0003:\u001d\u0000\u011f\u0121" +
			"\u0003 \u0010\u0000\u0120\u011d\u0001\u0000\u0000\u0000\u0120\u011e\u0001" +
			"\u0000\u0000\u0000\u0120\u011f\u0001\u0000\u0000\u0000\u0121+\u0001\u0000" +
			"\u0000\u0000\u0122\u0126\u0003\u001c\u000e\u0000\u0123\u0126\u0003:\u001d" +
			"\u0000\u0124\u0126\u0003 \u0010\u0000\u0125\u0122\u0001\u0000\u0000\u0000" +
			"\u0125\u0123\u0001\u0000\u0000\u0000\u0125\u0124\u0001\u0000\u0000\u0000" +
			"\u0126-\u0001\u0000\u0000\u0000\u0127\u0128\u0005\u001a\u0000\u0000\u0128" +
			"/\u0001\u0000\u0000\u0000\u0129\u012a\u0005\u001b\u0000\u0000\u012a1\u0001" +
			"\u0000\u0000\u0000\u012b\u012c\u0006\u0019\uffff\uffff\u0000\u012c\u013a" +
			"\u00036\u001b\u0000\u012d\u013a\u00034\u001a\u0000\u012e\u013a\u0003<" +
			"\u001e\u0000\u012f\u0130\u0005\u0001\u0000\u0000\u0130\u0131\u00032\u0019" +
			"\u0000\u0131\u0132\u0005\u0002\u0000\u0000\u0132\u013a\u0001\u0000\u0000" +
			"\u0000\u0133\u0134\u0007\u0000\u0000\u0000\u0134\u013a\u00032\u0019\u000b" +
			"\u0135\u0136\u00034\u001a\u0000\u0136\u0137\u0007\u0001\u0000\u0000\u0137" +
			"\u0138\u00032\u0019\u0001\u0138\u013a\u0001\u0000\u0000\u0000\u0139\u012b" +
			"\u0001\u0000\u0000\u0000\u0139\u012d\u0001\u0000\u0000\u0000\u0139\u012e" +
			"\u0001\u0000\u0000\u0000\u0139\u012f\u0001\u0000\u0000\u0000\u0139\u0133" +
			"\u0001\u0000\u0000\u0000\u0139\u0135\u0001\u0000\u0000\u0000\u013a\u0158" +
			"\u0001\u0000\u0000\u0000\u013b\u013c\n\n\u0000\u0000\u013c\u013d\u0005" +
			",\u0000\u0000\u013d\u0157\u00032\u0019\u000b\u013e\u013f\n\t\u0000\u0000" +
			"\u013f\u0140\u0005-\u0000\u0000\u0140\u0157\u00032\u0019\n\u0141\u0142" +
			"\n\b\u0000\u0000\u0142\u0143\u0007\u0002\u0000\u0000\u0143\u0157\u0003" +
			"2\u0019\t\u0144\u0145\n\u0007\u0000\u0000\u0145\u0146\u0005.\u0000\u0000" +
			"\u0146\u0157\u00032\u0019\b\u0147\u0148\n\u0006\u0000\u0000\u0148\u0149" +
			"\u0005/\u0000\u0000\u0149\u0157\u00032\u0019\u0007\u014a\u014b\n\u0005" +
			"\u0000\u0000\u014b\u014c\u00050\u0000\u0000\u014c\u0157\u00032\u0019\u0006" +
			"\u014d\u014e\n\u0004\u0000\u0000\u014e\u014f\u00051\u0000\u0000\u014f" +
			"\u0157\u00032\u0019\u0005\u0150\u0151\n\u0003\u0000\u0000\u0151\u0152" +
			"\u00052\u0000\u0000\u0152\u0157\u00032\u0019\u0004\u0153\u0154\n\u0002" +
			"\u0000\u0000\u0154\u0155\u00053\u0000\u0000\u0155\u0157\u00032\u0019\u0003" +
			"\u0156\u013b\u0001\u0000\u0000\u0000\u0156\u013e\u0001\u0000\u0000\u0000" +
			"\u0156\u0141\u0001\u0000\u0000\u0000\u0156\u0144\u0001\u0000\u0000\u0000" +
			"\u0156\u0147\u0001\u0000\u0000\u0000\u0156\u014a\u0001\u0000\u0000\u0000" +
			"\u0156\u014d\u0001\u0000\u0000\u0000\u0156\u0150\u0001\u0000\u0000\u0000" +
			"\u0156\u0153\u0001\u0000\u0000\u0000\u0157\u015a\u0001\u0000\u0000\u0000" +
			"\u0158\u0156\u0001\u0000\u0000\u0000\u0158\u0159\u0001\u0000\u0000\u0000" +
			"\u01593\u0001\u0000\u0000\u0000\u015a\u0158\u0001\u0000\u0000\u0000\u015b" +
			"\u015c\u0005>\u0000\u0000\u015c5\u0001\u0000\u0000\u0000\u015d\u015e\u0003" +
			"\b\u0004\u0000\u015e\u015f\u0005\u0001\u0000\u0000\u015f\u0160\u00038" +
			"\u001c\u0000\u0160\u0161\u0005\u0002\u0000\u0000\u01617\u0001\u0000\u0000" +
			"\u0000\u0162\u0164\u00032\u0019\u0000\u0163\u0162\u0001\u0000\u0000\u0000" +
			"\u0163\u0164\u0001\u0000\u0000\u0000\u0164\u0169\u0001\u0000\u0000\u0000" +
			"\u0165\u0166\u0005\u0003\u0000\u0000\u0166\u0168\u00032\u0019\u0000\u0167" +
			"\u0165\u0001\u0000\u0000\u0000\u0168\u016b\u0001\u0000\u0000\u0000\u0169" +
			"\u0167\u0001\u0000\u0000\u0000\u0169\u016a\u0001\u0000\u0000\u0000\u016a" +
			"9\u0001\u0000\u0000\u0000\u016b\u0169\u0001\u0000\u0000\u0000\u016c\u016e" +
			"\u00055\u0000\u0000\u016d\u016f\u0005+\u0000\u0000\u016e\u016d\u0001\u0000" +
			"\u0000\u0000\u016e\u016f\u0001\u0000\u0000\u0000\u016f\u0170\u0001\u0000" +
			"\u0000\u0000\u0170\u0171\u00032\u0019\u0000\u0171;\u0001\u0000\u0000\u0000" +
			"\u0172\u0173\u0007\u0003\u0000\u0000\u0173=\u0001\u0000\u0000\u0000(D" +
			"KP[cjrz\u0082\u008a\u0092\u009a\u00a2\u00aa\u00b2\u00b5\u00bc\u00c4\u00c9" +
			"\u00cd\u00de\u00e8\u00ee\u00f2\u00f7\u00fb\u00ff\u010b\u010e\u0112\u0116" +
			"\u0119\u0120\u0125\u0139\u0156\u0158\u0163\u0169\u016e";
	public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}