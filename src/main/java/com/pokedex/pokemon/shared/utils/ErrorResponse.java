package com.pokedex.pokemon.shared.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private String title;
    private String code;
    private String message;
    private String details;
    private String messageCode;
    private List<Field> fieldList = new ArrayList<>();

    public record Field(String name, String message) {
    }
}
