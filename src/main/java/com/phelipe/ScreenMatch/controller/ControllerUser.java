package com.phelipe.ScreenMatch.controller;

import com.phelipe.ScreenMatch.dto.request.RequestLoginUser;
import com.phelipe.ScreenMatch.dto.request.RequestRegisterUser;
import com.phelipe.ScreenMatch.dto.response.ResponseLoginUser;
import com.phelipe.ScreenMatch.dto.response.ResponseRegisterUser;
import com.phelipe.ScreenMatch.dto.response.ResponseUpdatePassword;
import com.phelipe.ScreenMatch.model.modelUser.UpdatePasswordUser;
import com.phelipe.ScreenMatch.service.userService.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:5173/")
public class ControllerUser {

    private final UserService userService;

    public ControllerUser(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseRegisterUser register(@Valid @RequestBody RequestRegisterUser register) {
        return userService.userRegister(register);
    }

    @PostMapping("/login")
    public ResponseLoginUser login(@Valid @RequestBody RequestLoginUser login) {
        return userService.userLogin(login);
    }

    @PutMapping("/updatePassword")
    public ResponseUpdatePassword updatePassword(@Valid @RequestBody UpdatePasswordUser update) {
        return userService.userUpdatePassword(update);
    }
}
