package ar.soft.AT.API.models.director.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record FileSearchRequest(
        Long id,
        String name,               // Имя искомого файла
        Long newDirectoryId,
        Long currentDirectoryId    // ID папки, в которой ищем
) {}

