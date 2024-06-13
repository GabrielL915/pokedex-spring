package com.pokedex.pokemon.dataSource.repository.custom;

import com.pokedex.pokemon.dataSource.repository.CRUDRepository;
import com.pokedex.pokemon.domain.entities.Pokemon;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends CRUDRepository<Pokemon, String> {
}
