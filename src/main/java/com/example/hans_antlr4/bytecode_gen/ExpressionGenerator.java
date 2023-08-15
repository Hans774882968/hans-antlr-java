package com.example.hans_antlr4.bytecode_gen;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.expression.Value;
import com.example.hans_antlr4.domain.expression.VarReference;
import com.example.hans_antlr4.domain.scope.LocalVariable;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.domain.type.Type;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ExpressionGenerator implements Opcodes {
    private MethodVisitor mv;

    public void generate(Expression expression, Scope scope) {
        if (expression instanceof VarReference) {
            VarReference varReference = (VarReference) expression;
            generate(varReference, scope);
        }
        if (expression instanceof Value) {
            Value value = (Value) expression;
            generate(value, scope);
        }
    }

    public void generate(VarReference varReference, Scope scope) {
        String varName = varReference.getVarName();
        int index = scope.getLocalVariableIndex(varName);
        LocalVariable localVariable = scope.getLocalVariable(varName);
        Type type = localVariable.getType();
        if (type == BuiltInType.INT) {
            mv.visitVarInsn(ILOAD, index);
        } else if (type == BuiltInType.STRING) {
            mv.visitVarInsn(ALOAD, index);
        }
    }

    public void generate(Value value, Scope scope) {
        Type type = value.getType();
        String stringValue = value.getValue();
        if (type == BuiltInType.INT) {
            int intValue = Integer.parseInt(stringValue);
            mv.visitIntInsn(SIPUSH, intValue);
        } else if (type == BuiltInType.STRING) {
            mv.visitLdcInsn(stringValue);
        }
    }
}
