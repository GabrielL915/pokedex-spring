package com.pokedex.pokemon.domain.service.exceptions;

import com.pokedex.pokemon.shared.exception.PokedexStandardExeption;

public class EntityNotFoundException extends PokedexStandardExeption {

    private static final String DEFAULT_MESSAGE = "Unable to find entity.";

    private static final String DEFAULT_MESSAGE_KEY = "pokedex.entity-not-found.error";

    public EntityNotFoundException(Object identifier) {
        super(String.format("Entity with identifier %s not found.", identifier));
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
