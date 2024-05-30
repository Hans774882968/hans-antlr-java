package com.example.hans_antlr4.domain.expression.call;

import java.util.List;
import java.util.Objects;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.data_processor.ExpressionTreeProcessor;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.global.ValueInferResult;
import com.example.hans_antlr4.domain.scope.FunctionSignature;
import com.example.hans_antlr4.domain.statement.Statement;

import lombok.Getter;

@Getter
public class FunctionCall extends Call {
    private final Expression owner;
    private final FunctionSignature signature;
    private final List<Expression> arguments;

    public FunctionCall(
            Expression owner,
            FunctionSignature signature,
            List<Expression> arguments,
            int sourceLine) {
        super(signature.getReturnType(), null, null, sourceLine);
        this.owner = owner;
        this.signature = signature;
        this.arguments = arguments;
        calculateValueInferResult();
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }

    @Override
    public void processSubExpressionTree(
            ExpressionTreeProcessor processor,
            Expression parent,
            Statement belongStatement) {
        processor.processExpressionTree(this, parent, belongStatement);
    }

    @Override
    public void calculateValueInferResult() {
        this.setValueInferResult(ValueInferResult.nonConst);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof FunctionCall)) {
            return false;
        }
        FunctionCall functionCall = (FunctionCall) o;
        return Objects.equals(owner, functionCall.owner)
                && Objects.equals(signature, functionCall.signature)
                && Objects.equals(arguments, functionCall.arguments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, signature, arguments);
    }
}
