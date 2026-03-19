package com.phelipe.ScreenMatch.model.modelTitulo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.phelipe.ScreenMatch.Exception.ExceptionTitulo.ExceptionInjectionJsonModel;
import com.phelipe.ScreenMatch.model.modelTitulo.entity.EntityMedia;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InjectJsonModel( String title,
                               String year,
                               String runtime,
                               String director,
                               String poster,
                               String type,
                               double imdbRating ) {

    public EntityMedia injection() {
        if(title == null || title.trim().isEmpty() || year == null || year.trim().isEmpty() || runtime == null ||runtime.trim().isEmpty() || director == null || director.trim().isEmpty() || poster == null || poster.trim().isEmpty() || type == null || type.trim().isEmpty()) {
            throw new ExceptionInjectionJsonModel("Campos json vazios API EXTERNA");
        }
        if(Integer.parseInt(year.trim()) > LocalDateTime.now().getYear() || Integer.parseInt(year.trim()) <= 0) {
            throw new IllegalArgumentException("Data do JSON inválida");
        }
        if(imdbRating < 0 || imdbRating > 10) {
            throw new IllegalArgumentException("imdbRating acima ou abaixo do permitido API EXTERNA");
        }

        return new EntityMedia(title,year,runtime,director,poster,type,imdbRating);
    }
}
