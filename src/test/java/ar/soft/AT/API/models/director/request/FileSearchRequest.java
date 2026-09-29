package ar.soft.AT.API.models.director.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FileSearchRequest {
    private Long id;
    private String name;
    private Long newDirectoryId;
    private Long currentDirectoryId;
}




