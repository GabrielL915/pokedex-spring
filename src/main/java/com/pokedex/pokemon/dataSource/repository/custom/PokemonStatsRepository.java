package com.pokedex.pokemon.dataSource.repository.custom;

import com.pokedex.pokemon.dataSource.repository.CRUDRepository;
import com.pokedex.pokemon.domain.entities.PokemonStats;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonStatsRepository extends CRUDRepository<PokemonStats, String> {
}
