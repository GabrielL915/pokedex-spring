package com.pokedex.pokemon.domain.service;

import com.pokedex.pokemon.domain.repository.PokedexRepository;
import com.pokedex.pokemon.domain.service.mapper.PokedexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class PokedexService<Entity, ID, DTO> {

    @Autowired
    private PokedexRepository<Entity, ID> repository;

    @Autowired
    private PokedexMapper<Entity, DTO> mapper;

    public List<DTO> findAll() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }
}
