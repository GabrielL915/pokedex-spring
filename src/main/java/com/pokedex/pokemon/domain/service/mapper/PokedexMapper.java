package com.pokedex.pokemon.domain.service.mapper;

public interface PokedexMapper<Entity, DTO> {

    DTO toDTO(Entity entity);

    Entity toEntity(DTO dto);
}
