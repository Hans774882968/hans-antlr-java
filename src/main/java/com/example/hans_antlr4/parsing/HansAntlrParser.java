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
	public static final int T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, POW = 7, MULTIPLICATIVE = 8,
			ADDITIVE = 9, SHIFT = 10, RELATIONAL = 11, EQUALITY = 12, AND = 13, XOR = 14, OR = 15,
			VARIABLE = 16, PRINT = 17, EQUALS = 18, NUMBER = 19, STRING = 20, Identifier = 21,
			WS = 22, COMMENT = 23, LINE_COMMENT = 24;
	public static final int RULE_compilationUnit = 0, RULE_statements = 1, RULE_block = 2, RULE_statement = 3,
			RULE_variable = 4, RULE_ifStatement = 5, RULE_expression = 6, RULE_variableReference = 7,
			RULE_print = 8, RULE_value = 9;

	private static String[] makeRuleNames() {
		return new String[] {
				"compilationUnit", "statements", "block", "statement", "variable", "ifStatement",
				"expression", "variableReference", "print", "value"
		};
	}

	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
				null, "'{'", "'}'", "'if'", "'('", "')'", "'else'", "'**'", null, null,
				null, null, null, "'&'", "'^'", "'|'", "'var'", "'print'", "'='"
		};
	}

	private static final String[] _LITERAL_NAMES = makeLiteralNames();

	private static String[] makeSymbolicNames() {
		return new String[] {
				null, null, null, null, null, null, null, "POW", "MULTIPLICATIVE", "ADDITIVE",
				"SHIFT", "RELATIONAL", "EQUALITY", "AND", "XOR", "OR", "VARIABLE", "PRINT",
				"EQUALS", "NUMBER", "STRING", "Identifier", "WS", "COMMENT", "LINE_COMMENT"
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
				setState(20);
				statements();
				setState(21);
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
				setState(26);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 196618L) != 0)) {
					{
						{
							setState(23);
							statement();
						}
					}
					setState(28);
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
				setState(29);
				match(T__0);
				setState(30);
				statements();
				setState(31);
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class, 0);
		}

		public VariableContext variable() {
			return getRuleContext(VariableContext.class, 0);
		}

		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class, 0);
		}

		public PrintContext print() {
			return getRuleContext(PrintContext.class, 0);
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
			setState(37);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case T__0:
					enterOuterAlt(_localctx, 1); {
					setState(33);
					block();
				}
					break;
				case VARIABLE:
					enterOuterAlt(_localctx, 2); {
					setState(34);
					variable();
				}
					break;
				case T__2:
					enterOuterAlt(_localctx, 3); {
					setState(35);
					ifStatement();
				}
					break;
				case PRINT:
					enterOuterAlt(_localctx, 4); {
					setState(36);
					print();
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
				setState(39);
				match(VARIABLE);
				setState(40);
				match(Identifier);
				setState(41);
				match(EQUALS);
				setState(42);
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
		enterRule(_localctx, 10, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(44);
				match(T__2);
				setState(46);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 2, _ctx)) {
					case 1: {
						setState(45);
						match(T__3);
					}
						break;
				}
				setState(48);
				expression(0);
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == T__4) {
					{
						setState(49);
						match(T__4);
					}
				}

				setState(52);
				((IfStatementContext) _localctx).trueStatement = statement();
				setState(55);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 4, _ctx)) {
					case 1: {
						setState(53);
						match(T__5);
						setState(54);
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
	public static class ADDITIVEContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}

		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class, i);
		}

		public TerminalNode ADDITIVE() {
			return getToken(HansAntlrParser.ADDITIVE, 0);
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

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
				setState(114);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 5, _ctx)) {
					case 1: {
						_localctx = new VarReferenceContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;

						setState(58);
						variableReference();
					}
						break;
					case 2: {
						_localctx = new ValueExprContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(59);
						value();
					}
						break;
					case 3: {
						_localctx = new POWContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(60);
						match(T__3);
						setState(61);
						expression(0);
						setState(62);
						match(POW);
						setState(63);
						expression(0);
						setState(64);
						match(T__4);
					}
						break;
					case 4: {
						_localctx = new MULTIPLICATIVEContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(66);
						match(T__3);
						setState(67);
						expression(0);
						setState(68);
						match(MULTIPLICATIVE);
						setState(69);
						expression(0);
						setState(70);
						match(T__4);
					}
						break;
					case 5: {
						_localctx = new ADDITIVEContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(72);
						match(T__3);
						setState(73);
						expression(0);
						setState(74);
						match(ADDITIVE);
						setState(75);
						expression(0);
						setState(76);
						match(T__4);
					}
						break;
					case 6: {
						_localctx = new SHIFTContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(78);
						match(T__3);
						setState(79);
						expression(0);
						setState(80);
						match(SHIFT);
						setState(81);
						expression(0);
						setState(82);
						match(T__4);
					}
						break;
					case 7: {
						_localctx = new RELATIONALContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(84);
						match(T__3);
						setState(85);
						expression(0);
						setState(86);
						match(RELATIONAL);
						setState(87);
						expression(0);
						setState(88);
						match(T__4);
					}
						break;
					case 8: {
						_localctx = new EQUALITYContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(90);
						match(T__3);
						setState(91);
						expression(0);
						setState(92);
						match(EQUALITY);
						setState(93);
						expression(0);
						setState(94);
						match(T__4);
					}
						break;
					case 9: {
						_localctx = new ANDContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(96);
						match(T__3);
						setState(97);
						expression(0);
						setState(98);
						match(AND);
						setState(99);
						expression(0);
						setState(100);
						match(T__4);
					}
						break;
					case 10: {
						_localctx = new XORContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(102);
						match(T__3);
						setState(103);
						expression(0);
						setState(104);
						match(XOR);
						setState(105);
						expression(0);
						setState(106);
						match(T__4);
					}
						break;
					case 11: {
						_localctx = new ORContext(_localctx);
						_ctx = _localctx;
						_prevctx = _localctx;
						setState(108);
						match(T__3);
						setState(109);
						expression(0);
						setState(110);
						match(OR);
						setState(111);
						expression(0);
						setState(112);
						match(T__4);
					}
						break;
				}
				_ctx.stop = _input.LT(-1);
				setState(145);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input, 7, _ctx);
				while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
					if (_alt == 1) {
						if (_parseListeners != null)
							triggerExitRuleEvent();
						_prevctx = _localctx;
						{
							setState(143);
							_errHandler.sync(this);
							switch (getInterpreter().adaptivePredict(_input, 6, _ctx)) {
								case 1: {
									_localctx = new POWContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(116);
									if (!(precpred(_ctx, 17)))
										throw new FailedPredicateException(this, "precpred(_ctx, 17)");
									setState(117);
									match(POW);
									setState(118);
									expression(18);
								}
									break;
								case 2: {
									_localctx = new MULTIPLICATIVEContext(
											new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(119);
									if (!(precpred(_ctx, 15)))
										throw new FailedPredicateException(this, "precpred(_ctx, 15)");
									setState(120);
									match(MULTIPLICATIVE);
									setState(121);
									expression(16);
								}
									break;
								case 3: {
									_localctx = new ADDITIVEContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(122);
									if (!(precpred(_ctx, 13)))
										throw new FailedPredicateException(this, "precpred(_ctx, 13)");
									setState(123);
									match(ADDITIVE);
									setState(124);
									expression(14);
								}
									break;
								case 4: {
									_localctx = new SHIFTContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(125);
									if (!(precpred(_ctx, 11)))
										throw new FailedPredicateException(this, "precpred(_ctx, 11)");
									setState(126);
									match(SHIFT);
									setState(127);
									expression(12);
								}
									break;
								case 5: {
									_localctx = new RELATIONALContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(128);
									if (!(precpred(_ctx, 9)))
										throw new FailedPredicateException(this, "precpred(_ctx, 9)");
									setState(129);
									match(RELATIONAL);
									setState(130);
									expression(10);
								}
									break;
								case 6: {
									_localctx = new EQUALITYContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(131);
									if (!(precpred(_ctx, 7)))
										throw new FailedPredicateException(this, "precpred(_ctx, 7)");
									setState(132);
									match(EQUALITY);
									setState(133);
									expression(8);
								}
									break;
								case 7: {
									_localctx = new ANDContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(134);
									if (!(precpred(_ctx, 5)))
										throw new FailedPredicateException(this, "precpred(_ctx, 5)");
									setState(135);
									match(AND);
									setState(136);
									expression(6);
								}
									break;
								case 8: {
									_localctx = new XORContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(137);
									if (!(precpred(_ctx, 3)))
										throw new FailedPredicateException(this, "precpred(_ctx, 3)");
									setState(138);
									match(XOR);
									setState(139);
									expression(4);
								}
									break;
								case 9: {
									_localctx = new ORContext(new ExpressionContext(_parentctx, _parentState));
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(140);
									if (!(precpred(_ctx, 1)))
										throw new FailedPredicateException(this, "precpred(_ctx, 1)");
									setState(141);
									match(OR);
									setState(142);
									expression(2);
								}
									break;
							}
						}
					}
					setState(147);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 7, _ctx);
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
		enterRule(_localctx, 14, RULE_variableReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(148);
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
		enterRule(_localctx, 16, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(150);
				match(PRINT);
				setState(151);
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
		enterRule(_localctx, 18, RULE_value);
		try {
			setState(155);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case NUMBER:
					enterOuterAlt(_localctx, 1); {
					setState(153);
					((ValueContext) _localctx).op = match(NUMBER);
				}
					break;
				case STRING:
					enterOuterAlt(_localctx, 2); {
					setState(154);
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
			case 6:
				return expression_sempred((ExpressionContext) _localctx, predIndex);
		}
		return true;
	}

	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
			case 0:
				return precpred(_ctx, 17);
			case 1:
				return precpred(_ctx, 15);
			case 2:
				return precpred(_ctx, 13);
			case 3:
				return precpred(_ctx, 11);
			case 4:
				return precpred(_ctx, 9);
			case 5:
				return precpred(_ctx, 7);
			case 6:
				return precpred(_ctx, 5);
			case 7:
				return precpred(_ctx, 3);
			case 8:
				return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN = "\u0004\u0001\u0018\u009e\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"
			+
			"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004" +
			"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007" +
			"\u0002\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001\u0000\u0001" +
			"\u0001\u0005\u0001\u0019\b\u0001\n\u0001\f\u0001\u001c\t\u0001\u0001\u0002" +
			"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003" +
			"\u0001\u0003\u0003\u0003&\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004" +
			"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0003\u0005/\b\u0005" +
			"\u0001\u0005\u0001\u0005\u0003\u00053\b\u0005\u0001\u0005\u0001\u0005" +
			"\u0001\u0005\u0003\u00058\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006" +
			"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006" +
			"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006" +
			"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006" +
			"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006" +
			"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006" +
			"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006" +
			"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006" +
			"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006" +
			"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006" +
			"\u0003\u0006s\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006" +
			"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006" +
			"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006" +
			"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006" +
			"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006" +
			"\u0090\b\u0006\n\u0006\f\u0006\u0093\t\u0006\u0001\u0007\u0001\u0007\u0001" +
			"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0003\t\u009c\b\t\u0001\t\u0000\u0001" +
			"\f\n\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0000\u0000\u00ae" +
			"\u0000\u0014\u0001\u0000\u0000\u0000\u0002\u001a\u0001\u0000\u0000\u0000" +
			"\u0004\u001d\u0001\u0000\u0000\u0000\u0006%\u0001\u0000\u0000\u0000\b" +
			"\'\u0001\u0000\u0000\u0000\n,\u0001\u0000\u0000\u0000\fr\u0001\u0000\u0000" +
			"\u0000\u000e\u0094\u0001\u0000\u0000\u0000\u0010\u0096\u0001\u0000\u0000" +
			"\u0000\u0012\u009b\u0001\u0000\u0000\u0000\u0014\u0015\u0003\u0002\u0001" +
			"\u0000\u0015\u0016\u0005\u0000\u0000\u0001\u0016\u0001\u0001\u0000\u0000" +
			"\u0000\u0017\u0019\u0003\u0006\u0003\u0000\u0018\u0017\u0001\u0000\u0000" +
			"\u0000\u0019\u001c\u0001\u0000\u0000\u0000\u001a\u0018\u0001\u0000\u0000" +
			"\u0000\u001a\u001b\u0001\u0000\u0000\u0000\u001b\u0003\u0001\u0000\u0000" +
			"\u0000\u001c\u001a\u0001\u0000\u0000\u0000\u001d\u001e\u0005\u0001\u0000" +
			"\u0000\u001e\u001f\u0003\u0002\u0001\u0000\u001f \u0005\u0002\u0000\u0000" +
			" \u0005\u0001\u0000\u0000\u0000!&\u0003\u0004\u0002\u0000\"&\u0003\b\u0004" +
			"\u0000#&\u0003\n\u0005\u0000$&\u0003\u0010\b\u0000%!\u0001\u0000\u0000" +
			"\u0000%\"\u0001\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000%$\u0001\u0000" +
			"\u0000\u0000&\u0007\u0001\u0000\u0000\u0000\'(\u0005\u0010\u0000\u0000" +
			"()\u0005\u0015\u0000\u0000)*\u0005\u0012\u0000\u0000*+\u0003\f\u0006\u0000" +
			"+\t\u0001\u0000\u0000\u0000,.\u0005\u0003\u0000\u0000-/\u0005\u0004\u0000" +
			"\u0000.-\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000/0\u0001\u0000" +
			"\u0000\u000002\u0003\f\u0006\u000013\u0005\u0005\u0000\u000021\u0001\u0000" +
			"\u0000\u000023\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u000047\u0003" +
			"\u0006\u0003\u000056\u0005\u0006\u0000\u000068\u0003\u0006\u0003\u0000" +
			"75\u0001\u0000\u0000\u000078\u0001\u0000\u0000\u00008\u000b\u0001\u0000" +
			"\u0000\u00009:\u0006\u0006\uffff\uffff\u0000:s\u0003\u000e\u0007\u0000" +
			";s\u0003\u0012\t\u0000<=\u0005\u0004\u0000\u0000=>\u0003\f\u0006\u0000" +
			">?\u0005\u0007\u0000\u0000?@\u0003\f\u0006\u0000@A\u0005\u0005\u0000\u0000" +
			"As\u0001\u0000\u0000\u0000BC\u0005\u0004\u0000\u0000CD\u0003\f\u0006\u0000" +
			"DE\u0005\b\u0000\u0000EF\u0003\f\u0006\u0000FG\u0005\u0005\u0000\u0000" +
			"Gs\u0001\u0000\u0000\u0000HI\u0005\u0004\u0000\u0000IJ\u0003\f\u0006\u0000" +
			"JK\u0005\t\u0000\u0000KL\u0003\f\u0006\u0000LM\u0005\u0005\u0000\u0000" +
			"Ms\u0001\u0000\u0000\u0000NO\u0005\u0004\u0000\u0000OP\u0003\f\u0006\u0000" +
			"PQ\u0005\n\u0000\u0000QR\u0003\f\u0006\u0000RS\u0005\u0005\u0000\u0000" +
			"Ss\u0001\u0000\u0000\u0000TU\u0005\u0004\u0000\u0000UV\u0003\f\u0006\u0000" +
			"VW\u0005\u000b\u0000\u0000WX\u0003\f\u0006\u0000XY\u0005\u0005\u0000\u0000" +
			"Ys\u0001\u0000\u0000\u0000Z[\u0005\u0004\u0000\u0000[\\\u0003\f\u0006" +
			"\u0000\\]\u0005\f\u0000\u0000]^\u0003\f\u0006\u0000^_\u0005\u0005\u0000" +
			"\u0000_s\u0001\u0000\u0000\u0000`a\u0005\u0004\u0000\u0000ab\u0003\f\u0006" +
			"\u0000bc\u0005\r\u0000\u0000cd\u0003\f\u0006\u0000de\u0005\u0005\u0000" +
			"\u0000es\u0001\u0000\u0000\u0000fg\u0005\u0004\u0000\u0000gh\u0003\f\u0006" +
			"\u0000hi\u0005\u000e\u0000\u0000ij\u0003\f\u0006\u0000jk\u0005\u0005\u0000" +
			"\u0000ks\u0001\u0000\u0000\u0000lm\u0005\u0004\u0000\u0000mn\u0003\f\u0006" +
			"\u0000no\u0005\u000f\u0000\u0000op\u0003\f\u0006\u0000pq\u0005\u0005\u0000" +
			"\u0000qs\u0001\u0000\u0000\u0000r9\u0001\u0000\u0000\u0000r;\u0001\u0000" +
			"\u0000\u0000r<\u0001\u0000\u0000\u0000rB\u0001\u0000\u0000\u0000rH\u0001" +
			"\u0000\u0000\u0000rN\u0001\u0000\u0000\u0000rT\u0001\u0000\u0000\u0000" +
			"rZ\u0001\u0000\u0000\u0000r`\u0001\u0000\u0000\u0000rf\u0001\u0000\u0000" +
			"\u0000rl\u0001\u0000\u0000\u0000s\u0091\u0001\u0000\u0000\u0000tu\n\u0011" +
			"\u0000\u0000uv\u0005\u0007\u0000\u0000v\u0090\u0003\f\u0006\u0012wx\n" +
			"\u000f\u0000\u0000xy\u0005\b\u0000\u0000y\u0090\u0003\f\u0006\u0010z{" +
			"\n\r\u0000\u0000{|\u0005\t\u0000\u0000|\u0090\u0003\f\u0006\u000e}~\n" +
			"\u000b\u0000\u0000~\u007f\u0005\n\u0000\u0000\u007f\u0090\u0003\f\u0006" +
			"\f\u0080\u0081\n\t\u0000\u0000\u0081\u0082\u0005\u000b\u0000\u0000\u0082" +
			"\u0090\u0003\f\u0006\n\u0083\u0084\n\u0007\u0000\u0000\u0084\u0085\u0005" +
			"\f\u0000\u0000\u0085\u0090\u0003\f\u0006\b\u0086\u0087\n\u0005\u0000\u0000" +
			"\u0087\u0088\u0005\r\u0000\u0000\u0088\u0090\u0003\f\u0006\u0006\u0089" +
			"\u008a\n\u0003\u0000\u0000\u008a\u008b\u0005\u000e\u0000\u0000\u008b\u0090" +
			"\u0003\f\u0006\u0004\u008c\u008d\n\u0001\u0000\u0000\u008d\u008e\u0005" +
			"\u000f\u0000\u0000\u008e\u0090\u0003\f\u0006\u0002\u008ft\u0001\u0000" +
			"\u0000\u0000\u008fw\u0001\u0000\u0000\u0000\u008fz\u0001\u0000\u0000\u0000" +
			"\u008f}\u0001\u0000\u0000\u0000\u008f\u0080\u0001\u0000\u0000\u0000\u008f" +
			"\u0083\u0001\u0000\u0000\u0000\u008f\u0086\u0001\u0000\u0000\u0000\u008f" +
			"\u0089\u0001\u0000\u0000\u0000\u008f\u008c\u0001\u0000\u0000\u0000\u0090" +
			"\u0093\u0001\u0000\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0091" +
			"\u0092\u0001\u0000\u0000\u0000\u0092\r\u0001\u0000\u0000\u0000\u0093\u0091" +
			"\u0001\u0000\u0000\u0000\u0094\u0095\u0005\u0015\u0000\u0000\u0095\u000f" +
			"\u0001\u0000\u0000\u0000\u0096\u0097\u0005\u0011\u0000\u0000\u0097\u0098" +
			"\u0003\f\u0006\u0000\u0098\u0011\u0001\u0000\u0000\u0000\u0099\u009c\u0005" +
			"\u0013\u0000\u0000\u009a\u009c\u0005\u0014\u0000\u0000\u009b\u0099\u0001" +
			"\u0000\u0000\u0000\u009b\u009a\u0001\u0000\u0000\u0000\u009c\u0013\u0001" +
			"\u0000\u0000\u0000\t\u001a%.27r\u008f\u0091\u009b";
	public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}