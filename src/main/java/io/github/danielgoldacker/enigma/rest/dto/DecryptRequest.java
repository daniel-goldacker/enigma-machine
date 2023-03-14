package io.github.danielgoldacker.enigma.rest.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class DecryptRequest {
    @NotBlank(message = "cryptography key is required")
    private String keyCryptography;
    @NotBlank(message = "encrypted message is required")
    private String encryptedMessage;
}
