package com.phelipe.ScreenMatch.model.modelTitulo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Entity
@Table(name = "titulo")
@Getter
public class EntityMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank
    @Column(unique = true)
    private String title;
    @NotNull
    private int year;
    @NotBlank
    private String runtime;
    @NotBlank
    private String director;
    @NotBlank
    private String poster;
    @NotBlank
    private String type;
    @NotNull
    private double imdbRating;

    public EntityMedia(String title,
                       String year,
                       String runtime,
                       String director,
                       String poster,
                       String type,
                       double imdbRating) {
        this.title = title;
        this.year = Integer.parseInt(year.trim());
        this.runtime = runtime;
        this.director = director;
        this.poster = poster;
        this.type = type;
        this.imdbRating = imdbRating;
    }

    public EntityMedia() {

    }
}
