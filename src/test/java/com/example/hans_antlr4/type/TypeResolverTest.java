package com.example.hans_antlr4.type;

import org.junit.Assert;
import org.junit.Test;

import com.example.hans_antlr4.domain.type.ArrayType;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.domain.type.Type;
import com.example.hans_antlr4.utils.HantNumber;
import com.example.hans_antlr4.utils.TypeResolver;

public class TypeResolverTest {
    final String[] integerStrings = {
            "0x3f", "0o43", "0b1001", "0X40", "0O44", "0B1101", "340", "0", "0x0", "0o0", "0b0",
            "00", "000", "01", "08", "00123",
            "0x00", "0x000", "0x0a",
            "0o00", "0o000", "0o07",
            "0b00", "0b000", "0b01", "0b010"
    };

    @Test
    public void testGetFromValueVoid() {
        Assert.assertEquals(BuiltInType.VOID, TypeResolver.getFromValue(""));
        Assert.assertEquals(BuiltInType.VOID, TypeResolver.getFromValue(null));
    }

    @Test
    public void testGetFromValueBoolean() {
        Assert.assertEquals(BuiltInType.BOOLEAN, TypeResolver.getFromValue("true"));
        Assert.assertEquals(BuiltInType.BOOLEAN, TypeResolver.getFromValue("false"));
    }

    @Test
    public void testGetFromValueInt() {
        for (String integerString : integerStrings) {
            Assert.assertEquals(BuiltInType.INT, TypeResolver.getFromValue(integerString));
        }
    }

    @Test
    public void testGetFromValueLong() {
        for (String integerString : integerStrings) {
            Assert.assertEquals(BuiltInType.LONG, TypeResolver.getFromValue(integerString + "L"));
        }
    }

    @Test
    public void testGetFromValueFloat() {
        for (String integerString : integerStrings) {
            if (HantNumber.mayBeHex(integerString)
                    || HantNumber.mayBeOctal(integerString)
                    || HantNumber.mayBeBinary(integerString)) {
                continue;
            }
            Assert.assertEquals(BuiltInType.FLOAT, TypeResolver.getFromValue(integerString + "F"));
        }
    }

    @Test
    public void testGetFromValueDouble() {
        for (String integerString : integerStrings) {
            if (HantNumber.mayBeHex(integerString)
                    || HantNumber.mayBeOctal(integerString)
                    || HantNumber.mayBeBinary(integerString)) {
                continue;
            }
            Assert.assertEquals(BuiltInType.DOUBLE, TypeResolver.getFromValue(integerString + "D"));
        }
    }

    @Test
    public void testGetValueFromStringInt() {
        Assert.assertEquals(63, TypeResolver.getValueFromString("0x3f", BuiltInType.INT));
        Assert.assertEquals(13, TypeResolver.getValueFromString("0b1101", BuiltInType.INT));
        Assert.assertEquals(26, TypeResolver.getValueFromString("0o32", BuiltInType.INT));
        Assert.assertEquals(233, TypeResolver.getValueFromString("233", BuiltInType.INT));
        Assert.assertEquals(0, TypeResolver.getValueFromString("0", BuiltInType.INT));

        Assert.assertEquals(0, TypeResolver.getValueFromString("00", BuiltInType.INT));
        Assert.assertEquals(0, TypeResolver.getValueFromString("000", BuiltInType.INT));
        Assert.assertEquals(8, TypeResolver.getValueFromString("08", BuiltInType.INT));
        Assert.assertEquals(123, TypeResolver.getValueFromString("00123", BuiltInType.INT));

        Assert.assertEquals(0, TypeResolver.getValueFromString("0x00", BuiltInType.INT));
        Assert.assertEquals(0, TypeResolver.getValueFromString("0x000", BuiltInType.INT));
        Assert.assertEquals(10, TypeResolver.getValueFromString("0x0a", BuiltInType.INT));

        Assert.assertEquals(0, TypeResolver.getValueFromString("0o00", BuiltInType.INT));
        Assert.assertEquals(0, TypeResolver.getValueFromString("0o000", BuiltInType.INT));
        Assert.assertEquals(7, TypeResolver.getValueFromString("0o07", BuiltInType.INT));
        Assert.assertEquals(8, TypeResolver.getValueFromString("0o010", BuiltInType.INT));

        Assert.assertEquals(0, TypeResolver.getValueFromString("0b00", BuiltInType.INT));
        Assert.assertEquals(0, TypeResolver.getValueFromString("0b000", BuiltInType.INT));
        Assert.assertEquals(1, TypeResolver.getValueFromString("0b01", BuiltInType.INT));
        Assert.assertEquals(2, TypeResolver.getValueFromString("0b010", BuiltInType.INT));
    }

