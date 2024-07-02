package com.pokedex.pokemon.domain.service;

import com.pokedex.pokemon.domain.repository.CRUDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class CRUDService<Entity, ID, DTO> {

    @Autowired
    private CRUDRepository<Entity, ID> repository;


}
