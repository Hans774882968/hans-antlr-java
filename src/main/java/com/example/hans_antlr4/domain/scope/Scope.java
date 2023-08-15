package com.example.hans_antlr4.domain.scope;

import java.util.ArrayList;
import java.util.List;

import com.example.hans_antlr4.domain.global.MetaData;
import com.example.hans_antlr4.exception.LocalVariableNotFoundException;

public class Scope {
    private List<LocalVariable> localVariables;
    private MetaData metaData;

    public Scope(MetaData metaData) {
        this.metaData = metaData;
        localVariables = new ArrayList<>();
    }

    public Scope(Scope scope) {
        metaData = scope.metaData;
        localVariables = new ArrayList<>();
    }

    public void addLocalVariable(LocalVariable localVariable) {
        localVariables.add(localVariable);
    }

    public LocalVariable getLocalVariable(String varName) {
        return localVariables.stream()
                .filter(variable -> variable.getVarName().equals(varName))
                .findFirst()
                .orElseThrow(() -> new LocalVariableNotFoundException(this, varName));
    }

    public int getLocalVariableIndex(String varName) {
        LocalVariable localVariable = getLocalVariable(varName);
        return localVariables.indexOf(localVariable);
    }

    public String getClassName() {
        return metaData.getClassName();
    }
}
