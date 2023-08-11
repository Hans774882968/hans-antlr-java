package com.example.hans_antlr4;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Variable {
    private int varIndex;
    private int varType;
    private String name;
    private String varTextValue;
}
