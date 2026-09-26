package ar.soft.AT.API.models.director.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true) // 👈 Защита от новых полей в data
public record DirectoryDto(
        Long id,
        String name,
        Long projectId,
        List<FileDto> filesInDirectory // Использует наш укороченный FileDto
) {}

