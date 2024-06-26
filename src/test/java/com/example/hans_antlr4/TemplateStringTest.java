package com.example.hans_antlr4;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.example.hans_antlr4.domain.expression.Addition;
import com.example.hans_antlr4.domain.expression.Multiplication;
import com.example.hans_antlr4.domain.expression.TemplateString;
import com.example.hans_antlr4.domain.expression.UnsignedShr;
import com.example.hans_antlr4.domain.expression.Value;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.statement.var.VariableDeclaration;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.exception.func.MainMethodNotFoundInPublicClass;

public class TemplateStringTest {
    private void testOnlyString(String inp, String expected) throws MainMethodNotFoundInPublicClass {
        Statement statement = TestUtils.getFirstStatementFromCode("var a = `" + inp + "`");
        VariableDeclaration variableDeclaration = (VariableDeclaration) statement;
        TemplateString templateString = TemplateString.templateStringWithoutSourceLine(
                Arrays.asList(expected),
                new ArrayList<>());
        Assert.assertEquals(templateString, variableDeclaration.getVarDefUnits().get(0).getExpression());
    }

    @Test
    public void testExpressionTreeWithStrAndExpr() throws MainMethodNotFoundInPublicClass {
        Statement statement = TestUtils.getFirstStatementFromCode("var a = `abc${1 + 2 * 3}def`");
        VariableDeclaration variableDeclaration = (VariableDeclaration) statement;
        TemplateString templateString = TemplateString.templateStringWithoutSourceLine(
                Arrays.asList("abc", "def"),
                Arrays.asList(Addition.additionWithoutSourceLine(
                        Value.valueWithoutSourceLine(BuiltInType.INT, "1"),
                        Multiplication.multiplicationWithoutSourceLine(
                                Value.valueWithoutSourceLine(BuiltInType.INT, "2"),
                                Value.valueWithoutSourceLine(BuiltInType.INT, "3")))));
        Assert.assertEquals(templateString, variableDeclaration.getVarDefUnits().get(0).getExpression());
    }

    @Test
    public void testExpressionTreeWithOnlyStr() throws MainMethodNotFoundInPublicClass {
        Statement statement = TestUtils.getFirstStatementFromCode("var a = `我是acmer`");
        VariableDeclaration variableDeclaration = (VariableDeclaration) statement;
        TemplateString templateString = TemplateString.templateStringWithoutSourceLine(
                Arrays.asList("我是acmer"),
                new ArrayList<>());
        Assert.assertEquals(templateString, variableDeclaration.getVarDefUnits().get(0).getExpression());
    }

    @Test
    public void testExpressionTreeWithOnlyExpr() throws MainMethodNotFoundInPublicClass {
        Statement statement = TestUtils.getFirstStatementFromCode("var a = `${11 >>> 3}`");
        VariableDeclaration variableDeclaration = (VariableDeclaration) statement;
        TemplateString templateString = TemplateString.templateStringWithoutSourceLine(
                Arrays.asList("", ""),
                Arrays.asList(UnsignedShr.unsignedShrWithoutSourceLine(
                        Value.valueWithoutSourceLine(BuiltInType.INT, "11"),
                        Value.valueWithoutSourceLine(BuiltInType.INT, "3"))));
        Assert.assertEquals(templateString, variableDeclaration.getVarDefUnits().get(0).getExpression());
    }

    @Test
    public void testExpressionTreeWithEmptyString() throws MainMethodNotFoundInPublicClass {
        Statement statement = TestUtils.getFirstStatementFromCode("var a = ``");
        VariableDeclaration variableDeclaration = (VariableDeclaration) statement;
        TemplateString templateString = TemplateString.templateStringWithoutSourceLine(
                Arrays.asList(""),
                new ArrayList<>());
        Assert.assertEquals(templateString, variableDeclaration.getVarDefUnits().get(0).getExpression());
    }

    @Test
    public void testExpressionTreeWithAntiSlash() throws MainMethodNotFoundInPublicClass {
        Statement statement = TestUtils.getFirstStatementFromCode("var a = `$\\{abc}`");
        VariableDeclaration variableDeclaration = (VariableDeclaration) statement;
        TemplateString templateString = TemplateString.templateStringWithoutSourceLine(
                Arrays.asList("${abc}"),
                new ArrayList<>());
        Assert.assertEquals(templateString, variableDeclaration.getVarDefUnits().get(0).getExpression());
    }

    @Test
    public void testCornerCases() throws MainMethodNotFoundInPublicClass {
        testOnlyString("\"", "\"");
        testOnlyString("\\\"", "\"");
        testOnlyString("\\`", "`");
        testOnlyString("$\\{", "${");
        testOnlyString("$\\\\{", "$\\{");
        testOnlyString("\\\\", "\\");
        testOnlyString("$\\{acmer}", "${acmer}");
        testOnlyString("{foo}", "{foo}");
        testOnlyString("\n", "\n");
        testOnlyString("\t", "\t");
    }
}
