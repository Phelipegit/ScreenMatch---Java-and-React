// src/main/java/com/phelipe/ScreenMatch/exception/AppBusinessException.java
package com.phelipe.ScreenMatch.Exception.ExceptionUser;

import lombok.Getter;

@Getter
public class ScreenMatchException extends RuntimeException {
    private final String code;

    public ScreenMatchException(String code, String message) {
        super(message);
        this.code = code;
    }
}
