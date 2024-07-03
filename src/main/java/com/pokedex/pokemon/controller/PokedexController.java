package com.pokedex.pokemon.controller;

import com.pokedex.pokemon.domain.service.PokedexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public abstract class PokedexController<Entity, ID, DTO> {

    @Autowired
    private PokedexService<Entity, ID, DTO> service;

    private static final String ID_PATH_VARIABLE = "/{id}";

    @GetMapping
    public ResponseEntity<List<DTO>> findAll() {
        var list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(ID_PATH_VARIABLE)
    public ResponseEntity<DTO> findById(@PathVariable ID id) {
        var object = service.findById(id);
        return ResponseEntity.ok(object);
    }
}
