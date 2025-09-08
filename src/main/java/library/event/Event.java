package library.event;

import library.app.FileManager;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import static application.Application.loggedUser;

/**
 * Classe que descreve um evento
 *
 * @author gilson.junior.a1
 */
public class Event {
    public static final EventCategory[] POSSIBLE_EVENT_CATEGORIES = EventCategory.values();
    private static final File eventStaticFile = new File(DataFileManager.DATA_FILENAME);
    private final File eventFile;
    public int id;
    public String name;
    public String address;
    public EventCategory category;
    public LocalDateTime startDateAndTime;
    public long durationInHours;
    public LocalDateTime endDateAndTime;
    public String description;
    public boolean isUserAttending;
    public String attendees;

    /**
     * Construtor da classe
     *
     * @param name             Nome do evento
     * @param address          Endereço do evento
     * @param category         Categoria do evento
     * @param startDateAndTime Data e horário de início do evento
     * @param durationInHours  Duração do evento em horas inteiras
     * @param description      Descrição do evento
     * @throws IOException Caso o programa encontre problemas para interagir com o arquivo de eventos
     */
    public Event(String name, String address, EventCategory category, LocalDateTime startDateAndTime, long durationInHours, String description) throws IOException {
        DataFileManager.setUpOrCheckEventsFile();
        this.eventFile = new File(DataFileManager.DATA_FILENAME);
        this.id = DataFileManager.countLinesForIds(eventFile);
        this.name = name;
        this.address = address;
        this.category = category;
        this.startDateAndTime = startDateAndTime;
        this.durationInHours = durationInHours;
        this.endDateAndTime = this.startDateAndTime.plusHours(durationInHours);
        this.description = description;
    }

    /**
     * Construtor da classe
     *
     * @param id               Código de identificação do evento
     * @param name             Nome do evento
     * @param address          Endereço do evento
     * @param category         Categoria do evento
     * @param startDateAndTime Data e horário de início do evento
     * @param durationInHours  Duração do evento em horas inteiras
     * @param description      Descrição do evento
     * @param attendees        Participantes do evento
     * @throws IOException Caso o programa encontre problemas para interagir com o arquivo de eventos
     */
    public Event(int id, String name, String address, EventCategory category, LocalDateTime startDateAndTime, long durationInHours, String description, String attendees) throws IOException {
        DataFileManager.setUpOrCheckEventsFile();
        this.eventFile = new File(DataFileManager.DATA_FILENAME);
        this.id = id;
        this.name = name;
        this.address = address;
        this.category = category;
        this.startDateAndTime = startDateAndTime;
        this.durationInHours = durationInHours;
        this.endDateAndTime = this.startDateAndTime.plusHours(durationInHours);
        this.description = description;
        this.attendees = attendees;
        this.isUserAttending = attendees.toLowerCase(Locale.ROOT).contains(loggedUser);
    }

    public static List<Event> listExistingEvents(boolean print) throws IOException {
        List<String> eventsListString = FileManager.readFile(eventStaticFile);
        List<Event> eventsListObj = new ArrayList<>();

        for (int index = 1; index < eventsListString.size(); index++) {
            String[] eventData = eventsListString.get(index).split(";");
            LocalDate startDate = LocalDate.parse(eventData[4].substring(0, eventData[4].indexOf("T")));
            LocalTime startTime = LocalTime.parse(eventData[4].substring(eventData[4].indexOf("T") + 1));
            Event event = new Event( //
                    Integer.parseInt(eventData[0]), //
                    eventData[1], //
                    eventData[2], //
                    EventCategory.valueOf(eventData[3]), //
                    LocalDateTime.of(startDate, startTime), //
                    Long.parseLong(eventData[5]), //
                    eventData[7], //
                    eventData[8]);
            eventsListObj.add(event);
        }

        eventsListObj.sort(Comparator.comparing(Event::getEndDateAndTime));
        if (print) {
            eventsListObj.forEach(Event::describe);
        }
        return eventsListObj;
    }

    /**
     * Formata e exibe os detalhes de um evento
     */
    public static void describe(Event event) {
        String result = String.format( //
                "Evento de ID %d_\tNome\t\t: %s_\tEndereço\t: %s_\tCategoria\t: %s_\tInício\t\t: %s_\tFim\t\t\t: %s (%dh)_\tDescrição\t: %s_\tInscrição\t: %s_" //
                        .replace("_", System.lineSeparator()), //
                event.getId(), //
                event.getName(), //
                event.getAddress(), //
                event.getCategory(), //
                event.getStartDateAndTime(), //
                event.getEndDateAndTime(), //
                event.getDurationInHours(), //
                event.getDescription(), //
                event.isUserAttending);

        System.out.println(result);
    }

    /**
     * @throws IOException Caso o programa encontre problemas para interagir com o arquivo de eventos
     */
    public static void setEvents(List<Event> eventsList) throws IOException {
        DataFileManager.deleteFile(new File(DataFileManager.DATA_FILENAME));
        DataFileManager.setUpOrCheckEventsFile();

        for (Event event : eventsList) {
            DataFileManager.writeLineToFile(new File(DataFileManager.DATA_FILENAME), event.toString());
        }
    }

    /* *********
     * GETTERS *
     ********* */

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public EventCategory getCategory() {
        return category;
    }

    public LocalDateTime getStartDateAndTime() {
        return startDateAndTime;
    }

    public long getDurationInHours() {
        return durationInHours;
    }

    public LocalDateTime getEndDateAndTime() {
        return endDateAndTime;
    }

    public String getDescription() {
        return description;
    }

    public String getAttendees() {
        return attendees;
    }

    public void setAttendee(String attendee) {
        this.attendees = String.format("%s%s", this.attendees == null ? "" : this.attendees + ",", attendee);
    }

    /**
     * Armazena os dados do evento instanciado no arquivo de eventos
     *
     * @throws IOException Caso o programa encontre problemas para interagir com o arquivo de eventos
     */
    public void registerEvent() throws IOException {
        DataFileManager.setUpOrCheckEventsFile();

        DataFileManager.writeLineToFile(eventFile, this.toString());
    }

    /**
     * Formata e retorna os detalhes de um evento para o arquivo
     *
     * @return Texto formatado com os detalhes de um evento
     */
    @Override
    public String toString() {
        // ID;NAME;ADDRESS;CATEGORY;START_DATE;DURATION;END_DATE;DESCRIPTION;
        return String.format("%d;%s;%s;%s;%s;%d;%s;%s;%s", //
                getId(), //
                getName(), //
                getAddress(), //
                getCategory(), //
                getStartDateAndTime(), //
                getDurationInHours(), //
                getEndDateAndTime(), //
                getDescription(), //
                getAttendees());
    }
}