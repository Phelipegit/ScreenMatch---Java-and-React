package com.phelipe.ScreenMatch.controller;

import com.phelipe.ScreenMatch.dto.request.RequestRegisterUser;
import com.phelipe.ScreenMatch.dto.response.ResponseRegisterUser;
import com.phelipe.ScreenMatch.model.modelTitulo.EntityMedia;
import com.phelipe.ScreenMatch.service.OnlyDevs.GetTituloJsonOmdb;
import com.phelipe.ScreenMatch.repository.RepositoryMedia;
import com.phelipe.ScreenMatch.service.userService.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filme")
public class ControllerTitulo {

    private final GetTituloJsonOmdb getTituloJsonOmdb;
    private final RepositoryMedia repositoryMedia;

    public ControllerTitulo(GetTituloJsonOmdb getTituloJsonOmdb, RepositoryMedia repositoryMedia) {
        this.getTituloJsonOmdb = getTituloJsonOmdb;
        this.repositoryMedia = repositoryMedia;
    }

    @GetMapping("/add")
    public EntityMedia salvarTitulo() {
        return getTituloJsonOmdb.addTitulos();
    }

    @GetMapping("/list")
    public List<EntityMedia> listarTudo() {
        return repositoryMedia.findAll();
    }
}
