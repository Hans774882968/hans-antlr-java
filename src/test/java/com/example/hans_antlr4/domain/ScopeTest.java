package com.example.hans_antlr4.domain;

import org.junit.Assert;
import org.junit.Test;

import com.example.hans_antlr4.domain.global.MetaData;
import com.example.hans_antlr4.domain.scope.LocalVariable;
import com.example.hans_antlr4.domain.scope.Scope;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.exception.LocalVariableNotFoundException;

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
}
