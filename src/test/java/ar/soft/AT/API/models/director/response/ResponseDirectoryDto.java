package ar.soft.AT.API.models.director.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // 👈 Спасает от полей timestamp, token и т.д.
public record ResponseDirectoryDto(
        String success,
        String error,
        DirectoryDto data// Вложенный объект с данными директории
) {}

