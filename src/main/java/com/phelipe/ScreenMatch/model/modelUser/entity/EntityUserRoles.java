package com.phelipe.ScreenMatch.model.modelUser.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Entity
@Table(name = "user_roles")
@Getter
public class EntityUserRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private EntityUser user;

    private String role;

    public EntityUserRoles() {

    }

    public EntityUserRoles(EntityUser user, String role) {
        this.user = user;
        this.role = role;
    }
}
