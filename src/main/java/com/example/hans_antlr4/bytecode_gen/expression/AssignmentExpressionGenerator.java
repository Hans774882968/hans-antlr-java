package com.example.hans_antlr4.bytecode_gen.expression;

import java.util.ArrayList;
import java.util.List;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.domain.expression.AssignmentExpression;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.global.AssignmentSign;
import com.example.hans_antlr4.domain.type.BuiltInType;
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
            Type maxPriorityNumericType = currentAssignmentExpression.getMaxPriorityNumericType();
            if (sign != AssignmentSign.ASSIGN) {
                mv.visitVarInsn(lhsType.getLoadVariableOpcode(), variableIndex);
                if (sign == AssignmentSign.POW) {
                    mv.visitInsn(lhsType.getToDoubleOpcode());
                } else if (!sign.isShiftSign()) {
                    mv.visitInsn(lhsType.getToHigherPriorityNumericTypeOpcode(maxPriorityNumericType));
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
                // **= 把运算结果的 double 强转为 LHS
                mv.visitInsn(lhsType.getDoubleToThisTypeOpcode());
            }
            if (sign == AssignmentSign.MUL) {
                Type maxPriorityNumericType = currentAssignmentExpression.getMaxPriorityNumericType();
                mv.visitInsn(rhsType.getToHigherPriorityNumericTypeOpcode(maxPriorityNumericType));
                mv.visitInsn(maxPriorityNumericType.getMultiplyOpcode());
                mv.visitInsn(maxPriorityNumericType.getToOtherNumericTypeOpcode(lhsType));
            }
            if (sign == AssignmentSign.DIV) {
                Type maxPriorityNumericType = currentAssignmentExpression.getMaxPriorityNumericType();
                mv.visitInsn(rhsType.getToHigherPriorityNumericTypeOpcode(maxPriorityNumericType));
                mv.visitInsn(maxPriorityNumericType.getDivideOpcode());
                mv.visitInsn(maxPriorityNumericType.getToOtherNumericTypeOpcode(lhsType));
            }
            if (sign == AssignmentSign.MOD) {
                Type maxPriorityNumericType = currentAssignmentExpression.getMaxPriorityNumericType();
                mv.visitInsn(rhsType.getToHigherPriorityNumericTypeOpcode(maxPriorityNumericType));
                mv.visitInsn(maxPriorityNumericType.getModOpcode());
                mv.visitInsn(maxPriorityNumericType.getToOtherNumericTypeOpcode(lhsType));
            }
            if (sign == AssignmentSign.ADD) {
                if (lhsType == BuiltInType.STRING) {
                    new StringAppendGenerator(parent, mv).generate(currentAssignmentExpression);
                } else {
                    Type maxPriorityNumericType = currentAssignmentExpression.getMaxPriorityNumericType();
                    mv.visitInsn(rhsType.getToHigherPriorityNumericTypeOpcode(maxPriorityNumericType));
                    mv.visitInsn(maxPriorityNumericType.getAddOpcode());
                    mv.visitInsn(maxPriorityNumericType.getToOtherNumericTypeOpcode(lhsType));
                }
            }
            if (sign == AssignmentSign.MINUS) {
                Type maxPriorityNumericType = currentAssignmentExpression.getMaxPriorityNumericType();
                mv.visitInsn(rhsType.getToHigherPriorityNumericTypeOpcode(maxPriorityNumericType));
                mv.visitInsn(maxPriorityNumericType.getSubtractOpcode());
                mv.visitInsn(maxPriorityNumericType.getToOtherNumericTypeOpcode(lhsType));
            }
            if (sign == AssignmentSign.SHL) {
                mv.visitInsn(rhsType.getToIntOpcode());
                mv.visitInsn(lhsType.getShlOpcode());
            }
            if (sign == AssignmentSign.SHR) {
                mv.visitInsn(rhsType.getToIntOpcode());
                mv.visitInsn(lhsType.getShrOpcode());
            }
            if (sign == AssignmentSign.UNSIGNED_SHR) {
                mv.visitInsn(rhsType.getToIntOpcode());
                mv.visitInsn(lhsType.getUnsignedShrOpcode());
            }
            if (sign == AssignmentSign.AND) {
                Type maxPriorityNumericType = currentAssignmentExpression.getMaxPriorityNumericType();
                mv.visitInsn(rhsType.getToHigherPriorityNumericTypeOpcode(maxPriorityNumericType));
                mv.visitInsn(maxPriorityNumericType.getAndOpcode());
                mv.visitInsn(maxPriorityNumericType.getToOtherNumericTypeOpcode(lhsType));
            }
            if (sign == AssignmentSign.XOR) {
                Type maxPriorityNumericType = currentAssignmentExpression.getMaxPriorityNumericType();
                mv.visitInsn(rhsType.getToHigherPriorityNumericTypeOpcode(maxPriorityNumericType));
                mv.visitInsn(maxPriorityNumericType.getXorOpcode());
                mv.visitInsn(maxPriorityNumericType.getToOtherNumericTypeOpcode(lhsType));
            }
            if (sign == AssignmentSign.OR) {
                Type maxPriorityNumericType = currentAssignmentExpression.getMaxPriorityNumericType();
                mv.visitInsn(rhsType.getToHigherPriorityNumericTypeOpcode(maxPriorityNumericType));
                mv.visitInsn(maxPriorityNumericType.getOrOpcode());
                mv.visitInsn(maxPriorityNumericType.getToOtherNumericTypeOpcode(lhsType));
            }

            if (i > 0 || (i == 0 && !assignmentExpression.notNecessaryToGenerateDupInstruction())) {
                mv.visitInsn(DUP);
            }
            mv.visitVarInsn(lhsType.getStoreVariableOpcode(), variableIndex);
        }
    }
}
