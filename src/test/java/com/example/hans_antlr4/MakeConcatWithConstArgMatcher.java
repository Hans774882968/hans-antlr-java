package com.example.hans_antlr4;

import org.mockito.ArgumentMatcher;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MakeConcatWithConstArgMatcher implements ArgumentMatcher<Object> {
    private int stringElementCount;

    @Override
    public boolean matches(Object right) {
        if (!(right instanceof String)) {
            return false;
        }
        return right.toString().equals("\u0001".repeat(stringElementCount));
    }
}
