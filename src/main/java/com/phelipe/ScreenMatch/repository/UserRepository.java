package com.phelipe.ScreenMatch.repository;

import com.phelipe.ScreenMatch.model.modelUser.EntityUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<EntityUser, UUID> {
    Optional<EntityUser> findByEmail(String email);
}
