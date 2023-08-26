package com.example.hans_antlr4.data_processor;

import java.util.Optional;

import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.statement.Block;
import com.example.hans_antlr4.domain.statement.Break;
import com.example.hans_antlr4.domain.statement.Continue;
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

    public void processStatementTree(Block block, Statement parent, RangedForStatement nearestForStatement) {
        if (block == null) {
            return;
        }
        block.setParent(parent);
        block.getStatements().forEach(stmt -> stmt.processSubStatementTree(this, block, nearestForStatement));
    }

    public void processStatementTree(
            ExpressionStatement expressionStatement,
            Statement parent,
            RangedForStatement nearestForStatement) {
        if (expressionStatement == null) {
            return;
        }
        expressionStatement.setParent(parent);
        Expression expression = expressionStatement.getExpression();
        expression.processSubExpressionTree(expressionTreeProcessor, null, expressionStatement);
    }

    public void processStatementTree(IfStatement ifStatement, Statement parent,
            RangedForStatement nearestForStatement) {
        if (ifStatement == null) {
            return;
        }
        ifStatement.setParent(parent);
        ifStatement.getCondition().processSubExpressionTree(expressionTreeProcessor, null, ifStatement);
        ifStatement.getTrueStatement().processSubStatementTree(this, ifStatement, nearestForStatement);
        Optional<StatementAfterIf> falseStatement = ifStatement.getFalseStatement();
        if (falseStatement.isPresent()) {
            falseStatement.get().processSubStatementTree(this, ifStatement, nearestForStatement);
        }
    }

    public void processStatementTree(PrintStatement printStatement, Statement parent,
            RangedForStatement nearestForStatement) {
        if (printStatement == null) {
            return;
        }
        printStatement.setParent(parent);
        printStatement.getExpression().processSubExpressionTree(expressionTreeProcessor, null, printStatement);
    }

    public void processStatementTree(
            RangedForStatement rangedForStatement,
            Statement parent,
            RangedForStatement nearestForStatement) {
        if (rangedForStatement == null) {
            return;
        }
        rangedForStatement.setParent(parent);
        rangedForStatement.getIteratorVariableStatement().processSubStatementTree(
                this, rangedForStatement, rangedForStatement);
        rangedForStatement.getStartExpression().processSubExpressionTree(
                expressionTreeProcessor, null, rangedForStatement);
        rangedForStatement.getEndExpression().processSubExpressionTree(
                expressionTreeProcessor, null, rangedForStatement);
        Statement body = rangedForStatement.getBodyStatement();
        if (body != null) {
            body.processSubStatementTree(this, rangedForStatement, rangedForStatement);
        }
    }

    public void processStatementTree(
            StatementAfterIf statementAfterIf,
            Statement parent,
            RangedForStatement nearestForStatement) {
        if (statementAfterIf == null) {
            return;
        }
        statementAfterIf.setParent(parent);
        statementAfterIf.getStatement().processSubStatementTree(this, statementAfterIf, nearestForStatement);
    }

    public void processStatementTree(
            VariableDeclaration variableDeclaration,
            Statement parent,
            RangedForStatement nearestForStatement) {
        if (variableDeclaration == null) {
            return;
        }
        variableDeclaration.setParent(parent);
        variableDeclaration.getExpression().processSubExpressionTree(
                expressionTreeProcessor, null, variableDeclaration);
    }

    public void processStatementTree(Break breakStatement, Statement parent, RangedForStatement nearestForStatement) {
        if (breakStatement == null) {
            return;
        }
        breakStatement.setParent(parent);
        breakStatement.setNearestForStatement(nearestForStatement);
    }

    public void processStatementTree(Continue continueStatement, Statement parent,
            RangedForStatement nearestForStatement) {
        if (continueStatement == null) {
            return;
        }
        continueStatement.setParent(parent);
        continueStatement.setNearestForStatement(nearestForStatement);
    }
}
