package com.example.hans_antlr4.domain.scope;

import com.example.hans_antlr4.domain.type.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FieldReferenceRecord {
    private boolean isStatic;
    private Type owner;
    private String fieldName;
    private Type fieldType;
}
