package com.phelipe.ScreenMatch.Exception.ExceptionUser;

public class EmailExistsException extends ScreenMatchException {
    public EmailExistsException() {
        super("EMAIL_EXISTS", "Email já cadastrado!");
    }
}
