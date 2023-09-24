package com.example.hans_antlr4.bytecode_gen.expression;

import java.util.ArrayList;
import java.util.List;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.bytecode_gen.AssignmentUtil;
import com.example.hans_antlr4.domain.expression.ArrayAccess;
import com.example.hans_antlr4.domain.expression.AssignmentExpression;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.global.AssignmentSign;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.domain.type.ClassType;
import com.example.hans_antlr4.domain.type.Type;

public class AssignmentExpressionGenerator implements Opcodes {
    private ExpressionGenerator parent;
    private ArrayGenerator arrayGenerator;
    private MethodVisitor mv;

    public AssignmentExpressionGenerator(ExpressionGenerator parent, MethodVisitor mv) {
        this.parent = parent;
        this.mv = mv;
        this.arrayGenerator = new ArrayGenerator(parent, mv);
    }

    private void generateCastToHigherPriorityTypeInsn(Type type, Type targetType) {
        if (type.isNumericTypes() && targetType.isNumericTypes()) {
            mv.visitInsn(type.getToHigherPriorityNumericTypeOpcode(targetType));
        }
    }

    private void generateCastToOtherPriorityTypeInsn(Type type, Type targetType) {
        if (type.isNumericTypes() && targetType.isNumericTypes()) {
            if (type == BuiltInType.LONG && targetType == BuiltInType.BYTE) {
                mv.visitInsn(L2I);
                mv.visitInsn(I2B);
            } else {
                mv.visitInsn(type.getToOtherNumericTypeOpcode(targetType));
            }
        }
    }

