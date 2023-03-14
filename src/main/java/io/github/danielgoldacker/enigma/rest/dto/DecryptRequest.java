package io.github.danielgoldacker.enigma.rest.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class DecryptRequest {
    @NotNull(message = "rotor position is required") 
    @Max(value = 50, message = "must be less than or equal to 50")
    private Integer rotorPosition;
    
    @NotBlank(message = "encrypted message is required")
    private String encryptedMessage;
}
