package com.phelipe.ScreenMatch.repository;

import com.phelipe.ScreenMatch.model.modelTitulo.entity.EntityMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MediaRepository extends JpaRepository<EntityMedia, UUID> {
}
