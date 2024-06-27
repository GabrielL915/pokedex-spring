package com.pokedex.pokemon.domain.repository.custom;

import com.pokedex.pokemon.domain.entities.Pokemon;
import com.pokedex.pokemon.domain.repository.CRUDRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends CRUDRepository<Pokemon, String> {
}
