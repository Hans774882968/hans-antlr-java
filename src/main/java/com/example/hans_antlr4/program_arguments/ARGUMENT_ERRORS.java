package com.example.hans_antlr4.program_arguments;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ARGUMENT_ERRORS {
    NONE(""), NO_FILE("Plz specify files for compilation"), BAD_FILE_EXTENSION("File has to end with .hant extension");

    private final String message;
}
