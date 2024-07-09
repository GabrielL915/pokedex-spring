package com.pokedex.pokemon.controller;

import com.pokedex.pokemon.domain.dto.PokemonDTO;
import com.pokedex.pokemon.domain.entities.Pokemon;
import com.pokedex.pokemon.domain.service.custom.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pokemon")
public class PokemonController extends PokedexController<Pokemon, String, PokemonDTO> {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping(path = "/name/{name}")
    ResponseEntity<PokemonDTO> findByName(@PathVariable String name) {
        return ResponseEntity.ok(pokemonService.findByName(name));
    }

    @GetMapping(path = "/dex")
    ResponseEntity<List<PokemonDTO>> findAllByOrderByPokedexNumber() {
        return ResponseEntity.ok(pokemonService.findAllByOrderByPokedexNumber());
    }

    @GetMapping(path = "/types")
    ResponseEntity<Map<String, List<PokemonDTO>>> findAllByOrderByType() {
        return ResponseEntity.ok(pokemonService.findAllByOrderByType());
    }

    @GetMapping(path = "/types/{pokedexNumber}")
    ResponseEntity<Map<String, String>> findTypeByPokedexNumber(@PathVariable Long pokedexNumber) {
        return ResponseEntity.ok(pokemonService.findTypeByPokedexNumber(pokedexNumber));
    }
}
