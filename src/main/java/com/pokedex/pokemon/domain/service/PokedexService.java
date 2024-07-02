package com.pokedex.pokemon.domain.service;

import com.pokedex.pokemon.domain.repository.PokedexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class PokedexService<Entity, ID, DTO> {

    @Autowired
    private PokedexRepository<Entity, ID> repository;


}
