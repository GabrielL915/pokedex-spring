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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController extends PokedexController<Pokemon, String, PokemonDTO> {
    // - get
//one
    //types by dex
//all
    //order types
//all
    //order dex
//one
    //name
}
