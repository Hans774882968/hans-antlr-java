package com.example.hans_antlr4.domain.expression;

import java.util.List;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.data_processor.ExpressionTreeProcessor;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.type.ArrayType;
import com.example.hans_antlr4.domain.type.BuiltInType;
import com.example.hans_antlr4.domain.type.Type;

import lombok.Getter;
import java.util.Objects;

@Getter
public class ArrayDeclaration extends Expression {
    private Type elementType;
    private List<Expression> dimensions;

    public ArrayDeclaration(Type elementType, List<Expression> dimensions) {
        super(null, null, null);
        // 数组下标支持 long 和 int
        for (Expression dimension : dimensions) {
            if (dimension.getType() != BuiltInType.INT && dimension.getType() != BuiltInType.LONG) {
                throw new RuntimeException("Array index type should be int or long, but got " + dimension.getType());
            }
        }
        setType(new ArrayType(elementType, dimensions.size()));
        this.elementType = elementType;
        this.dimensions = dimensions;
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
