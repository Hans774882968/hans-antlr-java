package com.example.hans_antlr4.domain.expression;

import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.type.Type;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Expression implements Statement {
    private Type type;
}
