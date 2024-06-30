package com.pokedex.pokemon.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokedex.pokemon.domain.entities.Pokemon;
import com.pokedex.pokemon.domain.entities.PokemonMoves;
import com.pokedex.pokemon.domain.entities.PokemonStats;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class PokemonData {

    @Autowired
    private RestTemplate restTemplate;

    public Pokemon getData() throws JsonProcessingException {
        String url = "https://pokeapi.co/api/v2/pokemon/1/";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String responseBody = response.getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(responseBody);

        String name = rootNode.path("name").asText();

        Long pokedexNumber = rootNode.path("id").asLong();

        String type = getType(rootNode);

        Double height = rootNode.path("height").asDouble();
        Double weight = rootNode.path("weight").asDouble();

        List<PokemonStats> pokemonStats = getStatsList(rootNode);

        List<String> pokMoves = getMoves(rootNode);

        return new Pokemon(pokedexNumber, name, type, height, weight,
                new PokemonMoves(pokMoves.get(0), pokMoves.get(1), pokMoves.get(2), pokMoves.get(3)),
                new PokemonStats());
    }

    private List<String> getMoves(JsonNode rootNode) {
        List<String> allMoves = new ArrayList<>();

        JsonNode movesNode = rootNode.path("moves");

        movesNode.forEach(moveNode -> {
            String moveName = moveNode.path("move").path("name").asText();
            allMoves.add(moveName);
        });

        Collections.shuffle(allMoves);

        return allMoves.stream().limit(4).toList();
    }

    private List<PokemonStats> getStatsList(JsonNode rootNode) {
        return StreamSupport.stream(rootNode.path("stats").spliterator(), false)
                .map(node -> new PokemonStats(node.path("stat").path("name").asText(),
                        node.path("base_stat").asDouble()))
                .toList();
    }

    private String getType(JsonNode rootNode) {
        return StreamSupport.stream(rootNode.path("types").spliterator(), false)
                .map(node -> node.path("type").path("name").asText())
                .collect(Collectors.joining(", "));
    }
}