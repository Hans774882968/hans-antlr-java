package com.example.hans_antlr4.domain.global;

import com.example.hans_antlr4.domain.scope.FunctionSignature;
import com.example.hans_antlr4.domain.statement.Block;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Objects;

@AllArgsConstructor
@Getter
public class Function {
    private FunctionSignature functionSignature;
    private Block body;

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Function)) {
            return false;
        }
        Function function = (Function) o;
        return Objects.equals(functionSignature, function.functionSignature)
                && Objects.equals(body, function.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(functionSignature, body);
    }
}
