package com.example.hans_antlr4.domain.scope;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        localVariables = new ArrayList<>(scope.localVariables);
    }

    public void addLocalVariable(LocalVariable localVariable) {
        localVariables.add(localVariable);
    }

    public LocalVariable getLocalVariable(String varName) {
        // 越靠后的元素作用域层级越大，所以可以通过返回最后一个元素来实现变量 shadow
        return localVariables.stream()
                .filter(variable -> variable.getVarName().equals(varName))
                .reduce((result, item) -> item)
                .orElseThrow(() -> new LocalVariableNotFoundException(this, varName));
    }

    public int getLocalVariableIndex(String varName) {
        LocalVariable localVariable = getLocalVariable(varName);
        // 这里必须使用 == 比较对象地址，所以不能使用 indexOf
        for (int i = 0; i < localVariables.size(); i++) {
            if (localVariables.get(i) == localVariable) {
                return i;
            }
        }
        return -1;
    }

    public boolean localVariableExists(String varName) {
        return localVariables.stream()
                .anyMatch(variable -> variable.getVarName().equals(varName));
    }

    public String getClassName() {
        return metaData.getClassName();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Scope)) {
            return false;
        }
        Scope scope = (Scope) o;
        return Objects.equals(localVariables, scope.localVariables) && Objects.equals(metaData, scope.metaData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(localVariables, metaData);
    }
}
