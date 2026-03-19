package com.phelipe.ScreenMatch.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class RequestRegisterUser {
    @NotBlank(message = "Campo nome é obrigatório")
    @Size(min = 5, max = 200, message = "Nome deve ter entre 5 e 200 caracteres")
    private String name;
    @Email(message = "Insira um email válido")
    @NotBlank(message = "Campo email não pode ficar vazio")
    private String email;
    @NotBlank(message = "Campo senha não pode ficar vazio")
    @Size(min = 8,max = 200,message = "Senha deve ter entre 8 e 200 caracteres" )
    private String password;

    public RequestRegisterUser() {
    }
}
