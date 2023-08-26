package com.example.hans_antlr4.exception;

public class ContinueStatementOutsideLoopException extends RuntimeException {
    public ContinueStatementOutsideLoopException(int sourceLine) {
        super("Unexpected continue statement outside loop at line " + sourceLine);
    }
}
