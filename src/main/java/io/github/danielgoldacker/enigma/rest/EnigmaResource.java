package io.github.danielgoldacker.enigma.rest;

import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.github.danielgoldacker.enigma.dominio.repository.EnigmaRepository;
import io.github.danielgoldacker.enigma.rest.dto.DecryptRequest;
import io.github.danielgoldacker.enigma.rest.dto.DecryptResponse;
import io.github.danielgoldacker.enigma.rest.dto.EncryptRequest;
import io.github.danielgoldacker.enigma.rest.dto.EncryptResponse;
import io.github.danielgoldacker.enigma.rest.dto.ResponseError;

@Path("/enigma")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EnigmaResource {
    private Validator validator; 

     @Inject
     public EnigmaResource(Validator validator){
         this.validator = validator;
     }

    @POST
    @Path("/encrypt-message")
    public Response encryptMessage(EncryptRequest encryptRequest) {
        Set<ConstraintViolation<EncryptRequest>> violations = validator.validate(encryptRequest);
        if (!violations.isEmpty()){
            return ResponseError.createFromValidation(violations).withStatusCode(ResponseError.UNPROCESSABLE_ENTITY_STATUS);
        }

        EnigmaRepository enigma = new EnigmaRepository(encryptRequest.getRotorPosition());
        String encryptedMessage = enigma.encrypt(encryptRequest.getMessage());
       
        EncryptResponse encryptResponse = new EncryptResponse();    
        encryptResponse.setEncryptedMessage(encryptedMessage);
        return Response.status(Response.Status.OK.getStatusCode()).entity(encryptResponse).build();
    }

    @POST
    @Path("/decrypt-message")
    public Response decryptMessage(DecryptRequest decryptRequest) {
        Set<ConstraintViolation<DecryptRequest>> violations = validator.validate(decryptRequest);
        if (!violations.isEmpty()){
            return ResponseError.createFromValidation(violations).withStatusCode(ResponseError.UNPROCESSABLE_ENTITY_STATUS);
        }

        EnigmaRepository enigma = new EnigmaRepository(decryptRequest.getRotorPosition());
        String decryptedMessage = enigma.decrypt(decryptRequest.getEncryptedMessage());

        DecryptResponse decryptResponse = new DecryptResponse();
        decryptResponse.setDecryptedMessage(decryptedMessage);
        return Response.status(Response.Status.OK.getStatusCode()).entity(decryptResponse).build();
    }
}
