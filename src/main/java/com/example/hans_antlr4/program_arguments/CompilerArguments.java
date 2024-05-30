package com.example.hans_antlr4.program_arguments;

import com.beust.jcommander.Parameter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompilerArguments {
    @Parameter(names = { "help", "-help", "-h" }, description = "View help information", help = true, order = 1)
    private boolean help;

    @Parameter(names = "-file", description = "File path ends with '.hant' extension", required = true, validateWith = HantFilePathValidator.class, order = 2)
    private String filePath;

    @Parameter(names = "-runMode", description = "Run the compiled class directly without writing the '.class' file to disk")
    private boolean runMode = false;

    @Parameter(names = "-constantFolding", description = "Enable constant folding optimization")
    private boolean constantFolding = false;

    @Parameter(names = "-debug", description = "Output debug information", hidden = true)
    private boolean debug = false;
}
