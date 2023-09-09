package com.example.hans_antlr4.domain.global;

import com.example.hans_antlr4.domain.scope.FunctionSignature;
import com.example.hans_antlr4.domain.statement.Block;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Function {
    private FunctionSignature functionSignature;
    private Block body;
}
