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