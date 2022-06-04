package com.example.petfriendlyapi.api.adocao.controllers;

import com.example.petfriendlyapi.api.adocao.dtos.AdocaoRequest;
import com.example.petfriendlyapi.api.adocao.dtos.AdocaoResponse;
import com.example.petfriendlyapi.api.adocao.mappers.AdocaoMapper;
import com.example.petfriendlyapi.core.repositories.AdocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdocaoController {

    @Autowired
    private AdocaoRepository adocaoRepository;

    @Autowired
    private AdocaoMapper adocaoMapper;

    @PostMapping("api/adocoes")
    @ResponseStatus(code = HttpStatus.CREATED)
    public AdocaoResponse create(@RequestBody AdocaoRequest adocaoRequest) {
        var adocao = adocaoMapper.toModel(adocaoRequest);
        var createdAdocao = adocaoRepository.save(adocao);
        return adocaoMapper.toResponse(createdAdocao);
    }
}
