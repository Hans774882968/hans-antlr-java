package com.example.hans_antlr4.bytecode_gen;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.scope.LocalVariable;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.VariableDeclaration;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.domain.type.Type;

public class VariableDeclarationStatementGenerator implements Opcodes {
    private MethodVisitor mv;
    private Scope scope;
    private ExpressionGenerator expressionGenerator;

    VariableDeclarationStatementGenerator(MethodVisitor mv, Scope scope) {
        this.mv = mv;
        this.scope = scope;
        this.expressionGenerator = new ExpressionGenerator(mv, scope);
    }

    public void generate(VariableDeclaration variableDeclaration) {
        Expression expression = variableDeclaration.getExpression();
        String varName = variableDeclaration.getName();
        int index = scope.getLocalVariableIndex(varName);

        Type type = expression.getType();
        expression.accept(expressionGenerator);
        if (type == BuiltInType.INT) {
            mv.visitVarInsn(ISTORE, index);
        } else {
            mv.visitVarInsn(ASTORE, index);
        }

        scope.addLocalVariable(new LocalVariable(varName, expression.getType()));
    }
}
