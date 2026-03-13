package com.phelipe.ScreenMatch.dto.response;

import lombok.Getter;

@Getter
public class ResponseRegisterUser {
    private boolean success;
    private String mensagem;

    public ResponseRegisterUser(boolean success, String mensagem) {
        this.success = success;
        this.mensagem = mensagem;
    }
}
