package library.user;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Contém os objetos necessários para trabalhar com criptografia de senha
 *
 * @author gilson.junior.a1
 */
public class PasswordHelper {
    // Atributos da classe
    private final String TEXT_ENCODING;
    private final MessageDigest hasher;

    /**
     * Construtor da classe
     *
     * @param mdInstance Algoritmo que deve ser usado na criptografia (ex.: MD5, SHA-256, etc)
     * @param encoding   Conjunto de caracteres que deve ser usado na criptografia (ex.: UTF-8)
     * @throws NoSuchAlgorithmException Caso o algoritmo de criptografia encontre problemas para a geração do hash
     */
    public PasswordHelper(final String mdInstance, final String encoding) throws NoSuchAlgorithmException {
        this.TEXT_ENCODING = encoding;
        this.hasher = MessageDigest.getInstance(mdInstance);
    }

    /**
     * Criptografa um texto conforme parâmetros da instância da classe
     *
     * @param password Texto que deve ser criptografado
     * @return Objeto de texto que contém o texto após criptografia
     * @throws UnsupportedEncodingException Caso o algoritmo de criptografia encontre problemas para a geração do hash
     */
    public String generateHash(final String password) throws UnsupportedEncodingException {
        byte[] hashBytes = hasher.digest(password.getBytes(TEXT_ENCODING));

        StringBuilder result = new StringBuilder();
        for (byte byteChar : hashBytes) {
            result.append(String.format("%02x", byteChar));
        }

        return result.toString();
    }
}