package com.phelipe.ScreenMatch.service.userService;

public class UserServiceMessages {

        // REGISTRO
        public static final String USER_REGISTER_SUCCESS = "Usuário registrado com sucesso";
        public static final String EMAIL_ALREADY_EXISTS = "E-mail já cadastrado";
        public static final String FIELDS_CANNOT_BE_BLANK_REGISTER = "Campos de e-mail, nome ou senha não podem ser vazios ou nulos";
        public static final String SHORT_PASSWORD = "A senha deve ter pelo menos 8 caracteres";
        public static final String LONG_PASSWORD = "A senha não pode ter mais de 200 caracteres";
        public static final String SHORT_NAME = "O nome deve ter pelo menos 5 caracteres";
        public static final String LONG_NAME = "O nome não pode ter mais de 200 caracteres";

        // LOGIN
        public static final String LOGIN_SUCCESS = "Usuário logado com sucesso";
        public static final String FIELDS_CANNOT_BE_BLANK_LOGIN = "E-mail ou senha não podem ser vazios";
        public static final String WRONG_EMAIL_OR_PASSWORD = "E-mail ou senha incorretos";

        // UPDATE PASSWORD
        public static final String USER_NOT_FOUND = "Usuário não existente";
        public static final String FIELDS_CANNOT_BE_BLANK = "Campos não podem ficar vazios ou nulos";
        public static final String PASSWORDS_DONT_MATCH = "Nova senha e confirmação não conferem";
        public static final String CURRENT_PASSWORD_WRONG = "Senha atual incorreta";
        public static final String PASSWORD_CHANGED_SUCCESS = "Senha alterada com sucesso";

}
