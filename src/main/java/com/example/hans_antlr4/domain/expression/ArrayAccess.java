package com.example.hans_antlr4.domain.expression;

import java.util.List;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.data_processor.ExpressionTreeProcessor;
import com.example.hans_antlr4.domain.global.ValueInferResult;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.type.ArrayType;
import com.example.hans_antlr4.domain.type.TypeChecker;
import com.example.hans_antlr4.exception.type.ArrayAccessGotNonArrayTypeException;

import lombok.Getter;
import java.util.Objects;

@Getter
public class ArrayAccess extends Expression {
    private Expression array;
    private List<Expression> dimensions;

    public ArrayAccess(Expression array, List<Expression> dimensions, int sourceLine) {
        super(null, null, null, sourceLine, null);
        arrayAccessTypeCheck(array, dimensions);
        ArrayType arrayType = (ArrayType) array.getType();
        this.array = array;
        this.dimensions = dimensions;
        setType(ArrayType.getDimensionReducedType(arrayType, dimensions.size(), sourceLine));
        calculateValueInferResult();
    }

    public void arrayAccessTypeCheck(Expression array, List<Expression> dimensions) {
        if (!(array.getType() instanceof ArrayType)) {
            throw new ArrayAccessGotNonArrayTypeException(array.getType(), getSourceLine());
        }
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
        if (!(o instanceof ArrayAccess)) {
            return false;
        }
        ArrayAccess arrayAccess = (ArrayAccess) o;
        return Objects.equals(getType(), arrayAccess.getType())
                && Objects.equals(array, arrayAccess.array)
                && Objects.equals(dimensions, arrayAccess.dimensions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), array, dimensions);
    }
}
