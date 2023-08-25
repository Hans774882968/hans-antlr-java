package com.example.hans_antlr4.bytecode_gen.expression;

import java.util.ArrayList;
import java.util.List;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.domain.expression.AssignmentExpression;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.global.AssignmentSign;
import com.example.hans_antlr4.domain.type.ClassType;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AssignmentExpressionGenerator implements Opcodes {
    private ExpressionGenerator parent;
    private MethodVisitor mv;

    public void generate(AssignmentExpression assignmentExpression) {
        Expression currentExpression = assignmentExpression;
        List<Integer> variableIndexes = new ArrayList<>();
        List<AssignmentSign> signs = new ArrayList<>();
        while (currentExpression instanceof AssignmentExpression) {
            AssignmentExpression currentAssignmentExpression = (AssignmentExpression) currentExpression;
            int index = parent.getScope().getLocalVariableIndex(currentAssignmentExpression.getVarName());
            variableIndexes.add(index);
            signs.add(currentAssignmentExpression.getSign());
            currentExpression = currentAssignmentExpression.getExpression();
        }

        for (int i = 0; i < variableIndexes.size(); i++) {
            AssignmentSign sign = signs.get(i);
            int variableIndex = variableIndexes.get(i);
            if (sign != AssignmentSign.ASSIGN) {
                mv.visitVarInsn(ILOAD, variableIndex);
                if (sign == AssignmentSign.POW) {
                    mv.visitInsn(I2D);
                }
            }
        }
        currentExpression.accept(parent);

        for (int i = variableIndexes.size() - 1; i >= 0; i--) {
            int variableIndex = variableIndexes.get(i);
            AssignmentSign sign = signs.get(i);

            if (sign == AssignmentSign.POW) {
                mv.visitInsn(I2D);
                ClassType owner = new ClassType("java.lang.Math");
                String fieldDescriptor = owner.getInternalName(); // "java/lang/Math"
                String descriptor = "(DD)D";
                mv.visitMethodInsn(INVOKESTATIC, fieldDescriptor, "pow", descriptor, false);
                mv.visitInsn(D2I);
            }
            if (sign == AssignmentSign.MUL) {
                mv.visitInsn(IMUL);
            }
            if (sign == AssignmentSign.DIV) {
                mv.visitInsn(IDIV);
            }
            if (sign == AssignmentSign.MOD) {
                mv.visitInsn(IREM);
            }
            if (sign == AssignmentSign.ADD) {
                mv.visitInsn(IADD);
            }
            if (sign == AssignmentSign.MINUS) {
                mv.visitInsn(ISUB);
            }
            if (sign == AssignmentSign.SHL) {
                mv.visitInsn(ISHL);
            }
            if (sign == AssignmentSign.SHR) {
                mv.visitInsn(ISHR);
            }
            if (sign == AssignmentSign.UNSIGNED_SHR) {
                mv.visitInsn(IUSHR);
            }
            if (sign == AssignmentSign.AND) {
                mv.visitInsn(IAND);
            }
            if (sign == AssignmentSign.XOR) {
                mv.visitInsn(IXOR);
            }
            if (sign == AssignmentSign.OR) {
                mv.visitInsn(IOR);
            }

            if (i > 0 || (i == 0 && !assignmentExpression.notNecessaryToGenerateDupInstruction())) {
                mv.visitInsn(DUP);
            }
            mv.visitVarInsn(ISTORE, variableIndex);
        }
    }
}
