package com.pokedex.pokemon.domain.repository.custom;

import com.pokedex.pokemon.domain.entities.Pokemon;
import com.pokedex.pokemon.domain.repository.PokedexRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends PokedexRepository<Pokemon, String> {
}
