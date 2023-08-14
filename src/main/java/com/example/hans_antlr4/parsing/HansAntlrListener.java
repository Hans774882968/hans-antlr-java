// Generated from src\main\java\com\example\hans_antlr4\HansAntlr.g by ANTLR 4.13.0

package com.example.hans_antlr4.parsing;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HansAntlrParser}.
 */
public interface HansAntlrListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HansAntlrParser#compilationUnit}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void enterCompilationUnit(HansAntlrParser.CompilationUnitContext ctx);

	/**
	 * Exit a parse tree produced by {@link HansAntlrParser#compilationUnit}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void exitCompilationUnit(HansAntlrParser.CompilationUnitContext ctx);

	/**
	 * Enter a parse tree produced by {@link HansAntlrParser#variable}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void enterVariable(HansAntlrParser.VariableContext ctx);

	/**
	 * Exit a parse tree produced by {@link HansAntlrParser#variable}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void exitVariable(HansAntlrParser.VariableContext ctx);

	/**
	 * Enter a parse tree produced by {@link HansAntlrParser#print}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void enterPrint(HansAntlrParser.PrintContext ctx);

	/**
	 * Exit a parse tree produced by {@link HansAntlrParser#print}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void exitPrint(HansAntlrParser.PrintContext ctx);

	/**
	 * Enter a parse tree produced by {@link HansAntlrParser#value}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void enterValue(HansAntlrParser.ValueContext ctx);

	/**
	 * Exit a parse tree produced by {@link HansAntlrParser#value}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void exitValue(HansAntlrParser.ValueContext ctx);
}