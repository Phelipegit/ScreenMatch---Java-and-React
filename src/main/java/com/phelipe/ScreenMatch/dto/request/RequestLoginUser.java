package com.phelipe.ScreenMatch.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class RequestLoginUser {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
