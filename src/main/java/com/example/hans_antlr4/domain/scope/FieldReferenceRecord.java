package com.example.hans_antlr4.domain.scope;

import com.example.hans_antlr4.domain.type.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Objects;

@AllArgsConstructor
@Getter
public class FieldReferenceRecord {
    private boolean isStatic;
    private Type owner;
    private String fieldName;
    private Type fieldType;

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof FieldReferenceRecord)) {
            return false;
        }
        FieldReferenceRecord fieldReferenceRecord = (FieldReferenceRecord) o;
        return isStatic == fieldReferenceRecord.isStatic
                && Objects.equals(owner, fieldReferenceRecord.owner)
                && Objects.equals(fieldName, fieldReferenceRecord.fieldName)
                && Objects.equals(fieldType, fieldReferenceRecord.fieldType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isStatic, owner, fieldName, fieldType);
    }
}
