package com.example.hans_antlr4.exception;

import com.example.hans_antlr4.domain.type.Type;

public class AssignmentLhsAndRhsTypeIncompatibleException extends RuntimeException {
    public AssignmentLhsAndRhsTypeIncompatibleException(Type lhsType, Type rhsType, int sourceLine) {
        super("Assignment expression LHS type and RHS type are incompatible at line "
                + sourceLine + ". LHS type: " + lhsType.getName() + ", RHS type: " + rhsType.getName());
    }
}
