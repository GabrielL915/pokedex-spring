package com.pokedex.pokemon.dataSource.repository.custom;

import com.pokedex.pokemon.dataSource.repository.CRUDRepository;
import com.pokedex.pokemon.domain.entities.PokemonMoves;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonMovesRepository extends CRUDRepository<PokemonMoves, String> {
}
