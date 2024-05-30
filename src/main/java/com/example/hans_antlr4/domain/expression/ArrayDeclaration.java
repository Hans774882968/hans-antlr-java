package com.example.hans_antlr4.domain.expression;

import java.util.List;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.data_processor.ExpressionTreeProcessor;
import com.example.hans_antlr4.domain.global.ValueInferResult;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.type.ArrayType;
import com.example.hans_antlr4.domain.type.Type;
import com.example.hans_antlr4.domain.type.TypeChecker;

import lombok.Getter;
import java.util.Objects;

@Getter
public class ArrayDeclaration extends Expression {
    private Type elementType;
    private List<Expression> dimensions;

    public ArrayDeclaration(Type elementType, List<Expression> dimensions, int sourceLine) {
        super(null, null, null, sourceLine, null);
        arrayDimensionTypeCheck(dimensions);
        setType(new ArrayType(elementType, dimensions.size()));
        this.elementType = elementType;
        this.dimensions = dimensions;
        calculateValueInferResult();
    }

    public void arrayDimensionTypeCheck(List<Expression> dimensions) {
        TypeChecker.arrayDimensionTypeCheck(dimensions, getSourceLine());
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
        if (!(o instanceof ArrayDeclaration)) {
            return false;
        }
        ArrayDeclaration arrayDeclaration = (ArrayDeclaration) o;
        return Objects.equals(getType(), arrayDeclaration.getType())
                && Objects.equals(elementType, arrayDeclaration.elementType)
                && Objects.equals(dimensions, arrayDeclaration.dimensions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), elementType, dimensions);
    }
}
