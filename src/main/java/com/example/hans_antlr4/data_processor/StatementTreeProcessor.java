package com.example.hans_antlr4.data_processor;

import java.util.Optional;

import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.statement.Block;
import com.example.hans_antlr4.domain.statement.ExpressionStatement;
import com.example.hans_antlr4.domain.statement.IfStatement;
import com.example.hans_antlr4.domain.statement.PrintStatement;
import com.example.hans_antlr4.domain.statement.RangedForStatement;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.statement.StatementAfterIf;
import com.example.hans_antlr4.domain.statement.VariableDeclaration;

public class StatementTreeProcessor {
    // 目前不允许 Expression 的 parent 为 Statement
    private ExpressionTreeProcessor expressionTreeProcessor;

    public StatementTreeProcessor() {
        this.expressionTreeProcessor = new ExpressionTreeProcessor();
    }

    public void processStatementTree(Block block, Statement parent) {
        if (block == null) {
            return;
        }
        block.setParent(parent);
        block.getStatements().forEach(stmt -> stmt.processSubStatementTree(this, block));
    }

    public void processStatementTree(ExpressionStatement expressionStatement, Statement parent) {
        if (expressionStatement == null) {
            return;
        }
        expressionStatement.setParent(parent);
        Expression expression = expressionStatement.getExpression();
        expression.processSubExpressionTree(expressionTreeProcessor, null);
    }

    public void processStatementTree(IfStatement ifStatement, Statement parent) {
        if (ifStatement == null) {
            return;
        }
        ifStatement.setParent(parent);
        ifStatement.getCondition().processSubExpressionTree(expressionTreeProcessor, null);
        ifStatement.getTrueStatement().processSubStatementTree(this, ifStatement);
        Optional<StatementAfterIf> falseStatement = ifStatement.getFalseStatement();
        if (falseStatement.isPresent()) {
            falseStatement.get().processSubStatementTree(this, ifStatement);
        }
    }

    public void processStatementTree(PrintStatement printStatement, Statement parent) {
        if (printStatement == null) {
            return;
        }
        printStatement.setParent(parent);
        printStatement.getExpression().processSubExpressionTree(expressionTreeProcessor, null);
    }

    public void processStatementTree(RangedForStatement rangedForStatement, Statement parent) {
        if (rangedForStatement == null) {
            return;
        }
        rangedForStatement.setParent(parent);
        rangedForStatement.getIteratorVariableStatement().processSubStatementTree(this, rangedForStatement);
        rangedForStatement.getStartExpression().processSubExpressionTree(expressionTreeProcessor, null);
        rangedForStatement.getEndExpression().processSubExpressionTree(expressionTreeProcessor, null);
        Statement body = rangedForStatement.getBodyStatement();
        if (body != null) {
            body.processSubStatementTree(this, rangedForStatement);
        }
    }

    public void processStatementTree(StatementAfterIf statementAfterIf, Statement parent) {
        if (statementAfterIf == null) {
            return;
        }
        statementAfterIf.setParent(parent);
        statementAfterIf.getStatement().processSubStatementTree(this, statementAfterIf);
    }

    public void processStatementTree(VariableDeclaration variableDeclaration, Statement parent) {
        if (variableDeclaration == null) {
            return;
        }
        variableDeclaration.setParent(parent);
        variableDeclaration.getExpression().processSubExpressionTree(expressionTreeProcessor, null);
    }
}
