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
@JsonIgnoreProperties(ignoreUnknown = true) // Защита от новых/лишних полей в блоке data
public class DirectoryDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("projectId")
    private Long projectId;

    // 🌟 Поле для списка файлов теперь находится внутри правильного POJO-класса
    @JsonProperty("filesInDirectory")
    private List<FileDto> filesInDirectory;
}