package com.phelipe.ScreenMatch.Exception.ExceptionUser;

public class ShortPasswordException extends ScreenMatchException {
    public ShortPasswordException() {
        super("SHORT_PASSWORD", "Senha precisa ser maior que 8 dígitos!");
    }
}