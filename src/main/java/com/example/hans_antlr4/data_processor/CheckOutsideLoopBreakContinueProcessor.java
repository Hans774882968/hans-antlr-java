package com.example.hans_antlr4.data_processor;

import com.example.hans_antlr4.domain.statement.Block;
import com.example.hans_antlr4.domain.statement.Break;
import com.example.hans_antlr4.domain.statement.Continue;
import com.example.hans_antlr4.domain.statement.ExpressionStatement;
import com.example.hans_antlr4.domain.statement.IfStatement;
import com.example.hans_antlr4.domain.statement.PrintStatement;
import com.example.hans_antlr4.domain.statement.RangedForStatement;
import com.example.hans_antlr4.domain.statement.ReturnStatement;
import com.example.hans_antlr4.domain.statement.StandardForStatement;
import com.example.hans_antlr4.domain.statement.StatementAfterIf;
import com.example.hans_antlr4.domain.statement.VariableDeclaration;
import com.example.hans_antlr4.exception.BreakStatementOutsideLoopException;
import com.example.hans_antlr4.exception.ContinueStatementOutsideLoopException;

public class CheckOutsideLoopBreakContinueProcessor {
    public void check(Block block) {
        if (block == null) {
            return;
        }
        block.getStatements().forEach(stmt -> stmt.checkOutsideLoopBreakContinue(this));
    }

    public void check(Break breakStatement) {
        if (breakStatement == null) {
            return;
        }
        if (breakStatement.getNearestLoopStatement() == null) {
            throw new BreakStatementOutsideLoopException(breakStatement.getSourceLine());
        }
    }

    public void check(Continue continueStatement) {
        if (continueStatement == null) {
            return;
        }
        if (continueStatement.getNearestLoopStatement() == null) {
            throw new ContinueStatementOutsideLoopException(continueStatement.getSourceLine());
        }
    }

    public void check(ExpressionStatement expressionStatement) {

    }

    public void check(IfStatement ifStatement) {
        if (ifStatement == null) {
            return;
        }
        ifStatement.getTrueStatement().checkOutsideLoopBreakContinue(this);
        ifStatement.getFalseStatement().ifPresent(falseStatement -> {
            falseStatement.checkOutsideLoopBreakContinue(this);
        });
    }

    public void check(PrintStatement printStatement) {

    }

    public void check(RangedForStatement rangedForStatement) {
        if (rangedForStatement == null) {
            return;
        }
        rangedForStatement.getIteratorVariableStatement().checkOutsideLoopBreakContinue(this);
        rangedForStatement.getBodyStatement().checkOutsideLoopBreakContinue(this);
    }

    public void check(StatementAfterIf statementAfterIf) {
        if (statementAfterIf == null) {
            return;
        }
        statementAfterIf.getStatement().checkOutsideLoopBreakContinue(this);
    }

    public void check(VariableDeclaration variableDeclaration) {

    }

    public void check(StandardForStatement standardForStatement) {
        if (standardForStatement == null) {
            return;
        }
        standardForStatement.getStandardForInit().ifPresent(forInit -> {
            forInit.checkOutsideLoopBreakContinue(this);
        });
        standardForStatement.getBodyStatement().checkOutsideLoopBreakContinue(this);
        standardForStatement.getStandardForUpdate().ifPresent(forUpdate -> {
            forUpdate.checkOutsideLoopBreakContinue(this);
        });
    }

    public void check(ReturnStatement returnStatement) {

    }
}
