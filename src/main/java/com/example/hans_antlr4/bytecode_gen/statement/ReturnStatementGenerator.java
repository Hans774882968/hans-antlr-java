package com.example.hans_antlr4.bytecode_gen.statement;

import org.objectweb.asm.MethodVisitor;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.ReturnStatement;
import com.example.hans_antlr4.domain.type.Type;

public class ReturnStatementGenerator {
    private MethodVisitor mv;
    private ExpressionGenerator expressionGenerator;

    public ReturnStatementGenerator(MethodVisitor mv, Scope scope) {
        this.mv = mv;
        this.expressionGenerator = new ExpressionGenerator(mv, scope);
    }

    public void generate(ReturnStatement returnStatement) {
        Expression expression = returnStatement.getExpression();
        Type type = expression.getType();
        expression.accept(expressionGenerator);
        mv.visitInsn(type.getReturnOpcode());
    }
}