    public void generate(AssignmentExpression assignmentExpression) {
        Expression currentExpression = assignmentExpression;
        List<AssignmentSign> signs = new ArrayList<>();
        List<AssignmentExpression> assignmentExpressions = new ArrayList<>();
        AssignmentUtil assignmentUtil = new AssignmentUtil(parent);

        while (currentExpression instanceof AssignmentExpression) {
            AssignmentExpression currentAssignmentExpression = (AssignmentExpression) currentExpression;
            signs.add(currentAssignmentExpression.getSign());
            assignmentExpressions.add(currentAssignmentExpression);
            currentExpression = currentAssignmentExpression.getExpression();
        }

        for (int i = 0; i < assignmentExpressions.size(); i++) {
            AssignmentSign sign = signs.get(i);
            AssignmentExpression currentAssignmentExpression = assignmentExpressions.get(i);
            Type lhsType = currentAssignmentExpression.getLhsType();
            Type maxPriorityNumericType = currentAssignmentExpression.getMaxPriorityNumericType();
            if (currentAssignmentExpression.lhsIsArrayAccess()) {
                arrayGenerator.generate(currentAssignmentExpression.getLhsArrayAccess(), false);
            }
            if (sign == AssignmentSign.ASSIGN) {
                continue;
            }
            if (currentAssignmentExpression.lhsIsArrayAccess()) {
                mv.visitInsn(DUP2);
                ArrayAccess arrayAccess = currentAssignmentExpression.getLhsArrayAccess();
                mv.visitInsn(arrayAccess.getType().getLoadArrayItemOpcode());
            }
            if (currentAssignmentExpression.lhsIsVariable()) {
                assignmentUtil.generateLoadVariableInsn(
                        mv, currentAssignmentExpression, lhsType);
            }
            if (sign == AssignmentSign.POW) {
                mv.visitInsn(lhsType.getToDoubleOpcode());
            } else if (!sign.isShiftSign()) {
                generateCastToHigherPriorityTypeInsn(lhsType, maxPriorityNumericType);
            }
        }

        currentExpression.accept(parent);

        for (int i = assignmentExpressions.size() - 1; i >= 0; i--) {
            AssignmentSign sign = signs.get(i);
            AssignmentExpression currentAssignmentExpression = assignmentExpressions.get(i);
            Type lhsType = currentAssignmentExpression.getLhsType();
            Type rhsType = currentAssignmentExpression.getRhsType();

            if (sign == AssignmentSign.ASSIGN) {
                mv.visitInsn(rhsType.getToHigherPriorityNumericTypeOpcode(lhsType, true));
            }
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
                generateCastToHigherPriorityTypeInsn(rhsType, maxPriorityNumericType);
                mv.visitInsn(maxPriorityNumericType.getMultiplyOpcode());
                generateCastToOtherPriorityTypeInsn(maxPriorityNumericType, lhsType);
            }
            if (sign == AssignmentSign.DIV) {
                Type maxPriorityNumericType = currentAssignmentExpression.getMaxPriorityNumericType();
                generateCastToHigherPriorityTypeInsn(rhsType, maxPriorityNumericType);
                mv.visitInsn(maxPriorityNumericType.getDivideOpcode());
                generateCastToOtherPriorityTypeInsn(maxPriorityNumericType, lhsType);
            }
            if (sign == AssignmentSign.MOD) {
                Type maxPriorityNumericType = currentAssignmentExpression.getMaxPriorityNumericType();
                generateCastToHigherPriorityTypeInsn(rhsType, maxPriorityNumericType);
                mv.visitInsn(maxPriorityNumericType.getModOpcode());
                generateCastToOtherPriorityTypeInsn(maxPriorityNumericType, lhsType);
            }
            if (sign == AssignmentSign.ADD) {
                if (lhsType == BuiltInType.STRING) {
                    new StringAppendGenerator(parent, mv).generate(currentAssignmentExpression);
                } else {
                    Type maxPriorityNumericType = currentAssignmentExpression.getMaxPriorityNumericType();
                    generateCastToHigherPriorityTypeInsn(rhsType, maxPriorityNumericType);
                    mv.visitInsn(maxPriorityNumericType.getAddOpcode());
                    generateCastToOtherPriorityTypeInsn(maxPriorityNumericType, lhsType);
                }
            }
            if (sign == AssignmentSign.MINUS) {
                Type maxPriorityNumericType = currentAssignmentExpression.getMaxPriorityNumericType();
                generateCastToHigherPriorityTypeInsn(rhsType, maxPriorityNumericType);
                mv.visitInsn(maxPriorityNumericType.getSubtractOpcode());
                generateCastToOtherPriorityTypeInsn(maxPriorityNumericType, lhsType);
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
                generateCastToHigherPriorityTypeInsn(rhsType, maxPriorityNumericType);
                mv.visitInsn(maxPriorityNumericType.getAndOpcode());
                generateCastToOtherPriorityTypeInsn(maxPriorityNumericType, lhsType);
            }
            if (sign == AssignmentSign.XOR) {
                Type maxPriorityNumericType = currentAssignmentExpression.getMaxPriorityNumericType();
                generateCastToHigherPriorityTypeInsn(rhsType, maxPriorityNumericType);
                mv.visitInsn(maxPriorityNumericType.getXorOpcode());
                generateCastToOtherPriorityTypeInsn(maxPriorityNumericType, lhsType);
            }
            if (sign == AssignmentSign.OR) {
                Type maxPriorityNumericType = currentAssignmentExpression.getMaxPriorityNumericType();
                generateCastToHigherPriorityTypeInsn(rhsType, maxPriorityNumericType);
                mv.visitInsn(maxPriorityNumericType.getOrOpcode());
                generateCastToOtherPriorityTypeInsn(maxPriorityNumericType, lhsType);
            }

            if (i > 0 || (i == 0 && !assignmentExpression.notNecessaryToGenerateDupInstruction())) {
                if (currentAssignmentExpression.lhsIsArrayAccess()) {
                    mv.visitInsn(lhsType.getDupX2Opcode());
                } else {
                    mv.visitInsn(lhsType.getDupOpcode());
                }
            }

            if (currentAssignmentExpression.lhsIsVariable()) {
                assignmentUtil.generateModifyVariableInsn(
                        mv, currentAssignmentExpression, lhsType);
            } else if (currentAssignmentExpression.lhsIsArrayAccess()) {
                mv.visitInsn(lhsType.getStoreArrayItemOpcode());
            }
        }
    }
}
