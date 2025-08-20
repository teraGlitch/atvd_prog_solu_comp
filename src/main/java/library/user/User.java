package library.user;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;

/**
 * Classe que descreve um usuário
 *
 * @author gilson.junior.a1
 */
public class User {
    private final int USER_NAME_POSITION_IN_FILE = 1;
    private final int USER_DOCUMENT_POSITION_IN_FILE = 4;
    private final File userFile;
    public int id;
    public String name;
    public char gender;
    public int age;
    public String documentNumber;
    public String password;

    /**
     * Construtor da classe
     *
     * @param name           Nome do usuário
     * @param gender         Gênero do usuário, podendo ser M (masculino), F (feminino) ou O (outro)
     * @param age            Idade do usuário
     * @param documentNumber Número do documento de identificação do usuário
     * @param password       Senha desejada pelo usuário
     * @throws IOException              Caso o programa encontre problemas para interagir com o arquivo de usuários
     * @throws NoSuchAlgorithmException Caso o PasswordHelper não encontre o parâmetro de algoritmo ou encoding
     */
    public User(String name, char gender, int age, String documentNumber, String password) throws IOException, NoSuchAlgorithmException {
        UserFileManager.setUpOrCheckUsersFile();
        this.userFile = new File(UserFileManager.USERS_FILENAME);
        this.id = UserFileManager.countLinesForIds(userFile);
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.documentNumber = documentNumber;

        PasswordHelper passwordHelper = new PasswordHelper("SHA-256", "UTF-8");
        this.password = passwordHelper.generateHash(password);
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

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public String getPassword() {
        return password;
    }

    /**
     * Formata e retorna os detalhes de um usuário
     *
     * @return Texto formatado com os detalhes de um usuário
     */
    public String describe() {
        return String.format( //
                "Usuário de ID %d_\tNome\t\t: %s_\tGênero\t\t: %c_\tIdade\t\t: %d_\tDocumento\t: %s_" //
                        .replace("_", System.lineSeparator()), //
                getId(), //
                getName(), //
                getGender(), //
                getAge(), //
                getDocumentNumber());
    }

    public boolean checkIfUserDataExists(final String desiredData, final int columnPositionInFile) throws IOException {
        boolean dataExists = false;
        UserFileManager.setUpOrCheckUsersFile();
        List<String> existingUsersList = UserFileManager.readFile(userFile);

        for (String userDataLine : existingUsersList) {
            String[] userData = userDataLine.split(";");
            dataExists = Objects.equals(desiredData, userData[columnPositionInFile]);

            if (dataExists) {
                break;
            }
        }

        return dataExists;
    }

    /**
     * Armazena os dados do usuário instanciado no arquivo de usuários
     *
     * @throws IOException      Caso o programa encontre problemas para interagir com o arquivo de usuários
     * @throws RuntimeException Caso os dados sensíveis de usuário já existam no arquivo de usuários
     */
    public void registerUser() throws IOException {
        UserFileManager.setUpOrCheckUsersFile();

        boolean userNameExists = checkIfUserDataExists(this.getName(), USER_NAME_POSITION_IN_FILE);
        boolean userDocumentExists = checkIfUserDataExists(this.getDocumentNumber(), USER_DOCUMENT_POSITION_IN_FILE);

        if (userNameExists || userDocumentExists) {
            throw new RuntimeException("Dados já existentes na base de dados");
        } else {
            UserFileManager.writeLineToFile(userFile, this.toString());
        }
    }

    /**
     * Formata e retorna os detalhes de um usuário
     *
     * @return Texto formatado com os detalhes de um usuário
     */
    @Override
    public String toString() {
        // ID;NAME;GENDER;AGE;DOCUMENT;PASSWORD
        return String.format("%d;%s;%s;%d;%s;%s", //
                getId(), //
                getName(), //
                getGender(), //
                getAge(), //
                getDocumentNumber(), //
                getPassword());
    }
}