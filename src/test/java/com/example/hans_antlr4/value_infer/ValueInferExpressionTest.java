package com.example.hans_antlr4.value_infer;

import java.util.Arrays;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import com.example.hans_antlr4.domain.expression.Addition;
import com.example.hans_antlr4.domain.expression.And;
import com.example.hans_antlr4.domain.expression.Division;
import com.example.hans_antlr4.domain.expression.Mod;
import com.example.hans_antlr4.domain.expression.Multiplication;
import com.example.hans_antlr4.domain.expression.Or;
import com.example.hans_antlr4.domain.expression.Pow;
import com.example.hans_antlr4.domain.expression.Shl;
import com.example.hans_antlr4.domain.expression.Shr;
import com.example.hans_antlr4.domain.expression.Subtraction;
import com.example.hans_antlr4.domain.expression.TemplateString;
import com.example.hans_antlr4.domain.expression.UnsignedShr;
import com.example.hans_antlr4.domain.expression.Value;
import com.example.hans_antlr4.domain.expression.Xor;
import com.example.hans_antlr4.domain.expression.reference.VarReference;
import com.example.hans_antlr4.domain.expression.unary.UnaryNegative;
import com.example.hans_antlr4.domain.expression.unary.UnaryPositive;
import com.example.hans_antlr4.domain.expression.unary.UnaryTilde;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.utils.Const;

public class ValueInferExpressionTest {
    @Test
    public void testStringLiteral() {
        TemplateString templateString1 = new TemplateString(
                Arrays.asList("hello ", "!"),
                Arrays.asList(new Value(BuiltInType.STRING, "world", Const.MOCK_SOURCE_LINE)),
                Const.MOCK_SOURCE_LINE);
        Assert.assertEquals("hello world!", templateString1.getValueInferResult().getValue().getValue());

        TemplateString templateString2 = new TemplateString(
                Arrays.asList("I am ", " years old"),
                Arrays.asList(new Value(BuiltInType.INT, "0x3f", Const.MOCK_SOURCE_LINE)),
                Const.MOCK_SOURCE_LINE);
        Assert.assertEquals("I am 63 years old", templateString2.getValueInferResult().getValue().getValue());

        TemplateString templateString3 = new TemplateString(
                Arrays.asList("I am ", " years old"),
                Arrays.asList(new Value(BuiltInType.LONG, "0xcfcfcfcfcf", Const.MOCK_SOURCE_LINE)),
                Const.MOCK_SOURCE_LINE);
        Assert.assertEquals("I am 892544733135 years old", templateString3.getValueInferResult().getValue().getValue());

        TemplateString templateString4 = new TemplateString(
                Arrays.asList("I am ", " years old"),
                Arrays.asList(new VarReference("x", BuiltInType.INT, Const.MOCK_SOURCE_LINE)),
                Const.MOCK_SOURCE_LINE);
        Assert.assertFalse(templateString4.getValueInferResult().isConst());
    }

    @Test
    public void testAddition() {
        Addition addition1 = new Addition(
                Value.valueWithoutSourceLine(BuiltInType.INT, "12"),
                Value.valueWithoutSourceLine(BuiltInType.LONG, "88"),
                Const.MOCK_SOURCE_LINE);
        Assert.assertEquals(
                Value.valueWithoutSourceLine(BuiltInType.LONG, "100"),
                addition1.getValueInferResult().getValue());

        Addition addition2 = new Addition(
                Value.valueWithoutSourceLine(BuiltInType.LONG, "1.2"),
                Value.valueWithoutSourceLine(BuiltInType.DOUBLE, "8.8"),
                Const.MOCK_SOURCE_LINE);
        Assert.assertEquals(
                Value.valueWithoutSourceLine(BuiltInType.DOUBLE, "10.0"),
                addition2.getValueInferResult().getValue());

        Addition addition3 = new Addition(
                Value.valueWithoutSourceLine(BuiltInType.INT, "12"),
                Value.valueWithoutSourceLine(BuiltInType.FLOAT, "8.5"),
                Const.MOCK_SOURCE_LINE);
        Assert.assertEquals(
                Value.valueWithoutSourceLine(BuiltInType.FLOAT, "20.5"),
                addition3.getValueInferResult().getValue());

        Addition addition4 = new Addition(
                Value.valueWithoutSourceLine(BuiltInType.STRING, "v = "),
                Value.valueWithoutSourceLine(BuiltInType.DOUBLE, "8.8"),
                Const.MOCK_SOURCE_LINE);
        Assert.assertEquals(
                Value.valueWithoutSourceLine(BuiltInType.STRING, "v = 8.8"),
                addition4.getValueInferResult().getValue());
    }

