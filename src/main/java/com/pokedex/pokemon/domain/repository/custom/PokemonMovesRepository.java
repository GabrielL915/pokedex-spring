package com.pokedex.pokemon.domain.repository.custom;

import com.pokedex.pokemon.domain.entities.PokemonMoves;
import com.pokedex.pokemon.domain.repository.PokedexRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonMovesRepository extends PokedexRepository<PokemonMoves, String> {
}
