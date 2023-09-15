package com.example.hans_antlr4.domain.expression;

import java.util.List;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.data_processor.ExpressionTreeProcessor;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.type.ArrayType;
import com.example.hans_antlr4.domain.type.BuiltInType;

import lombok.Getter;
import java.util.Objects;

@Getter
public class ArrayAccess extends Expression {
    private Expression array;
    private List<Expression> dimensions;

    public ArrayAccess(Expression array, List<Expression> dimensions) {
        super(null, null, null);
        if (!(array.getType() instanceof ArrayType)) {
            throw new RuntimeException("Expected array type but got non-array type " + array.getType().getName());
        }
        // 数组下标支持 long 和 int
        for (Expression dimension : dimensions) {
            if (dimension.getType() != BuiltInType.INT && dimension.getType() != BuiltInType.LONG) {
                throw new RuntimeException("Array index type should be int or long, but got " + dimension.getType());
            }
        }
        ArrayType arrayType = (ArrayType) array.getType();
        this.array = array;
        this.dimensions = dimensions;
        setType(ArrayType.getDimensionReducedType(arrayType, dimensions.size()));
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
