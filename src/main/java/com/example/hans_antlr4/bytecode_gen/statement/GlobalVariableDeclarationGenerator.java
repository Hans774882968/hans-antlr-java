package com.example.hans_antlr4.bytecode_gen.statement;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.GlobalVariableDeclaration;
import com.example.hans_antlr4.domain.type.Type;

import lombok.Getter;

@Getter
public class GlobalVariableDeclarationGenerator implements Opcodes {
    private MethodVisitor mv;
    private Scope scope;
    private ExpressionGenerator expressionGenerator;

    public GlobalVariableDeclarationGenerator(MethodVisitor mv, Scope scope) {
        this.mv = mv;
        this.scope = scope;
        this.expressionGenerator = new ExpressionGenerator(mv, scope);
    }

    public void generate(GlobalVariableDeclaration globalVariableDeclaration) {
        Expression expression = globalVariableDeclaration.getExpression();
        expression.accept(expressionGenerator);
        String varName = globalVariableDeclaration.getName();
        Type type = expression.getType();
        String publicClassName = scope.getMetaData().getClassName();
        mv.visitFieldInsn(PUTSTATIC, publicClassName, varName, type.getDescriptor());
    }
}
