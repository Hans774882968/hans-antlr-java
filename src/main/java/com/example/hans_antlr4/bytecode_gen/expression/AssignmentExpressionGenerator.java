package com.example.hans_antlr4.bytecode_gen.expression;

import java.util.ArrayList;
import java.util.List;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.domain.expression.AssignmentExpression;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.global.AssignmentSign;
import com.example.hans_antlr4.domain.type.ClassType;
import com.example.hans_antlr4.domain.type.Type;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AssignmentExpressionGenerator implements Opcodes {
    private ExpressionGenerator parent;
    private MethodVisitor mv;

    public void generate(AssignmentExpression assignmentExpression) {
        Expression currentExpression = assignmentExpression;
        List<Integer> variableIndexes = new ArrayList<>();
        List<AssignmentSign> signs = new ArrayList<>();
        List<AssignmentExpression> assignmentExpressions = new ArrayList<>();
        while (currentExpression instanceof AssignmentExpression) {
            AssignmentExpression currentAssignmentExpression = (AssignmentExpression) currentExpression;
            int index = parent.getScope().getLocalVariableIndex(currentAssignmentExpression.getVariable().getVarName());
            variableIndexes.add(index);
            signs.add(currentAssignmentExpression.getSign());
            assignmentExpressions.add(currentAssignmentExpression);
            currentExpression = currentAssignmentExpression.getExpression();
        }

        for (int i = 0; i < variableIndexes.size(); i++) {
            AssignmentSign sign = signs.get(i);
            int variableIndex = variableIndexes.get(i);
            AssignmentExpression currentAssignmentExpression = assignmentExpressions.get(i);
            Type lhsType = currentAssignmentExpression.getLhsType();
            if (sign != AssignmentSign.ASSIGN) {
                mv.visitVarInsn(lhsType.getLoadVariableOpcode(), variableIndex);
                if (sign == AssignmentSign.POW) {
                    mv.visitInsn(lhsType.getToDoubleOpcode());
                }
            }
        }
        currentExpression.accept(parent);

        for (int i = variableIndexes.size() - 1; i >= 0; i--) {
            int variableIndex = variableIndexes.get(i);
            AssignmentSign sign = signs.get(i);
            AssignmentExpression currentAssignmentExpression = assignmentExpressions.get(i);
            Type lhsType = currentAssignmentExpression.getVariable().getType();
            Type rhsType = currentAssignmentExpression.getRhsType();

            if (sign == AssignmentSign.POW) {
                mv.visitInsn(rhsType.getToDoubleOpcode());
                ClassType owner = new ClassType("java.lang.Math");
                String fieldDescriptor = owner.getInternalName(); // "java/lang/Math"
                String descriptor = "(DD)D";
                mv.visitMethodInsn(INVOKESTATIC, fieldDescriptor, "pow", descriptor, false);
                mv.visitInsn(lhsType.getDoubleToThisTypeOpcode());
            }
            // TODO: 支持隐式类型转换
            if (sign == AssignmentSign.MUL) {
                mv.visitInsn(rhsType.getMultiplyOpcode());
            }
            if (sign == AssignmentSign.DIV) {
                mv.visitInsn(rhsType.getDivideOpcode());
            }
            if (sign == AssignmentSign.MOD) {
                mv.visitInsn(rhsType.getModOpcode());
            }
            if (sign == AssignmentSign.ADD) {
                mv.visitInsn(rhsType.getAddOpcode());
            }
            if (sign == AssignmentSign.MINUS) {
                mv.visitInsn(rhsType.getSubtractOpcode());
            }
            if (sign == AssignmentSign.SHL) {
                mv.visitInsn(rhsType.getShlOpcode());
            }
            if (sign == AssignmentSign.SHR) {
                mv.visitInsn(rhsType.getShrOpcode());
            }
            if (sign == AssignmentSign.UNSIGNED_SHR) {
                mv.visitInsn(rhsType.getUnsignedShrOpcode());
            }
            if (sign == AssignmentSign.AND) {
                mv.visitInsn(rhsType.getAndOpcode());
            }
            if (sign == AssignmentSign.XOR) {
                mv.visitInsn(rhsType.getXorOpcode());
            }
            if (sign == AssignmentSign.OR) {
                mv.visitInsn(rhsType.getOrOpcode());
            }

            if (i > 0 || (i == 0 && !assignmentExpression.notNecessaryToGenerateDupInstruction())) {
                mv.visitInsn(DUP);
            }
            mv.visitVarInsn(lhsType.getStoreVariableOpcode(), variableIndex);
        }
    }
}
