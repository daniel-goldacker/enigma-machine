package io.github.danielgoldacker.enigma.dominio.repository;

public class EnigmaRepository {
    private int rotorPosition;
    private static final String EXTENDED_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZÁÉÍÓÚÂÊÎÔÛÀÈÌÒÙÃẼĨÕŨÇ0123456789.,;:!?()[]{}-_/\"'@#$%&*+=<>|~`^ ";
    private static final String ROTOR_MAPPING = "EKMFLGDQVZNTOWYHXUSPAIBRCJÁÉÍÓÚÂÊÎÔÛÀÈÌÒÙÃẼĨÕŨÇ0123456789.,;:!?()[]{}-_/\"'@#$%&*+=<>|~`^ ";
    
    public EnigmaRepository(int rotorPosition) {
        this.rotorPosition = rotorPosition;
    }

    public String encrypt(String message) {
        StringBuilder encrypted = new StringBuilder();
        for (char letter : message.toUpperCase().toCharArray()) {
            int index = EXTENDED_ALPHABET.indexOf(letter);
            if (index >= 0) {
                int shiftedIndex = (index + rotorPosition) % EXTENDED_ALPHABET.length();
                char encryptedLetter = ROTOR_MAPPING.charAt(shiftedIndex);
                encrypted.append(encryptedLetter);
                rotorPosition = (rotorPosition + 1) % EXTENDED_ALPHABET.length();
            }
        }
        return encrypted.toString();
    }

    public String decrypt(String message) {
        StringBuilder decrypted = new StringBuilder();
        for (char letter : message.toUpperCase().toCharArray()) {
            int index = ROTOR_MAPPING.indexOf(letter);
            if (index >= 0) {
                int shiftedIndex = (index - rotorPosition + ROTOR_MAPPING.length()) % ROTOR_MAPPING.length();
                char decryptedLetter = EXTENDED_ALPHABET.charAt(shiftedIndex);
                decrypted.append(decryptedLetter);
            }
            rotorPosition = (rotorPosition + 1) % EXTENDED_ALPHABET.length();
        }
        return decrypted.toString();
    }
}
