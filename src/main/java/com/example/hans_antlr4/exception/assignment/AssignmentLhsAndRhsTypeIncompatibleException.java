package com.example.hans_antlr4.exception.assignment;

import com.example.hans_antlr4.domain.global.AssignmentSign;
import com.example.hans_antlr4.domain.type.Type;

public class AssignmentLhsAndRhsTypeIncompatibleException extends RuntimeException {
    public AssignmentLhsAndRhsTypeIncompatibleException(
            Type lhsType,
            Type rhsType,
            AssignmentSign assignmentSign,
            int sourceLine) {
        super("Assignment expression LHS type and RHS type are incompatible for operator "
                + assignmentSign.getSign()
                + " at line " + sourceLine +
                ". LHS type: " + lhsType.getName()
                + ", RHS type: " + rhsType.getName());
    }
}
