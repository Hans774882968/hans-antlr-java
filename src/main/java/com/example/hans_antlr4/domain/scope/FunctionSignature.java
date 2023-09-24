package com.example.hans_antlr4.domain.scope;

import java.util.Collections;
import java.util.List;

import com.example.hans_antlr4.domain.expression.Parameter;
import com.example.hans_antlr4.domain.type.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Objects;

@AllArgsConstructor
@Getter
public class FunctionSignature {
    private final boolean isStatic;
    private final String name;
    private final List<Parameter> parameters;
    private final Type returnType;

    public List<Parameter> getParameters() {
        return Collections.unmodifiableList(parameters);
    }

    public boolean matches(String methodName, List<Type> argTypes) {
        if (!name.equals(methodName)) {
            return false;
        }
        if (parameters.size() != argTypes.size()) {
            return false;
        }
        for (int i = 0; i < argTypes.size(); i++) {
            Type paramType = parameters.get(i).getType();
            Type argType = argTypes.get(i);
            if (!paramType.equals(argType)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof FunctionSignature)) {
            return false;
        }
        FunctionSignature functionSignature = (FunctionSignature) o;
        return isStatic == functionSignature.isStatic
                && Objects.equals(name, functionSignature.name)
                && Objects.equals(parameters, functionSignature.parameters)
                && Objects.equals(returnType, functionSignature.returnType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isStatic, name, parameters, returnType);
    }
}
