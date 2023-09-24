package com.example.hans_antlr4.exception.scope;

import com.example.hans_antlr4.domain.scope.Scope;

public class GlobalVariableNotFoundException extends RuntimeException {
    public GlobalVariableNotFoundException(Scope scope, String variableName) {
        super("No global variable found for name " + variableName + " found in scope " + scope);
    }
}
