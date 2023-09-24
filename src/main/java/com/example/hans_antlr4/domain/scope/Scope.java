package com.example.hans_antlr4.domain.scope;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.example.hans_antlr4.domain.global.MetaData;
import com.example.hans_antlr4.domain.type.ClassType;
import com.example.hans_antlr4.domain.type.Type;
import com.example.hans_antlr4.exception.func.MethodSignatureNotFoundException;
import com.example.hans_antlr4.exception.scope.GlobalVariableNotFoundException;
import com.example.hans_antlr4.exception.scope.LocalVariableNotFoundException;

import lombok.Getter;

@Getter
public class Scope {
    private MetaData metaData;
    private List<LocalVariable> localVariables;
    private List<FunctionSignature> functionSignatures;
    private List<GlobalVariable> globalVariables;

    public Scope(MetaData metaData) {
        this.metaData = metaData;
        this.localVariables = new ArrayList<>();
        this.functionSignatures = new ArrayList<>();
        this.globalVariables = new ArrayList<>();
    }

    public Scope(Scope scope) {
        this.metaData = scope.metaData;
        this.localVariables = new ArrayList<>(scope.localVariables);
        this.functionSignatures = new ArrayList<>(scope.functionSignatures);
        this.globalVariables = new ArrayList<>(scope.globalVariables);
    }

    public void addLocalVariable(LocalVariable localVariable) {
        localVariables.add(localVariable);
    }

    public void addLocalVariables(LocalVariable... localVariableList) {
        for (LocalVariable localVariable : localVariableList) {
            addLocalVariable(localVariable);
        }
    }

    public void addGlobalVariable(GlobalVariable globalVariable) {
        globalVariables.add(globalVariable);
    }

    public void addGlobalVariables(GlobalVariable... globalVariableList) {
        for (GlobalVariable globalVariable : globalVariableList) {
            addGlobalVariable(globalVariable);
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

    public GlobalVariable getGlobalVariable(String varName) {
        return globalVariables.stream()
                .filter(variable -> variable.getVarName().equals(varName))
                .reduce((result, item) -> item)
                .orElseThrow(() -> new GlobalVariableNotFoundException(this, varName));
    }

    public boolean globalVariableExists(String varName) {
        return globalVariables.stream()
                .anyMatch(variable -> variable.getVarName().equals(varName));
    }

    public String getClassName() {
        return metaData.getClassName();
    }

    public Type getClassType() {
        String className = getClassName();
        return ClassType.getTypeByQualifiedName(className);
    }

    public void addSignature(FunctionSignature signature) {
        functionSignatures.add(signature);
    }

    // 支持重载功能
    public FunctionSignature getMethodCallSignature(String methodName, List<Type> argTypes, int sourceLine) {
        return functionSignatures.stream()
                .filter(signature -> signature.matches(methodName, argTypes))
                .findFirst()
                .orElseThrow(() -> new MethodSignatureNotFoundException(this, methodName, sourceLine));
    }

    public FunctionSignature getMethodCallSignature(
            Optional<Type> owner,
            String methodName,
            List<Type> argTypes,
            int sourceLine) {
        boolean isDifferentThanCurrentClass = owner.isPresent() && !owner.get().equals(getClassType());
        if (isDifferentThanCurrentClass) {
            return new ClassPathScope()
                    .getMethodSignature(owner.get(), methodName, argTypes)
                    .orElseThrow(() -> new MethodSignatureNotFoundException(this, methodName, sourceLine));
        }
        return getMethodCallSignature(methodName, argTypes, sourceLine);
    }

    public FunctionSignature getConstructorCallSignature(
            String className,
            List<Type> argTypes,
            int sourceLine) {
        boolean isDifferentThanCurrentClass = !className.equals(getClassName());
        if (isDifferentThanCurrentClass) {
            return new ClassPathScope()
                    .getConstructorSignature(className, argTypes)
                    .orElseThrow(() -> new MethodSignatureNotFoundException(this, className, sourceLine));
        }
        return getMethodCallSignature(Optional.empty(), getClassName(), argTypes, sourceLine);
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