    @Test
    public void testGetValueFromStringLong() {
        Assert.assertEquals(12345678901L, TypeResolver.getValueFromString("012345678901", BuiltInType.LONG));
        Assert.assertEquals(1250999896321l, TypeResolver.getValueFromString("0x12345678901", BuiltInType.LONG));
        Assert.assertEquals(0L, TypeResolver.getValueFromString("0b0", BuiltInType.LONG));
        Assert.assertEquals(0l, TypeResolver.getValueFromString("0b00", BuiltInType.LONG));
    }

    @Test
    public void testGetFromTypeName() {
        Type double0Type = TypeResolver.getFromTypeName("double");
        Assert.assertEquals("D", double0Type.getDescriptor());
        Type void0Type = TypeResolver.getFromTypeName("void");
        Assert.assertEquals("V", void0Type.getDescriptor());
        Type string0Type0 = TypeResolver.getFromTypeName("string");
        Assert.assertEquals("Ljava/lang/String;", string0Type0.getDescriptor());
        Type object0Type0 = TypeResolver.getFromTypeName("object");
        Assert.assertEquals("Ljava/lang/Object;", object0Type0.getDescriptor());
        Type string0Type1 = TypeResolver.getFromTypeName("java.lang.String");
        Assert.assertEquals("Ljava/lang/String;", string0Type1.getDescriptor());
        Type object0Type1 = TypeResolver.getFromTypeName("java.lang.Object");
        Assert.assertEquals("Ljava/lang/Object;", object0Type1.getDescriptor());

        Type double1Type = TypeResolver.getFromTypeName("double[]");
        Assert.assertEquals("[D", double1Type.getDescriptor());

        Type string1Type = TypeResolver.getFromTypeName("string[]");
        Assert.assertEquals("[Ljava/lang/String;", string1Type.getDescriptor());

        Type float2Type = TypeResolver.getFromTypeName("float[][]");
        Assert.assertEquals("[[F", float2Type.getDescriptor());

        Type string3Type = TypeResolver.getFromTypeName("string[][][]");
        Assert.assertEquals("[[[Ljava/lang/String;", string3Type.getDescriptor());
    }

    @Test
    public void testIsPrimitive() {
        Assert.assertTrue(BuiltInType.INT.getTypeClass().isPrimitive());
        Assert.assertTrue(BuiltInType.CHAR.getTypeClass().isPrimitive());
        Assert.assertTrue(BuiltInType.VOID.getTypeClass().isPrimitive());

        Assert.assertFalse(BuiltInType.STRING.getTypeClass().isPrimitive());
        Assert.assertFalse(new ArrayType(BuiltInType.INT, 1).getTypeClass().isPrimitive());
        Assert.assertFalse(new ArrayType(BuiltInType.CHAR, 1).getTypeClass().isPrimitive());
        Assert.assertFalse(new ArrayType(BuiltInType.STRING, 1).getTypeClass().isPrimitive());
        Assert.assertFalse(new ArrayType(BuiltInType.FLOAT, 2).getTypeClass().isPrimitive());
    }
}
