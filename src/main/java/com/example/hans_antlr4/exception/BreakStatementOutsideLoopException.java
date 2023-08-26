package com.example.hans_antlr4.exception;

public class BreakStatementOutsideLoopException extends RuntimeException {
    public BreakStatementOutsideLoopException(int sourceLine) {
        super("Unexpected break statement outside loop at line " + sourceLine);
    }
}
