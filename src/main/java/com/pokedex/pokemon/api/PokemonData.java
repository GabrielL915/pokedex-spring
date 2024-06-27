package com.pokedex.pokemon.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PokemonData {

    @Autowired
    private RestTemplate restTemplate;

    public String getData() {
        String url = "https://pokeapi.co/api/v2/pokemon/1/";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }
}
