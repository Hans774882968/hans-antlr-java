// Generated from src\main\java\com\example\hans_antlr4\parsing\HansAntlr.g by ANTLR 4.13.0

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
	 * Visit a parse tree produced by {@link HansAntlrParser#variable}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitVariable(HansAntlrParser.VariableContext ctx);

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
	 * Visit a parse tree produced by the {@code ADD}
	 * labeled alternative in {@link HansAntlrParser#expression}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitADD(HansAntlrParser.ADDContext ctx);

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
	 * Visit a parse tree produced by the {@code POW}
	 * labeled alternative in {@link HansAntlrParser#expression}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitPOW(HansAntlrParser.POWContext ctx);

	/**
	 * Visit a parse tree produced by the {@code MULTIPLY}
	 * labeled alternative in {@link HansAntlrParser#expression}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitMULTIPLY(HansAntlrParser.MULTIPLYContext ctx);

	/**
	 * Visit a parse tree produced by the {@code SUBTRACT}
	 * labeled alternative in {@link HansAntlrParser#expression}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitSUBTRACT(HansAntlrParser.SUBTRACTContext ctx);

	/**
	 * Visit a parse tree produced by the {@code DIVIDE}
	 * labeled alternative in {@link HansAntlrParser#expression}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitDIVIDE(HansAntlrParser.DIVIDEContext ctx);

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