    @Test
    public void testSubtraction() {
        Subtraction subtraction1 = Subtraction.subtractionWithoutSourceLine(
                Value.valueWithoutSourceLine(BuiltInType.INT, "12"),
                Value.valueWithoutSourceLine(BuiltInType.LONG, "112"));
        Assert.assertEquals(
                Value.valueWithoutSourceLine(BuiltInType.LONG, "-100"),
                subtraction1.getValueInferResult().getValue());

        Subtraction subtraction2 = Subtraction.subtractionWithoutSourceLine(
                Value.valueWithoutSourceLine(BuiltInType.DOUBLE, "1.23"),
                Value.valueWithoutSourceLine(BuiltInType.DOUBLE, "8.83"));
        Assert.assertEquals(
                Value.valueWithoutSourceLine(BuiltInType.DOUBLE, "-7.6"),
                subtraction2.getValueInferResult().getValue());
    }

    @Test
    public void testPow() {
        Pow pow1 = Pow.powWithoutSourceLine(
                Value.valueWithoutSourceLine(BuiltInType.INT, "12"),
                Value.valueWithoutSourceLine(BuiltInType.LONG, "3"));
        Assert.assertEquals(
                Value.valueWithoutSourceLine(BuiltInType.LONG, "1728"),
                pow1.getValueInferResult().getValue());

        Pow pow2 = Pow.powWithoutSourceLine(
                Value.valueWithoutSourceLine(BuiltInType.DOUBLE, "1.23"),
                Value.valueWithoutSourceLine(BuiltInType.DOUBLE, "8.88"));
        Assert.assertEquals(
                Value.valueWithoutSourceLine(BuiltInType.DOUBLE, "6.285754132679758"),
                pow2.getValueInferResult().getValue());

        Pow pow3 = Pow.powWithoutSourceLine(
                Value.valueWithoutSourceLine(BuiltInType.FLOAT, "4.55"),
                Addition.additionWithoutSourceLine(
                        Value.valueWithoutSourceLine(BuiltInType.FLOAT, "2.490"),
                        Value.valueWithoutSourceLine(BuiltInType.FLOAT, "0.002")));
        Assert.assertEquals(
                Value.valueWithoutSourceLine(BuiltInType.FLOAT, "43.627922"),
                pow3.getValueInferResult().getValue());
    }

    @Test
    public void testMulDivMod1() {
        Random r = new Random();
        long v1 = r.nextLong();
        int v2 = r.nextInt();
        double v3 = r.nextDouble();
        float v4 = r.nextFloat();
        double divisionResult = Double.parseDouble(Double.toString(v3)) / Double.parseDouble(Float.toString(v4));
        double res = (v1 % v2) * divisionResult;
        Mod mod = Mod.modWithoutSourceLine(
                Value.valueWithoutSourceLine(BuiltInType.LONG, Long.toString(v1)),
                Value.valueWithoutSourceLine(BuiltInType.INT, Integer.toString(v2)));
        Division division = Division.divisionWithoutSourceLine(
                Value.valueWithoutSourceLine(BuiltInType.DOUBLE, Double.toString(v3)),
                Value.valueWithoutSourceLine(BuiltInType.FLOAT, Float.toString(v4)));
        Multiplication multiplication = Multiplication.multiplicationWithoutSourceLine(
                mod,
                division);
        Assert.assertEquals(
                Value.valueWithoutSourceLine(BuiltInType.LONG, Long.toString(v1 % v2)),
                mod.getValueInferResult().getValue());
        Assert.assertEquals(
                Value.valueWithoutSourceLine(BuiltInType.DOUBLE, Double.toString(divisionResult)),
                division.getValueInferResult().getValue());
        Assert.assertEquals(
                Value.valueWithoutSourceLine(BuiltInType.DOUBLE, Double.toString(res)),
                multiplication.getValueInferResult().getValue());
    }

    @Test
    public void testMulDivMod2() {
        Random r = new Random();
        float v1 = r.nextFloat();
        float v2 = r.nextFloat();
        int v3 = r.nextInt();
        long v4 = r.nextLong();
        Division division = Division.divisionWithoutSourceLine(
                Value.valueWithoutSourceLine(BuiltInType.INT, Integer.toString(v3)),
                Addition.additionWithoutSourceLine(
                        Mod.modWithoutSourceLine(
                                Value.valueWithoutSourceLine(BuiltInType.LONG, Long.toString(v4)),
                                Value.valueWithoutSourceLine(BuiltInType.INT, Integer.toString(10))),
                        Value.valueWithoutSourceLine(BuiltInType.INT, Integer.toString(12))));
        long divisionResult = v3 / (v4 % 10 + 12);
        float res = divisionResult * (v1 % v2);
        Mod mod = Mod.modWithoutSourceLine(
                Value.valueWithoutSourceLine(BuiltInType.FLOAT, Float.toString(v1)),
                Value.valueWithoutSourceLine(BuiltInType.FLOAT, Float.toString(v2)));
        Multiplication multiplication = Multiplication.multiplicationWithoutSourceLine(
                division,
                mod);
        Assert.assertEquals(
                Value.valueWithoutSourceLine(BuiltInType.LONG, Long.toString(divisionResult)),
                division.getValueInferResult().getValue());
        Assert.assertEquals(
                Value.valueWithoutSourceLine(BuiltInType.FLOAT, Float.toString(v1 % v2)),
                mod.getValueInferResult().getValue());
        Assert.assertEquals(
                Value.valueWithoutSourceLine(BuiltInType.FLOAT, Float.toString(res)),
                multiplication.getValueInferResult().getValue());
    }

