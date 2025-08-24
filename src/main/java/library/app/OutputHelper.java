package library.app;

public interface OutputHelper {
    /* *********
     * COMMON  *
     ********* *///
    String WELCOME_PAGE = //
            "==============================================\n" + //
                    "=        BEM VINDO AO MENU DE EVENTOS        =\n" + //
                    "==============================================\n" + //
                    "| DIGITE UMA OPCAO                           |\n" + //
                    "|--------------------------------------------|\n" + //
                    "| 1 - CADASTRO DE NOVO USUARIO               |\n" + //
                    "| 2 - LOGIN                                  |\n" + //
                    "| 3 - CADASTRO DE NOVO EVENTO                |\n" + //
                    "| 4 - LISTAR EVENTOS                         |\n" + //
                    "| 5 - PARTICIPAR DE UM EVENTO                |\n" + //
                    "| 6 - LOGOUT                                 |\n" + //
                    "| 0 - ENCERRAR                               |\n" + //
                    "==============================================";

    String INPUT_USERNAME_MESSAGE = "\tDIGITE O NOME DE USUARIO DESEJADO : (ALFANUMERICO)\n\t> ";
    String INPUT_USER_PASSWORD_MESSAGE = "\tDIGITE A SENHA DESEJADA : (ALFANUMERICO)\n\t> ";
    String CONFIRM_USER_PASSWORD_MESSAGE = "\tCONFIRME A SENHA DESEJADA : (ALFANUMERICO)\n\t> ";
    String INPUT_USER_GENDER_MESSAGE = "\tDIGITE O GENERO : (M)ASCULINO (F)EMININO (O)UTRO\n\t> ";
    String INPUT_USER_AGE_MESSAGE = "\tDIGITE A IDADE : (NUMERO INTEIRO)\n\t> ";
    String INPUT_USER_DOCUMENT_MESSAGE = "\tDIGITE O NUMERO DO DOCUMENTO DE IDENTIFICACAO : (ALFANUMERICO)\n\t> ";
    String USER_REGISTERED_MESSAGE = "=== USUARIO CADASTRADO COM SUCESSO ===";

    String INPUT_LOGIN_USERNAME = "\tDIGITE O NOME DE USUARIO CADASTRADO : \n\t> ";
    String INPUT_LOGIN_PASSWORD = "\tDIGITE A SENHA : \n\t> ";
    String USER_LOGGED_IN_MESSAGE = "=== USUARIO LOGADO COM SUCESSO ===";
    String SESSION_ALREADY_LOGGED_IN_MESSAGE = "=== SESSAO JA POSSUI USUARIO LOGADO ===";
    String SESSION_NOT_LOGGED_IN_MESSAGE = "=== SESSAO NAO POSSUI USUARIO LOGADO ===";
    String LOG_IN_TO_CONTINUE_MESSAGE = "=== FACA LOGIN PARA USAR ESSA FUNCAO ===";

    String END_LINE = //
            "==============================================\n" + //
                    "=       PROGRAMA ENCERRADO COM SUCESSO       =\n" + //
                    "==============================================\n";

    String LOGOUT_LINE = //
            "==============================================\n" + //
                    "=        USUARIO DESLOGADO COM SUCESSO       =\n" + //
                    "==============================================\n";

    /* *********
     * ERRORS  *
     ********* *///
    String INVALID_OPTION_MESSAGE = "=== OPCAO INVALIDA. TENTE NOVAMENTE ===";
    String INVALID_USERNAME_MESSAGE = "=== USUARIO INVALIDO. TENTE NOVAMENTE ===";
    String INVALID_GENDER_MESSAGE = "=== GENERO INVALIDO INVALIDO. TENTE NOVAMENTE ===";
    String INVALID_AGE_MESSAGE = "=== IDADE NAO PERMITIDA PARA INGRESSAR NOS EVENTOS ===";
    String INVALID_DOCUMENT_MESSAGE = "=== DOCUMENTO INVALIDO. TENTE NOVAMENTE ===";
    String INVALID_PASSWORD_MESSAGE = "=== SENHAS NAO CONFEREM. TENTE NOVAMENTE ===";
    String LOGIN_ERROR_MESSAGE = "=== ERRO AO REALIZAR LOGIN. TENTE NOVAMENTE ===";
}