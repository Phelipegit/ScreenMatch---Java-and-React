package com.phelipe.ScreenMatch.Exception.ExceptionUser;

public class LongPasswordException extends ScreenMatchException {
    public LongPasswordException() {
        super("LONG_PASSWORD","Senha extremamente grande!");
    }
}
