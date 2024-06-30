package com.pokedex.pokemon.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "Pokemon")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "pokedexNumber", nullable = false)
    private Long pokedexNumber;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "height", nullable = false)
    private Double height;

    @Column(name = "weight", nullable = false)
    private Double weight;

    @OneToMany
    @JoinColumn(name = "moves_id", referencedColumnName = "id")
    private List<PokemonMoves> moves;

    @OneToMany
    @JoinColumn(name = "stats_id", referencedColumnName = "id")
    private List<PokemonStats> stats;

    public Pokemon(Long pokedexNumber, String name, String type, Double height, Double weight, List<PokemonMoves> moves, List<PokemonStats> stats) {
        this.pokedexNumber = pokedexNumber;
        this.name = name;
        this.type = type;
        this.height = height;
        this.weight = weight;
        this.moves = moves;
        this.stats = stats;

    }
}