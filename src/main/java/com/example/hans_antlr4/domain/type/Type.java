package com.example.hans_antlr4.domain.type;

public interface Type {
    String getName();

    Class<?> getTypeClass();

    String getDescriptor();

    String getInternalName();
}
