package io.github.danielgoldacker.enigma.rest.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EncryptRequest {
    
    @NotBlank(message = "message is required")
    private String message;
    @NotBlank(message = "cryptography key is required")
    private String keyCryptography;
}
