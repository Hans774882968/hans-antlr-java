package com.example.hans_antlr4.domain.expression;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.data_processor.ExpressionTreeProcessor;
import com.example.hans_antlr4.domain.scope.FieldReferenceRecord;
import com.example.hans_antlr4.domain.scope.Variable;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.type.ClassType;
import com.example.hans_antlr4.domain.type.Type;

import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
public class ClassFieldReference extends Expression {
    private boolean startsWithClass;
    private Variable startVar; // 仅 startsWithClass = false 时有
    private List<FieldReferenceRecord> fieldReferenceRecords;

    public ClassFieldReference(String qualifiedName, List<FieldReferenceRecord> fieldReferenceRecords) {
        super(getReturnTypeInInit(qualifiedName, fieldReferenceRecords), null, null);
        this.startsWithClass = true;
        this.fieldReferenceRecords = fieldReferenceRecords;
    }

    public ClassFieldReference(Variable startVar, List<FieldReferenceRecord> fieldReferenceRecords) {
        super(getReturnTypeInInitOrReportError(fieldReferenceRecords), null, null);
        this.startsWithClass = false;
        this.startVar = startVar;
        this.fieldReferenceRecords = fieldReferenceRecords;
    }

    private static Type getReturnTypeInInit(String qualifiedName, List<FieldReferenceRecord> fieldReferenceRecords) {
        if (fieldReferenceRecords.isEmpty()) {
            return ClassType.getTypeByQualifiedName(qualifiedName);
        }
        return fieldReferenceRecords.get(fieldReferenceRecords.size() - 1).getFieldType();
    }

    private static Type getReturnTypeInInitOrReportError(List<FieldReferenceRecord> fieldReferenceRecords) {
        if (fieldReferenceRecords.isEmpty()) {
            throw new RuntimeException("Illegal field reference without class qualified name");
        }
        return fieldReferenceRecords.get(fieldReferenceRecords.size() - 1).getFieldType();
    }

    @Override
    public void accept(ExpressionGenerator generator) {
        generator.generate(this);
    }

    @Override
    public void processSubExpressionTree(
            ExpressionTreeProcessor processor,
            Expression parent,
            Statement belongStatement) {
        processor.processExpressionTree(this, parent, belongStatement);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ClassFieldReference)) {
            return false;
        }
        ClassFieldReference classFieldReference = (ClassFieldReference) o;
        return Objects.equals(getType(), classFieldReference.getType())
                && Objects.equals(fieldReferenceRecords, classFieldReference.fieldReferenceRecords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldReferenceRecords);
    }
}
