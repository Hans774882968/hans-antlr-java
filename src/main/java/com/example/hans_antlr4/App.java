package com.example.hans_antlr4;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class App {
    public static void main(String[] args) {
        HansAntlrLexer lexer = new HansAntlrLexer(CharStreams.fromString("var x1 = 114514\r\n" + //
                "print x1\r\n" +
                "var str = \"hello world\"\r\n" +
                "print str"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        HansAntlrParser parser = new HansAntlrParser(tokens);

        HansAntlrBaseListener listener = new HansAntlrBaseListener();
        parser.addParseListener(listener);
        HansAntlrErrorListener errorListener = new HansAntlrErrorListener();
        parser.addErrorListener(errorListener);

        ParseTree tree = parser.compilationUnit();
        String treeString = tree.toStringTree(parser);
        System.out.println(treeString);
    }
}
