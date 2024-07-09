package com.pokedex.pokemon.domain.repository.custom;

import com.pokedex.pokemon.domain.entities.Pokemon;
import com.pokedex.pokemon.domain.projection.PokemonTypeProjection;
import com.pokedex.pokemon.domain.repository.PokedexRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PokemonRepository extends PokedexRepository<Pokemon, String> {
    Optional<Pokemon> findByName(String name);

    List<Pokemon> findAllByOrderByPokedexNumberAsc();

    List<Pokemon> findAllByOrderByType();

    @Query("SELECT p.type FROM Pokemon p WHERE p.pokedexNumber = :pokedexNumber")
    Optional<String> findTypeByPokedexNumber(Long pokedexNumber);
}
