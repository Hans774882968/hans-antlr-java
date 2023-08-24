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
			POW = 25, MULTIPLICATIVE = 26, SHIFT = 27, RELATIONAL = 28, EQUALITY = 29, AND = 30,
			XOR = 31, OR = 32, VARIABLE = 33, PRINT = 34, EQUALS = 35, NUMBER = 36, STRING = 37,
			Identifier = 38, WS = 39, COMMENT = 40, LINE_COMMENT = 41;
	public static final int RULE_compilationUnit = 0, RULE_statements = 1, RULE_block = 2, RULE_statement = 3,
			RULE_variable = 4, RULE_expressionStatement = 5, RULE_ifStatement = 6,
			RULE_forStatement = 7, RULE_rangedForConditions = 8, RULE_expression = 9,
			RULE_variableReference = 10, RULE_print = 11, RULE_value = 12;

	private static String[] makeRuleNames() {
		return new String[] {
				"compilationUnit", "statements", "block", "statement", "variable", "expressionStatement",
				"ifStatement", "forStatement", "rangedForConditions", "expression", "variableReference",
				"print", "value"
		};
	}

	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
				null, "'{'", "'}'", "'if'", "'('", "')'", "'else'", "'for'", "':'", "'to'",
				"'+'", "'-'", "'~'", "'**='", "'*='", "'/='", "'%='", "'+='", "'-='",
				"'<<='", "'>>='", "'>>>='", "'&='", "'^='", "'|='", "'**'", null, null,
				null, null, "'&'", "'^'", "'|'", "'var'", "'print'", "'='"
		};
	}

	private static final String[] _LITERAL_NAMES = makeLiteralNames();

	private static String[] makeSymbolicNames() {
		return new String[] {
				null, null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, null,
				null, "POW", "MULTIPLICATIVE", "SHIFT", "RELATIONAL", "EQUALITY", "AND",
				"XOR", "OR", "VARIABLE", "PRINT", "EQUALS", "NUMBER", "STRING", "Identifier",
				"WS", "COMMENT", "LINE_COMMENT"
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
				setState(26);
				statements();
				setState(27);
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
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 506806148250L) != 0)) {
					{
						{
							setState(29);
							statement();
						}
					}
					setState(34);
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
				setState(35);
				match(T__0);
				setState(36);
				statements();
				setState(37);
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

		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class, 0);
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
			setState(45);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case VARIABLE:
					enterOuterAlt(_localctx, 1); {
					setState(39);
					variable();
				}
					break;
				case PRINT:
					enterOuterAlt(_localctx, 2); {
					setState(40);
					print();
				}
					break;
				case T__3:
				case T__9:
				case T__10:
				case T__11:
				case NUMBER:
				case STRING:
				case Identifier:
					enterOuterAlt(_localctx, 3); {
					setState(41);
					expressionStatement();
				}
					break;
				case T__0:
					enterOuterAlt(_localctx, 4); {
					setState(42);
					block();
				}
					break;
				case T__2:
					enterOuterAlt(_localctx, 5); {
					setState(43);
					ifStatement();
				}
					break;
				case T__6:
					enterOuterAlt(_localctx, 6); {
					setState(44);
					forStatement();
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
				setState(47);
				match(VARIABLE);
				setState(48);
				match(Identifier);
				setState(49);
				match(EQUALS);
				setState(50);
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
				setState(52);
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
				setState(54);
				match(T__2);
				setState(56);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 2, _ctx)) {
					case 1: {
						setState(55);
						match(T__3);
					}
						break;
				}
				setState(58);
				expression(0);
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == T__4) {
					{
						setState(59);
						match(T__4);
					}
				}

				setState(62);
				((IfStatementContext) _localctx).trueStatement = statement();
				setState(65);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 4, _ctx)) {
					case 1: {
						setState(63);
						match(T__5);
						setState(64);
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
	public static class ForStatementContext extends ParserRuleContext {
		public RangedForConditionsContext rangedForConditions() {
			return getRuleContext(RangedForConditionsContext.class, 0);
		}

		public StatementContext statement() {
			return getRuleContext(StatementContext.class, 0);
		}

		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_forStatement;
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitForStatement(this);
			else
				return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(67);
				match(T__6);
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == T__3) {
					{
						setState(68);
						match(T__3);
					}
				}

				setState(71);
				rangedForConditions();
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
				setState(77);
				((RangedForConditionsContext) _localctx).iterator = variableReference();
				setState(78);
				match(T__7);
				setState(79);
				((RangedForConditionsContext) _localctx).startExpr = expression(0);
				setState(80);
				((RangedForConditionsContext) _localctx).range = match(T__8);
				setState(81);
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
				setState(96);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 7, _ctx)) {
					case 1: {
						_localctx = new VarReferenceContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;

						setState(84);
						variableReference();
					}
						break;
					case 2: {
						_localctx = new ValueExprContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(85);
						value();
					}
						break;
					case 3: {
						_localctx = new BRACKETContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(86);
						match(T__3);
						setState(87);
						expression(0);
						setState(88);
						match(T__4);
					}
						break;
					case 4: {
						_localctx = new UNARYContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(90);
						((UNARYContext) _localctx).UNARY = _input.LT(1);
						_la = _input.LA(1);
						if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 7168L) != 0))) {
							((UNARYContext) _localctx).UNARY = (Token) _errHandler.recoverInline(this);
						} else {
							if (_input.LA(1) == Token.EOF)
								matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(91);
						expression(11);
					}
						break;
					case 5: {
						_localctx = new ASSIGNMENTContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(92);
						variableReference();
						setState(93);
						((ASSIGNMENTContext) _localctx).AssignmentOperator = _input.LT(1);
						_la = _input.LA(1);
						if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 34393284608L) != 0))) {
							((ASSIGNMENTContext) _localctx).AssignmentOperator = (Token) _errHandler
									.recoverInline(this);
						} else {
							if (_input.LA(1) == Token.EOF)
								matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(94);
						expression(1);
					}
						break;
				}
				_ctx.stop = _input.LT(-1);
				setState(127);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input, 9, _ctx);
				while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
					if (_alt == 1) {
						if (_parseListeners != null)
							triggerExitRuleEvent();
						_prevctx = _localctx;
						{
							setState(125);
							_errHandler.sync(this);
							switch (getInterpreter().adaptivePredict(_input, 8, _ctx)) {
								case 1: {
									_localctx = new POWContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(98);
									if (!(precpred(_ctx, 10)))
										throw new FailedPredicateException(this, "precpred(_ctx, 10)");
									setState(99);
									match(POW);
									setState(100);
									expression(11);
								}
									break;
								case 2: {
									_localctx = new MULTIPLICATIVEContext(
											new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(101);
									if (!(precpred(_ctx, 9)))
										throw new FailedPredicateException(this, "precpred(_ctx, 9)");
									setState(102);
									match(MULTIPLICATIVE);
									setState(103);
									expression(10);
								}
									break;
								case 3: {
									_localctx = new ADDITIVEContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(104);
									if (!(precpred(_ctx, 8)))
										throw new FailedPredicateException(this, "precpred(_ctx, 8)");
									setState(105);
									((ADDITIVEContext) _localctx).ADDITIVE = _input.LT(1);
									_la = _input.LA(1);
									if (!(_la == T__9 || _la == T__10)) {
										((ADDITIVEContext) _localctx).ADDITIVE = (Token) _errHandler
												.recoverInline(this);
									} else {
										if (_input.LA(1) == Token.EOF)
											matchedEOF = true;
										_errHandler.reportMatch(this);
										consume();
									}
									setState(106);
									expression(9);
								}
									break;
								case 4: {
									_localctx = new SHIFTContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(107);
									if (!(precpred(_ctx, 7)))
										throw new FailedPredicateException(this, "precpred(_ctx, 7)");
									setState(108);
									match(SHIFT);
									setState(109);
									expression(8);
								}
									break;
								case 5: {
									_localctx = new RELATIONALContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(110);
									if (!(precpred(_ctx, 6)))
										throw new FailedPredicateException(this, "precpred(_ctx, 6)");
									setState(111);
									match(RELATIONAL);
									setState(112);
									expression(7);
								}
									break;
								case 6: {
									_localctx = new EQUALITYContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(113);
									if (!(precpred(_ctx, 5)))
										throw new FailedPredicateException(this, "precpred(_ctx, 5)");
									setState(114);
									match(EQUALITY);
									setState(115);
									expression(6);
								}
									break;
								case 7: {
									_localctx = new ANDContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(116);
									if (!(precpred(_ctx, 4)))
										throw new FailedPredicateException(this, "precpred(_ctx, 4)");
									setState(117);
									match(AND);
									setState(118);
									expression(5);
								}
									break;
								case 8: {
									_localctx = new XORContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(119);
									if (!(precpred(_ctx, 3)))
										throw new FailedPredicateException(this, "precpred(_ctx, 3)");
									setState(120);
									match(XOR);
									setState(121);
									expression(4);
								}
									break;
								case 9: {
									_localctx = new ORContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(122);
									if (!(precpred(_ctx, 2)))
										throw new FailedPredicateException(this, "precpred(_ctx, 2)");
									setState(123);
									match(OR);
									setState(124);
									expression(3);
								}
									break;
							}
						}
					}
					setState(129);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 9, _ctx);
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
		enterRule(_localctx, 20, RULE_variableReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(130);
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
		enterRule(_localctx, 22, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(132);
				match(PRINT);
				setState(133);
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
		public Token op;

		public TerminalNode NUMBER() {
			return getToken(HansAntlrParser.NUMBER, 0);
		}

		public TerminalNode STRING() {
			return getToken(HansAntlrParser.STRING, 0);
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
		enterRule(_localctx, 24, RULE_value);
		try {
			setState(137);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case NUMBER:
					enterOuterAlt(_localctx, 1); {
					setState(135);
					((ValueContext) _localctx).op = match(NUMBER);
				}
					break;
				case STRING:
					enterOuterAlt(_localctx, 2); {
					setState(136);
					((ValueContext) _localctx).op = match(STRING);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
			case 9:
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

	public static final String _serializedATN = "\u0004\u0001)\u008c\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"
			+
			"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002" +
			"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002" +
			"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002" +
			"\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0005\u0001" +
			"\u001f\b\u0001\n\u0001\f\u0001\"\t\u0001\u0001\u0002\u0001\u0002\u0001" +
			"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001" +
			"\u0003\u0001\u0003\u0003\u0003.\b\u0003\u0001\u0004\u0001\u0004\u0001" +
			"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001" +
			"\u0006\u0003\u00069\b\u0006\u0001\u0006\u0001\u0006\u0003\u0006=\b\u0006" +
			"\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006B\b\u0006\u0001\u0007" +
			"\u0001\u0007\u0003\u0007F\b\u0007\u0001\u0007\u0001\u0007\u0003\u0007" +
			"J\b\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001" +
			"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001" +
			"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\ta\b\t\u0001\t\u0001" +
			"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001" +
			"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001" +
			"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t~\b" +
			"\t\n\t\f\t\u0081\t\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b" +
			"\u0001\f\u0001\f\u0003\f\u008a\b\f\u0001\f\u0000\u0001\u0012\r\u0000\u0002" +
			"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u0000\u0003\u0001" +
			"\u0000\n\f\u0002\u0000\r\u0018##\u0001\u0000\n\u000b\u0097\u0000\u001a" +
			"\u0001\u0000\u0000\u0000\u0002 \u0001\u0000\u0000\u0000\u0004#\u0001\u0000" +
			"\u0000\u0000\u0006-\u0001\u0000\u0000\u0000\b/\u0001\u0000\u0000\u0000" +
			"\n4\u0001\u0000\u0000\u0000\f6\u0001\u0000\u0000\u0000\u000eC\u0001\u0000" +
			"\u0000\u0000\u0010M\u0001\u0000\u0000\u0000\u0012`\u0001\u0000\u0000\u0000" +
			"\u0014\u0082\u0001\u0000\u0000\u0000\u0016\u0084\u0001\u0000\u0000\u0000" +
			"\u0018\u0089\u0001\u0000\u0000\u0000\u001a\u001b\u0003\u0002\u0001\u0000" +
			"\u001b\u001c\u0005\u0000\u0000\u0001\u001c\u0001\u0001\u0000\u0000\u0000" +
			"\u001d\u001f\u0003\u0006\u0003\u0000\u001e\u001d\u0001\u0000\u0000\u0000" +
			"\u001f\"\u0001\u0000\u0000\u0000 \u001e\u0001\u0000\u0000\u0000 !\u0001" +
			"\u0000\u0000\u0000!\u0003\u0001\u0000\u0000\u0000\" \u0001\u0000\u0000" +
			"\u0000#$\u0005\u0001\u0000\u0000$%\u0003\u0002\u0001\u0000%&\u0005\u0002" +
			"\u0000\u0000&\u0005\u0001\u0000\u0000\u0000\'.\u0003\b\u0004\u0000(.\u0003" +
			"\u0016\u000b\u0000).\u0003\n\u0005\u0000*.\u0003\u0004\u0002\u0000+.\u0003" +
			"\f\u0006\u0000,.\u0003\u000e\u0007\u0000-\'\u0001\u0000\u0000\u0000-(" +
			"\u0001\u0000\u0000\u0000-)\u0001\u0000\u0000\u0000-*\u0001\u0000\u0000" +
			"\u0000-+\u0001\u0000\u0000\u0000-,\u0001\u0000\u0000\u0000.\u0007\u0001" +
			"\u0000\u0000\u0000/0\u0005!\u0000\u000001\u0005&\u0000\u000012\u0005#" +
			"\u0000\u000023\u0003\u0012\t\u00003\t\u0001\u0000\u0000\u000045\u0003" +
			"\u0012\t\u00005\u000b\u0001\u0000\u0000\u000068\u0005\u0003\u0000\u0000" +
			"79\u0005\u0004\u0000\u000087\u0001\u0000\u0000\u000089\u0001\u0000\u0000" +
			"\u00009:\u0001\u0000\u0000\u0000:<\u0003\u0012\t\u0000;=\u0005\u0005\u0000" +
			"\u0000<;\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=>\u0001\u0000" +
			"\u0000\u0000>A\u0003\u0006\u0003\u0000?@\u0005\u0006\u0000\u0000@B\u0003" +
			"\u0006\u0003\u0000A?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000" +
			"B\r\u0001\u0000\u0000\u0000CE\u0005\u0007\u0000\u0000DF\u0005\u0004\u0000" +
			"\u0000ED\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FG\u0001\u0000" +
			"\u0000\u0000GI\u0003\u0010\b\u0000HJ\u0005\u0005\u0000\u0000IH\u0001\u0000" +
			"\u0000\u0000IJ\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KL\u0003" +
			"\u0006\u0003\u0000L\u000f\u0001\u0000\u0000\u0000MN\u0003\u0014\n\u0000" +
			"NO\u0005\b\u0000\u0000OP\u0003\u0012\t\u0000PQ\u0005\t\u0000\u0000QR\u0003" +
			"\u0012\t\u0000R\u0011\u0001\u0000\u0000\u0000ST\u0006\t\uffff\uffff\u0000" +
			"Ta\u0003\u0014\n\u0000Ua\u0003\u0018\f\u0000VW\u0005\u0004\u0000\u0000" +
			"WX\u0003\u0012\t\u0000XY\u0005\u0005\u0000\u0000Ya\u0001\u0000\u0000\u0000" +
			"Z[\u0007\u0000\u0000\u0000[a\u0003\u0012\t\u000b\\]\u0003\u0014\n\u0000" +
			"]^\u0007\u0001\u0000\u0000^_\u0003\u0012\t\u0001_a\u0001\u0000\u0000\u0000" +
			"`S\u0001\u0000\u0000\u0000`U\u0001\u0000\u0000\u0000`V\u0001\u0000\u0000" +
			"\u0000`Z\u0001\u0000\u0000\u0000`\\\u0001\u0000\u0000\u0000a\u007f\u0001" +
			"\u0000\u0000\u0000bc\n\n\u0000\u0000cd\u0005\u0019\u0000\u0000d~\u0003" +
			"\u0012\t\u000bef\n\t\u0000\u0000fg\u0005\u001a\u0000\u0000g~\u0003\u0012" +
			"\t\nhi\n\b\u0000\u0000ij\u0007\u0002\u0000\u0000j~\u0003\u0012\t\tkl\n" +
			"\u0007\u0000\u0000lm\u0005\u001b\u0000\u0000m~\u0003\u0012\t\bno\n\u0006" +
			"\u0000\u0000op\u0005\u001c\u0000\u0000p~\u0003\u0012\t\u0007qr\n\u0005" +
			"\u0000\u0000rs\u0005\u001d\u0000\u0000s~\u0003\u0012\t\u0006tu\n\u0004" +
			"\u0000\u0000uv\u0005\u001e\u0000\u0000v~\u0003\u0012\t\u0005wx\n\u0003" +
			"\u0000\u0000xy\u0005\u001f\u0000\u0000y~\u0003\u0012\t\u0004z{\n\u0002" +
			"\u0000\u0000{|\u0005 \u0000\u0000|~\u0003\u0012\t\u0003}b\u0001\u0000" +
			"\u0000\u0000}e\u0001\u0000\u0000\u0000}h\u0001\u0000\u0000\u0000}k\u0001" +
			"\u0000\u0000\u0000}n\u0001\u0000\u0000\u0000}q\u0001\u0000\u0000\u0000" +
			"}t\u0001\u0000\u0000\u0000}w\u0001\u0000\u0000\u0000}z\u0001\u0000\u0000" +
			"\u0000~\u0081\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u007f" +
			"\u0080\u0001\u0000\u0000\u0000\u0080\u0013\u0001\u0000\u0000\u0000\u0081" +
			"\u007f\u0001\u0000\u0000\u0000\u0082\u0083\u0005&\u0000\u0000\u0083\u0015" +
			"\u0001\u0000\u0000\u0000\u0084\u0085\u0005\"\u0000\u0000\u0085\u0086\u0003" +
			"\u0012\t\u0000\u0086\u0017\u0001\u0000\u0000\u0000\u0087\u008a\u0005$" +
			"\u0000\u0000\u0088\u008a\u0005%\u0000\u0000\u0089\u0087\u0001\u0000\u0000" +
			"\u0000\u0089\u0088\u0001\u0000\u0000\u0000\u008a\u0019\u0001\u0000\u0000" +
			"\u0000\u000b -8<AEI`}\u007f\u0089";
	public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}