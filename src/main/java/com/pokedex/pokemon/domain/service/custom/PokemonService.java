package com.pokedex.pokemon.domain.service.custom;

import com.pokedex.pokemon.domain.dto.PokemonDTO;
import com.pokedex.pokemon.domain.entities.Pokemon;
import com.pokedex.pokemon.domain.service.PokedexService;
import com.pokedex.pokemon.domain.service.mapper.PokedexMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PokemonService extends PokedexService<Pokemon, String, PokemonDTO> {
}
