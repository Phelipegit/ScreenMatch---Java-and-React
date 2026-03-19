package com.phelipe.ScreenMatch.controller;

import com.phelipe.ScreenMatch.model.modelTitulo.entity.EntityMedia;
import com.phelipe.ScreenMatch.service.OnlyDevs.GetTituloJsonOmdbService;
import com.phelipe.ScreenMatch.repository.MediaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filme")
@CrossOrigin(origins = "http://localhost:5173/")
public class ControllerTitulo {


    private final GetTituloJsonOmdbService getTituloJsonOmdb;
    private final MediaRepository repositoryMedia;

    public ControllerTitulo(GetTituloJsonOmdbService getTituloJsonOmdb, MediaRepository repositoryMedia) {
        this.getTituloJsonOmdb = getTituloJsonOmdb;
        this.repositoryMedia = repositoryMedia;
    }

    @GetMapping("/add/{titulo}")
    public EntityMedia salvarTitulo(@PathVariable String titulo) {
        return getTituloJsonOmdb.addTitulos(titulo);
    }

    @GetMapping("/list")
    public List<EntityMedia> listarTudo() {
        return repositoryMedia.findAll();
    }
}
