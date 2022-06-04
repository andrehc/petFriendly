package com.example.petfriendlyapi.api.adocao.mappers;

import com.example.petfriendlyapi.api.adocao.dtos.AdocaoRequest;
import com.example.petfriendlyapi.api.adocao.dtos.AdocaoResponse;
import com.example.petfriendlyapi.api.pet.mappers.PetMapper;
import com.example.petfriendlyapi.core.models.Adocao;
import com.example.petfriendlyapi.core.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdocaoMapper {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetMapper petMapper;

    public Adocao toModel(AdocaoRequest adocaoRequest) {
        var adocao = new Adocao();
        adocao.setEmail(adocaoRequest.getEmail());
        adocao.setValor(adocaoRequest.getValor());
        adocao.setPet(petRepository.findByIdOrElseThrow(adocaoRequest.getPetId()));
        return adocao;
    }

    public AdocaoResponse toResponse(Adocao adocao) {
        var adocaoResponse = new AdocaoResponse();
        adocaoResponse.setId(adocao.getId());
        adocaoResponse.setEmail(adocao.getEmail());
        adocaoResponse.setValor(adocao.getValor());
        adocaoResponse.setPet(petMapper.toResponse(adocao.getPet()));
        return adocaoResponse;
    }
}
