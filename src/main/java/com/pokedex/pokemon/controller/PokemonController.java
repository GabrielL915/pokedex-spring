package com.pokedex.pokemon.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pokedex.pokemon.api.PokemonData;
import com.pokedex.pokemon.domain.entities.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {

    private static final String ID_PATH_VARIABLE = "/{id}";

//    @Autowired
//    private PokemonService service;

    @Autowired
    private PokemonData pokemonDataService;

    @GetMapping
    public ResponseEntity<Pokemon> getPokemonData() throws JsonProcessingException {
        return ResponseEntity.ok(pokemonDataService.getData());
    }

    // - post
    //insert

    // - get
    //types by dex

    //types

    //dex

    //name
}
