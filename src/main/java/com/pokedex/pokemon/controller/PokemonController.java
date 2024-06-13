package com.pokedex.pokemon.controller;

import com.pokedex.pokemon.domain.service.custom.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pokemon")
@RequiredArgsConstructor
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

//    @GetMapping
//    public ResponseEntity<String> getData() {
//        return ResponseEntity.ok(pokemonService.getData());
//    }
}
