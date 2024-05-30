package com.example.hans_antlr4.bytecode_gen.statement;

import org.objectweb.asm.MethodVisitor;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.ExpressionStatement;

import lombok.Getter;

@Getter
public class ExpressionStatementGenerator {
    private MethodVisitor mv;
    private Scope scope;
    private ExpressionGenerator expressionGenerator;

    public ExpressionStatementGenerator(MethodVisitor mv, Scope scope, boolean constantFolding) {
        this.mv = mv;
        this.scope = scope;
        this.expressionGenerator = new ExpressionGenerator(mv, scope, constantFolding);
    }

    public void generate(ExpressionStatement expressionStatement) {
        expressionStatement.getExpression().accept(expressionGenerator);
    }
}
