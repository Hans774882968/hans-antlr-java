package com.example.hans_antlr4.bytecode_gen;

import org.apache.commons.lang3.StringUtils;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.expression.Value;
import com.example.hans_antlr4.domain.scope.LocalVariable;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.statement.VariableDeclaration;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.domain.type.Type;

public class VariableDeclarationStatementGenerator implements Opcodes {
    public void generate(MethodVisitor mv, VariableDeclaration variableDeclaration, Scope scope) {
        Expression expression = variableDeclaration.getExpression();
        String varName = variableDeclaration.getName();
        int index = scope.getLocalVariableIndex(varName);

        if (expression instanceof Value) {
            Value value = (Value) expression;
            Type type = value.getType();
            String stringValue = value.getValue();
            if (type == BuiltInType.INT) {
                int val = Integer.parseInt(stringValue);
                mv.visitIntInsn(SIPUSH, val);
                mv.visitVarInsn(ISTORE, index);
            } else if (type == BuiltInType.STRING) {
                stringValue = StringUtils.removeStart(stringValue, "\"");
                stringValue = StringUtils.removeEnd(stringValue, "\"");
                mv.visitLdcInsn(stringValue);
                mv.visitVarInsn(ASTORE, index);
            }
        }

        scope.addLocalVariable(new LocalVariable(varName, expression.getType()));
    }
}
