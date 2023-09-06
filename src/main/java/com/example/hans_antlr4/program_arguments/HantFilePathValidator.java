package com.example.hans_antlr4.program_arguments;

import java.io.File;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class HantFilePathValidator implements IParameterValidator {
    @Override
    public void validate(String key, String filePath) throws ParameterException {
        if (!filePath.endsWith(".hant")) {
            throw new ParameterException(ARGUMENT_ERRORS.BAD_FILE_EXTENSION.getMessage());
        }
        File file = new File(filePath);
        if (!file.exists()) {
            throw new ParameterException("'" + filePath + "' does not exist");
        }
    }
}
