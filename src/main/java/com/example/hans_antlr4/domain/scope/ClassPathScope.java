package com.example.hans_antlr4.domain.scope;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.reflect.MethodUtils;

import com.example.hans_antlr4.domain.type.Type;
import com.example.hans_antlr4.utils.ReflectionObjectToSignatureMapper;

public class ClassPathScope {
    private Class<?>[] getParsedParamsFromArguments(Class<?> methodOwnerClass, List<Type> arguments) {
        return arguments.stream()
                .map(Type::getTypeClass).toArray(Class<?>[]::new);
    }

    private boolean isSpecialLibraryMethod(Class<?> methodOwnerClass) {
        return methodOwnerClass.getCanonicalName().equals("java.io.PrintStream");
    }

    private boolean isSystemOutPrintf(Class<?> methodOwnerClass, String methodName) {
        return methodOwnerClass.getCanonicalName().equals("java.io.PrintStream") && methodName.equals("printf");
    }

    public Method getMatchingAccessibleMethod(Class<?> methodOwnerClass, String methodName, Class<?>[] params) {
        if (isSpecialLibraryMethod(methodOwnerClass)) {
            final Method[] methods = methodOwnerClass.getMethods();
            final List<Method> matchingMethods = Stream.of(methods)
                    .filter(method -> method.getName().equals(methodName))
                    .collect(Collectors.toList());
            // TODO: 复制 MethodUtils.getMatchingAccessibleMethod 的一部分逻辑出来，增强通用性
            if (isSystemOutPrintf(methodOwnerClass, methodName)) {
                return matchingMethods.stream().filter(method -> {
                    if (params[0].getName().equals("java.util.Locale")) {
                        return method.getParameterTypes()[0].getCanonicalName().equals("java.util.Locale");
                    }
                    return method.getParameterTypes()[0].getCanonicalName().equals("java.lang.String");
                }).findFirst().orElseThrow(() -> new RuntimeException("Find matching System.out.printf failed!"));
            }
            return matchingMethods.get(0);
        }
        return MethodUtils.getMatchingAccessibleMethod(methodOwnerClass, methodName, params);
    }

    public Optional<FunctionSignature> getMethodSignature(Type owner, String methodName, List<Type> arguments) {
        try {
            Class<?> methodOwnerClass = owner.getTypeClass();
            Class<?>[] params = getParsedParamsFromArguments(methodOwnerClass, arguments);

            Method method = getMatchingAccessibleMethod(methodOwnerClass, methodName, params);
            return Optional.of(ReflectionObjectToSignatureMapper.fromMethod(method));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
