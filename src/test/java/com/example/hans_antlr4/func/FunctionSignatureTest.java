package com.example.hans_antlr4.func;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.example.hans_antlr4.domain.expression.EmptyExpression;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.expression.Parameter;
import com.example.hans_antlr4.domain.scope.FunctionSignature;
import com.example.hans_antlr4.domain.type.ArrayType;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.domain.type.Type;

public class FunctionSignatureTest {
    @Test
    public void testFunctionSignatureMatch1() {
        List<Parameter> parameters = Arrays.asList(new Parameter(new ArrayType(BuiltInType.LONG, 2), "a"));
        FunctionSignature sign = new FunctionSignature(true, "f", parameters, BuiltInType.LONG);
        List<Type> argTypes = Arrays.asList(new ArrayType(BuiltInType.LONG, 2));
        Assert.assertTrue(sign.matches("f", argTypes, 10));
    }

    @Test
    public void testFunctionSignatureMatch2() {
        List<Parameter> parameters = Arrays.asList(new Parameter(new ArrayType(BuiltInType.LONG, 2), "a"));
        FunctionSignature sign = new FunctionSignature(true, "f", parameters, BuiltInType.LONG);
        List<Expression> dimensions = Arrays.asList(
                new EmptyExpression(BuiltInType.LONG),
                new EmptyExpression(BuiltInType.LONG));
        List<Type> argTypes = Arrays.asList(new ArrayType(BuiltInType.LONG, dimensions));
        Assert.assertTrue(sign.matches("f", argTypes, 10));
    }
}
