package com.example.hans_antlr4.exception;

import com.example.hans_antlr4.domain.scope.Scope;

public class LocalVariableNotFoundException extends RuntimeException {
    public LocalVariableNotFoundException(Scope scope, String variableName) {
        super("No local variable found for name " + variableName + " found in scope " + scope);
    }
}
