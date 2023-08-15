// Generated from src\main\java\com\example\hans_antlr4\parsing\HansAntlr.g by ANTLR 4.13.0

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
	public static final int T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, VARIABLE = 7, PRINT = 8,
			EQUALS = 9,
			NUMBER = 10, STRING = 11, ID = 12, WS = 13;
	public static final int RULE_compilationUnit = 0, RULE_statements = 1, RULE_variable = 2, RULE_expression = 3,
			RULE_variableReference = 4, RULE_print = 5, RULE_value = 6;

	private static String[] makeRuleNames() {
		return new String[] {
				"compilationUnit", "statements", "variable", "expression", "variableReference",
				"print", "value"
		};
	}

	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
				null, "'('", "'*'", "')'", "'/'", "'+'", "'-'", "'var'", "'print'", "'='"
		};
	}

	private static final String[] _LITERAL_NAMES = makeLiteralNames();

	private static String[] makeSymbolicNames() {
		return new String[] {
				null, null, null, null, null, null, null, "VARIABLE", "PRINT", "EQUALS",
				"NUMBER", "STRING", "ID", "WS"
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
		return "HansAntlr.g";
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
				setState(14);
				statements();
				setState(15);
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
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}

		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class, i);
		}

		public List<PrintContext> print() {
			return getRuleContexts(PrintContext.class);
		}

		public PrintContext print(int i) {
			return getRuleContext(PrintContext.class, i);
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
				setState(21);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la == VARIABLE || _la == PRINT) {
					{
						setState(19);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
							case VARIABLE: {
								setState(17);
								variable();
							}
								break;
							case PRINT: {
								setState(18);
								print();
							}
								break;
							default:
								throw new NoViableAltException(this);
						}
					}
					setState(23);
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
	public static class VariableContext extends ParserRuleContext {
		public TerminalNode VARIABLE() {
			return getToken(HansAntlrParser.VARIABLE, 0);
		}

		public TerminalNode ID() {
			return getToken(HansAntlrParser.ID, 0);
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
		enterRule(_localctx, 4, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(24);
				match(VARIABLE);
				setState(25);
				match(ID);
				setState(26);
				match(EQUALS);
				setState(27);
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
	public static class ADDContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}

		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class, i);
		}

		public ADDContext(ExpressionContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitADD(this);
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
	public static class SUBSTRACTContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}

		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class, i);
		}

		public SUBSTRACTContext(ExpressionContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitSUBSTRACT(this);
			else
				return visitor.visitChildren(this);
		}
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MULTIPLYContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}

		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class, i);
		}

		public MULTIPLYContext(ExpressionContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitMULTIPLY(this);
			else
				return visitor.visitChildren(this);
		}
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DIVIDEContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}

		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class, i);
		}

		public DIVIDEContext(ExpressionContext ctx) {
			copyFrom(ctx);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof HansAntlrVisitor)
				return ((HansAntlrVisitor<? extends T>) visitor).visitDIVIDE(this);
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
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
				setState(56);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 2, _ctx)) {
					case 1: {
						_localctx = new VarReferenceContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;

						setState(30);
						variableReference();
					}
						break;
					case 2: {
						_localctx = new ValueExprContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(31);
						value();
					}
						break;
					case 3: {
						_localctx = new MULTIPLYContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(32);
						match(T__0);
						setState(33);
						expression(0);
						setState(34);
						match(T__1);
						setState(35);
						expression(0);
						setState(36);
						match(T__2);
					}
						break;
					case 4: {
						_localctx = new DIVIDEContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(38);
						match(T__0);
						setState(39);
						expression(0);
						setState(40);
						match(T__3);
						setState(41);
						expression(0);
						setState(42);
						match(T__2);
					}
						break;
					case 5: {
						_localctx = new ADDContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(44);
						match(T__0);
						setState(45);
						expression(0);
						setState(46);
						match(T__4);
						setState(47);
						expression(0);
						setState(48);
						match(T__2);
					}
						break;
					case 6: {
						_localctx = new SUBSTRACTContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(50);
						match(T__0);
						setState(51);
						expression(0);
						setState(52);
						match(T__5);
						setState(53);
						expression(0);
						setState(54);
						match(T__2);
					}
						break;
				}
				_ctx.stop = _input.LT(-1);
				setState(72);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input, 4, _ctx);
				while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
					if (_alt == 1) {
						if (_parseListeners != null)
							triggerExitRuleEvent();
						_prevctx = _localctx;
						{
							setState(70);
							_errHandler.sync(this);
							switch (getInterpreter().adaptivePredict(_input, 3, _ctx)) {
								case 1: {
									_localctx = new MULTIPLYContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(58);
									if (!(precpred(_ctx, 7)))
										throw new FailedPredicateException(this, "precpred(_ctx, 7)");
									setState(59);
									match(T__1);
									setState(60);
									expression(8);
								}
									break;
								case 2: {
									_localctx = new DIVIDEContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(61);
									if (!(precpred(_ctx, 5)))
										throw new FailedPredicateException(this, "precpred(_ctx, 5)");
									setState(62);
									match(T__3);
									setState(63);
									expression(6);
								}
									break;
								case 3: {
									_localctx = new ADDContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(64);
									if (!(precpred(_ctx, 3)))
										throw new FailedPredicateException(this, "precpred(_ctx, 3)");
									setState(65);
									match(T__4);
									setState(66);
									expression(4);
								}
									break;
								case 4: {
									_localctx = new SUBSTRACTContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(67);
									if (!(precpred(_ctx, 1)))
										throw new FailedPredicateException(this, "precpred(_ctx, 1)");
									setState(68);
									match(T__5);
									setState(69);
									expression(2);
								}
									break;
							}
						}
					}
					setState(74);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 4, _ctx);
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
		public TerminalNode ID() {
			return getToken(HansAntlrParser.ID, 0);
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
		enterRule(_localctx, 8, RULE_variableReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(75);
				match(ID);
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
		enterRule(_localctx, 10, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(77);
				match(PRINT);
				setState(78);
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
		enterRule(_localctx, 12, RULE_value);
		try {
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case NUMBER:
					enterOuterAlt(_localctx, 1); {
					setState(80);
					((ValueContext) _localctx).op = match(NUMBER);
				}
					break;
				case STRING:
					enterOuterAlt(_localctx, 2); {
					setState(81);
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
			case 3:
				return expression_sempred((ExpressionContext) _localctx, predIndex);
		}
		return true;
	}

	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
			case 0:
				return precpred(_ctx, 7);
			case 1:
				return precpred(_ctx, 5);
			case 2:
				return precpred(_ctx, 3);
			case 3:
				return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN = "\u0004\u0001\rU\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"
			+
			"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002" +
			"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0001\u0000\u0001" +
			"\u0000\u0001\u0001\u0001\u0001\u0005\u0001\u0014\b\u0001\n\u0001\f\u0001" +
			"\u0017\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002" +
			"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003" +
			"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003" +
			"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003" +
			"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003" +
			"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u00039\b\u0003\u0001\u0003" +
			"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003" +
			"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003" +
			"G\b\u0003\n\u0003\f\u0003J\t\u0003\u0001\u0004\u0001\u0004\u0001\u0005" +
			"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0003\u0006S\b\u0006" +
			"\u0001\u0006\u0000\u0001\u0006\u0007\u0000\u0002\u0004\u0006\b\n\f\u0000" +
			"\u0000Y\u0000\u000e\u0001\u0000\u0000\u0000\u0002\u0015\u0001\u0000\u0000" +
			"\u0000\u0004\u0018\u0001\u0000\u0000\u0000\u00068\u0001\u0000\u0000\u0000" +
			"\bK\u0001\u0000\u0000\u0000\nM\u0001\u0000\u0000\u0000\fR\u0001\u0000" +
			"\u0000\u0000\u000e\u000f\u0003\u0002\u0001\u0000\u000f\u0010\u0005\u0000" +
			"\u0000\u0001\u0010\u0001\u0001\u0000\u0000\u0000\u0011\u0014\u0003\u0004" +
			"\u0002\u0000\u0012\u0014\u0003\n\u0005\u0000\u0013\u0011\u0001\u0000\u0000" +
			"\u0000\u0013\u0012\u0001\u0000\u0000\u0000\u0014\u0017\u0001\u0000\u0000" +
			"\u0000\u0015\u0013\u0001\u0000\u0000\u0000\u0015\u0016\u0001\u0000\u0000" +
			"\u0000\u0016\u0003\u0001\u0000\u0000\u0000\u0017\u0015\u0001\u0000\u0000" +
			"\u0000\u0018\u0019\u0005\u0007\u0000\u0000\u0019\u001a\u0005\f\u0000\u0000" +
			"\u001a\u001b\u0005\t\u0000\u0000\u001b\u001c\u0003\u0006\u0003\u0000\u001c" +
			"\u0005\u0001\u0000\u0000\u0000\u001d\u001e\u0006\u0003\uffff\uffff\u0000" +
			"\u001e9\u0003\b\u0004\u0000\u001f9\u0003\f\u0006\u0000 !\u0005\u0001\u0000" +
			"\u0000!\"\u0003\u0006\u0003\u0000\"#\u0005\u0002\u0000\u0000#$\u0003\u0006" +
			"\u0003\u0000$%\u0005\u0003\u0000\u0000%9\u0001\u0000\u0000\u0000&\'\u0005" +
			"\u0001\u0000\u0000\'(\u0003\u0006\u0003\u0000()\u0005\u0004\u0000\u0000" +
			")*\u0003\u0006\u0003\u0000*+\u0005\u0003\u0000\u0000+9\u0001\u0000\u0000" +
			"\u0000,-\u0005\u0001\u0000\u0000-.\u0003\u0006\u0003\u0000./\u0005\u0005" +
			"\u0000\u0000/0\u0003\u0006\u0003\u000001\u0005\u0003\u0000\u000019\u0001" +
			"\u0000\u0000\u000023\u0005\u0001\u0000\u000034\u0003\u0006\u0003\u0000" +
			"45\u0005\u0006\u0000\u000056\u0003\u0006\u0003\u000067\u0005\u0003\u0000" +
			"\u000079\u0001\u0000\u0000\u00008\u001d\u0001\u0000\u0000\u00008\u001f" +
			"\u0001\u0000\u0000\u00008 \u0001\u0000\u0000\u00008&\u0001\u0000\u0000" +
			"\u00008,\u0001\u0000\u0000\u000082\u0001\u0000\u0000\u00009H\u0001\u0000" +
			"\u0000\u0000:;\n\u0007\u0000\u0000;<\u0005\u0002\u0000\u0000<G\u0003\u0006" +
			"\u0003\b=>\n\u0005\u0000\u0000>?\u0005\u0004\u0000\u0000?G\u0003\u0006" +
			"\u0003\u0006@A\n\u0003\u0000\u0000AB\u0005\u0005\u0000\u0000BG\u0003\u0006" +
			"\u0003\u0004CD\n\u0001\u0000\u0000DE\u0005\u0006\u0000\u0000EG\u0003\u0006" +
			"\u0003\u0002F:\u0001\u0000\u0000\u0000F=\u0001\u0000\u0000\u0000F@\u0001" +
			"\u0000\u0000\u0000FC\u0001\u0000\u0000\u0000GJ\u0001\u0000\u0000\u0000" +
			"HF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000I\u0007\u0001\u0000" +
			"\u0000\u0000JH\u0001\u0000\u0000\u0000KL\u0005\f\u0000\u0000L\t\u0001" +
			"\u0000\u0000\u0000MN\u0005\b\u0000\u0000NO\u0003\u0006\u0003\u0000O\u000b" +
			"\u0001\u0000\u0000\u0000PS\u0005\n\u0000\u0000QS\u0005\u000b\u0000\u0000" +
			"RP\u0001\u0000\u0000\u0000RQ\u0001\u0000\u0000\u0000S\r\u0001\u0000\u0000" +
			"\u0000\u0006\u0013\u00158FHR";
	public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}