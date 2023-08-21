package com.example.hans_antlr4.exception;

import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.global.CompareSign;

public class SupportGenerateObjectsComparisonLaterException extends RuntimeException {
    public SupportGenerateObjectsComparisonLaterException(
            Expression leftExpression, Expression rightExpression, CompareSign compareSign) {
        super("We will support ConditionalExpressionGenerator.generateObjectsComparison(Expression leftExpression, Expression rightExpression, CompareSign compareSign) later "
                + leftExpression + ", " + rightExpression + ", " + compareSign);
    }
}
