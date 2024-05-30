package com.example.hans_antlr4.domain.expression;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.data_processor.ExpressionTreeProcessor;
import com.example.hans_antlr4.domain.global.ValueInferResult;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.type.ArrayType;
import com.example.hans_antlr4.domain.type.Type;
import com.example.hans_antlr4.exception.array.IllegalArrayLiteralException;

import lombok.Getter;
import java.util.Objects;

@Getter
public class ArrayLiteral extends Expression {
    private List<Expression> items;

    public ArrayLiteral(List<Expression> items, int sourceLine) {
        super(getInferredArrayType(items, sourceLine), null, null, sourceLine, null);
        this.items = items;
        calculateValueInferResult();
    }

    private static ArrayType getInferredArrayType(List<Expression> items, int sourceLine) {
        Set<Type> kinds = new HashSet<>();
        items.forEach(item -> {
            kinds.add(item.getType());
        });
        if (kinds.size() > 1 || kinds.isEmpty()) {
            throw new IllegalArrayLiteralException(items, kinds.size(), sourceLine);
        }
        Type elementType = items.get(0).getType();
        if (elementType instanceof ArrayType) {
            ArrayType arrayElementType = (ArrayType) elementType;
            return new ArrayType(arrayElementType.getElementType(), arrayElementType.getDimension() + 1);
        }
        return new ArrayType(elementType, 1);
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
        if (!(o instanceof ArrayLiteral)) {
            return false;
        }
        ArrayLiteral arrayLiteral = (ArrayLiteral) o;
        return Objects.equals(getType(), arrayLiteral.getType())
                && Objects.equals(items, arrayLiteral.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), items);
    }
}
