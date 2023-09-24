package com.example.hans_antlr4.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

import com.example.hans_antlr4.domain.expression.Parameter;
import com.example.hans_antlr4.domain.global.MetaData;
import com.example.hans_antlr4.domain.scope.FunctionSignature;
import com.example.hans_antlr4.domain.scope.LocalVariable;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.domain.type.ClassType;
import com.example.hans_antlr4.exception.func.MethodSignatureNotFoundException;
import com.example.hans_antlr4.exception.scope.LocalVariableNotFoundException;

public class ScopeTest {
    @Test
    public void useAnotherScopeToInitTest() {
        Scope s1 = new Scope(new MetaData(null));
        s1.addLocalVariable(new LocalVariable("x", BuiltInType.INT));
        Scope s2 = new Scope(s1);
        s2.addLocalVariable(new LocalVariable("y", BuiltInType.INT));
        Assert.assertEquals(0, s1.getLocalVariableIndex("x"));
        Assert.assertThrows(LocalVariableNotFoundException.class, () -> {
            s1.getLocalVariableIndex("y");
        });
        Assert.assertEquals(0, s2.getLocalVariableIndex("x"));
        Assert.assertEquals(1, s2.getLocalVariableIndex("y"));

        s1.addLocalVariable(new LocalVariable("z", BuiltInType.STRING));
        Assert.assertEquals(1, s1.getLocalVariableIndex("z"));
        Assert.assertThrows(LocalVariableNotFoundException.class, () -> {
            s2.getLocalVariableIndex("z");
        });
    }

    @Test
    public void sameNameVariable() {
        Scope s1 = new Scope(new MetaData(null));
        s1.addLocalVariable(new LocalVariable("x", BuiltInType.INT));
        s1.addLocalVariable(new LocalVariable("y", BuiltInType.INT));
        Scope s2 = new Scope(s1);
        s2.addLocalVariable(new LocalVariable("x", BuiltInType.INT));
        s2.addLocalVariable(new LocalVariable("y", BuiltInType.INT));

        Assert.assertEquals(0, s1.getLocalVariableIndex("x"));
        Assert.assertEquals(1, s1.getLocalVariableIndex("y"));
        Assert.assertEquals(2, s2.getLocalVariableIndex("x"));
        Assert.assertEquals(3, s2.getLocalVariableIndex("y"));
    }

    @Test
    public void getMethodCallSignatureWithOwnerNotFound() {
        Scope scope = new Scope(new MetaData("Foo"));
        Assert.assertThrows(MethodSignatureNotFoundException.class, () -> {
            scope.getMethodCallSignature(Optional.of(new ClassType("MyLib")), "foo", new ArrayList<>(), 10);
        });
    }

    @Test
    public void getMethodCallSignatureWithOwnerFound1() {
        Scope scope = new Scope(new MetaData("Foo"));
        FunctionSignature mathMaxExpected = new FunctionSignature(
                true, "max",
                Arrays.asList(new Parameter(BuiltInType.INT, "arg0"), new Parameter(BuiltInType.INT, "arg1")),
                BuiltInType.INT);
        FunctionSignature mathMaxActual = scope.getMethodCallSignature(
                Optional.of(new ClassType("java.lang.Math")), "max",
                Arrays.asList(BuiltInType.INT, BuiltInType.INT), 11);
        Assert.assertEquals(mathMaxExpected, mathMaxActual);
    }

    @Test
    public void getMethodCallSignatureWithOwnerFound2() {
        Scope scope = new Scope(new MetaData("Foo"));
        ClassType printStreamType = new ClassType("java.io.PrintStream");
        FunctionSignature systemOutPrintfExpected = new FunctionSignature(
                true, "setOut",
                Arrays.asList(new Parameter(printStreamType, "arg0")),
                BuiltInType.VOID);
        FunctionSignature systemOutPrintfActual = scope.getMethodCallSignature(
                Optional.of(new ClassType("java.lang.System")), "setOut",
                Arrays.asList(printStreamType), 11);
        Assert.assertEquals(systemOutPrintfExpected, systemOutPrintfActual);
    }
}
