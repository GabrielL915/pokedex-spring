package com.pokedex.pokemon.domain.repository.custom;

import com.pokedex.pokemon.domain.entities.Pokemon;
import com.pokedex.pokemon.domain.repository.PokedexRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PokemonRepository extends PokedexRepository<Pokemon, String> {
    Optional<Pokemon> findByName(String name);
    List<Pokemon> findAllByOrderByPokedexNumberAsc();

    List<Pokemon> findAllByOrderByType();
}
