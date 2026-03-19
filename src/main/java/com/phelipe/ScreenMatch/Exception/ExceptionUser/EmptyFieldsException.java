package com.phelipe.ScreenMatch.Exception.ExceptionUser;

public class EmptyFieldsException extends ScreenMatchException {
    public EmptyFieldsException(String message) {
        super("EMPTY", message);
    }
}
