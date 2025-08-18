package library.app;

import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;

import static library.app.FileManager.*;

/**
 * Contém os objetos necessários para trabalhar com o arquivo de dados
 *
 * @author gilson.junior.a1
 */
@UtilityClass
public class DataFileManager {
    // Atributos da classe
    private final String DATA_FILENAME = Paths.get(FILE_PATH, "data", "events.data").toString();
    private final String DEFAULT_FILE_CONTENT = "ID,DESCRIPTION,TYPE,ADDRESS,ATTENDEES";

    /**
     * Cria e confere o conteúdo necessário para que o programa execute corretamente
     *
     * @throws IOException Caso o programa encontre problemas para interagir com o arquivo
     */
    public void setUpOrCheckEnvironment() throws IOException {
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

    /**
     * Função principal
     *
     * @param args Argumentos para execução
     * @throws IOException Caso o programa encontre problemas para interagir com algum arquivo
     */
    public static void main(String[] args) throws IOException {
        setUpOrCheckEnvironment();
    }
}