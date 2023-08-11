package com.example.antlr4_hello;

// Generated from src\main\java\com\example\antlr4_hello\Hello.g by ANTLR 4.13.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HelloParser}.
 */
public interface HelloListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HelloParser#s}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void enterS(HelloParser.SContext ctx);

	/**
	 * Exit a parse tree produced by {@link HelloParser#s}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void exitS(HelloParser.SContext ctx);
}