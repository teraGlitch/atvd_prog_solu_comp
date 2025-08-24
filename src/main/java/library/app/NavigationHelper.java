package library.app;

import application.Application;
import library.event.Event;
import library.user.PasswordHelper;
import library.user.User;
import library.user.UserFileManager;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.Objects;

import static library.app.OutputHelper.*;
import static library.user.User.*;

/**
 * Descreve o comportamento ao navegar pelo menu
 *
 * @author gilson.junior.a1
 */
public class NavigationHelper extends Application {
    /**
     * Executa funções conforme opção digitada
     *
     * @param userInput Opção fornecida pelo usuário
     * @throws IOException              Caso a aplicação encontre problemas para interagir com os arquivos
     * @throws NoSuchAlgorithmException Caso a aplicação encontre problemas para criptografar senhas
     */
    public static void selectOption(final int userInput) throws IOException, NoSuchAlgorithmException {
        if (userInput < 0 || userInput > 6) {
            System.out.println(INVALID_OPTION_MESSAGE);
        } else {
            switch (userInput) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    registerEvent();
                    break;
                case 4:
                    listEvents();
                    break;
                case 5:
                    applyToAnEvent();
                    break;
                case 6:
                    logout();
                    break;
                default:
                    System.out.println(END_LINE);
                    break;
            }
        }
    }

    /**
     * Executa função de cadastrar novo usuário
     *
     * @throws IOException              Caso a aplicação encontre problemas para interagir com o arquivo de usuário
     * @throws NoSuchAlgorithmException Caso a aplicação encontre problemas para criptografar senhas
     */
    public static void registerUser() throws IOException, NoSuchAlgorithmException {
        String[] userData = new String[UserFileManager.DEFAULT_FILE_CONTENT.split(";").length - 1];

        try {
            System.out.print(INPUT_USERNAME_MESSAGE);
            userData[0] = inputReader.nextLine();

            if (Objects.equals(userData[0].trim(), "") || userData[0].contains(";")) {
                throw new RuntimeException(INVALID_USERNAME_MESSAGE);
            }

            System.out.print(INPUT_USER_PASSWORD_MESSAGE);
            userData[4] = inputReader.nextLine();
            System.out.print(CONFIRM_USER_PASSWORD_MESSAGE);
            if (inputReader.nextLine().equals(userData[4])) {
                System.out.print(INPUT_USER_GENDER_MESSAGE);
                userData[1] = inputReader.nextLine();

                if (userData[1].trim().length() != 1 || !POSSIBLE_USER_GENDERS.contains(userData[1].toLowerCase(Locale.ROOT))) {
                    throw new RuntimeException(INVALID_GENDER_MESSAGE);
                }

                System.out.print(INPUT_USER_AGE_MESSAGE);
                userData[2] = inputReader.nextLine();

                if (Integer.parseInt(userData[2]) < MIN_USER_AGE || Integer.parseInt(userData[2]) > MAX_USER_AGE) {
                    throw new RuntimeException(INVALID_AGE_MESSAGE);
                }

                System.out.print(INPUT_USER_DOCUMENT_MESSAGE);
                userData[3] = inputReader.nextLine();

                if (Objects.equals(userData[3].trim(), "") || userData[3].contains(";")) {
                    throw new RuntimeException(INVALID_DOCUMENT_MESSAGE);
                }

                User user = new User( //
                        userData[0], //
                        userData[1].toUpperCase(Locale.ROOT).toCharArray()[0], //
                        Integer.parseInt(userData[2]), //
                        userData[3], //
                        userData[4]);
                user.registerUser();

                System.out.println(user.describe());
                System.out.println(USER_REGISTERED_MESSAGE);
            } else {
                throw new RuntimeException(INVALID_PASSWORD_MESSAGE);
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage().toUpperCase(Locale.ROOT));
        }
    }

    /**
     * Verifica se há um usuário logado e lança exceção caso não esteja
     */
    public static void userMustBeLogged() {
        if (!isUserLogged) {
            throw new RuntimeException(LOG_IN_TO_CONTINUE_MESSAGE);
        }
    }

    /**
     * Executa função de acessar a aplicação com credenciais de usuário
     *
     * @throws NoSuchAlgorithmException Caso a aplicação encontre problemas para criptografar senhas
     */
    public static void login() throws NoSuchAlgorithmException {
        if (!isUserLogged) {
            try {
                System.out.print(INPUT_LOGIN_USERNAME);
                String username = inputReader.nextLine();
                System.out.print(INPUT_LOGIN_PASSWORD);
                String plainPassword = inputReader.nextLine();

                String registeredPassword = User.getUserPassword(username);
                String cryptedPassword = new PasswordHelper("SHA-256", "UTF-8").generateHash(plainPassword);
                if (Objects.equals(registeredPassword, cryptedPassword)) {
                    System.out.println(USER_LOGGED_IN_MESSAGE);
                    isUserLogged = true;
                    loggedUser = username;
                } else {
                    throw new RuntimeException(LOGIN_ERROR_MESSAGE);
                }
            } catch (RuntimeException | IOException e) {
                System.out.println(e.getMessage().toUpperCase(Locale.ROOT));
            }
        } else {
            System.out.println(SESSION_ALREADY_LOGGED_IN_MESSAGE);
        }
    }

    /**
     * Executa função de cadastrar um novo evento
     */
    public static void registerEvent() {
        try {
            userMustBeLogged();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage().toUpperCase(Locale.ROOT));
        }
    }

    /**
     * Executa função de cadastrar um usuário em um evento existente
     */
    public static void applyToAnEvent() {
        try {
            userMustBeLogged();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage().toUpperCase(Locale.ROOT));
        }
    }

    /**
     * Lista os eventos existentes
     *
     * @throws IOException Caso a aplicação encontre problemas para interagir com o arquivo de eventos
     */
    public static void listEvents() throws IOException {
        try {
            userMustBeLogged();
            Event.listExistingEvents();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage().toUpperCase(Locale.ROOT));
        }
    }

    /**
     * Desloga um usuário logado, se aplicável
     */
    public static void logout() {
        if (isUserLogged) {
            isUserLogged = false;
            loggedUser = null;
            System.out.println(LOGOUT_LINE);
        } else {
            System.out.println(SESSION_NOT_LOGGED_IN_MESSAGE);
        }
    }
}