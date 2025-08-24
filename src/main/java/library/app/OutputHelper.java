package library.app;

public interface OutputHelper {
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

    String[] REGISTER_STEPS = //
            new String[]{ //
                    "\tDIGITE O NOME DE USUARIO DESEJADO : (ALFANUMERICO)\n\t> ", //
                    "\tDIGITE A SENHA DESEJADA : (ALFANUMERICO)\n\t> ", //
                    "\tCONFIRME A SENHA DESEJADA : (ALFANUMERICO)\n\t> ", //
                    "\tDIGITE O GENERO : (M)ASCULINO (F)EMININO (O)OUTRO\n\t> ", //
                    "\tDIGITE A IDADE : (NUMERO INTEIRO)\n\t> ", //
                    "\tDIGITE O NUMERO DO DOCUMENTO DE IDENTIFICACAO : (ALFANUMERICO)\n\t> "};

    String[] LOGIN_STEPS = //
            new String[]{ //
                    "\tDIGITE O NOME DE USUARIO CADASTRADO : \n\t> ", //
                    "\tDIGITE A SENHA : \n\t> "};

    String END_LINE = //
            "==============================================\n" + //
                    "=       PROGRAMA ENCERRADO COM SUCESSO       =\n" + //
                    "==============================================\n";

    String LOGOUT_LINE = //
            "==============================================\n" + //
                    "=        USUARIO DESLOGADO COM SUCESSO       =\n" + //
                    "==============================================\n";
}