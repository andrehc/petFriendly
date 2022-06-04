package com.example.petfriendlyapi.api.pet.controllers;

import com.example.petfriendlyapi.api.pet.dtos.PetResponse;
import com.example.petfriendlyapi.api.pet.mappers.PetMapper;
import com.example.petfriendlyapi.core.models.Pet;
import com.example.petfriendlyapi.core.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetMapper petMapper;

    @GetMapping("api/pets")
    public List<PetResponse> findAll() {
        var pets = petRepository.findAll();
        var petResponses = new ArrayList<PetResponse>();
        for (Pet pet : pets) {
            petResponses.add(petMapper.toResponse(pet));
        }
        return petResponses;
    }
}
