package library.event;

import library.app.FileManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * Contém os objetos necessários para trabalhar com o arquivo de dados
 *
 * @author gilson.junior.a1
 */
public class DataFileManager extends FileManager {
    // Atributos da classe
    public static final String DATA_FILENAME = Paths.get(FILE_PATH, "data", "events.data").toString();
    private static final String DEFAULT_FILE_CONTENT = "ID;NAME;ADDRESS;CATEGORY;START_DATE;DURATION;END_DATE;DESCRIPTION;ATTENDEES";

    /**
     * Cria e confere o conteúdo necessário para que o programa execute corretamente
     *
     * @throws IOException Caso o programa encontre problemas para interagir com o arquivo
     */
    public static void setUpOrCheckEventsFile() throws IOException {
        File dataFile = new File(DATA_FILENAME);

        if (!fileExists(dataFile)) {
            if (!createFile(dataFile)) throw new IOException("O arquivo de dados não pôde ser criado");
            writeLineToFile(dataFile, DEFAULT_FILE_CONTENT);
        }

        if (Objects.equals(readFile(dataFile).size(), 0))
            throw new RuntimeException("O arquivo de dados não possui conteúdo algum");

        if (!Objects.equals(readFile(dataFile).get(0), DEFAULT_FILE_CONTENT))
            throw new RuntimeException("O arquivo de dados não possui o cabeçalho esperado");
    }
}