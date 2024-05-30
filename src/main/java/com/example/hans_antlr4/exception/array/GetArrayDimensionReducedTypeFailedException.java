package com.example.hans_antlr4.exception.array;

import com.example.hans_antlr4.domain.type.ArrayType;

public class GetArrayDimensionReducedTypeFailedException extends RuntimeException {
    public GetArrayDimensionReducedTypeFailedException(ArrayType array, int dimension, int sourceLine) {
        super("dimension " + dimension + " exceed the dimension of array " + array.getName()
                + " with dimension " + array.getDimension() + " at line " + sourceLine);
    }
}
