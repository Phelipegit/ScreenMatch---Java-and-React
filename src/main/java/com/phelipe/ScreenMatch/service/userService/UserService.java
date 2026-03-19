package com.phelipe.ScreenMatch.service.userService;

import com.phelipe.ScreenMatch.Exception.ExceptionUser.*;
import com.phelipe.ScreenMatch.dto.request.RequestLoginUser;
import com.phelipe.ScreenMatch.dto.request.RequestRegisterUser;
import com.phelipe.ScreenMatch.dto.response.ResponseLoginUser;
import com.phelipe.ScreenMatch.dto.response.ResponseRegisterUser;
import com.phelipe.ScreenMatch.dto.response.ResponseUpdatePassword;
import com.phelipe.ScreenMatch.model.modelUser.entity.EntityUser;
import com.phelipe.ScreenMatch.model.modelUser.UpdatePasswordUser;
import com.phelipe.ScreenMatch.model.modelUser.entity.EntityUserRoles;
import com.phelipe.ScreenMatch.repository.UserRepository;
import com.phelipe.ScreenMatch.repository.UserRolesRepository;
import com.phelipe.ScreenMatch.security.JWT.JwtService;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/*
    Lógica de negócio, tratamento dos Requests e Responses
 */

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserRolesRepository userRolesRepository;
    private final Argon2PasswordEncoder encoder;
    private final JwtService jwtService;
    public UserService(Argon2PasswordEncoder encoder,
                       UserRepository userRepository,
                       UserRolesRepository userRolesRepository,
                       JwtService jwtService) {

        this.encoder = encoder;
        this.userRepository = userRepository;
        this.userRolesRepository = userRolesRepository;
        this.jwtService = jwtService;
    }

    @Transactional
    public ResponseRegisterUser userRegister(RequestRegisterUser request)  {
        Optional<EntityUser> exist = userRepository.findByEmail(request.getEmail());
        if(exist.isPresent()) {
            throw new EmailExistsException(UserServiceMessages.EMAIL_ALREADY_EXISTS);
        }

        if(request.getEmail().isBlank() || request.getName().isBlank() || request.getPassword().isBlank()) {
            throw new EmptyFieldsException(UserServiceMessages.FIELDS_CANNOT_BE_BLANK_REGISTER);
        }

        if(request.getPassword().length() < 8) {
            throw new ShortPasswordException(UserServiceMessages.SHORT_PASSWORD);
        }
        if(request.getPassword().length() > 200) {
            throw new LongPasswordException(UserServiceMessages.LONG_PASSWORD);
        }
        if(request.getName().length() < 5) {
            throw new ShortNameException(UserServiceMessages.SHORT_NAME);
        }
        if(request.getName().length() > 200) {
            throw new LongNameException(UserServiceMessages.LONG_NAME);
        }

        EntityUser entityUser = new EntityUser(request.getEmail(),request.getName(), encoder.encode(request.getPassword()));

        userRepository.save(entityUser);

        EntityUserRoles role = new EntityUserRoles(entityUser, "USER");

        userRolesRepository.save(role);

        return new ResponseRegisterUser(true,UserServiceMessages.USER_REGISTER_SUCCESS);
    }
    @Transactional
    public ResponseLoginUser userLogin(RequestLoginUser login) {

        if(login.getEmail().trim().isBlank() || login.getPassword().trim().isBlank()) {
            throw new EmptyFieldsException(UserServiceMessages.FIELDS_CANNOT_BE_BLANK_LOGIN);
        }

        Optional<EntityUser> exist = userRepository.findByEmail(login.getEmail());
        if(exist.isEmpty()) {
            throw new EmailEmptyException(UserServiceMessages.WRONG_EMAIL_OR_PASSWORD);
        }

        EntityUser user = exist.get();

        if(!encoder.matches(login.getPassword(),user.getHashPassword())) {
            return new ResponseLoginUser(false,UserServiceMessages.WRONG_EMAIL_OR_PASSWORD);
        }

        List<String> roles = user.getRoles().stream()
                .map(EntityUserRoles::getRole)
                .toList();

        String token = jwtService.gerarToken(login.getEmail(),roles);

        return new ResponseLoginUser(true,UserServiceMessages.LOGIN_SUCCESS,token);
    }
    @Transactional
    public ResponseUpdatePassword userUpdatePassword(UpdatePasswordUser updatePasswordUser) {
        Optional<EntityUser> exist = userRepository.findByEmail(jwtService.getEmailDoToken(updatePasswordUser.getToken()));

        if(exist.isEmpty()) {
            throw new ExceptionUpdatePassword(UserServiceMessages.USER_NOT_FOUND);
        }

        if(updatePasswordUser.getCurrentPassword().isBlank() || updatePasswordUser.getNewPassword().isBlank() || updatePasswordUser.getConfirmPassword().isBlank()) {
            throw new ExceptionUpdatePassword(UserServiceMessages.FIELDS_CANNOT_BE_BLANK);
        }

        if(!updatePasswordUser.getNewPassword().equals(updatePasswordUser.getConfirmPassword())) {
            throw new ExceptionUpdatePassword(UserServiceMessages.PASSWORDS_DONT_MATCH);
        }

        if(updatePasswordUser.getNewPassword().length() < 8) {
            throw new ExceptionUpdatePassword(UserServiceMessages.SHORT_PASSWORD);
        }

        EntityUser user = exist.get();

        if(!encoder.matches(updatePasswordUser.getCurrentPassword(),user.getHashPassword())) {
            throw new ExceptionUpdatePassword(UserServiceMessages.CURRENT_PASSWORD_WRONG);
        }

         user.setHashPassword(encoder.encode(updatePasswordUser.getNewPassword()));

        userRepository.save(user);

        return new ResponseUpdatePassword(true, UserServiceMessages.PASSWORD_CHANGED_SUCCESS);
    }
}
