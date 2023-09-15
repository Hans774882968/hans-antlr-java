package com.example.hans_antlr4.exception;

public class InvalidHantTypeNameException extends RuntimeException {
    public InvalidHantTypeNameException(String typeName) {
        super("Invalid hant type name " + typeName);
    }
}
