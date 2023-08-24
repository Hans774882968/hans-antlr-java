package com.example.hans_antlr4.parsing;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import com.example.hans_antlr4.bytecode_gen.CompilationUnit;
import com.example.hans_antlr4.data_processor.ProcessorEntry;
import com.example.hans_antlr4.parsing.biz_visitor.CompilationUnitVisitor;

public class ParseEntry {
    public static CompilationUnit parseFromFilePath(String fileAbsolutePath) throws IOException {
        CharStream charStream = CharStreams.fromFileName(fileAbsolutePath);
        return parse(charStream);
    }

    public static CompilationUnit parseFromCode(String code) {
        CharStream charStream = CharStreams.fromString(code);
        return parse(charStream);
    }

    private static CompilationUnit parse(CharStream charStream) {
        HansAntlrLexer lexer = new HansAntlrLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        HansAntlrParser parser = new HansAntlrParser(tokens);

        CompilationUnitVisitor compilationUnitVisitor = new CompilationUnitVisitor();
        HansAntlrErrorListener errorListener = new HansAntlrErrorListener();
        parser.addErrorListener(errorListener);

        ParseTree tree = parser.compilationUnit();
        CompilationUnit compilationUnit = tree.accept(compilationUnitVisitor);

        onParseEnd(compilationUnit);

        String treeString = tree.toStringTree(parser);
        System.out.println(treeString);

        return compilationUnit;
    }

    private static void onParseEnd(CompilationUnit compilationUnit) {
        ProcessorEntry.process(compilationUnit);
    }
}
