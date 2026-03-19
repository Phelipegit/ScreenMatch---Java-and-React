package com.phelipe.ScreenMatch.Exception.ExceptionUser;

public class ShortPasswordException extends ScreenMatchException {
    public ShortPasswordException(String message) {
        super("SHORT_PASSWORD", message);
    }
}