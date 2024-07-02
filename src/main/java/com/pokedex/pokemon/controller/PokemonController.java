package com.pokedex.pokemon.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pokedex.pokemon.api.PokemonData;
import com.pokedex.pokemon.domain.dto.PokemonDTO;
import com.pokedex.pokemon.domain.entities.Pokemon;
import com.pokedex.pokemon.domain.service.PokedexService;
import com.pokedex.pokemon.domain.service.custom.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PokemonController {

    private static final String ID_PATH_VARIABLE = "/{id}";

    //    @Autowired
//    private PokedexService service;
    @Autowired
    private PokemonService service;

    @GetMapping
    public ResponseEntity<List<PokemonDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // - get
    //types by dex

    //types

    //dex

    //name
}
