package com.example.hans_antlr4.exception.assignment;

import com.example.hans_antlr4.domain.expression.Expression;

public class IllegalAssignmentLhsType extends RuntimeException {
    public IllegalAssignmentLhsType(Expression lhs, int sourceLine) {
        super("Illegal assignment left hand side: " + lhs + " at line " + sourceLine);
    }
}
