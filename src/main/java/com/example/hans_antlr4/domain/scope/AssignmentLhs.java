package com.example.hans_antlr4.domain.scope;

import com.example.hans_antlr4.domain.expression.ArrayAccess;
import com.example.hans_antlr4.domain.expression.ClassFieldReference;
import com.example.hans_antlr4.domain.type.Type;

import lombok.Getter;
import java.util.Objects;

@Getter
public class AssignmentLhs {
    private Variable variable;
    private ClassFieldReference classFieldReference;
    private ArrayAccess arrayAccess;

    public AssignmentLhs(Variable variable) {
        this.variable = variable;
    }

    public AssignmentLhs(ClassFieldReference classFieldReference) {
        this.classFieldReference = classFieldReference;
    }

    public AssignmentLhs(ArrayAccess arrayAccess) {
        this.arrayAccess = arrayAccess;
    }

    public Type getType() {
        if (variable != null) {
            return variable.getType();
        }
        if (classFieldReference != null) {
            return classFieldReference.getType();
        }
        if (arrayAccess != null) {
            return arrayAccess.getType();
        }
        throw new RuntimeException("Null AssignmentLhs has no type!");
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AssignmentLhs)) {
            return false;
        }
        AssignmentLhs assignmentLhs = (AssignmentLhs) o;
        return Objects.equals(variable, assignmentLhs.variable)
                && Objects.equals(classFieldReference, assignmentLhs.classFieldReference)
                && Objects.equals(arrayAccess, assignmentLhs.arrayAccess);
    }

    @Override
    public int hashCode() {
        return Objects.hash(variable, classFieldReference, arrayAccess);
    }
}
