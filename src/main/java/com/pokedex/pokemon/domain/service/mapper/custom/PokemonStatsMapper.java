package com.pokedex.pokemon.domain.service.mapper.custom;

import com.pokedex.pokemon.domain.dto.PokemonStatsDTO;
import com.pokedex.pokemon.domain.entities.PokemonStats;
import com.pokedex.pokemon.domain.service.mapper.PokedexMapper;
import org.springframework.stereotype.Component;

@Component
public class PokemonStatsMapper implements PokedexMapper<PokemonStats, PokemonStatsDTO> {
    @Override
    public PokemonStatsDTO toDTO(PokemonStats pokemonStats) {
        return new PokemonStatsDTO(pokemonStats.getId(), pokemonStats.getName(), pokemonStats.getValue());
    }

    @Override
    public PokemonStats toEntity(PokemonStatsDTO pokemonStatsDTO) {
        return new PokemonStats(pokemonStatsDTO.getName(), pokemonStatsDTO.getValue());
    }
}
