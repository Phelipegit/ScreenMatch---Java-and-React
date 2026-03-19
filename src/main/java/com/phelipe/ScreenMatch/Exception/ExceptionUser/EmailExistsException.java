package com.phelipe.ScreenMatch.Exception.ExceptionUser;

public class EmailExistsException extends ScreenMatchException {
    public EmailExistsException(String message) {
        super("EMAIL_EXISTS", message);
    }
}
