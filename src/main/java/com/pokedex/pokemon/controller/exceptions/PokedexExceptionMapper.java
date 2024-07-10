package com.pokedex.pokemon.controller.exceptions;

import com.pokedex.pokemon.domain.service.exceptions.EntityNotFoundException;
import com.pokedex.pokemon.shared.exception.PokedexStandardExeption;
import com.pokedex.pokemon.shared.utils.ErrorResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class PokedexExceptionMapper {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse mapPokedexStandardExceptionWithNotFound(PokedexStandardExeption exeption) {
        return buildErrorResponse(HttpStatus.NOT_FOUND, exeption);
    }

    private ErrorResponse buildErrorResponse(HttpStatus httpStatus, PokedexStandardExeption exception) {
        return ErrorResponse.builder()
                .code(httpStatus.toString())
                .message(exception.getDefaultMessage())
                .details(exception.getMessage())
                .messageCode(exception.getDefaultMessageKey())
                .build();
    }
}
