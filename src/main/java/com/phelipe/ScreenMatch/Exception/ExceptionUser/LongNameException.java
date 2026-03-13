package com.phelipe.ScreenMatch.Exception.ExceptionUser;

public class LongNameException extends ScreenMatchException {
    public LongNameException() {
        super("LONG_NAME", "Nome não pode ter acima de 200 caracteres");
    }
}
