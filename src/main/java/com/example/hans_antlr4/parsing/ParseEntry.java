package com.example.hans_antlr4.parsing;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import com.example.hans_antlr4.bytecode_gen.CompilationUnit;
import com.example.hans_antlr4.data_processor.ProcessorEntry;
import com.example.hans_antlr4.parsing.biz_visitor.CompilationUnitVisitor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ParseEntry {
    public static String publicClassName;

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

        CompilationUnitVisitor compilationUnitVisitor = new CompilationUnitVisitor(publicClassName);
        HansAntlrErrorListener errorListener = new HansAntlrErrorListener();
        parser.addErrorListener(errorListener);

        ParseTree tree = parser.compilationUnit();
        CompilationUnit compilationUnit = tree.accept(compilationUnitVisitor);

        onParseEnd(compilationUnit);

        String treeString = tree.toStringTree(parser);
        log.debug(treeString);

        return compilationUnit;
    }

    private static void onParseEnd(CompilationUnit compilationUnit) {
        ProcessorEntry.process(compilationUnit);
    }
}
