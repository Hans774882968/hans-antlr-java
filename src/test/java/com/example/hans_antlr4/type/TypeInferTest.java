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
        Expression division = new Division(new Value(BuiltInType.LONG, "30"), new Value(BuiltInType.FLOAT, "3.2"));
        Assert.assertEquals(BuiltInType.FLOAT, division.getType());
        Expression mod = new Mod(new Value(BuiltInType.LONG, "30"), new Value(BuiltInType.INT, "7"));
        Assert.assertEquals(BuiltInType.LONG, mod.getType());

        Expression pw1 = new Pow(new Value(BuiltInType.INT, "30"), new Value(BuiltInType.LONG, "7"));
        Assert.assertEquals(BuiltInType.LONG, pw1.getType());
        Expression pw2 = new Pow(new Value(BuiltInType.FLOAT, "30"), new Value(BuiltInType.INT, "7"));
        Assert.assertEquals(BuiltInType.FLOAT, pw2.getType());
    }

    @Test
    public void bitwiseExpression() {
        Expression shl1 = new Shl(new Value(BuiltInType.INT, "30"), new Value(BuiltInType.INT, "30"));
        Assert.assertEquals(BuiltInType.INT, shl1.getType());
        Expression shl2 = new Shl(new Value(BuiltInType.INT, "30"), new Value(BuiltInType.LONG, "30"));
        Assert.assertEquals(BuiltInType.INT, shl2.getType());
        Expression shr = new Shr(new Value(BuiltInType.LONG, "30"), new Value(BuiltInType.INT, "30"));
        Assert.assertEquals(BuiltInType.LONG, shr.getType());
        Expression uShr = new UnsignedShr(new Value(BuiltInType.LONG, "30"), new Value(BuiltInType.LONG, "30"));
        Assert.assertEquals(BuiltInType.LONG, uShr.getType());

        Expression xor1 = new Xor(new Value(BuiltInType.INT, "30"), new Value(BuiltInType.INT, "30"));
        Assert.assertEquals(BuiltInType.INT, xor1.getType());
        Expression andExpr = new And(new Value(BuiltInType.INT, "30"), new Value(BuiltInType.LONG, "30"));
        Assert.assertEquals(BuiltInType.LONG, andExpr.getType());
        Expression xor2 = new Xor(new Value(BuiltInType.LONG, "30"), new Value(BuiltInType.INT, "30"));
        Assert.assertEquals(BuiltInType.LONG, xor2.getType());
        Expression orExpr = new Or(new Value(BuiltInType.LONG, "30"), new Value(BuiltInType.LONG, "30"));
        Assert.assertEquals(BuiltInType.LONG, orExpr.getType());
    }
}
