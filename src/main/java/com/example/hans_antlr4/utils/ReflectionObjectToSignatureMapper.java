package com.example.hans_antlr4.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.example.hans_antlr4.domain.expression.Parameter;
import com.example.hans_antlr4.domain.scope.FunctionSignature;
import com.example.hans_antlr4.domain.type.BuiltInType;

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

    public static FunctionSignature fromConstructor(Constructor<?> constructor) {
        String name = constructor.getName();
        List<Parameter> parameters = Arrays.stream(constructor.getParameters())
                .map(p -> new Parameter(TypeResolver.getFromTypeName(p.getType().getCanonicalName()), p.getName()))
                .collect(Collectors.toList());
        return new FunctionSignature(
                false, name, parameters,
                BuiltInType.VOID);
    }
}
