package com.example.hans_antlr4.exception.type;

import com.example.hans_antlr4.domain.type.Type;

public class ArrayAccessGotNonArrayTypeException extends RuntimeException {
    public ArrayAccessGotNonArrayTypeException(Type type, int sourceLine) {
        super("Expected array type but got non-array type " + type.getName()
                + " at line " + sourceLine);
    }
}
