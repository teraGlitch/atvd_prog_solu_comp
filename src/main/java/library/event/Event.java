package library.event;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Classe que descreve um evento
 *
 * @author gilson.junior.a1
 */
public class Event {
    public int id;
    public String name;
    public String address;
    public EventCategory category;
    public LocalDateTime startDateAndTime;
    public long durationInHours;
    public LocalDateTime endDateAndTime;
    public String description;

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
        this.id = DataFileManager.countLinesForIds(new File(DataFileManager.DATA_FILENAME));
        this.name = name;
        this.address = address;
        this.category = category;
        this.startDateAndTime = startDateAndTime;
        this.durationInHours = durationInHours;
        this.endDateAndTime = this.startDateAndTime.plusHours(durationInHours);
        this.description = description;
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

    /**
     * Formata e retorna os detalhes de um evento
     *
     * @return Texto formatado com os detalhes de um evento
     */
    public String describe() {
        return String.format( //
                "Evento de ID %d_\tNome\t\t: %s_\tEndereço\t: %s_\tCategoria\t: %s_\tInício\t\t: %s_\tFim\t\t\t: %s (%dh)_\tDescrição\t: %s_" //
                        .replace("_", System.lineSeparator()), //
                getId(), //
                getName(), //
                getAddress(), //
                getCategory(), //
                getStartDateAndTime(), //
                getEndDateAndTime(), //
                getDurationInHours(), //
                getDescription());
    }

    /**
     * Formata e retorna os detalhes de um evento para o arquivo
     *
     * @return Texto formatado com os detalhes de um evento
     */
    @Override
    public String toString() {
        // ID,NAME,ADDRESS,CATEGORY,START_DATE,DESCRIPTION
        return String.format("%d,%s,%s,%s,%s,%s", //
                getId(), //
                getName(), //
                getAddress(), //
                getCategory(), //
                getStartDateAndTime(), //
                getDescription());
    }
}