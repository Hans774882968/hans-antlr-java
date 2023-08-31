package com.example.hans_antlr4.bytecode_gen.expression;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.expression.Shift;
import com.example.hans_antlr4.domain.type.Type;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ShiftExpressionGenerator implements Opcodes {
    private ExpressionGenerator parent;
    private MethodVisitor mv;

    public void evaluateShiftComponents(Shift shift) {
        Expression leftExpression = shift.getLeftExpression();
        Expression rightExpression = shift.getRightExpression();
        leftExpression.accept(parent);
        rightExpression.accept(parent);
        Type rightType = rightExpression.getType();
        mv.visitInsn(rightType.getToIntOpcode());
    }
}
