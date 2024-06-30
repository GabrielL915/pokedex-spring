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

        List<PokemonMoves> pokemonMoves = getMoves(rootNode);

        return new Pokemon(pokedexNumber, name, type, height, weight,
                pokemonMoves,
                pokemonStats);
    }

    private List<PokemonMoves> getMoves(JsonNode rootNode) {
        List<PokemonMoves> allMoves = new ArrayList<>();

        JsonNode movesNode = rootNode.path("moves");

        movesNode.forEach(moveNode -> {
            String move = moveNode.path("move").path("name").asText();
            PokemonMoves pokemonMoves = new PokemonMoves(move);
            allMoves.add(pokemonMoves);
        });

        Collections.shuffle(allMoves);

        return allMoves.stream().limit(4).toList();
    }

    private List<PokemonStats> getStatsList(JsonNode rootNode) {
        List<PokemonStats> statsList = new ArrayList<>();
        JsonNode statsNode = rootNode.path("stats");

        statsNode.forEach(statNode -> {
            String name = statNode.path("stat").path("name").asText();
            double baseStat = statNode.path("base_stat").asDouble();
            PokemonStats pokemonStats = new PokemonStats(name, baseStat);
            statsList.add(pokemonStats);
        });
        return statsList;
    }

    private String getType(JsonNode rootNode) {
        return StreamSupport.stream(rootNode.path("types").spliterator(), false)
                .map(node -> node.path("type").path("name").asText())
                .collect(Collectors.joining(", "));
    }
}