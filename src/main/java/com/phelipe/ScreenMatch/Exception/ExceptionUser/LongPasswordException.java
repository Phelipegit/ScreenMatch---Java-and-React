package com.phelipe.ScreenMatch.Exception.ExceptionUser;

public class LongPasswordException extends ScreenMatchException {
    public LongPasswordException(String message) {
        super("LONG_PASSWORD",message);
    }
}
