package com.example.hans_antlr4.parsing.biz_visitor;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

import org.antlr.v4.runtime.tree.TerminalNode;

import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.scope.LocalVariable;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.Block;
import com.example.hans_antlr4.domain.statement.ExpressionStatement;
import com.example.hans_antlr4.domain.statement.IfStatement;
import com.example.hans_antlr4.domain.statement.PrintStatement;
import com.example.hans_antlr4.domain.statement.RangedForStatement;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.statement.StatementAfterIf;
import com.example.hans_antlr4.domain.statement.VariableDeclaration;
import com.example.hans_antlr4.exception.SupportAssignmentLaterException;
import com.example.hans_antlr4.parsing.HansAntlrBaseVisitor;
import com.example.hans_antlr4.parsing.HansAntlrParser;
import com.example.hans_antlr4.parsing.HansAntlrParser.ExpressionContext;
import com.example.hans_antlr4.parsing.HansAntlrParser.RangedForConditionsContext;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@EqualsAndHashCode(callSuper = false)
@Data
@Slf4j
public class StatementVisitor extends HansAntlrBaseVisitor<Statement> {
    private Scope scope;
    private Queue<Statement> instructionsQueue = new ArrayDeque<>();

    public StatementVisitor(Scope scope) {
        super();
        this.scope = scope;
    }

    @Override
    public VariableDeclaration visitVariable(HansAntlrParser.VariableContext ctx) {
        final TerminalNode varTerminalNode = ctx.Identifier();
        final String varName = varTerminalNode.getText();
        final ExpressionContext expressionContext = ctx.expression();
        final ExpressionVisitor expressionVisitor = new ExpressionVisitor(scope);
        Expression expression = expressionContext.accept(expressionVisitor);

        scope.addLocalVariable(new LocalVariable(varName, expression.getType()));
        VariableDeclaration variableDeclaration = new VariableDeclaration(varName, expression);
        instructionsQueue.add(variableDeclaration);

        logVariableDeclarationStatementFound(varTerminalNode, expression);

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

    private void logVariableDeclarationStatementFound(TerminalNode varTerminalNode, Expression expression) {
        final int line = varTerminalNode.getSymbol().getLine();
        log.info("OK: Define variable '{}' with type '{}' at line {}",
                varTerminalNode.getText(), expression.getType(), line);
    }

    @Override
    public ExpressionStatement visitExpressionStatement(HansAntlrParser.ExpressionStatementContext ctx) {
        final ExpressionContext expressionContext = ctx.expression();
        final ExpressionVisitor expressionVisitor = new ExpressionVisitor(scope);
        Expression expression = expressionContext.accept(expressionVisitor);
        ExpressionStatement expressionStatement = new ExpressionStatement(expression);
        instructionsQueue.add(expressionStatement);
        return expressionStatement;
    }

    @Override
    public Block visitBlock(HansAntlrParser.BlockContext ctx) {
        Scope newScope = new Scope(scope);
        StatementsVisitor statementsVisitor = new StatementsVisitor(newScope);
        List<Statement> statements = ctx.statements().accept(statementsVisitor);
        Block block = new Block(statements, newScope);
        instructionsQueue.add(block);
        return block;
    }

    @Override
    public IfStatement visitIfStatement(HansAntlrParser.IfStatementContext ctx) {
        final ExpressionContext conditionalExpressionContext = ctx.expression();
        final ExpressionVisitor expressionVisitor = new ExpressionVisitor(scope);
        final Expression condition = conditionalExpressionContext.accept(expressionVisitor);
        // if 的两个语句应该各自新开作用域
        Scope newTrueScope = new Scope(scope);
        final StatementVisitor trueStatementVisitor = new StatementVisitor(newTrueScope);
        final Statement trueStatement = ctx.trueStatement.accept(trueStatementVisitor);
        final StatementAfterIf trueStatementAfterIf = new StatementAfterIf(newTrueScope, trueStatement);
        if (ctx.falseStatement == null) {
            IfStatement ifStatementResult = new IfStatement(condition, trueStatementAfterIf);
            instructionsQueue.add(ifStatementResult);
            return ifStatementResult;
        }
        Scope newFalseScope = new Scope(scope);
        final StatementVisitor falseStatementVisitor = new StatementVisitor(newFalseScope);
        final Statement falseStatement = ctx.falseStatement.accept(falseStatementVisitor);
        final StatementAfterIf falseStatementAfterIf = new StatementAfterIf(newFalseScope, falseStatement);
        IfStatement ifStatementResult = new IfStatement(condition, trueStatementAfterIf, falseStatementAfterIf);
        instructionsQueue.add(ifStatementResult);
        return ifStatementResult;
    }

    @Override
    public RangedForStatement visitForStatement(HansAntlrParser.ForStatementContext ctx) {
        Scope newScope = new Scope(scope);
        final RangedForConditionsContext rangedForConditionsContext = ctx.rangedForConditions();
        final ExpressionVisitor expressionVisitor = new ExpressionVisitor(newScope);
        final String iteratorVarName = rangedForConditionsContext.variableReference().getText();
        final Expression startExpr = rangedForConditionsContext.startExpr.accept(expressionVisitor);
        final Expression endExpr = rangedForConditionsContext.endExpr.accept(expressionVisitor);
        final StatementVisitor statementVisitor = new StatementVisitor(newScope);
        // TODO: 实现赋值表达式后再修改这里
        if (newScope.localVariableExists(iteratorVarName)) {
            throw new SupportAssignmentLaterException();
        }
        newScope.addLocalVariable(new LocalVariable(iteratorVarName, startExpr.getType()));
        Statement iteratorVariableStatement = new VariableDeclaration(iteratorVarName, startExpr);
        Statement statement = ctx.statement().accept(statementVisitor);

        RangedForStatement rangedForStatement = new RangedForStatement(
                iteratorVariableStatement, iteratorVarName, startExpr, endExpr, statement, newScope);
        instructionsQueue.add(rangedForStatement);
        return rangedForStatement;
    }
}
