package com.example.hans_antlr4;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Assert;
import org.junit.Test;

import com.example.hans_antlr4.bytecode_gen.CompilationUnit;
import com.example.hans_antlr4.parsing.HansAntlrErrorListener;
import com.example.hans_antlr4.parsing.HansAntlrLexer;
import com.example.hans_antlr4.parsing.HansAntlrParser;
import com.example.hans_antlr4.parsing.biz_visitor.CompilationUnitVisitor;

public class HansAntlr4Test {
    @Test
    public void varAndPrintTest() {
        HansAntlrLexer lexer = new HansAntlrLexer(CharStreams.fromString("var x = 5\r\n" +
                "print x\r\n" +
                "var str = \"hello world\"\r\n" +
                "print str\n" +
                "var str2 = \"支持输入中文\"" +
                "print str2"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        HansAntlrParser parser = new HansAntlrParser(tokens);

        CompilationUnitVisitor compilationUnitVisitor = new CompilationUnitVisitor();
        HansAntlrErrorListener errorListener = new HansAntlrErrorListener();
        parser.addErrorListener(errorListener);

        ParseTree tree = parser.compilationUnit();
        CompilationUnit compilationUnit = tree.accept(compilationUnitVisitor);
        String treeString = tree.toStringTree(parser);
        System.out.println(treeString);
        Assert.assertEquals(
                "(compilationUnit (statements (variable var x = (expression (value 5))) (print print (expression (variableReference x))) (variable var str = (expression (value \"hello world\"))) (print print (expression (variableReference str))) (variable var str2 = (expression (value \"支持输入中文\"))) (print print (expression (variableReference str2)))) <EOF>)",
                treeString);

        Assert.assertEquals(6, compilationUnit.getInstructionsQueue().size());
    }

    @Test
    public void expressionTest() {
        HansAntlrLexer lexer = new HansAntlrLexer(
                CharStreams.fromString("var x = 2 ** 3 * 3 ** 2 + 2 ** 3\r\n" + "print x\r\n"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        HansAntlrParser parser = new HansAntlrParser(tokens);

        CompilationUnitVisitor compilationUnitVisitor = new CompilationUnitVisitor();
        HansAntlrErrorListener errorListener = new HansAntlrErrorListener();
        parser.addErrorListener(errorListener);

        ParseTree tree = parser.compilationUnit();
        tree.accept(compilationUnitVisitor);
        String treeString = tree.toStringTree(parser);
        Assert.assertEquals(
                "(compilationUnit (statements (variable var x = (expression (expression (expression (expression (value 2)) ** (expression (value 3))) * (expression (expression (value 3)) ** (expression (value 2)))) + (expression (expression (value 2)) ** (expression (value 3))))) (print print (expression (variableReference x)))) <EOF>)",
                treeString);
    }
}
