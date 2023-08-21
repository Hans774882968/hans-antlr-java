// Generated from src\main\java\com\example\hans_antlr4\parsing\HansAntlr.g4 by ANTLR 4.13.0

package com.example.hans_antlr4.parsing;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link HansAntlrParser}.
 *
 * @param <T>
 *            The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface HansAntlrVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link HansAntlrParser#compilationUnit}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(HansAntlrParser.CompilationUnitContext ctx);

	/**
	 * Visit a parse tree produced by {@link HansAntlrParser#statements}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitStatements(HansAntlrParser.StatementsContext ctx);

	/**
	 * Visit a parse tree produced by {@link HansAntlrParser#block}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitBlock(HansAntlrParser.BlockContext ctx);

	/**
	 * Visit a parse tree produced by {@link HansAntlrParser#statement}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitStatement(HansAntlrParser.StatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link HansAntlrParser#variable}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitVariable(HansAntlrParser.VariableContext ctx);

	/**
	 * Visit a parse tree produced by {@link HansAntlrParser#ifStatement}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(HansAntlrParser.IfStatementContext ctx);

	/**
	 * Visit a parse tree produced by the {@code RELATIONAL}
	 * labeled alternative in {@link HansAntlrParser#expression}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitRELATIONAL(HansAntlrParser.RELATIONALContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ValueExpr}
	 * labeled alternative in {@link HansAntlrParser#expression}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitValueExpr(HansAntlrParser.ValueExprContext ctx);

	/**
	 * Visit a parse tree produced by the {@code OR}
	 * labeled alternative in {@link HansAntlrParser#expression}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitOR(HansAntlrParser.ORContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ADDITIVE}
	 * labeled alternative in {@link HansAntlrParser#expression}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitADDITIVE(HansAntlrParser.ADDITIVEContext ctx);

	/**
	 * Visit a parse tree produced by the {@code SHIFT}
	 * labeled alternative in {@link HansAntlrParser#expression}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitSHIFT(HansAntlrParser.SHIFTContext ctx);

	/**
	 * Visit a parse tree produced by the {@code VarReference}
	 * labeled alternative in {@link HansAntlrParser#expression}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitVarReference(HansAntlrParser.VarReferenceContext ctx);

	/**
	 * Visit a parse tree produced by the {@code BRACKET}
	 * labeled alternative in {@link HansAntlrParser#expression}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitBRACKET(HansAntlrParser.BRACKETContext ctx);

	/**
	 * Visit a parse tree produced by the {@code MULTIPLICATIVE}
	 * labeled alternative in {@link HansAntlrParser#expression}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitMULTIPLICATIVE(HansAntlrParser.MULTIPLICATIVEContext ctx);

	/**
	 * Visit a parse tree produced by the {@code EQUALITY}
	 * labeled alternative in {@link HansAntlrParser#expression}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitEQUALITY(HansAntlrParser.EQUALITYContext ctx);

	/**
	 * Visit a parse tree produced by the {@code AND}
	 * labeled alternative in {@link HansAntlrParser#expression}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitAND(HansAntlrParser.ANDContext ctx);

	/**
	 * Visit a parse tree produced by the {@code POW}
	 * labeled alternative in {@link HansAntlrParser#expression}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitPOW(HansAntlrParser.POWContext ctx);

	/**
	 * Visit a parse tree produced by the {@code XOR}
	 * labeled alternative in {@link HansAntlrParser#expression}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitXOR(HansAntlrParser.XORContext ctx);

	/**
	 * Visit a parse tree produced by the {@code UNARY}
	 * labeled alternative in {@link HansAntlrParser#expression}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitUNARY(HansAntlrParser.UNARYContext ctx);

	/**
	 * Visit a parse tree produced by {@link HansAntlrParser#variableReference}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitVariableReference(HansAntlrParser.VariableReferenceContext ctx);

	/**
	 * Visit a parse tree produced by {@link HansAntlrParser#print}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitPrint(HansAntlrParser.PrintContext ctx);

	/**
	 * Visit a parse tree produced by {@link HansAntlrParser#value}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitValue(HansAntlrParser.ValueContext ctx);
}