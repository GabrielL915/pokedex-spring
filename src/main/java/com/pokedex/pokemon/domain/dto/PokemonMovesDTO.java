package com.pokedex.pokemon.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PokemonMovesDTO {

    private String id;

    @NotBlank(message = "Pokemon move must not be blank")
    private String move;
}
