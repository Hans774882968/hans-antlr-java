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
	 * Visit a parse tree produced by {@link HansAntlrParser#functions}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitFunctions(HansAntlrParser.FunctionsContext ctx);

	/**
	 * Visit a parse tree produced by {@link HansAntlrParser#function}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitFunction(HansAntlrParser.FunctionContext ctx);

	/**
	 * Visit a parse tree produced by {@link HansAntlrParser#functionDeclaration}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(HansAntlrParser.FunctionDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link HansAntlrParser#functionName}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(HansAntlrParser.FunctionNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link HansAntlrParser#functionParameterList}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParameterList(HansAntlrParser.FunctionParameterListContext ctx);

	/**
	 * Visit a parse tree produced by {@link HansAntlrParser#functionParameter}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParameter(HansAntlrParser.FunctionParameterContext ctx);

	/**
	 * Visit a parse tree produced by {@link HansAntlrParser#type}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitType(HansAntlrParser.TypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link HansAntlrParser#primitiveType}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(HansAntlrParser.PrimitiveTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link HansAntlrParser#classType}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitClassType(HansAntlrParser.ClassTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link HansAntlrParser#qualifiedName}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedName(HansAntlrParser.QualifiedNameContext ctx);

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
	 * Visit a parse tree produced by the {@code ReturnWithValue}
	 * labeled alternative in {@link HansAntlrParser#returnStatement}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitReturnWithValue(HansAntlrParser.ReturnWithValueContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ReturnVoid}
	 * labeled alternative in {@link HansAntlrParser#returnStatement}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitReturnVoid(HansAntlrParser.ReturnVoidContext ctx);

	/**
	 * Visit a parse tree produced by {@link HansAntlrParser#expressionStatement}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(HansAntlrParser.ExpressionStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link HansAntlrParser#ifStatement}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(HansAntlrParser.IfStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link HansAntlrParser#rangedForStatement}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitRangedForStatement(HansAntlrParser.RangedForStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link HansAntlrParser#rangedForConditions}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitRangedForConditions(HansAntlrParser.RangedForConditionsContext ctx);

	/**
	 * Visit a parse tree produced by {@link HansAntlrParser#standardForStatement}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitStandardForStatement(HansAntlrParser.StandardForStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link HansAntlrParser#standardForInit}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitStandardForInit(HansAntlrParser.StandardForInitContext ctx);

	/**
	 * Visit a parse tree produced by {@link HansAntlrParser#standardForUpdate}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitStandardForUpdate(HansAntlrParser.StandardForUpdateContext ctx);

	/**
	 * Visit a parse tree produced by {@link HansAntlrParser#breakStatement}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(HansAntlrParser.BreakStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link HansAntlrParser#continueStatement}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(HansAntlrParser.ContinueStatementContext ctx);

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
	 * Visit a parse tree produced by the {@code ASSIGNMENT}
	 * labeled alternative in {@link HansAntlrParser#expression}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitASSIGNMENT(HansAntlrParser.ASSIGNMENTContext ctx);

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
	 * Visit a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link HansAntlrParser#expression}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(HansAntlrParser.FunctionCallContext ctx);

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
	 * Visit a parse tree produced by {@link HansAntlrParser#funcCall}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall(HansAntlrParser.FuncCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link HansAntlrParser#argumentList}.
	 * 
	 * @param ctx
	 *            the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(HansAntlrParser.ArgumentListContext ctx);

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