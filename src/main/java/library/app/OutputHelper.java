package library.app;

import java.util.Arrays;

import static library.event.Event.POSSIBLE_EVENT_CATEGORIES;

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

    String INPUT_EVENT_NAME_MESSAGE = "\tDIGITE O NOME DO EVENTO : (ALFANUMERICO)\n\t> ";
    String INPUT_EVENT_ADDRESS_MESSAGE = "\tDIGITE O ENDERECO DO EVENTO : (ALFANUMERICO)\n\t> ";
    String INPUT_EVENT_CATEGORY_MESSAGE = String.format("\tDIGITE A CATEGORIA DO EVENTO : %s\n\t> ", Arrays.toString(POSSIBLE_EVENT_CATEGORIES));
    String INPUT_EVENT_START_DATE_TIME_MESSAGE = "\tDIGITE A DATA E HORA DO INICIO DO EVENTO : yyyy-MM-ddThh:mm\n\t> ";
    String INPUT_EVENT_DURATION_MESSAGE = "\tDIGITE A DURACAO DO EVENTO EM HORAS : (NUMERO INTEIRO > 1)\n\t> ";
    String INPUT_EVENT_DESCRIPTION_MESSAGE = "\tDIGITE A DESCRICAO DO EVENTO : (ALFANUMERICO)\n\t> ";
    String EVENT_REGISTERED_MESSAGE = "=== EVENTO CADASTRADO COM SUCESSO ===";

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
    String INVALID_GENDER_MESSAGE = "=== GENERO INVALIDO. TENTE NOVAMENTE ===";
    String INVALID_AGE_MESSAGE = "=== IDADE NAO PERMITIDA PARA INGRESSAR NOS EVENTOS ===";
    String INVALID_DOCUMENT_MESSAGE = "=== DOCUMENTO INVALIDO. TENTE NOVAMENTE ===";
    String INVALID_PASSWORD_MESSAGE = "=== SENHAS NAO CONFEREM. TENTE NOVAMENTE ===";
    String LOGIN_ERROR_MESSAGE = "=== ERRO AO REALIZAR LOGIN. TENTE NOVAMENTE ===";

    String INVALID_EVENT_NAME_MESSAGE = "=== EVENTO INVALIDO. TENTE NOVAMENTE ===";
    String INVALID_ADDRESS_MESSAGE = "=== ENDERECO INVALIDO. TENTE NOVAMENTE ===";
    String INVALID_CATEGORY_MESSAGE = "=== CATEGORIA INVALIDA. TENTE NOVAMENTE ===";
    String INVALID_DATE_MESSAGE = "=== DATA-HORA INICIO INVALIDA. TENTE NOVAMENTE ===";
    String INVALID_DURATION_MESSAGE = "=== DURACAO INVALIDA. TENTE NOVAMENTE ===";
    String INVALID_DESCRIPTION_MESSAGE = "=== DESCRICAO INVALIDA. TENTE NOVAMENTE ===";
}