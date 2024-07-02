package com.pokedex.pokemon.domain.service.mapper.custom;

import com.pokedex.pokemon.domain.dto.PokemonDTO;
import com.pokedex.pokemon.domain.entities.Pokemon;
import com.pokedex.pokemon.domain.service.mapper.PokedexMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PokemonMapper implements PokedexMapper<Pokemon, PokemonDTO> {

    private final PokemonMovesMapper pokemonMovesMapper;

    private final PokemonStatsMapper pokemonStatsMapper;

    @Override
    public PokemonDTO toDTO(Pokemon pokemon) {
        return new PokemonDTO(pokemon.getId(), pokemon.getPokedexNumber(), pokemon.getName(),
                pokemon.getType(), pokemon.getHeight(), pokemon.getWeight(),
                pokemon.getMoves().stream().map(pokemonMovesMapper::toDTO).toList(),
                pokemon.getStats().stream().map(pokemonStatsMapper::toDTO).toList());
    }

    @Override
    public Pokemon toEntity(PokemonDTO pokemonDTO) {
        return new Pokemon(pokemonDTO.getPokedexNumber(), pokemonDTO.getName(),
                pokemonDTO.getType(), pokemonDTO.getHeight(), pokemonDTO.getWeight(),
                pokemonDTO.getMovesDTOS().stream().map(pokemonMovesMapper::toEntity).toList(),
                pokemonDTO.getStatsDTOS().stream().map(pokemonStatsMapper::toEntity).toList());
    }
}
