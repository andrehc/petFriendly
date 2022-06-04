package com.example.petfriendlyapi.api.pet.mappers;

import com.example.petfriendlyapi.api.pet.dtos.PetResponse;
import com.example.petfriendlyapi.core.models.Pet;
import org.springframework.stereotype.Component;

@Component
public class PetMapper {

    public PetResponse toResponse(Pet pet) {
        var petResponse = new PetResponse();
        petResponse.setId(pet.getId());
        petResponse.setNome(pet.getNome());
        petResponse.setHistoria(pet.getHistoria());
        petResponse.setFoto(pet.getFoto());
        return petResponse;
    }

}
