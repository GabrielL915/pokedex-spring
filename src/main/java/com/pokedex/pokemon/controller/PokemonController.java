package com.pokedex.pokemon.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pokedex.pokemon.api.PokemonData;
import com.pokedex.pokemon.domain.entities.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PokemonController {

    private static final String ID_PATH_VARIABLE = "/{id}";

//    @Autowired
//    private PokemonService service;

    @Autowired
    private PokemonData pokemonDataService;

    @GetMapping
    public ResponseEntity<List<Pokemon>> getPokemonData() throws JsonProcessingException, InterruptedException {
        return ResponseEntity.ok(pokemonDataService.fetchPokemonData());
    }

    // - post
    //insert

    // - get
    //types by dex

    //types

    //dex

    //name
}
