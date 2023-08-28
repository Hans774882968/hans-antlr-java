package com.example.hans_antlr4.type;

import org.junit.Assert;
import org.junit.Test;

import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.utils.TypeResolver;

public class TypeResolverTest {
    @Test
    public void testGetFromValue() {
        System.out.println(TypeResolver.getFromValue("0x3f"));
        System.out.println(TypeResolver.getFromValue("0o43"));
        System.out.println(TypeResolver.getFromValue("0b1001"));
        System.out.println(TypeResolver.getFromValue("340"));
        System.out.println(TypeResolver.getFromValue("0"));
    }

    @Test
    public void testGetValueFromString() {
        Assert.assertEquals(63, TypeResolver.getValueFromString("0x3f", BuiltInType.INT));
        Assert.assertEquals(13, TypeResolver.getValueFromString("0b1101", BuiltInType.INT));
        Assert.assertEquals(26, TypeResolver.getValueFromString("0o32", BuiltInType.INT));
        Assert.assertEquals(233, TypeResolver.getValueFromString("233", BuiltInType.INT));
        Assert.assertEquals(0, TypeResolver.getValueFromString("0", BuiltInType.INT));
    }
}
