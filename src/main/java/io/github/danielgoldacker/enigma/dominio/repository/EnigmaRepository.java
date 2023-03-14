package io.github.danielgoldacker.enigma.dominio.repository;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class EnigmaRepository  {
    
    public String encrypt(String message, String key) {
        StringBuilder messageEncrypted = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char letter = message.charAt(i);

            // apply the key to the letter
            letter += key.charAt(i % key.length());

            messageEncrypted.append(letter);

            // update the key
            key = updateKey(key);
        }

        return messageEncrypted.toString();
    }

    public String decrypt(String messageEncrypted, String keyCryptography) {
        StringBuilder messageDecoded = new StringBuilder();

        for (int i = 0; i < messageEncrypted.length(); i++) {
            char letter = messageEncrypted.charAt(i);

           // apply the decode key to the letter
            letter -= keyCryptography.charAt(i % keyCryptography.length());

            messageDecoded.append(letter);

            // update the decryption key
            keyCryptography = updateKey(keyCryptography);
        }

        return messageDecoded.toString();
    }

    private String updateKey(String key) {
        // increment the key value by 1
        char lastCharacter = key.charAt(key.length() - 1);
        char newCharacter = (char) (lastCharacter + 1);

        // check if the new character is an uppercase letter
        if (newCharacter > 'Z') {
            newCharacter = 'A';
        }

        // replace the last character of the key with the new character
        return key.substring(0, key.length() - 1) + newCharacter;
    }
    
}
