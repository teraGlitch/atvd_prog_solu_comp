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

public class NavigationHelper extends Application {
    public static void selectOption(final int userInput) throws IOException, NoSuchAlgorithmException {
        if (userInput < 0 || userInput > 6) {
            System.out.println("=== OPCAO INVALIDA. TENTE NOVAMENTE ===");
        } else {
            switch (userInput) {
                case 0:
                    System.out.println(OutputHelper.END_LINE);
                    break;
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
//                case 3:
//                    break;
                case 4:
                    listEvents();
                    break;
                case 5:
                    break;
                case 6:
                    logout();
                    break;
            }
        }
    }

    public static void register() throws IOException, NoSuchAlgorithmException {
        String[] outputHelper = OutputHelper.REGISTER_STEPS;
        String[] userData = new String[UserFileManager.DEFAULT_FILE_CONTENT.split(";").length - 1];

        System.out.print(outputHelper[0]); // Usuário
        userData[0] = inputReader.nextLine();
        System.out.print(outputHelper[1]); // Senha (1)
        userData[4] = inputReader.nextLine();
        System.out.print(outputHelper[2]); // Senha (2)
        if (inputReader.nextLine().equals(userData[4])) {
            System.out.print(outputHelper[3]); // Gênero
            userData[1] = inputReader.nextLine();
            System.out.print(outputHelper[4]); // Idade
            userData[2] = inputReader.nextLine();
            System.out.print(outputHelper[5]); // Documento
            userData[3] = inputReader.nextLine();

            try {
                User user = new User( //
                        userData[0], //
                        userData[1].toCharArray()[0], //
                        Integer.parseInt(userData[2]), //
                        userData[3], //
                        userData[4]);
                user.registerUser();
                System.out.println("=== USUARIO CADASTRADO COM SUCESSO ===");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage().toUpperCase(Locale.ROOT));
            }
        } else {
            System.out.println("=== SENHAS NAO CONFEREM. TENTE NOVAMENTE ===");
        }
    }

    public static void login() throws NoSuchAlgorithmException {
        if (!isUserLogged) {
            String[] outputHelper = OutputHelper.LOGIN_STEPS;

            try {
                System.out.print(outputHelper[0]); // Usuário
                String username = inputReader.nextLine();
                System.out.print(outputHelper[1]); // Senha
                String plainPassword = inputReader.nextLine();

                String registeredPassword = User.getUserPassword(username);
                String cryptedPassword = new PasswordHelper("SHA-256", "UTF-8").generateHash(plainPassword);
                if (Objects.equals(registeredPassword, cryptedPassword)) {
                    System.out.println("=== USUARIO LOGADO COM SUCESSO ===");
                    isUserLogged = true;
                    loggedUser = username;
                } else {
                    throw new RuntimeException("=== ERRO AO REALIZAR LOGIN. TENTE NOVAMENTE ===");
                }
            } catch (RuntimeException | IOException e) {
                System.out.println(e.getMessage().toUpperCase(Locale.ROOT));
            }
        } else {
            System.out.println("=== SESSAO JA POSSUI USUARIO LOGADO ===");
        }
    }

    public static void listEvents() throws IOException {
        try {
            if (isUserLogged) {
                Event.listExistingEvents();
            } else {
                throw new RuntimeException("=== FACA LOGIN PARA USAR ESSA FUNCAO ===");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void logout() {
        isUserLogged = false;
        loggedUser = null;
        System.out.println(OutputHelper.LOGOUT_LINE);
    }
}