package com.example.hans_antlr4.exception;

import com.example.hans_antlr4.domain.expression.ArithmeticExpression;

public class ArithmeticExprLhsAndRhsTypeIncompatibleException extends RuntimeException {
    public ArithmeticExprLhsAndRhsTypeIncompatibleException(
            ArithmeticExpression arithmeticExpression, int sourceLine) {
        super("Arithmetic expression LHS type and RHS type are incompatible for operator "
                + arithmeticExpression.getSign()
                + " at line " + sourceLine +
                ". LHS type: " + arithmeticExpression.getLeftExpression().getType().getName()
                + ", RHS type: " + arithmeticExpression.getRightExpression().getType().getName());
    }
}
