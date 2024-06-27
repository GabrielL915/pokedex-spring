package com.pokedex.pokemon.domain.repository.custom;

import com.pokedex.pokemon.domain.entities.PokemonStats;
import com.pokedex.pokemon.domain.repository.CRUDRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonStatsRepository extends CRUDRepository<PokemonStats, String> {
}
