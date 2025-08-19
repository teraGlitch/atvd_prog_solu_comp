package library.user;

import java.io.File;
import java.io.IOException;

/**
 * Classe que descreve um usuário
 *
 * @author gilson.junior.a1
 */
public class User {
    public int id;
    public String name;
    public char gender;
    public int age;
    public String documentNumber;

    /**
     * Construtor da classe
     *
     * @param name           Nome do usuário
     * @param gender         Gênero do usuário, podendo ser M (masculino), F (feminino) ou O (outro)
     * @param age            Idade do usuário
     * @param documentNumber Número do documento de identificação do usuário
     * @throws IOException Caso o programa encontre problemas para interagir com o arquivo de usuários
     */
    public User(String name, char gender, int age, String documentNumber) throws IOException {
        UserFileManager.setUpOrCheckUsersFile();
        this.id = UserFileManager.countLinesForIds(new File(UserFileManager.USERS_FILENAME));
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.documentNumber = documentNumber;
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

    /**
     * Formata e retorna os detalhes de um usuário
     *
     * @return Texto formatado com os detalhes de um usuário
     */
    @Override
    public String toString() {
        // ID,NAME,GENDER,AGE,DOCUMENT
        return String.format("%d,%s,%s,%d,%s", //
                getId(), //
                getName(), //
                getGender(), //
                getAge(), //
                getDocumentNumber());
    }
}