package com.phelipe.ScreenMatch.Exception.ExceptionUser;

public class EmptyFieldsException extends ScreenMatchException {
    public EmptyFieldsException() {
        super("EMPTY", "Campos não podem ficar vazios!");
    }
}
