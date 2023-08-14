package com.example.hans_antlr4;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Assert;
import org.junit.Test;

import com.example.hans_antlr4.parsing.HansAntlrBaseListener;
import com.example.hans_antlr4.parsing.HansAntlrErrorListener;
import com.example.hans_antlr4.parsing.HansAntlrLexer;
import com.example.hans_antlr4.parsing.HansAntlrParser;

public class HansAntlr4Test {
    @Test
    public void var_and_print_test() {
        HansAntlrLexer lexer = new HansAntlrLexer(CharStreams.fromString("var x = 5\r\n" + //
                "print x\r\n" +
                "var str = \"hello world\"\r\n" +
                "print str\n" +
                "var str2 = \"支持输入中文\"" +
                "print str2"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        HansAntlrParser parser = new HansAntlrParser(tokens);

        HansAntlrBaseListener listener = new HansAntlrBaseListener();
        parser.addParseListener(listener);
        HansAntlrErrorListener errorListener = new HansAntlrErrorListener();
        parser.addErrorListener(errorListener);

        ParseTree tree = parser.compilationUnit();
        String treeString = tree.toStringTree(parser);
        System.out.println(treeString);
        Assert.assertEquals(
                "(compilationUnit (variable var x = (value 5)) (print print x) (variable var str = (value \"hello world\")) (print print str) (variable var str2 = (value \"\u652F\u6301\u8F93\u5165\u4E2D\u6587\")) (print print str2) <EOF>)",
                treeString);
    }
}
