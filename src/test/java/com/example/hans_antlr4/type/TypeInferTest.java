package com.example.hans_antlr4.type;

import org.junit.Assert;
import org.junit.Test;

import com.example.hans_antlr4.domain.expression.And;
import com.example.hans_antlr4.domain.expression.Division;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.expression.Mod;
import com.example.hans_antlr4.domain.expression.Or;
import com.example.hans_antlr4.domain.expression.Pow;
import com.example.hans_antlr4.domain.expression.Shl;
import com.example.hans_antlr4.domain.expression.Shr;
import com.example.hans_antlr4.domain.expression.UnsignedShr;
import com.example.hans_antlr4.domain.expression.Value;
import com.example.hans_antlr4.domain.expression.Xor;
import com.example.hans_antlr4.domain.type.BuiltInType;

public class TypeInferTest {
    @Test
    public void nonBitwiseExpression() {
        Expression division = Division.divisionWithoutSourceLine(
                Value.valueWithoutSourceLine(BuiltInType.LONG, "30"),
                Value.valueWithoutSourceLine(BuiltInType.FLOAT, "3.2"));
        Assert.assertEquals(BuiltInType.FLOAT, division.getType());
        Expression mod = Mod.modWithoutSourceLine(
                Value.valueWithoutSourceLine(BuiltInType.LONG, "30"),
                Value.valueWithoutSourceLine(BuiltInType.INT, "7"));
        Assert.assertEquals(BuiltInType.LONG, mod.getType());

        Expression pw1 = Pow.powWithoutSourceLine(
                Value.valueWithoutSourceLine(BuiltInType.INT, "30"),
                Value.valueWithoutSourceLine(BuiltInType.LONG, "7"));
        Assert.assertEquals(BuiltInType.LONG, pw1.getType());
        Expression pw2 = Pow.powWithoutSourceLine(
                Value.valueWithoutSourceLine(BuiltInType.FLOAT, "30"),
                Value.valueWithoutSourceLine(BuiltInType.INT, "7"));
        Assert.assertEquals(BuiltInType.FLOAT, pw2.getType());
    }

    @Test
    public void bitwiseExpression() {
        Expression shl1 = Shl.shlWithoutSourceLine(
                Value.valueWithoutSourceLine(BuiltInType.INT, "30"),
                Value.valueWithoutSourceLine(BuiltInType.INT, "30"));
        Assert.assertEquals(BuiltInType.INT, shl1.getType());
        Expression shl2 = Shl.shlWithoutSourceLine(
                Value.valueWithoutSourceLine(BuiltInType.INT, "30"),
                Value.valueWithoutSourceLine(BuiltInType.LONG, "30"));
        Assert.assertEquals(BuiltInType.INT, shl2.getType());
        Expression shr = Shr.shrWithoutSourceLine(
                Value.valueWithoutSourceLine(BuiltInType.LONG, "30"),
                Value.valueWithoutSourceLine(BuiltInType.INT, "30"));
        Assert.assertEquals(BuiltInType.LONG, shr.getType());
        Expression uShr = UnsignedShr.unsignedShrWithoutSourceLine(
                Value.valueWithoutSourceLine(BuiltInType.LONG, "30"),
                Value.valueWithoutSourceLine(BuiltInType.LONG, "30"));
        Assert.assertEquals(BuiltInType.LONG, uShr.getType());

        Expression xor1 = Xor.xorWithoutSourceLine(
                Value.valueWithoutSourceLine(BuiltInType.INT, "30"),
                Value.valueWithoutSourceLine(BuiltInType.INT, "30"));
        Assert.assertEquals(BuiltInType.INT, xor1.getType());
        Expression andExpr = And.andWithoutSourceLine(
                Value.valueWithoutSourceLine(BuiltInType.INT, "30"),
                Value.valueWithoutSourceLine(BuiltInType.LONG, "30"));
        Assert.assertEquals(BuiltInType.LONG, andExpr.getType());
        Expression xor2 = Xor.xorWithoutSourceLine(
                Value.valueWithoutSourceLine(BuiltInType.LONG, "30"),
                Value.valueWithoutSourceLine(BuiltInType.INT, "30"));
        Assert.assertEquals(BuiltInType.LONG, xor2.getType());
        Expression orExpr = Or.orWithoutSourceLine(
                Value.valueWithoutSourceLine(BuiltInType.LONG, "30"),
                Value.valueWithoutSourceLine(BuiltInType.LONG, "30"));
        Assert.assertEquals(BuiltInType.LONG, orExpr.getType());
    }
}
