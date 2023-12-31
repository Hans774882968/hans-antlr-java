package com.example.hans_antlr4.domain.expression.call;

import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.statement.ExpressionStatement;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.type.Type;

public abstract class Call extends Expression {
    public Call(Type type, Expression parent, Statement belongStatement) {
        super(type, parent, belongStatement);
    }

    public boolean returnValueIsNotUsed() {
        if (!isRootExpression()) {
            return false;
        }
        Statement statement = getBelongStatement();
        return statement instanceof ExpressionStatement;
    }
}
