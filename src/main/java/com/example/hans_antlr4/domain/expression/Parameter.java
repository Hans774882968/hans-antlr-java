package com.example.hans_antlr4.domain.expression;

import com.example.hans_antlr4.domain.type.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Objects;

@AllArgsConstructor
@Getter
public class Parameter {
    private Type type;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Parameter)) {
            return false;
        }
        Parameter parameter = (Parameter) o;
        return Objects.equals(type, parameter.type) && Objects.equals(name, parameter.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name);
    }
}
