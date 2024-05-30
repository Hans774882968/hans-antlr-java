package com.example.hans_antlr4.domain.global;

import com.example.hans_antlr4.domain.expression.Value;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Objects;

@AllArgsConstructor
@Getter
public class ValueInferResult {
    public static ValueInferResult nonConst = new ValueInferResult(false, null);
    private boolean isConst;
    private Value value;

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ValueInferResult)) {
            return false;
        }
        ValueInferResult valueInferResult = (ValueInferResult) o;
        return isConst == valueInferResult.isConst &&
                Objects.equals(value, valueInferResult.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isConst, value);
    }
}
