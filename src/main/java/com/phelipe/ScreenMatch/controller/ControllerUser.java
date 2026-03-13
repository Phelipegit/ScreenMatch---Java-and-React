package com.phelipe.ScreenMatch.controller;

import com.phelipe.ScreenMatch.dto.request.RequestRegisterUser;
import com.phelipe.ScreenMatch.dto.response.ResponseRegisterUser;
import com.phelipe.ScreenMatch.service.userService.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ControllerUser {

    private final UserService userService;

    public ControllerUser(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseRegisterUser register(@Valid @RequestBody RequestRegisterUser request) {
        System.out.println("dentro do register");
        return userService.registrar(request);
    }
}
