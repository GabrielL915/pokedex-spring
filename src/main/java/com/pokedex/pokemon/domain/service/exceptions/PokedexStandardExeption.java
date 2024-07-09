package com.pokedex.pokemon.domain.service.exceptions;

import org.apache.commons.lang3.StringUtils;

public abstract class PokedexStandardExeption extends RuntimeException {

    protected PokedexStandardExeption(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        String message = super.getMessage();
        return StringUtils.isNotBlank(message) ? message : this.getDefaultMessage();
    }

    public abstract String getDefaultMessage();

    public abstract String getDefaultMessageKey();
}
