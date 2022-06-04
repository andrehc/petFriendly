package com.example.petfriendlyapi;

import com.example.petfriendlyapi.core.models.Pet;
import com.example.petfriendlyapi.core.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetFriendlyApiApplication implements CommandLineRunner {

    @Autowired
    private PetRepository petRepository;

    public static void main(String[] args) {
        SpringApplication.run(PetFriendlyApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var pet = new Pet();
        pet.setNome("bil");
        pet.setHistoria("viralata caramelo.");
        pet.setFoto("https://www.petz.com.br/blog/wp-content/uploads/2020/01/vira-lata-caramelo.jpg");

        petRepository.save(pet);
    }
}
