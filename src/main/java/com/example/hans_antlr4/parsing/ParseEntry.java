package com.example.hans_antlr4.parsing;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import com.example.hans_antlr4.bytecode_gen.CompilationUnit;
import com.example.hans_antlr4.data_processor.ProcessorEntry;
import com.example.hans_antlr4.parsing.biz_visitor.CompilationUnitVisitor;
import com.example.hans_antlr4.program_arguments.CompilerArguments;
import com.example.hans_antlr4.utils.Const;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ParseEntry {
    public static CompilerArguments compilerArguments;

    public static CompilationUnit parseFromFilePath(
            String fileAbsolutePath, String publicClassName) throws IOException {
        CharStream charStream = CharStreams.fromFileName(fileAbsolutePath);
        return parse(charStream, publicClassName);
    }

    public static CompilationUnit parseFromCode(String code) {
        CharStream charStream = CharStreams.fromString(code);
        return parse(charStream, Const.mockPublicClass);
    }

    private static CompilationUnit parse(CharStream charStream, String publicClassName) {
        HansAntlrLexer lexer = new HansAntlrLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        HansAntlrParser parser = new HansAntlrParser(tokens);

        CompilationUnitVisitor compilationUnitVisitor = new CompilationUnitVisitor(publicClassName, compilerArguments);
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
