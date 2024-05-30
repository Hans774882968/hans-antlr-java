package com.example.hans_antlr4.domain.expression;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.data_processor.ExpressionTreeProcessor;
import com.example.hans_antlr4.domain.global.ValueInferResult;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.type.Type;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class Expression {
    private Type type;
    private Expression parent;
    private Statement belongStatement;
    private int sourceLine;
    private ValueInferResult valueInferResult;

    public boolean isRootExpression() {
        return parent == null;
    }

    public abstract void accept(ExpressionGenerator generator);

    public abstract void processSubExpressionTree(
            ExpressionTreeProcessor processor,
            Expression parent,
            Statement belongStatement);

    // 所有 Expression 的 valueInferResult 都不能在构造函数中直接给出，而是需要由该方法设置
    public abstract void calculateValueInferResult();
}
