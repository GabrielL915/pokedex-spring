package com.pokedex.pokemon.domain.dto;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PokemonDTO {

    private String id;

    @NotNull(message = "Pokedex Number must not be null")
    private Long pokedexNumber;

    @NotBlank(message = "Pokemon name must not be blank")
    private String name;

    @NotBlank(message = "Pokemon Type must not be blank")
    private String type;

    @NotNull(message = "Pokemon height must not be null")
    private Double height;

    @NotNull(message = "Pokemon weight must not be null")
    private Double weight;

    @NotEmpty(message = "Pokemon moves must not be empty")
    @Size(min = 4, message = "Must have at least four moves")
    private List<PokemonMovesDTO> movesDTOS;

    @NotEmpty(message = "Pokemon stats must not be empty")
    @Size(min = 1, message = "Must have at least a stat")
    private List<PokemonStatsDTO> statsDTOS;
}
