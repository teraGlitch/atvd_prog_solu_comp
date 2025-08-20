package application;

import library.event.Event;
import library.event.EventCategory;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

/**
 * Descreve a classe principal do programa
 *
 * @author gilson.junior.a1
 */
public class EventApplication {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
//        String seed = String.valueOf(Instant.now().toEpochMilli());
//        User user1 = new User("Testingson_" + seed, 'M', 18, "1234567890", seed);
//        user1.registerUser();

        Event event1 = new Event("Testing Event", "1st Testingroad", EventCategory.BUSINESS, LocalDateTime.now(), 1L, "This is a test");
        event1.registerEvent();
        event1.listExistingEvents();

//        System.out.println(String.format("%s".replace("_", System.lineSeparator()), user1.describe()));
    }
}