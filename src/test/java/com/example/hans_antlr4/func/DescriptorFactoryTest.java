package com.example.hans_antlr4.func;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.example.hans_antlr4.domain.expression.Parameter;
import com.example.hans_antlr4.domain.scope.FunctionSignature;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.utils.DescriptorFactory;

public class DescriptorFactoryTest {
    @Test
    public void returnVoidFunction() {
        Assert.assertEquals("()V", DescriptorFactory.getMethodDescriptor(
                new FunctionSignature("voidFn", new ArrayList<>(), BuiltInType.VOID)));
        Assert.assertEquals("(Ljava/lang/String;)V", DescriptorFactory.getMethodDescriptor(
                new FunctionSignature("voidFn",
                        Arrays.asList(new Parameter(BuiltInType.STRING, "s")), BuiltInType.VOID)));
    }

    @Test
    public void primitiveTypeFunction() {
        Assert.assertEquals("(IJ)Z", DescriptorFactory.getMethodDescriptor(
                new FunctionSignature(
                        "f",
                        Arrays.asList(
                                new Parameter(BuiltInType.INT, "l"),
                                new Parameter(BuiltInType.LONG, "r")),
                        BuiltInType.BOOLEAN)));

    }
}
