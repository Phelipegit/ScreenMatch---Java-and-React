package com.phelipe.ScreenMatch.repository;

import com.phelipe.ScreenMatch.model.modelUser.entity.EntityUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<EntityUser, UUID> {
    Optional<EntityUser> findByEmail(String email);
}
