package com.example.hans_antlr4.domain.expression;

import com.example.hans_antlr4.bytecode_gen.expression.ExpressionGenerator;
import com.example.hans_antlr4.data_processor.ExpressionTreeProcessor;
import com.example.hans_antlr4.domain.scope.FieldReferenceRecord;
import com.example.hans_antlr4.domain.statement.Statement;
import com.example.hans_antlr4.domain.type.ClassType;
import com.example.hans_antlr4.domain.type.Type;

import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
public class ClassFieldReference extends Expression {
    private String qualifiedName;
    private List<FieldReferenceRecord> fieldReferenceRecords;

    public ClassFieldReference(String qualifiedName, List<FieldReferenceRecord> fieldReferenceRecords) {
        super(getReturnTypeInInit(qualifiedName, fieldReferenceRecords), null, null);
        this.qualifiedName = qualifiedName;
        this.fieldReferenceRecords = fieldReferenceRecords;
    }

    private static Type getReturnTypeInInit(String qualifiedName, List<FieldReferenceRecord> fieldReferenceRecords) {
        if (fieldReferenceRecords.isEmpty()) {
            return new ClassType(qualifiedName);
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
                && Objects.equals(qualifiedName, classFieldReference.qualifiedName)
                && Objects.equals(fieldReferenceRecords, classFieldReference.fieldReferenceRecords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qualifiedName, fieldReferenceRecords);
    }
}
