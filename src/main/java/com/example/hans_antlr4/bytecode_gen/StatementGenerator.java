package com.example.hans_antlr4.bytecode_gen;

import org.objectweb.asm.MethodVisitor;

import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.Block;
import com.example.hans_antlr4.domain.statement.IfStatement;
import com.example.hans_antlr4.domain.statement.PrintStatement;
import com.example.hans_antlr4.domain.statement.StatementAfterIf;
import com.example.hans_antlr4.domain.statement.VariableDeclaration;

public class StatementGenerator {
    private MethodVisitor mv;
    private Scope scope;

    public StatementGenerator(MethodVisitor mv, Scope scope) {
        this.mv = mv;
        this.scope = scope;
    }

    public void generate(PrintStatement printStatement) {
        new PrintStatementGenerator(mv, scope).generate(printStatement);
    }

    public void generate(VariableDeclaration variableDeclaration) {
        new VariableDeclarationStatementGenerator(mv, scope).generate(variableDeclaration);
    }

    public void generate(Block block) {
        new BlockStatementGenerator(mv).generate(block);
    }

    public void generate(IfStatement ifStatement) {
        new IfStatementGenerator(mv, scope).generate(ifStatement);
    }

    public void generate(StatementAfterIf statementAfterIf) {
        StatementGenerator statementGenerator = new StatementGenerator(mv, scope);
        statementAfterIf.getStatement().accept(statementGenerator);
    }
}
