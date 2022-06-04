package com.example.petfriendlyapi.core.repositories;

import com.example.petfriendlyapi.core.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.persistence.EntityNotFoundException;


public interface PetRepository extends JpaRepository<Pet, Long> {
    default Pet findByIdOrElseThrow(Long id) {
        var petOptional = findById(id);
        if(petOptional.isPresent())
            return petOptional.get();
        throw new EntityNotFoundException("Pet não encontrado.");
    }
}
