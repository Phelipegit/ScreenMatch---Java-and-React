package com.phelipe.ScreenMatch.dto.response;

import lombok.Getter;

@Getter
public class ResponseLoginUser {
    private boolean success;
    private String message;
    private String token;
    public ResponseLoginUser(boolean success, String message, String token) {
        this.success = success;
        this.message = message;
        this.token = token;
    }

    public ResponseLoginUser(boolean success,String message) {
        this.success = success;
        this.message = message;
    }
}
