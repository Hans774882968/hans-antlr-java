package com.example.hans_antlr4.domain.scope;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.example.hans_antlr4.domain.global.MetaData;
import com.example.hans_antlr4.domain.type.Type;
import com.example.hans_antlr4.exception.LocalVariableNotFoundException;
import com.example.hans_antlr4.exception.func.MethodSignatureNotFoundException;

public class Scope {
    private MetaData metaData;
    private List<LocalVariable> localVariables;
    private List<FunctionSignature> functionSignatures;

    public Scope(MetaData metaData) {
        this.metaData = metaData;
        this.localVariables = new ArrayList<>();
        this.functionSignatures = new ArrayList<>();
    }

    public Scope(Scope scope) {
        this.metaData = scope.metaData;
        this.localVariables = new ArrayList<>(scope.localVariables);
        this.functionSignatures = new ArrayList<>(scope.functionSignatures);
    }

    public void addLocalVariable(LocalVariable localVariable) {
        localVariables.add(localVariable);
    }

    public void addLocalVariables(LocalVariable... localVariableList) {
        for (LocalVariable localVariable : localVariableList) {
            addLocalVariable(localVariable);
        }
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
        for (int i = 0, currentLocalVarIndex = 0; i < localVariables.size(); i++) {
            if (localVariables.get(i) == localVariable) {
                return currentLocalVarIndex;
            }
            currentLocalVarIndex += localVariables.get(i).getType().slotUsage();
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

    public void addSignature(FunctionSignature signature) {
        functionSignatures.add(signature);
    }

    // 支持重载功能
    public FunctionSignature getSignature(String methodName, List<Type> argTypes, int sourceLine) {
        return functionSignatures.stream()
                .filter(signature -> {
                    if (!signature.getName().equals(methodName)) {
                        return false;
                    }
                    if (signature.getParameters().size() != argTypes.size()) {
                        return false;
                    }
                    for (int i = 0; i < argTypes.size(); i++) {
                        Type paramType = signature.getParameters().get(i).getType();
                        Type argType = argTypes.get(i);
                        if (paramType != argType) {
                            return false;
                        }
                    }
                    return true;
                })
                .findFirst()
                .orElseThrow(() -> new MethodSignatureNotFoundException(this, methodName, sourceLine));
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
