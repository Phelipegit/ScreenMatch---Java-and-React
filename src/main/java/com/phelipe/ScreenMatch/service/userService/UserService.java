package com.phelipe.ScreenMatch.service.userService;

import com.phelipe.ScreenMatch.Exception.ExceptionUser.*;
import com.phelipe.ScreenMatch.dto.request.RequestRegisterUser;
import com.phelipe.ScreenMatch.dto.response.ResponseRegisterUser;
import com.phelipe.ScreenMatch.model.modelUser.EntityUser;
import com.phelipe.ScreenMatch.repository.UserRepository;
import com.phelipe.ScreenMatch.security.ArgonPasswordConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final Argon2PasswordEncoder encoder;

    public UserService(Argon2PasswordEncoder encoder, UserRepository userRepository) {
        this.encoder = encoder;
        this.userRepository = userRepository;
    }

    public ResponseRegisterUser registrar(RequestRegisterUser request)  {
        Optional<EntityUser> exist = userRepository.findByEmail(request.getEmail());
        if(exist.isPresent()) {
            throw new EmailExistsException();
        }

        if(request.getEmail().isBlank() || request.getName().isBlank() || request.getPassword().isBlank()) {
            throw new EmptyFieldsException();
        }

        if(request.getPassword().length() < 8) {
            throw new ShortPasswordException();
        }
        if(request.getPassword().length() > 200) {
            throw new LongPasswordException();
        }
        if(request.getName().length() < 5) {
            throw new ShortNameException();
        }
        if(request.getName().length() > 200) {
            throw new LongNameException();
        }

        EntityUser entityUser = new EntityUser(request.getEmail(),request.getName(), encoder.encode(request.getPassword()));

        userRepository.save(entityUser);

        return new ResponseRegisterUser(true,"Usuário cadastrado com sucesso");
    }
}
