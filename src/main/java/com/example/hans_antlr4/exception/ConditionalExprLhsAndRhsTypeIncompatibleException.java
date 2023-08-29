package com.example.hans_antlr4.exception;

import com.example.hans_antlr4.domain.type.Type;

public class ConditionalExprLhsAndRhsTypeIncompatibleException extends RuntimeException {
    public ConditionalExprLhsAndRhsTypeIncompatibleException(Type lhsType, Type rhsType) {
        super("Conditional expression LHS type and RHS type are incompatible. "
                + "LHS type: " + lhsType.getName() + ", RHS type: " + rhsType.getName());
    }

    public ConditionalExprLhsAndRhsTypeIncompatibleException(Type lhsType, Type rhsType, int sourceLine) {
        super("Conditional expression LHS type and RHS type are incompatible at line "
                + sourceLine + ". LHS type: " + lhsType.getName() + ", RHS type: " + rhsType.getName());
    }
}
