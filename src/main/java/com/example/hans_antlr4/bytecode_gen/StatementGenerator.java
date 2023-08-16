package com.example.hans_antlr4.bytecode_gen;

import org.objectweb.asm.MethodVisitor;

import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.PrintStatement;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.statement.VariableDeclaration;

public class StatementGenerator {
    private MethodVisitor mv;
    private ExpressionGenerator expressionGenerator;
    private Scope scope;

    public StatementGenerator(MethodVisitor mv, Scope scope) {
        this.mv = mv;
        expressionGenerator = new ExpressionGenerator(mv, scope);
        this.scope = scope;
    }

    // TODO: 改成不同签名的方法
    public void generate(Statement expression) {
        if (expression instanceof PrintStatement) {
            PrintStatement printStatement = (PrintStatement) expression;
            new PrintStatementGenerator(scope).generate(mv, printStatement);
        }
        if (expression instanceof VariableDeclaration) {
            VariableDeclaration variableDeclaration = (VariableDeclaration) expression;
            new VariableDeclarationStatementGenerator(mv, scope).generate(variableDeclaration);
        }
        if (expression instanceof Expression) {
            ((Expression) expression).accept(expressionGenerator);
        }
    }
}
