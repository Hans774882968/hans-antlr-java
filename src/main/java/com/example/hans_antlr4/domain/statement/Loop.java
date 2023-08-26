package com.example.hans_antlr4.domain.statement;

import org.objectweb.asm.Label;

import com.example.hans_antlr4.domain.scope.Scope;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Loop extends Statement {
    private Statement bodyStatement;
    private Scope scope;
    private Label operationLabel;
    private Label endLoopLabel;

    public Loop(Statement bodyStatement, Scope scope) {
        this.bodyStatement = bodyStatement;
        this.scope = scope;
        this.operationLabel = new Label();
        this.endLoopLabel = new Label();
    }
}
