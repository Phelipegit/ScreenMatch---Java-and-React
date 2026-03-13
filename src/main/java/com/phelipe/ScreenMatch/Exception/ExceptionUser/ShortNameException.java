package com.phelipe.ScreenMatch.Exception.ExceptionUser;

public class ShortNameException extends ScreenMatchException {
    public ShortNameException() {
        super("SHORT_NAME", "Nome precisa ter no mínimo 5 caracteres!");
    }
}