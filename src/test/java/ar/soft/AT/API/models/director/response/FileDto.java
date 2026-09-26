package ar.soft.AT.API.models.director.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FileDto(
        Long id,
        String name
) {}

