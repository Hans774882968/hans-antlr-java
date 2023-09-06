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
			T__24 = 25, T__25 = 26, T__26 = 27, T__27 = 28, POW = 29, MULTIPLICATIVE = 30, SHIFT = 31,
			RELATIONAL = 32, EQUALITY = 33, AND = 34, XOR = 35, OR = 36, VARIABLE = 37, PRINT = 38,
			EQUALS = 39, NUMBER = 40, IntegerOrDecimalLiteral = 41, HexIntegerLiteral = 42,
			OctalIntegerLiteral = 43, BinaryIntegerLiteral = 44, BOOL = 45, STRING = 46, Identifier = 47,
			WS = 48, COMMENT = 49, LINE_COMMENT = 50;
	public static final int RULE_compilationUnit = 0, RULE_statements = 1, RULE_block = 2, RULE_statement = 3,
			RULE_variable = 4, RULE_expressionStatement = 5, RULE_ifStatement = 6,
			RULE_rangedForStatement = 7, RULE_rangedForConditions = 8, RULE_standardForStatement = 9,
			RULE_standardForInit = 10, RULE_standardForUpdate = 11, RULE_breakStatement = 12,
			RULE_continueStatement = 13, RULE_expression = 14, RULE_variableReference = 15,
			RULE_print = 16, RULE_value = 17;

	private static String[] makeRuleNames() {
		return new String[] {
				"compilationUnit", "statements", "block", "statement", "variable", "expressionStatement",
				"ifStatement", "rangedForStatement", "rangedForConditions", "standardForStatement",
				"standardForInit", "standardForUpdate", "breakStatement", "continueStatement",
				"expression", "variableReference", "print", "value"
		};
	}

	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
				null, "'{'", "'}'", "'if'", "'('", "')'", "'else'", "'for'", "':'", "'to'",
				"';'", "'break'", "'continue'", "'+'", "'-'", "'~'", "'**='", "'*='",
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
				null, null, null, null, null, "POW", "MULTIPLICATIVE", "SHIFT", "RELATIONAL",
				"EQUALITY", "AND", "XOR", "OR", "VARIABLE", "PRINT", "EQUALS", "NUMBER",
				"IntegerOrDecimalLiteral", "HexIntegerLiteral", "OctalIntegerLiteral",
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
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class, 0);
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
				setState(36);
				statements();
				setState(37);
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
		enterRule(_localctx, 2, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 247802433173658L) != 0)) {
					{
						{
							setState(39);
							statement();
						}
					}
					setState(44);
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
		enterRule(_localctx, 4, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(45);
				match(T__0);
				setState(46);
				statements();
				setState(47);
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
	public static class StatementContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class, 0);
		}

		public PrintContext print() {
			return getRuleContext(PrintContext.class, 0);
		}

		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class, 0);
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
		enterRule(_localctx, 6, RULE_statement);
		try {
			setState(58);
			_errHandler.sync(this);
			switch (getInterpreter().adaptivePredict(_input, 1, _ctx)) {
				case 1:
					enterOuterAlt(_localctx, 1); {
					setState(49);
					variable();
				}
					break;
				case 2:
					enterOuterAlt(_localctx, 2); {
					setState(50);
					print();
				}
					break;
				case 3:
					enterOuterAlt(_localctx, 3); {
					setState(51);
					expressionStatement();
				}
					break;
				case 4:
					enterOuterAlt(_localctx, 4); {
					setState(52);
					block();
				}
					break;
				case 5:
					enterOuterAlt(_localctx, 5); {
					setState(53);
					ifStatement();
				}
					break;
				case 6:
					enterOuterAlt(_localctx, 6); {
					setState(54);
					rangedForStatement();
				}
					break;
				case 7:
					enterOuterAlt(_localctx, 7); {
					setState(55);
					standardForStatement();
				}
					break;
				case 8:
					enterOuterAlt(_localctx, 8); {
					setState(56);
					breakStatement();
				}
					break;
				case 9:
					enterOuterAlt(_localctx, 9); {
					setState(57);
					continueStatement();
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
		enterRule(_localctx, 8, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(60);
				match(VARIABLE);
				setState(61);
				match(Identifier);
				setState(62);
				match(EQUALS);
				setState(63);
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
		enterRule(_localctx, 10, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(65);
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
		enterRule(_localctx, 12, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(67);
				match(T__2);
				setState(69);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 2, _ctx)) {
					case 1: {
						setState(68);
						match(T__3);
					}
						break;
				}
				setState(71);
				expression(0);
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == T__4) {
					{
						setState(72);
						match(T__4);
					}
				}

				setState(75);
				((IfStatementContext) _localctx).trueStatement = statement();
				setState(78);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 4, _ctx)) {
					case 1: {
						setState(76);
						match(T__5);
						setState(77);
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
		enterRule(_localctx, 14, RULE_rangedForStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(80);
				match(T__6);
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == T__3) {
					{
						setState(81);
						match(T__3);
					}
				}

				setState(84);
				rangedForConditions();
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == T__4) {
					{
						setState(85);
						match(T__4);
					}
				}

				setState(88);
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
		enterRule(_localctx, 16, RULE_rangedForConditions);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(90);
				((RangedForConditionsContext) _localctx).iterator = variableReference();
				setState(91);
				match(T__7);
				setState(92);
				((RangedForConditionsContext) _localctx).startExpr = expression(0);
				setState(93);
				((RangedForConditionsContext) _localctx).range = match(T__8);
				setState(94);
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
		enterRule(_localctx, 18, RULE_standardForStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(96);
				match(T__6);
				setState(98);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 7, _ctx)) {
					case 1: {
						setState(97);
						match(T__3);
					}
						break;
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 247802433167376L) != 0)) {
					{
						setState(100);
						standardForInit();
					}
				}

				setState(103);
				match(T__9);
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 247390116306960L) != 0)) {
					{
						setState(104);
						expression(0);
					}
				}

				setState(107);
				match(T__9);
				setState(109);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 10, _ctx)) {
					case 1: {
						setState(108);
						standardForUpdate();
					}
						break;
				}
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == T__4) {
					{
						setState(111);
						match(T__4);
					}
				}

				setState(114);
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
		enterRule(_localctx, 20, RULE_standardForInit);
		try {
			setState(119);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case VARIABLE:
					enterOuterAlt(_localctx, 1); {
					setState(116);
					variable();
				}
					break;
				case PRINT:
					enterOuterAlt(_localctx, 2); {
					setState(117);
					print();
				}
					break;
				case T__3:
				case T__12:
				case T__13:
				case T__14:
				case NUMBER:
				case BOOL:
				case STRING:
				case Identifier:
					enterOuterAlt(_localctx, 3); {
					setState(118);
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
		enterRule(_localctx, 22, RULE_standardForUpdate);
		try {
			setState(124);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case VARIABLE:
					enterOuterAlt(_localctx, 1); {
					setState(121);
					variable();
				}
					break;
				case PRINT:
					enterOuterAlt(_localctx, 2); {
					setState(122);
					print();
				}
					break;
				case T__3:
				case T__12:
				case T__13:
				case T__14:
				case NUMBER:
				case BOOL:
				case STRING:
				case Identifier:
					enterOuterAlt(_localctx, 3); {
					setState(123);
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
		enterRule(_localctx, 24, RULE_breakStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(126);
				match(T__10);
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
		enterRule(_localctx, 26, RULE_continueStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(128);
				match(T__11);
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
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
				setState(143);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 14, _ctx)) {
					case 1: {
						_localctx = new VarReferenceContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;

						setState(131);
						variableReference();
					}
						break;
					case 2: {
						_localctx = new ValueExprContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(132);
						value();
					}
						break;
					case 3: {
						_localctx = new BRACKETContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(133);
						match(T__3);
						setState(134);
						expression(0);
						setState(135);
						match(T__4);
					}
						break;
					case 4: {
						_localctx = new UNARYContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(137);
						((UNARYContext) _localctx).UNARY = _input.LT(1);
						_la = _input.LA(1);
						if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 57344L) != 0))) {
							((UNARYContext) _localctx).UNARY = (Token) _errHandler.recoverInline(this);
						} else {
							if (_input.LA(1) == Token.EOF)
								matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(138);
						expression(11);
					}
						break;
					case 5: {
						_localctx = new ASSIGNMENTContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(139);
						variableReference();
						setState(140);
						((ASSIGNMENTContext) _localctx).AssignmentOperator = _input.LT(1);
						_la = _input.LA(1);
						if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 550024183808L) != 0))) {
							((ASSIGNMENTContext) _localctx).AssignmentOperator = (Token) _errHandler
									.recoverInline(this);
						} else {
							if (_input.LA(1) == Token.EOF)
								matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(141);
						expression(1);
					}
						break;
				}
				_ctx.stop = _input.LT(-1);
				setState(174);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input, 16, _ctx);
				while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
					if (_alt == 1) {
						if (_parseListeners != null)
							triggerExitRuleEvent();
						_prevctx = _localctx;
						{
							setState(172);
							_errHandler.sync(this);
							switch (getInterpreter().adaptivePredict(_input, 15, _ctx)) {
								case 1: {
									_localctx = new POWContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(145);
									if (!(precpred(_ctx, 10)))
										throw new FailedPredicateException(this, "precpred(_ctx, 10)");
									setState(146);
									match(POW);
									setState(147);
									expression(11);
								}
									break;
								case 2: {
									_localctx = new MULTIPLICATIVEContext(
											new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(148);
									if (!(precpred(_ctx, 9)))
										throw new FailedPredicateException(this, "precpred(_ctx, 9)");
									setState(149);
									match(MULTIPLICATIVE);
									setState(150);
									expression(10);
								}
									break;
								case 3: {
									_localctx = new ADDITIVEContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(151);
									if (!(precpred(_ctx, 8)))
										throw new FailedPredicateException(this, "precpred(_ctx, 8)");
									setState(152);
									((ADDITIVEContext) _localctx).ADDITIVE = _input.LT(1);
									_la = _input.LA(1);
									if (!(_la == T__12 || _la == T__13)) {
										((ADDITIVEContext) _localctx).ADDITIVE = (Token) _errHandler
												.recoverInline(this);
									} else {
										if (_input.LA(1) == Token.EOF)
											matchedEOF = true;
										_errHandler.reportMatch(this);
										consume();
									}
									setState(153);
									expression(9);
								}
									break;
								case 4: {
									_localctx = new SHIFTContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(154);
									if (!(precpred(_ctx, 7)))
										throw new FailedPredicateException(this, "precpred(_ctx, 7)");
									setState(155);
									match(SHIFT);
									setState(156);
									expression(8);
								}
									break;
								case 5: {
									_localctx = new RELATIONALContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(157);
									if (!(precpred(_ctx, 6)))
										throw new FailedPredicateException(this, "precpred(_ctx, 6)");
									setState(158);
									match(RELATIONAL);
									setState(159);
									expression(7);
								}
									break;
								case 6: {
									_localctx = new EQUALITYContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(160);
									if (!(precpred(_ctx, 5)))
										throw new FailedPredicateException(this, "precpred(_ctx, 5)");
									setState(161);
									match(EQUALITY);
									setState(162);
									expression(6);
								}
									break;
								case 7: {
									_localctx = new ANDContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(163);
									if (!(precpred(_ctx, 4)))
										throw new FailedPredicateException(this, "precpred(_ctx, 4)");
									setState(164);
									match(AND);
									setState(165);
									expression(5);
								}
									break;
								case 8: {
									_localctx = new XORContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(166);
									if (!(precpred(_ctx, 3)))
										throw new FailedPredicateException(this, "precpred(_ctx, 3)");
									setState(167);
									match(XOR);
									setState(168);
									expression(4);
								}
									break;
								case 9: {
									_localctx = new ORContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(169);
									if (!(precpred(_ctx, 2)))
										throw new FailedPredicateException(this, "precpred(_ctx, 2)");
									setState(170);
									match(OR);
									setState(171);
									expression(3);
								}
									break;
							}
						}
					}
					setState(176);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 16, _ctx);
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
		enterRule(_localctx, 30, RULE_variableReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(177);
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
		enterRule(_localctx, 32, RULE_print);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(179);
				match(PRINT);
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == T__27) {
					{
						setState(180);
						((PrintContext) _localctx).printArg = match(T__27);
					}
				}

				setState(183);
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
		enterRule(_localctx, 34, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(185);
				_la = _input.LA(1);
				if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 106652627894272L) != 0))) {
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
			case 14:
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

	public static final String _serializedATN = "\u0004\u00012\u00bc\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"
			+
			"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002" +
			"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002" +
			"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002" +
			"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f" +
			"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0001\u0000" +
			"\u0001\u0000\u0001\u0001\u0005\u0001)\b\u0001\n\u0001\f\u0001,\t\u0001" +
			"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003" +
			"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003" +
			"\u0001\u0003\u0003\u0003;\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004" +
			"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006" +
			"\u0003\u0006F\b\u0006\u0001\u0006\u0001\u0006\u0003\u0006J\b\u0006\u0001" +
			"\u0006\u0001\u0006\u0001\u0006\u0003\u0006O\b\u0006\u0001\u0007\u0001" +
			"\u0007\u0003\u0007S\b\u0007\u0001\u0007\u0001\u0007\u0003\u0007W\b\u0007" +
			"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001" +
			"\b\u0001\t\u0001\t\u0003\tc\b\t\u0001\t\u0003\tf\b\t\u0001\t\u0001\t\u0003" +
			"\tj\b\t\u0001\t\u0001\t\u0003\tn\b\t\u0001\t\u0003\tq\b\t\u0001\t\u0001" +
			"\t\u0001\n\u0001\n\u0001\n\u0003\nx\b\n\u0001\u000b\u0001\u000b\u0001" +
			"\u000b\u0003\u000b}\b\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e" +
			"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e" +
			"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e" +
			"\u0003\u000e\u0090\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e" +
			"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e" +
			"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e" +
			"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e" +
			"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e" +
			"\u00ad\b\u000e\n\u000e\f\u000e\u00b0\t\u000e\u0001\u000f\u0001\u000f\u0001" +
			"\u0010\u0001\u0010\u0003\u0010\u00b6\b\u0010\u0001\u0010\u0001\u0010\u0001" +
			"\u0011\u0001\u0011\u0001\u0011\u0000\u0001\u001c\u0012\u0000\u0002\u0004" +
			"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"" +
			"\u0000\u0004\u0001\u0000\r\u000f\u0002\u0000\u0010\u001b\'\'\u0001\u0000" +
			"\r\u000e\u0002\u0000((-.\u00ce\u0000$\u0001\u0000\u0000\u0000\u0002*\u0001" +
			"\u0000\u0000\u0000\u0004-\u0001\u0000\u0000\u0000\u0006:\u0001\u0000\u0000" +
			"\u0000\b<\u0001\u0000\u0000\u0000\nA\u0001\u0000\u0000\u0000\fC\u0001" +
			"\u0000\u0000\u0000\u000eP\u0001\u0000\u0000\u0000\u0010Z\u0001\u0000\u0000" +
			"\u0000\u0012`\u0001\u0000\u0000\u0000\u0014w\u0001\u0000\u0000\u0000\u0016" +
			"|\u0001\u0000\u0000\u0000\u0018~\u0001\u0000\u0000\u0000\u001a\u0080\u0001" +
			"\u0000\u0000\u0000\u001c\u008f\u0001\u0000\u0000\u0000\u001e\u00b1\u0001" +
			"\u0000\u0000\u0000 \u00b3\u0001\u0000\u0000\u0000\"\u00b9\u0001\u0000" +
			"\u0000\u0000$%\u0003\u0002\u0001\u0000%&\u0005\u0000\u0000\u0001&\u0001" +
			"\u0001\u0000\u0000\u0000\')\u0003\u0006\u0003\u0000(\'\u0001\u0000\u0000" +
			"\u0000),\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000\u0000*+\u0001\u0000" +
			"\u0000\u0000+\u0003\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000" +
			"-.\u0005\u0001\u0000\u0000./\u0003\u0002\u0001\u0000/0\u0005\u0002\u0000" +
			"\u00000\u0005\u0001\u0000\u0000\u00001;\u0003\b\u0004\u00002;\u0003 \u0010" +
			"\u00003;\u0003\n\u0005\u00004;\u0003\u0004\u0002\u00005;\u0003\f\u0006" +
			"\u00006;\u0003\u000e\u0007\u00007;\u0003\u0012\t\u00008;\u0003\u0018\f" +
			"\u00009;\u0003\u001a\r\u0000:1\u0001\u0000\u0000\u0000:2\u0001\u0000\u0000" +
			"\u0000:3\u0001\u0000\u0000\u0000:4\u0001\u0000\u0000\u0000:5\u0001\u0000" +
			"\u0000\u0000:6\u0001\u0000\u0000\u0000:7\u0001\u0000\u0000\u0000:8\u0001" +
			"\u0000\u0000\u0000:9\u0001\u0000\u0000\u0000;\u0007\u0001\u0000\u0000" +
			"\u0000<=\u0005%\u0000\u0000=>\u0005/\u0000\u0000>?\u0005\'\u0000\u0000" +
			"?@\u0003\u001c\u000e\u0000@\t\u0001\u0000\u0000\u0000AB\u0003\u001c\u000e" +
			"\u0000B\u000b\u0001\u0000\u0000\u0000CE\u0005\u0003\u0000\u0000DF\u0005" +
			"\u0004\u0000\u0000ED\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000" +
			"FG\u0001\u0000\u0000\u0000GI\u0003\u001c\u000e\u0000HJ\u0005\u0005\u0000" +
			"\u0000IH\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JK\u0001\u0000" +
			"\u0000\u0000KN\u0003\u0006\u0003\u0000LM\u0005\u0006\u0000\u0000MO\u0003" +
			"\u0006\u0003\u0000NL\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000" +
			"O\r\u0001\u0000\u0000\u0000PR\u0005\u0007\u0000\u0000QS\u0005\u0004\u0000" +
			"\u0000RQ\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000ST\u0001\u0000" +
			"\u0000\u0000TV\u0003\u0010\b\u0000UW\u0005\u0005\u0000\u0000VU\u0001\u0000" +
			"\u0000\u0000VW\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XY\u0003" +
			"\u0006\u0003\u0000Y\u000f\u0001\u0000\u0000\u0000Z[\u0003\u001e\u000f" +
			"\u0000[\\\u0005\b\u0000\u0000\\]\u0003\u001c\u000e\u0000]^\u0005\t\u0000" +
			"\u0000^_\u0003\u001c\u000e\u0000_\u0011\u0001\u0000\u0000\u0000`b\u0005" +
			"\u0007\u0000\u0000ac\u0005\u0004\u0000\u0000ba\u0001\u0000\u0000\u0000" +
			"bc\u0001\u0000\u0000\u0000ce\u0001\u0000\u0000\u0000df\u0003\u0014\n\u0000" +
			"ed\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000" +
			"\u0000gi\u0005\n\u0000\u0000hj\u0003\u001c\u000e\u0000ih\u0001\u0000\u0000" +
			"\u0000ij\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000km\u0005\n\u0000" +
			"\u0000ln\u0003\u0016\u000b\u0000ml\u0001\u0000\u0000\u0000mn\u0001\u0000" +
			"\u0000\u0000np\u0001\u0000\u0000\u0000oq\u0005\u0005\u0000\u0000po\u0001" +
			"\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000" +
			"rs\u0003\u0006\u0003\u0000s\u0013\u0001\u0000\u0000\u0000tx\u0003\b\u0004" +
			"\u0000ux\u0003 \u0010\u0000vx\u0003\n\u0005\u0000wt\u0001\u0000\u0000" +
			"\u0000wu\u0001\u0000\u0000\u0000wv\u0001\u0000\u0000\u0000x\u0015\u0001" +
			"\u0000\u0000\u0000y}\u0003\b\u0004\u0000z}\u0003 \u0010\u0000{}\u0003" +
			"\n\u0005\u0000|y\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000|{\u0001" +
			"\u0000\u0000\u0000}\u0017\u0001\u0000\u0000\u0000~\u007f\u0005\u000b\u0000" +
			"\u0000\u007f\u0019\u0001\u0000\u0000\u0000\u0080\u0081\u0005\f\u0000\u0000" +
			"\u0081\u001b\u0001\u0000\u0000\u0000\u0082\u0083\u0006\u000e\uffff\uffff" +
			"\u0000\u0083\u0090\u0003\u001e\u000f\u0000\u0084\u0090\u0003\"\u0011\u0000" +
			"\u0085\u0086\u0005\u0004\u0000\u0000\u0086\u0087\u0003\u001c\u000e\u0000" +
			"\u0087\u0088\u0005\u0005\u0000\u0000\u0088\u0090\u0001\u0000\u0000\u0000" +
			"\u0089\u008a\u0007\u0000\u0000\u0000\u008a\u0090\u0003\u001c\u000e\u000b" +
			"\u008b\u008c\u0003\u001e\u000f\u0000\u008c\u008d\u0007\u0001\u0000\u0000" +
			"\u008d\u008e\u0003\u001c\u000e\u0001\u008e\u0090\u0001\u0000\u0000\u0000" +
			"\u008f\u0082\u0001\u0000\u0000\u0000\u008f\u0084\u0001\u0000\u0000\u0000" +
			"\u008f\u0085\u0001\u0000\u0000\u0000\u008f\u0089\u0001\u0000\u0000\u0000" +
			"\u008f\u008b\u0001\u0000\u0000\u0000\u0090\u00ae\u0001\u0000\u0000\u0000" +
			"\u0091\u0092\n\n\u0000\u0000\u0092\u0093\u0005\u001d\u0000\u0000\u0093" +
			"\u00ad\u0003\u001c\u000e\u000b\u0094\u0095\n\t\u0000\u0000\u0095\u0096" +
			"\u0005\u001e\u0000\u0000\u0096\u00ad\u0003\u001c\u000e\n\u0097\u0098\n" +
			"\b\u0000\u0000\u0098\u0099\u0007\u0002\u0000\u0000\u0099\u00ad\u0003\u001c" +
			"\u000e\t\u009a\u009b\n\u0007\u0000\u0000\u009b\u009c\u0005\u001f\u0000" +
			"\u0000\u009c\u00ad\u0003\u001c\u000e\b\u009d\u009e\n\u0006\u0000\u0000" +
			"\u009e\u009f\u0005 \u0000\u0000\u009f\u00ad\u0003\u001c\u000e\u0007\u00a0" +
			"\u00a1\n\u0005\u0000\u0000\u00a1\u00a2\u0005!\u0000\u0000\u00a2\u00ad" +
			"\u0003\u001c\u000e\u0006\u00a3\u00a4\n\u0004\u0000\u0000\u00a4\u00a5\u0005" +
			"\"\u0000\u0000\u00a5\u00ad\u0003\u001c\u000e\u0005\u00a6\u00a7\n\u0003" +
			"\u0000\u0000\u00a7\u00a8\u0005#\u0000\u0000\u00a8\u00ad\u0003\u001c\u000e" +
			"\u0004\u00a9\u00aa\n\u0002\u0000\u0000\u00aa\u00ab\u0005$\u0000\u0000" +
			"\u00ab\u00ad\u0003\u001c\u000e\u0003\u00ac\u0091\u0001\u0000\u0000\u0000" +
			"\u00ac\u0094\u0001\u0000\u0000\u0000\u00ac\u0097\u0001\u0000\u0000\u0000" +
			"\u00ac\u009a\u0001\u0000\u0000\u0000\u00ac\u009d\u0001\u0000\u0000\u0000" +
			"\u00ac\u00a0\u0001\u0000\u0000\u0000\u00ac\u00a3\u0001\u0000\u0000\u0000" +
			"\u00ac\u00a6\u0001\u0000\u0000\u0000\u00ac\u00a9\u0001\u0000\u0000\u0000" +
			"\u00ad\u00b0\u0001\u0000\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000" +
			"\u00ae\u00af\u0001\u0000\u0000\u0000\u00af\u001d\u0001\u0000\u0000\u0000" +
			"\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005/\u0000\u0000\u00b2" +
			"\u001f\u0001\u0000\u0000\u0000\u00b3\u00b5\u0005&\u0000\u0000\u00b4\u00b6" +
			"\u0005\u001c\u0000\u0000\u00b5\u00b4\u0001\u0000\u0000\u0000\u00b5\u00b6" +
			"\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\u00b8" +
			"\u0003\u001c\u000e\u0000\u00b8!\u0001\u0000\u0000\u0000\u00b9\u00ba\u0007" +
			"\u0003\u0000\u0000\u00ba#\u0001\u0000\u0000\u0000\u0012*:EINRVbeimpw|" +
			"\u008f\u00ac\u00ae\u00b5";
	public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}