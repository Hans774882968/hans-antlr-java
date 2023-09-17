package com.example.hans_antlr4.type;

import org.junit.Assert;
import org.junit.Test;

import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.domain.type.ClassType;

public class ClassTypeTest {
    @Test
    public void testEqualityWithBuiltIn() {
        ClassType classTypeString = new ClassType("java.lang.String");
        Assert.assertEquals(BuiltInType.STRING.getInternalName(), classTypeString.getInternalName());
        Assert.assertEquals(BuiltInType.STRING.getDescriptor(), classTypeString.getDescriptor());
        Assert.assertEquals(BuiltInType.STRING.getTypeClass(), classTypeString.getTypeClass());
        Assert.assertEquals(BuiltInType.STRING.getDupOpcode(), classTypeString.getDupOpcode());
        Assert.assertEquals(BuiltInType.STRING.getDupX2Opcode(), classTypeString.getDupX2Opcode());
        ClassType classTypeObject = new ClassType("java.lang.Object");
        Assert.assertEquals(BuiltInType.OBJECT.getInternalName(), classTypeObject.getInternalName());
        Assert.assertEquals(BuiltInType.OBJECT.getDescriptor(), classTypeObject.getDescriptor());
        Assert.assertEquals(BuiltInType.OBJECT.getTypeClass(), classTypeObject.getTypeClass());
        Assert.assertEquals(BuiltInType.OBJECT.getDupOpcode(), classTypeObject.getDupOpcode());
        Assert.assertEquals(BuiltInType.OBJECT.getDupX2Opcode(), classTypeObject.getDupX2Opcode());
    }
}
