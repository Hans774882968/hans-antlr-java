package com.example.hans_antlr4.type;

import org.junit.Assert;
import org.junit.Test;

import com.example.hans_antlr4.domain.type.ArrayType;
import com.example.hans_antlr4.domain.type.BuiltInType;

public class ArrayTypeTest {
    @Test
    public void testArrayTypeEqual() {
        ArrayType objectArr = new ArrayType(BuiltInType.OBJECT, 1);
        Assert.assertEquals(objectArr, ArrayType.OBJECT_ARR);
    }
}
