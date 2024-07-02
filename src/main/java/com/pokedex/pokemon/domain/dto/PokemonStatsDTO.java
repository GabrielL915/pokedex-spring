package com.pokedex.pokemon.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class PokemonStatsDTO {

    private String id;

    @NotBlank(message = "Pokemon stat name must not be blank")
    private String name;

    @NotNull(message = "Pokemon stat value must not be blank")
    private Double value;
}