    @Test
    public void testShift() {
        Shl shl1 = Shl.shlWithoutSourceLine(
                Value.valueWithoutSourceLine(BuiltInType.INT, "0b11"),
                Value.valueWithoutSourceLine(BuiltInType.LONG, "0o10"));
        Assert.assertEquals(
                Value.valueWithoutSourceLine(BuiltInType.INT, "768"),
                shl1.getValueInferResult().getValue());

        Shr shr1 = Shr.shrWithoutSourceLine(
                Value.valueWithoutSourceLine(BuiltInType.LONG, "768"),
                Value.valueWithoutSourceLine(BuiltInType.BYTE, "7"));
        Assert.assertEquals(
                Value.valueWithoutSourceLine(BuiltInType.LONG, "6"),
                shr1.getValueInferResult().getValue());

        UnsignedShr unsignedShr1 = UnsignedShr.unsignedShrWithoutSourceLine(
                Value.valueWithoutSourceLine(BuiltInType.BYTE, "17"),
                Value.valueWithoutSourceLine(BuiltInType.INT, "2"));
        Assert.assertEquals(
                Value.valueWithoutSourceLine(BuiltInType.INT, "4"),
                unsignedShr1.getValueInferResult().getValue());

        UnsignedShr unsignedShr2 = UnsignedShr.unsignedShrWithoutSourceLine(
                Value.valueWithoutSourceLine(BuiltInType.BYTE, "17"),
                Value.valueWithoutSourceLine(BuiltInType.BYTE, "1"));
        Assert.assertEquals(
                Value.valueWithoutSourceLine(BuiltInType.INT, "8"),
                unsignedShr2.getValueInferResult().getValue());
    }

    @Test
    public void testAndXorOr() {
        Random r = new Random();
        byte v1 = (byte) r.nextInt(Byte.MAX_VALUE);
        int v2 = r.nextInt();
        int v3 = r.nextInt();
        long v4 = r.nextLong();
        long res = (v1 | v2) ^ (v3 & v4);
        Or or1 = Or.orWithoutSourceLine(
                Value.valueWithoutSourceLine(BuiltInType.BYTE, Byte.toString(v1)),
                Value.valueWithoutSourceLine(BuiltInType.INT, Integer.toString(v2)));
        And and1 = And.andWithoutSourceLine(
                Value.valueWithoutSourceLine(BuiltInType.INT, Integer.toString(v3)),
                Value.valueWithoutSourceLine(BuiltInType.LONG, Long.toString(v4)));
        Xor xor1 = Xor.xorWithoutSourceLine(or1, and1);
        Assert.assertEquals(
                Value.valueWithoutSourceLine(BuiltInType.INT, Integer.toString(v1 | v2)),
                or1.getValueInferResult().getValue());
        Assert.assertEquals(
                Value.valueWithoutSourceLine(BuiltInType.LONG, Long.toString(v3 & v4)),
                and1.getValueInferResult().getValue());
        Assert.assertEquals(
                Value.valueWithoutSourceLine(BuiltInType.LONG, Long.toString(res)),
                xor1.getValueInferResult().getValue());
    }

    @Test
    public void testUnaryNegPos() {
        Random r = new Random();
        byte v1 = (byte) r.nextInt(Byte.MAX_VALUE);
        double v2 = r.nextDouble();
        UnaryNegative unaryNegative1 = UnaryNegative.unaryNegativeWithoutSourceLine(
                UnaryPositive.unaryPositiveWithoutSourceLine(
                        Value.valueWithoutSourceLine(BuiltInType.BYTE, Byte.toString(v1))));
        UnaryPositive unaryPositive1 = UnaryPositive.unaryPositiveWithoutSourceLine(
                Value.valueWithoutSourceLine(BuiltInType.DOUBLE, Double.toString(v2)));
        Assert.assertEquals(
                Value.valueWithoutSourceLine(BuiltInType.INT, Integer.toString(-v1)),
                unaryNegative1.getValueInferResult().getValue());
        Assert.assertEquals(
                Value.valueWithoutSourceLine(BuiltInType.DOUBLE, Double.toString(v2)),
                unaryPositive1.getValueInferResult().getValue());
    }

    @Test
    public void testUnaryTilde() {
        Random r = new Random();
        long v1 = r.nextLong();
        UnaryTilde unaryTilde1 = UnaryTilde.unaryTildeWithoutSourceLine(
                UnaryNegative.unaryNegativeWithoutSourceLine(
                        Value.valueWithoutSourceLine(BuiltInType.LONG, Long.toString(v1))));
        Assert.assertEquals(
                Value.valueWithoutSourceLine(BuiltInType.LONG, Long.toString(~-v1)),
                unaryTilde1.getValueInferResult().getValue());
    }
}
