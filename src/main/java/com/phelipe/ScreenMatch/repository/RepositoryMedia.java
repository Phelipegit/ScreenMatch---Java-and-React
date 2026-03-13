package com.phelipe.ScreenMatch.repository;

import com.phelipe.ScreenMatch.model.modelTitulo.EntityMedia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryMedia extends JpaRepository<EntityMedia, UUID> {
}
