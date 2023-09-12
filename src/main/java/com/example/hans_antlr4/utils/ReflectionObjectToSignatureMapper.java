package com.example.hans_antlr4.utils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.example.hans_antlr4.domain.expression.Parameter;
import com.example.hans_antlr4.domain.scope.FunctionSignature;

public class ReflectionObjectToSignatureMapper {
    public static FunctionSignature fromMethod(Method method) {
        String name = method.getName();
        List<Parameter> parameters = Arrays.stream(method.getParameters())
                .map(p -> new Parameter(TypeResolver.getFromTypeName(p.getType().getCanonicalName()), p.getName()))
                .collect(Collectors.toList());
        Class<?> returnType = method.getReturnType();
        boolean isStatic = Modifier.isStatic(method.getModifiers());
        return new FunctionSignature(
                isStatic, name, parameters,
                TypeResolver.getFromJavaLangClass(returnType));
    }
}
