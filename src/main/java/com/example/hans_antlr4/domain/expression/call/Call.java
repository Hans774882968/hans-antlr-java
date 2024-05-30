package com.example.hans_antlr4.domain.expression.call;

import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.statement.ExpressionStatement;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.type.Type;

public abstract class Call extends Expression {
    public Call(Type type, Expression parent, Statement belongStatement, int sourceLine) {
        super(type, parent, belongStatement, sourceLine, null);
        calculateValueInferResult();
    }

    public boolean returnValueIsNotUsed() {
        if (!isRootExpression()) {
            return false;
        }
        Statement statement = getBelongStatement();
        return statement instanceof ExpressionStatement;
    }
}
