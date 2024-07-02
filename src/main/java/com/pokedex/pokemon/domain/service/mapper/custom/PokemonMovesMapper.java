package com.pokedex.pokemon.domain.service.mapper.custom;

import com.pokedex.pokemon.domain.dto.PokemonMovesDTO;
import com.pokedex.pokemon.domain.entities.PokemonMoves;
import com.pokedex.pokemon.domain.service.mapper.PokedexMapper;
import org.springframework.stereotype.Component;

@Component
public class PokemonMovesMapper implements PokedexMapper<PokemonMoves, PokemonMovesDTO> {
    @Override
    public PokemonMovesDTO toDTO(PokemonMoves pokemonMoves) {
        return new PokemonMovesDTO(pokemonMoves.getId(), pokemonMoves.getMove());
    }

    @Override
    public PokemonMoves toEntity(PokemonMovesDTO pokemonMovesDTO) {
        return new PokemonMoves(pokemonMovesDTO.getMove());
    }
}
