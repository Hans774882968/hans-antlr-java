package com.example.hans_antlr4.type;

import org.junit.Assert;
import org.junit.Test;

import com.example.hans_antlr4.TestUtils;
import com.example.hans_antlr4.domain.statement.Block;
import com.example.hans_antlr4.domain.statement.PrintStatement;
import com.example.hans_antlr4.domain.statement.StandardForStatement;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.statement.var.VariableDeclaration;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.exception.func.MainMethodNotFoundInPublicClass;

public class ByteTypeTest {
    @Test
    public void testByteExpressionType() throws MainMethodNotFoundInPublicClass {
        Statement statement = TestUtils.getFirstStatementFromCode(
                "var v1 = 13y ** 2y, v2 = 13y * 13y, v3 = 13y / 12y, v4 = 13y % 13y, v5 = 13y + 13y, v6 = 13y - 13y;\n"
                        + "var v7 = 13y << 2y, v8 = 13y >> 1y, v9 = 13y >>> 1y\n"
                        + "var v10 = 13y & 13y, v11 = 13y ^ 13y, v12 = 13y | 13y\n"
                        + "var v11 = -13y, v12 = +13y, v13 = ~13y");
        VariableDeclaration firstStatement = (VariableDeclaration) statement;
        firstStatement.getVarDefUnits().forEach(varDefUnit -> {
            Assert.assertEquals(BuiltInType.INT, varDefUnit.getExpression().getType());
        });
    }

    @Test
    public void testByteArithmeticNoTypeCast() throws MainMethodNotFoundInPublicClass {
        Statement statement = TestUtils.getFirstStatementFromCode(
                "for var i = 0y; i < 3; i += 1 { var y = 0x7fy + i; print \n y; print \n \" \"}");
        StandardForStatement forStatement = (StandardForStatement) statement;
        Block body = (Block) forStatement.getBodyStatement();
        Assert.assertEquals(3, body.getStatements().size());
        VariableDeclaration firstStatement = (VariableDeclaration) body.getStatements().get(0);
        Assert.assertEquals(BuiltInType.INT, firstStatement.getVarDefUnits().get(0).getExpression().getType());
        PrintStatement secondStatement = (PrintStatement) body.getStatements().get(1);
        Assert.assertEquals(BuiltInType.INT, secondStatement.getExpression().getType());
    }

    @Test
    public void testByteArithmeticWithTypeCast() throws MainMethodNotFoundInPublicClass {
        Statement statementInt = TestUtils.getFirstStatementFromCode(
                "for var i = 0; i < 3; i += 1 { var y = 0x7fy + i; print \\n y; print \\n \" \"}");
        StandardForStatement forStatementInt = (StandardForStatement) statementInt;
        Block bodyInt = (Block) forStatementInt.getBodyStatement();
        Assert.assertEquals(3, bodyInt.getStatements().size());
        VariableDeclaration firstStatementInt = (VariableDeclaration) bodyInt.getStatements().get(0);
        Assert.assertEquals(BuiltInType.INT, firstStatementInt.getVarDefUnits().get(0).getExpression().getType());
        PrintStatement secondStatementInt = (PrintStatement) bodyInt.getStatements().get(1);
        Assert.assertEquals(BuiltInType.INT, secondStatementInt.getExpression().getType());

        Statement statementLong = TestUtils.getFirstStatementFromCode(
                "for var i = 0L; i < 3; i += 1 { var y = 0x7fy ^ i; print \\n y; print \\n \" \"}");
        StandardForStatement forStatementLong = (StandardForStatement) statementLong;
        Block bodyLong = (Block) forStatementLong.getBodyStatement();
        Assert.assertEquals(3, bodyLong.getStatements().size());
        VariableDeclaration firstStatementLong = (VariableDeclaration) bodyLong.getStatements().get(0);
        Assert.assertEquals(BuiltInType.LONG, firstStatementLong.getVarDefUnits().get(0).getExpression().getType());
        PrintStatement secondStatementLong = (PrintStatement) bodyLong.getStatements().get(1);
        Assert.assertEquals(BuiltInType.LONG, secondStatementLong.getExpression().getType());
    }
}
