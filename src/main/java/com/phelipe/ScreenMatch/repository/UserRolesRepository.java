package com.phelipe.ScreenMatch.repository;

import com.phelipe.ScreenMatch.model.modelUser.entity.EntityUserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRolesRepository extends JpaRepository<EntityUserRoles, UUID> {
}
