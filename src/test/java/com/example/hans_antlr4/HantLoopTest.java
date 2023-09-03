package com.example.hans_antlr4;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.example.hans_antlr4.domain.expression.AssignmentExpression;
import com.example.hans_antlr4.domain.expression.Value;
import com.example.hans_antlr4.domain.global.AssignmentSign;
import com.example.hans_antlr4.domain.scope.LocalVariable;
import com.example.hans_antlr4.domain.statement.ExpressionStatement;
import com.example.hans_antlr4.domain.statement.RangedForStatement;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.statement.VariableDeclaration;
import com.example.hans_antlr4.domain.type.BuiltInType;

public class HantLoopTest {
    @Test
    public void newVarAsIteratorVariable() {
        Statement statement = TestUtils.getFirstStatementFromCode(
                "for i: 114512 to 114514 print i");
        Assert.assertTrue(statement instanceof RangedForStatement);
        RangedForStatement rangedForStatement = (RangedForStatement) statement;
        Statement iteratorVariableStatement = rangedForStatement.getIteratorVariableStatement();
        VariableDeclaration variableDeclaration = new VariableDeclaration(
                "i", new Value(BuiltInType.INT, "114512"));
        Assert.assertEquals(variableDeclaration, iteratorVariableStatement);
    }

    @Test
    public void definedVarAsIteratorVariable() {
        List<Statement> statements = TestUtils.getStatementsFromCode(
                "var i = 114510\nfor i: 114512 to 114514 print i");
        statements.forEach(stmt -> {
            if (!(stmt instanceof RangedForStatement))
                return;
            RangedForStatement rangedForStatement = (RangedForStatement) stmt;
            Statement iteratorVariableStatement = rangedForStatement.getIteratorVariableStatement();
            ExpressionStatement expressionStatement = new ExpressionStatement(
                    new AssignmentExpression(
                            new LocalVariable("i", BuiltInType.INT),
                            AssignmentSign.ASSIGN,
                            new Value(BuiltInType.INT, "114512")));
            Assert.assertEquals(expressionStatement, iteratorVariableStatement);
        });
    }
}
