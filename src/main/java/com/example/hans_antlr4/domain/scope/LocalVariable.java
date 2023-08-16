package com.example.hans_antlr4.domain.scope;

import com.example.hans_antlr4.domain.type.Type;

import lombok.AllArgsConstructor;
import lombok.Data;

// 目前包含的字段与 src\main\java\com\example\hans_antlr4\domain\expression\VarReference.java 完全一致
@AllArgsConstructor
@Data
public class LocalVariable {
    private String varName;
    private Type type;
}
