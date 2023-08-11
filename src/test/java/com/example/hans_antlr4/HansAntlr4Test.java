package com.example.hans_antlr4;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Assert;
import org.junit.Test;

public class HansAntlr4Test {
    @Test
    public void var_and_print_test() {
        HansAntlrLexer lexer = new HansAntlrLexer(CharStreams.fromString("var x = 5\r\n" + //
                "print x\r\n" +
                "var str = \"hello world\"\r\n" +
                "print str"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        HansAntlrParser parser = new HansAntlrParser(tokens);
        ParseTree tree = parser.compilationUnit();
        String treeString = tree.toStringTree(parser);
        System.out.println(treeString);
        Assert.assertEquals(
                "(compilationUnit (variable var x = (value 5)) (print print x) (variable var str = (value \"hello world\")) (print print str) <EOF>)",
                treeString);
    }
}
