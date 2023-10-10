package com.example.hans_antlr4.bytecode_gen.statement;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.var.GlobalVariableDeclaration;
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
        globalVariableDeclaration.getVarDefUnits().forEach(varDefUnit -> {
            Expression expression = varDefUnit.getExpression();
            expression.accept(expressionGenerator);
            String varName = varDefUnit.getName();
            Type type = expression.getType();
            String publicClassName = scope.getClassName();
            mv.visitFieldInsn(PUTSTATIC, publicClassName, varName, type.getDescriptor());
        });
    }
}
