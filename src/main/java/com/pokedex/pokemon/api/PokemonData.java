package com.pokedex.pokemon.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokedex.pokemon.api.exceptions.PokemonDataFetchException;
import com.pokedex.pokemon.domain.entities.Pokemon;
import com.pokedex.pokemon.domain.entities.PokemonMoves;
import com.pokedex.pokemon.domain.entities.PokemonStats;
import com.pokedex.pokemon.domain.repository.custom.PokemonMovesRepository;
import com.pokedex.pokemon.domain.repository.custom.PokemonRepository;
import com.pokedex.pokemon.domain.repository.custom.PokemonStatsRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class PokemonData implements CommandLineRunner {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PokemonMovesRepository pokemonMovesRepository;

    @Autowired
    private PokemonStatsRepository pokemonStatsRepository;

    @Autowired
    private PokemonRepository pokemonRepository;

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);
    private static final Logger logger = LoggerFactory.getLogger(PokemonData.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("Starting to fetch Pokemon data...");
        try {
            List<Pokemon> pokemons = fetchPokemonData();
            logger.info("Fetched and saved {} Pokemons", pokemons.size());
        } catch (PokemonDataFetchException e) {
            logger.error("Error fetching Pokemon data ", e);
        }
    }

    private List<Pokemon> fetchPokemonData() throws JsonProcessingException, InterruptedException {
        String url = "https://pokeapi.co/api/v2/pokemon?limit=151";
        JsonNode rootNode = getJsonNode(url);
        JsonNode resultsNode = rootNode.path("results");

        List<Callable<Pokemon>> pokemons = new ArrayList<>();

        for (JsonNode pokemonNode : resultsNode) {
            String pokemonUrl = pokemonNode.path("url").asText();
            pokemons.add(() -> fetchPokemonDetails(pokemonUrl));
        }
        List<Future<Pokemon>> futures = executorService.invokeAll(pokemons);

        return futures.stream()
                .map(this::getPokemonFromFuture)
                .toList();
    }

    private Pokemon getPokemonFromFuture(Future<Pokemon> future) {
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private Pokemon fetchPokemonDetails(String url) throws JsonProcessingException {
        JsonNode rootNode = getJsonNode(url);

        String name = rootNode.path("name").asText();
        Long pokedexNumber = rootNode.path("id").asLong();

        String type = getType(rootNode);

        Double height = rootNode.path("height").asDouble();
        Double weight = rootNode.path("weight").asDouble();

        List<PokemonStats> pokemonStats = getStatsList(rootNode);
        List<PokemonMoves> pokemonMoves = getMoves(rootNode);
        Pokemon pokemon = new Pokemon(pokedexNumber, name, type, height, weight,
                pokemonMoves,
                pokemonStats);

        pokemonMovesRepository.saveAll(pokemonMoves);

        pokemonStatsRepository.saveAll(pokemonStats);

        return pokemonRepository.save(pokemon);

    }

    private JsonNode getJsonNode(String url) throws JsonProcessingException {
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String responseBody = response.getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readTree(responseBody);
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