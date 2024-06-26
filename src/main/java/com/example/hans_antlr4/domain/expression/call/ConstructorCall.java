package com.example.hans_antlr4.domain.expression.call;

import java.util.Collections;
import java.util.List;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.data_processor.ExpressionTreeProcessor;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.global.ValueInferResult;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.type.ClassType;

import lombok.Getter;

import java.util.Objects;

@Getter
public class ConstructorCall extends Call {
    private final List<Expression> arguments;
    private final String identifier;
    private final int sourceLine;

    public ConstructorCall(String identifier, int sourceLine) {
        this(identifier, Collections.emptyList(), sourceLine);
    }

    public ConstructorCall(String className, List<Expression> arguments, int sourceLine) {
        super(ClassType.getTypeByQualifiedName(className), null, null, sourceLine);
        this.arguments = arguments;
        this.identifier = getIdentifierName();
        this.sourceLine = sourceLine;
        calculateValueInferResult();
    }

    private String getIdentifierName() {
        String tmpName = getType().getName();
        if (tmpName.equals("string")) {
            return "java.lang.String";
        }
        if (tmpName.equals("object")) {
            return "java.lang.Object";
        }
        return tmpName;
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
        if (!(o instanceof ConstructorCall)) {
            return false;
        }
        ConstructorCall constructorCall = (ConstructorCall) o;
        return Objects.equals(arguments, constructorCall.arguments)
                && Objects.equals(getType(), constructorCall.getType())
                && Objects.equals(identifier, constructorCall.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(arguments, getType(), identifier);
    }
}
