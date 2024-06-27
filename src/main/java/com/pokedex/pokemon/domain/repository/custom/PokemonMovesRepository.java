package com.pokedex.pokemon.domain.repository.custom;

import com.pokedex.pokemon.domain.entities.PokemonMoves;
import com.pokedex.pokemon.domain.repository.CRUDRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonMovesRepository extends CRUDRepository<PokemonMoves, String> {
}
