package com.example.hans_antlr4.domain.expression.call;

import java.util.List;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.data_processor.ExpressionTreeProcessor;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.scope.FunctionSignature;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.type.Type;

import lombok.Getter;

@Getter
public class FunctionCall extends Call {
    private final Type owner;
    private final FunctionSignature signature;
    private final List<Expression> arguments;

    public FunctionCall(Type owner, FunctionSignature signature, List<Expression> arguments) {
        super(signature.getReturnType(), null, null);
        this.owner = owner;
        this.signature = signature;
        this.arguments = arguments;
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
}
