package com.example.hans_antlr4.parsing.biz_visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.hans_antlr4.domain.expression.Expression;
import com.example.hans_antlr4.domain.expression.TemplateString;
import com.example.hans_antlr4.parsing.HansAntlrParser;
import com.example.hans_antlr4.parsing.HansAntlrParserBaseVisitor;
import com.example.hans_antlr4.parsing.HansAntlrParser.TemplateStringAtomContext;
import com.example.hans_antlr4.utils.TypeResolver;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TemplateStringVisitor extends HansAntlrParserBaseVisitor<TemplateString> {
    private ExpressionVisitor parent;

    @Override
    public TemplateString visitTemplateStringLiteral(HansAntlrParser.TemplateStringLiteralContext ctx) {
        List<String> strs = new ArrayList<>();
        List<Expression> expressions = new ArrayList<>();
        String curString = "";
        List<TemplateStringAtomContext> atoms = ctx.templateStringAtom();
        for (TemplateStringAtomContext atom : atoms) {
            if (atom.TemplateStringAtom() != null) {
                curString += atom.TemplateStringAtom().getText();
                continue;
            }
            strs.add(curString);
            curString = "";
            if (atom.expression() != null) {
                expressions.add(atom.expression().accept(parent));
            }
        }
        strs.add(curString);
        strs = strs.stream().map(s -> {
            return TypeResolver.getTransformedStringInTemplateString(s);
        }).collect(Collectors.toList());
        int sourceLine = ctx.getStart().getLine();
        return new TemplateString(strs, expressions, sourceLine);
    }
}
