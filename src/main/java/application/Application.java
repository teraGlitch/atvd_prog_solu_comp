package application;

import library.app.OutputHelper;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import static library.app.NavigationHelper.selectOption;

/**
 * Descreve a classe principal do programa
 *
 * @author gilson.junior.a1
 */
public class Application {
    public static Scanner inputReader = new Scanner(System.in);
    public static boolean isUserLogged = false;
    public static String loggedUser = null;

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        int userInput;

        do {
            System.out.println(OutputHelper.WELCOME_PAGE);
            userInput = inputReader.nextInt();
            inputReader.nextLine();
            selectOption(userInput);
        } while (userInput != 0);

//        Event event1 = new Event("Testing Event", "1st Testingroad", EventCategory.BUSINESS, LocalDateTime.now(), 1L, "This is a test");
//        event1.registerEvent();
//        event1.listExistingEvents();

//        System.out.println(String.format("%s".replace("_", System.lineSeparator()), user1.describe()));
    }
}