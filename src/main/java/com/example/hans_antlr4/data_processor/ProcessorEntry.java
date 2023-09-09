package com.example.hans_antlr4.data_processor;

import com.example.hans_antlr4.bytecode_gen.CompilationUnit;
import com.example.hans_antlr4.domain.global.Function;

public class ProcessorEntry {
    public static void process(CompilationUnit compilationUnit) {
        StatementTreeProcessor processor = new StatementTreeProcessor();
        for (Function function : compilationUnit.getFunctions()) {
            function.getBody().processSubStatementTree(processor, null, null);
        }

        CheckOutsideLoopBreakContinueProcessor checkProcessor = new CheckOutsideLoopBreakContinueProcessor();
        for (Function function : compilationUnit.getFunctions()) {
            function.getBody().checkOutsideLoopBreakContinue(checkProcessor);
        }
    }
}
