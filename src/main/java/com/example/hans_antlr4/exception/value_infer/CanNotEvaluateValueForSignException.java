package com.example.hans_antlr4.exception.value_infer;

import com.example.hans_antlr4.domain.global.ArithmeticSign;

public class CanNotEvaluateValueForSignException extends RuntimeException {
    public CanNotEvaluateValueForSignException(ArithmeticSign sign, int sourceLine) {
        super("Can not evaluate value for sign " + sign + " at line " + sourceLine);
    }
}
