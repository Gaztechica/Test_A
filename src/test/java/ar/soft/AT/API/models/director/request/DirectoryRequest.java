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
@JsonInclude(JsonInclude.Include.NON_NULL) // Чтобы пустые необязательные поля не отправлялись
public class DirectoryRequest {
    private Long id;              // Округляем до Long, так как в Swagger указан int64
    private String name;          // Имя папки (бизнес-обязательное)
    private Long projectId;       // ID проекта (бизнес-обязательное)
    private Long parentDirectoryId; // ID родительской папки (необязательное)
}



