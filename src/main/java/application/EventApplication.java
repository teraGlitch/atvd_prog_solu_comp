package application;

import library.event.DataFileManager;
import library.event.Event;
import library.event.EventCategory;
import library.user.User;
import library.user.UserFileManager;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class EventApplication {
    public static void main(String[] args) throws IOException {
        File userFile = new File(UserFileManager.USERS_FILENAME);
        User user1 = new User("Testingson", 'M', 18, "1234567890");
        UserFileManager.writeLineToFile(userFile, user1.toString());
        User user2 = new User("Testingson Jr", 'M', 18, "1234567890");
        UserFileManager.writeLineToFile(userFile, user2.toString());

        File eventFile = new File(DataFileManager.DATA_FILENAME);
        Event event1 = new Event("Testing Event", "1st Testingroad", EventCategory.BUSINESS, LocalDateTime.now(), 1L, "This is a test");
        UserFileManager.writeLineToFile(eventFile, event1.toString());
        Event event2 = new Event("Testing TED", "2nd Testingroad", EventCategory.BUSINESS, LocalDateTime.now(), 48L, "This is another test");
        UserFileManager.writeLineToFile(eventFile, event2.toString());

        System.out.println(String.format("%s_%s_%s_%s".replace("_", System.lineSeparator()), user1.describe(), user2.describe(), event1.describe(), event2.describe()));
    }
}