package com.example.hans_antlr4.validation;

public enum ARGUMENT_ERRORS {
    NONE(""), NO_FILE("Plz specify files for compilation"), BAD_FILE_EXTENSION("File has to end with .hant extension");

    private final String message;

    ARGUMENT_ERRORS(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
