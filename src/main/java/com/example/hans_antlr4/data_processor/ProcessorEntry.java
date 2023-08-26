package com.example.hans_antlr4.data_processor;

import com.example.hans_antlr4.bytecode_gen.CompilationUnit;
import com.example.hans_antlr4.domain.statement.Statement;

public class ProcessorEntry {
    public static void process(CompilationUnit compilationUnit) {
        StatementTreeProcessor processor = new StatementTreeProcessor();
        for (Statement statement : compilationUnit.getInstructionsQueue()) {
            statement.processSubStatementTree(processor, null, null);
        }
    }
}
