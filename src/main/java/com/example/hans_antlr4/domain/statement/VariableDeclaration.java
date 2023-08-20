package com.example.hans_antlr4.domain.statement;

import com.example.hans_antlr4.bytecode_gen.statement.StatementGenerator;
import com.example.hans_antlr4.domain.expression.Expression;

import lombok.Getter;
import java.util.Objects;

@Getter
public class VariableDeclaration implements Statement {
    private String name;
    private Expression expression;

    public VariableDeclaration(String name, Expression expression) {
        this.name = name;
        this.expression = expression;
    }

    @Override
    public void accept(StatementGenerator generator) {
        generator.generate(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof VariableDeclaration)) {
            return false;
        }
        VariableDeclaration variableDeclaration = (VariableDeclaration) o;
        return Objects.equals(name, variableDeclaration.name)
                && Objects.equals(expression, variableDeclaration.expression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, expression);
    }
}
