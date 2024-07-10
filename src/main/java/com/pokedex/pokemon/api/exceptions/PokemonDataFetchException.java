package com.pokedex.pokemon.api.exceptions;

import com.pokedex.pokemon.shared.exception.PokedexStandardExeption;

public class PokemonDataFetchException extends PokedexStandardExeption {

    private static final String DEFAULT_MESSAGE = "Unable to fetch from poke api.";

    private static final String DEFAULT_MESSAGE_KEY = "pokedex.pokemon-data-fetch.error";

    public PokemonDataFetchException(Object identifier) {
        super(String.format("Unable to fetch %s.", identifier));
    }

    @Override
    public String getDefaultMessage() {
        return DEFAULT_MESSAGE;
    }

    @Override
    public String getDefaultMessageKey() {
        return DEFAULT_MESSAGE_KEY;
    }
}
