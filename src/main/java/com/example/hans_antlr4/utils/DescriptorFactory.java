package com.example.hans_antlr4.utils;

import java.util.Collection;
import java.util.stream.Collectors;

import com.example.hans_antlr4.domain.expression.Parameter;
import com.example.hans_antlr4.domain.global.Function;
import com.example.hans_antlr4.domain.scope.FunctionSignature;
import com.example.hans_antlr4.domain.type.Type;

public class DescriptorFactory {
    public static String getMethodDescriptor(Function function) {
        Collection<Parameter> parameters = function.getFunctionSignature().getParameters();
        Type returnType = function.getFunctionSignature().getReturnType();
        return getMethodDescriptor(parameters, returnType);
    }

    public static String getMethodDescriptor(FunctionSignature signature) {
        Collection<Parameter> parameters = signature.getParameters();
        Type returnType = signature.getReturnType();
        return getMethodDescriptor(parameters, returnType);
    }

    private static String getMethodDescriptor(Collection<Parameter> parameters, Type returnType) {
        String parametersDescriptor = parameters.stream()
                .map(parameter -> parameter.getType().getDescriptor())
                .collect(Collectors.joining("", "(", ")"));
        String returnDescriptor = returnType.getDescriptor();
        return parametersDescriptor + returnDescriptor;
    }
}
