package com.phelipe.ScreenMatch.model.modelUser;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.util.UUID;
@Entity
@Table(name = "users")
@Getter
public class EntityUser {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Email
    @NotBlank
    @Column(unique = true)
    private String email;
    @NotBlank
    private String name;
    @NotBlank
    private String hashPassword;

    public EntityUser() {

    }

    public EntityUser(String email, String name, String hashPassword) {
        this.email = email;
        this.name = name;
        this.hashPassword = hashPassword;
    }
}
