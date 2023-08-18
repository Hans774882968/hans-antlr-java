package com.example.hans_antlr4;

import com.example.hans_antlr4.bytecode_gen.CompilationUnit;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.parsing.ParseEntry;

public class TestUtils {
    public static Statement getFirstStatementFromCode(String code) {
        CompilationUnit compilationUnit = ParseEntry.parseFromCode(code);
        return compilationUnit.getInstructionsQueue().peek();
    }
}
