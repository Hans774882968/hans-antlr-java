package com.example.hans_antlr4.parsing.biz_visitor;

import java.util.ArrayDeque;
import java.util.Queue;

import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.scope.LocalVariable;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.PrintStatement;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.statement.VariableDeclaration;
import com.example.hans_antlr4.parsing.HansAntlrBaseVisitor;
import com.example.hans_antlr4.parsing.HansAntlrParser;
import com.example.hans_antlr4.parsing.HansAntlrParser.ExpressionContext;

import lombok.Data;
import lombok.EqualsAndHashCode;
// import lombok.extern.slf4j.Slf4j;

@EqualsAndHashCode(callSuper = false)
@Data
// @Slf4j
public class StatementVisitor extends HansAntlrBaseVisitor<Statement> {
    private Scope scope;
    private Queue<Statement> instructionsQueue = new ArrayDeque<>();

    public StatementVisitor(Scope scope) {
        super();
        this.scope = scope;
    }

    @Override
    public VariableDeclaration visitVariable(HansAntlrParser.VariableContext ctx) {
        final String varName = ctx.ID().getText();
        final ExpressionContext expressionContext = ctx.expression();
        final ExpressionVisitor expressionVisitor = new ExpressionVisitor(scope);
        Expression expression = expressionContext.accept(expressionVisitor);

        scope.addLocalVariable(new LocalVariable(varName, expression.getType()));
        VariableDeclaration variableDeclaration = new VariableDeclaration(varName, expression);
        instructionsQueue.add(variableDeclaration);

        return variableDeclaration;
    }

    @Override
    public PrintStatement visitPrint(HansAntlrParser.PrintContext ctx) {
        final ExpressionContext expressionContext = ctx.expression();
        final ExpressionVisitor expressionVisitor = new ExpressionVisitor(scope);
        Expression expression = expressionContext.accept(expressionVisitor);
        PrintStatement printStatement = new PrintStatement(expression);
        instructionsQueue.add(printStatement);
        return printStatement;
    }

    // private void logVariableDeclarationStatementFound(TerminalNode varName, Variable variable) {
    // final int line = varName.getSymbol().getLine();
    // log.info("OK: Define variable '{}' with type '{}' and value '{}' at line {}",
    // variable.getName(), variable.getVarType(), variable.getVarTextValue(), line);
    // }

    // private void logPrintStatementFound(TerminalNode varName, Variable variable) {
    // final int line = varName.getSymbol().getLine();
    // final String format = "OK: You instructed to print variable '{}' which has type '{}' value of '{}' at line {}";
    // log.info(format, variable.getVarIndex(), variable.getVarType(), variable.getVarTextValue(), line);
    // }
}
