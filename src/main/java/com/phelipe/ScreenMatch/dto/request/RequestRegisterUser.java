package com.phelipe.ScreenMatch.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class RequestRegisterUser {
    @NotBlank
    @Size(min = 5, max = 200)
    private String name;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    @Size(min = 8,max = 200)
    private String password;

    public RequestRegisterUser() {
    }
}
