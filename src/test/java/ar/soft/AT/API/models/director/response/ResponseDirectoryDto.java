package ar.soft.AT.API.models.director.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) // Спасает от лишних полей (timestamp, token и т.д.)
public class ResponseDirectoryDto {

    @JsonProperty("success")
    private String success;

    @JsonProperty("error")
    private String error;

    @JsonProperty("data")
    private DirectoryDto data; // Вложенный объект с данными директории

    // 🌟 ДОБАВЛЕНО: Список файлов, который бэкенд возвращает в JSON при загрузке
    @JsonProperty("filesInDirectory")
    private List<FileDto> filesInDirectory;
}