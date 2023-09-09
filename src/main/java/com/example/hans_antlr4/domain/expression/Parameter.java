package com.example.hans_antlr4.domain.expression;

import com.example.hans_antlr4.domain.type.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Parameter {
    private Type type;
    private String name;
}
