package com.example.hans_antlr4.domain.type;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClassType implements Type {
    private String name;

    @Override
    public Class<?> getTypeClass() {
        try {
            return Class.forName(name);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public String getDescriptor() {
        return "L" + getInternalName() + ";";
    }

    @Override
    public String getInternalName() {
        return name.replace(".", "/");
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ClassType)) {
            return false;
        }
        ClassType classType = (ClassType) o;
        return Objects.equals(name, classType.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
