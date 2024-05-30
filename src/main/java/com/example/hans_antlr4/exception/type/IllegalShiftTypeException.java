package com.example.hans_antlr4.exception.type;

import com.example.hans_antlr4.domain.type.Type;

public class IllegalShiftTypeException extends RuntimeException {
    public IllegalShiftTypeException(Type leftType, Type rightType, int sourceLine) {
        super("Both LHS and RHS type should be integer types at line " + sourceLine
                + ". LHS type: " + leftType.getName() + ", RHS type: " + rightType.getName());
    }
}
