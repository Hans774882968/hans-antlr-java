package com.example.hans_antlr4.domain.expression.reference;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.data_processor.ExpressionTreeProcessor;
import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.global.ValueInferResult;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.type.Type;
import com.example.hans_antlr4.utils.Const;

import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

@Setter
@Getter
public class VarReference extends Reference {
    public VarReference(String varName, Type type, int sourceLine) {
        super(varName, type, sourceLine);
        calculateValueInferResult();
    }

    public static VarReference varReferenceWithoutSourceLine(String varName, Type type) {
        return new VarReference(varName, type, Const.MOCK_SOURCE_LINE);
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
        if (!(o instanceof VarReference)) {
            return false;
        }
        VarReference varReference = (VarReference) o;
        return Objects.equals(getType(), varReference.getType())
                && Objects.equals(getVarName(), varReference.getVarName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getVarName());
    }
}
