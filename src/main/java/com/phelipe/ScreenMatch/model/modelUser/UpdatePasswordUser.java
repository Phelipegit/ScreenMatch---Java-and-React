package com.phelipe.ScreenMatch.model.modelUser;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UpdatePasswordUser {
    @NotBlank
    private String token;
    @NotBlank
    private String currentPassword;
    @NotBlank
    private String newPassword;
    @NotBlank
    private String confirmPassword;


    public UpdatePasswordUser(String currentPassword,
                              String newPassword,
                              String confirmPassword,
                              String token) {
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
        this.token = token;
    }

    public UpdatePasswordUser() {

    }
}
