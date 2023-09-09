package com.example.hans_antlr4.exception.func;

import com.example.hans_antlr4.domain.scope.Scope;

public class MethodSignatureNotFoundException extends RuntimeException {
    public MethodSignatureNotFoundException(Scope scope, String methodName, int sourceLine) {
        super("There is no method " + methodName + " at line " + sourceLine);
    }
}
