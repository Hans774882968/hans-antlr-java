package com.example.hans_antlr4.bytecode_gen.statement;

import org.objectweb.asm.MethodVisitor;

import com.example.hans_antlr4.domain.scope.Scope;
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
import com.example.hans_antlr4.domain.statement.var.GlobalVariableDeclaration;
import com.example.hans_antlr4.domain.statement.var.VariableDeclaration;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StatementGenerator {
    private MethodVisitor mv;
    private Scope scope;
    private boolean constantFolding;

    public void generate(PrintStatement printStatement) {
        new PrintStatementGenerator(mv, scope, constantFolding).generate(printStatement);
    }

    public void generate(VariableDeclaration variableDeclaration) {
        new VariableDeclarationStatementGenerator(mv, scope, constantFolding).generate(variableDeclaration);
    }

    public void generate(ReturnStatement returnStatement) {
        new ReturnStatementGenerator(mv, scope, constantFolding).generate(returnStatement);
    }

    public void generate(Block block) {
        new BlockStatementGenerator(mv, constantFolding).generate(block);
    }

    public void generate(IfStatement ifStatement) {
        new IfStatementGenerator(mv, scope, constantFolding).generate(ifStatement);
    }

    public void generate(StatementAfterIf statementAfterIf) {
        StatementGenerator statementGenerator = new StatementGenerator(mv, scope, constantFolding);
        statementAfterIf.getStatement().accept(statementGenerator);
    }

    public void generate(RangedForStatement rangedForStatement) {
        RangedForStatementGenerator rangedForStatementGenerator = new RangedForStatementGenerator(mv, constantFolding);
        rangedForStatementGenerator.generate(rangedForStatement);
    }

    public void generate(Break breakStatement) {
        BreakStatementGenerator breakStatementGenerator = new BreakStatementGenerator(mv);
        breakStatementGenerator.generate(breakStatement);
    }

    public void generate(Continue continueStatement) {
        ContinueStatementGenerator continueStatementGenerator = new ContinueStatementGenerator(mv);
        continueStatementGenerator.generate(continueStatement);
    }

    public void generate(StandardForStatement standardForStatement) {
        StandardForStatementGenerator standardForStatementGenerator = new StandardForStatementGenerator(
                mv, constantFolding);
        standardForStatementGenerator.generate(standardForStatement);
    }

    public void generate(ExpressionStatement expressionStatement) {
        new ExpressionStatementGenerator(mv, scope, constantFolding).generate(expressionStatement);
    }

    public void generate(GlobalVariableDeclaration globalVariableDeclaration) {
        new GlobalVariableDeclarationGenerator(mv, scope, constantFolding).generate(globalVariableDeclaration);
    }
}
