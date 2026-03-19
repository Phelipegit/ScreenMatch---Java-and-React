package com.phelipe.ScreenMatch.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class RequestLoginUser {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;
}
