package com.example.hans_antlr4.bytecode_gen;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.domain.expression.AssignmentExpression;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AssignmentUtil {
    private ExpressionGenerator parent;

    public int getVariableIndexByAssignmentExpression(AssignmentExpression assignmentExpression) {
        String varName = assignmentExpression.getLhsVariable().getVarName();
        int variableIndex = parent.getScope().getLocalVariableIndex(varName);
        return variableIndex;
    }
}
