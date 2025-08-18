package library.app;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Contém os objetos necessários para trabalhar com arquivos em geral
 *
 * @author gilson.junior.a1
 */
public class FileManager {
    // Atributos da classe
    public static final String FILE_PATH = Paths.get(new File("").getAbsolutePath(), "src", "main", "resources").toString();

    /**
     * Checa se um arquivo existe
     *
     * @param file Objeto que representa o arquivo que deve existir
     * @return Verdadeiro se o arquivo existe, falso caso contrário
     */
    public static boolean fileExists(final File file) {
        return file.exists();
    }

    /**
     * Checa se um arquivo pôde ser criado
     *
     * @param file Objeto que representa o arquivo que deve ser criado e conferido
     * @return Verdadeiro se o arquivo pôde ser criado, falso caso contrário
     * @throws IOException Caso o programa encontre problemas para interagir com o arquivo
     */
    public static boolean createFile(final File file) throws IOException {
        return file.createNewFile();
    }

    /**
     * Lê e devolve o conteúdo de um arquivo
     *
     * @param file Objeto que representa o arquivo que deve ter o conteúdo lido e retornado
     * @return Uma lista de String que representa o conteúdo do arquivo
     */
    public static List<String> readFile(final File file) {
        List<String> fileContent = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
            String line;

            while (!Objects.equals(line = reader.readLine(), null)) {
                fileContent.add(line);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return fileContent;
    }

    /**
     * Escreve certo conteúdo num determinado arquivo
     *
     * @param file        Objeto que representa o arquivo que deve ter o conteúdo lido e retornado
     * @param contentLine Linha que representa o conteúdo que deve ser escrito no arquivo
     */
    public static void writeLineToFile(final File file, final String contentLine) {
        List<String> currrentContent = readFile(file);
        currrentContent.add(contentLine);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.getAbsolutePath()))) {
            for (String line : currrentContent) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}