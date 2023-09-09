package com.example.hans_antlr4.exception.func;

public class MainMethodNotFoundInPublicClass extends NoSuchMethodException {
    public MainMethodNotFoundInPublicClass() {
        super("Main method not found in public class");
    }

    public MainMethodNotFoundInPublicClass(String className) {
        super("Main method not found in public class " + className);
    }
}
