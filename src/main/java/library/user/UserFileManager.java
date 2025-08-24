package library.user;

import library.app.FileManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * Contém os objetos necessários para trabalhar com o arquivo de usuários
 *
 * @author gilson.junior.a1
 */
public class UserFileManager extends FileManager {
    // Atributos da classe
    public static final String USERS_FILENAME = Paths.get(FILE_PATH, "data", "users.data").toString();
    public static final String DEFAULT_FILE_CONTENT = "ID;NAME;GENDER;AGE;DOCUMENT;PASSWORD";

    /**
     * Cria e confere o conteúdo necessário para que o programa execute corretamente
     *
     * @throws IOException Caso o programa encontre problemas para interagir com o arquivo
     */
    public static void setUpOrCheckUsersFile() throws IOException {
        File dataFile = new File(USERS_FILENAME);

        if (!fileExists(dataFile)) {
            if (!createFile(dataFile)) throw new IOException("O arquivo de usuários não pôde ser criado");
            writeLineToFile(dataFile, DEFAULT_FILE_CONTENT);
        }

        if (Objects.equals(readFile(dataFile).size(), 0))
            throw new RuntimeException("O arquivo de usuários não possui conteúdo algum");

        if (!Objects.equals(readFile(dataFile).get(0), DEFAULT_FILE_CONTENT))
            throw new RuntimeException("O arquivo de usuários não possui o cabeçalho esperado");
    }

    /**
     * Função principal
     *
     * @param args Argumentos para execução
     * @throws IOException Caso o programa encontre problemas para interagir com algum arquivo
     */
    public static void main(String[] args) throws IOException {
        setUpOrCheckUsersFile();
    }
}