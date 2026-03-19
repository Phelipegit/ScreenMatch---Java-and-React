package com.phelipe.ScreenMatch.dto.response;

import lombok.Getter;

@Getter
public class ResponseUpdatePassword {
    private boolean success;
    private String message;

    public ResponseUpdatePassword(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ResponseUpdatePassword() {

    }
}
