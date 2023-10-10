package com.example.hans_antlr4.bytecode_gen;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.domain.expression.AssignmentExpression;
import com.example.hans_antlr4.domain.scope.GlobalVariable;
import com.example.hans_antlr4.domain.scope.LocalVariable;
import com.example.hans_antlr4.domain.scope.Variable;
import com.example.hans_antlr4.domain.type.Type;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AssignmentUtil {
    private ExpressionGenerator parent;

    public int getVariableIndexByAssignmentExpression(AssignmentExpression assignmentExpression) {
        String varName = assignmentExpression.getLhsVariable().getVarName();
        int variableIndex = parent.getScope().getLocalVariableIndex(varName);
        return variableIndex;
    }

    public void generateLoadVariableInsn(
            MethodVisitor mv,
            AssignmentExpression assignmentExpression,
            Type lhsType) {
        Variable variable = assignmentExpression.getLhsVariable();
        if (variable instanceof LocalVariable) {
            int variableIndex = getVariableIndexByAssignmentExpression(assignmentExpression);
            mv.visitVarInsn(lhsType.getLoadVariableOpcode(), variableIndex);
        }
        if (variable instanceof GlobalVariable) {
            String publicClassName = parent.getScope().getClassName();
            String varName = variable.getVarName();
            String descriptor = variable.getType().getDescriptor();
            mv.visitFieldInsn(Opcodes.GETSTATIC, publicClassName, varName, descriptor);
        }
    }

    public void generateModifyVariableInsn(
            MethodVisitor mv,
            AssignmentExpression assignmentExpression,
            Type lhsType) {
        Variable variable = assignmentExpression.getLhsVariable();
        if (variable instanceof LocalVariable) {
            int variableIndex = getVariableIndexByAssignmentExpression(assignmentExpression);
            mv.visitVarInsn(lhsType.getStoreVariableOpcode(), variableIndex);
        }
        if (variable instanceof GlobalVariable) {
            String publicClassName = parent.getScope().getClassName();
            String varName = variable.getVarName();
            String descriptor = variable.getType().getDescriptor();
            mv.visitFieldInsn(Opcodes.PUTSTATIC, publicClassName, varName, descriptor);
        }
    }
}
