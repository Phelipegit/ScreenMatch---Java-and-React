package com.phelipe.ScreenMatch.Exception.ExceptionUser;

public class EmailEmptyException extends ScreenMatchException {
    public EmailEmptyException(String message) {
        super("EMAIL_EMPTY",message);
    }
}
