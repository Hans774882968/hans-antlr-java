package com.example.hans_antlr4.domain.global;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Objects;

@AllArgsConstructor
@Data
public class MetaData {
    private String className;

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MetaData)) {
            return false;
        }
        MetaData metaData = (MetaData) o;
        return Objects.equals(className, metaData.className);
    }

    @Override
    public int hashCode() {
        return Objects.hash(className);
    }
}
