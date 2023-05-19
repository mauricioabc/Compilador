package com.compiler.Parser;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.*;

/**
 *
 * @author mauricio.rodrigues
 */
public class ErrorListener extends BaseErrorListener{
    private List<String> errors;
    
    public ErrorListener() {
        errors = new ArrayList<>();
    }

    public List<String> getErrors() {
        return errors;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
            int line, int charPositionInLine, String msg, RecognitionException e) {
        String error = "line " + line + ":" + charPositionInLine + " " + msg;
        errors.add(error);
    }
}
