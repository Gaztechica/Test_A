package ar.soft.AT.API.models.director.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder // 👈 Позволяет создавать объект через DirectoryRequest.builder()...
@JsonInclude(JsonInclude.Include.NON_NULL)
public record DirectoryRequest(
        Long id,
        String name,
        String projectId,
        Long parentDirectoryId
) {}


