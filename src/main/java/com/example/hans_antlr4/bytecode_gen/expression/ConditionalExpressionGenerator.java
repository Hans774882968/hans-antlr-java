package com.example.hans_antlr4.bytecode_gen.expression;

import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.MethodVisitor;

import com.example.hans_antlr4.domain.expression.ConditionalExpression;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.global.CompareSign;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.domain.type.Type;
import com.example.hans_antlr4.exception.SupportGenerateObjectsComparisonLaterException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ConditionalExpressionGenerator implements Opcodes {
    private ExpressionGenerator parent;
    private MethodVisitor mv;

    public void generate(ConditionalExpression conditionalExpression) {
        Expression leftExpression = conditionalExpression.getLeftExpression();
        Expression rightExpression = conditionalExpression.getRightExpression();
        CompareSign compareSign = conditionalExpression.getCompareSign();
        if (conditionalExpression.isPrimitiveComparison()) {
            generatePrimitivesComparison(conditionalExpression);
        } else {
            throw new SupportGenerateObjectsComparisonLaterException(leftExpression, rightExpression, compareSign);
        }
        Label endLabel = new Label();
        Label falseLabel = new Label();
        mv.visitJumpInsn(compareSign.getOppositeCompareSign().getOpcode(), falseLabel);
        mv.visitInsn(ICONST_1);
        mv.visitJumpInsn(GOTO, endLabel);
        mv.visitLabel(falseLabel);
        mv.visitInsn(ICONST_0);
        mv.visitLabel(endLabel);
    }

    private void generatePrimitivesComparison(ConditionalExpression conditionalExpression) {
        Expression leftExpression = conditionalExpression.getLeftExpression();
        Expression rightExpression = conditionalExpression.getRightExpression();
        CompareSign compareSign = conditionalExpression.getCompareSign();
        Type maxPriorityNumericType = conditionalExpression.getMaxPriorityNumericType();
        Type lhsType = leftExpression.getType();
        Type rhsType = rightExpression.getType();
        leftExpression.accept(parent);
        mv.visitInsn(lhsType.getToHigherPriorityNumericTypeOpcode(maxPriorityNumericType));
        rightExpression.accept(parent);
        mv.visitInsn(rhsType.getToHigherPriorityNumericTypeOpcode(maxPriorityNumericType));
        if (maxPriorityNumericType == BuiltInType.INT) {
            mv.visitInsn(ISUB);
        }
        if (maxPriorityNumericType == BuiltInType.LONG) {
            mv.visitInsn(LCMP);
        }
        if (maxPriorityNumericType == BuiltInType.FLOAT) {
            if (compareSign == CompareSign.LESS || compareSign == CompareSign.LESS_OR_EQUAL) {
                mv.visitInsn(FCMPG);
            } else {
                mv.visitInsn(FCMPL);
            }
        }
        if (maxPriorityNumericType == BuiltInType.DOUBLE) {
            if (compareSign == CompareSign.LESS || compareSign == CompareSign.LESS_OR_EQUAL) {
                mv.visitInsn(DCMPG);
            } else {
                mv.visitInsn(DCMPL);
            }
        }
    }
}
