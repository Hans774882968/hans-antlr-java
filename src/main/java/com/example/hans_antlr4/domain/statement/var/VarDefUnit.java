package com.example.hans_antlr4.domain.statement.var;

import java.util.Objects;

import com.example.hans_antlr4.domain.expression.Expression;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class VarDefUnit {
    private String name;
    private Expression expression;

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof VarDefUnit)) {
            return false;
        }
        VarDefUnit varDefUnit = (VarDefUnit) o;
        return Objects.equals(name, varDefUnit.name) && Objects.equals(expression, varDefUnit.expression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, expression);
    }
}
