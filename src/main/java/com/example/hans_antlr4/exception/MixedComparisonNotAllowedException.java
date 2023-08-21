package com.example.hans_antlr4.exception;

import com.example.hans_antlr4.domain.type.Type;

public class MixedComparisonNotAllowedException extends RuntimeException {
    public MixedComparisonNotAllowedException(Type leftType, Type rightType) {
        super("Comparison between object and primitive is not supported: " + leftType + " | " + rightType);
    }
}
