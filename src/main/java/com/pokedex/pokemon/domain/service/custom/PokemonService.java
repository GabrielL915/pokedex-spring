package com.pokedex.pokemon.domain.service.custom;

import com.pokedex.pokemon.domain.dto.PokemonDTO;
import com.pokedex.pokemon.domain.entities.Pokemon;
import com.pokedex.pokemon.domain.repository.custom.PokemonRepository;
import com.pokedex.pokemon.domain.service.PokedexService;
import com.pokedex.pokemon.domain.service.mapper.custom.PokemonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PokemonService extends PokedexService<Pokemon, String, PokemonDTO> {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private PokemonMapper pokemonMapper;

    public PokemonDTO findByName(String name) {
        var pokemon = pokemonRepository.findByName(name).orElseThrow();
        return pokemonMapper.toDTO(pokemon);
    }

    public List<PokemonDTO> findAllByOrderByPokedexNumber() {
        return pokemonRepository.findAllByOrderByPokedexNumberAsc().stream()
                .map(pokemonMapper::toDTO)
                .toList();
    }

    public Map<String, List<PokemonDTO>> findAllByOrderByType() {
        return pokemonRepository.findAllByOrderByType().stream()
                .map(pokemonMapper::toDTO)
                .collect(Collectors.groupingBy(PokemonDTO::getType));
    }
}
