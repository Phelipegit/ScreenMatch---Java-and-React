package com.phelipe.ScreenMatch.Exception.ExceptionUser;

public class ShortNameException extends ScreenMatchException {
    public ShortNameException(String message) {
        super("SHORT_NAME", message);
    }
}