package ar.soft.AT.API.models.workResource.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkResourceCreateRequest {

    private Long projectId;
    private Long employmentId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate entryDate;

    // Вместо String используем строгие Enum
    private ResourceType resourceType;
    private LabourType labourType;

    private Long mechanismTypeId;

    private Integer planValue;
    private Integer factValue;
    private Integer recommendedValue;
}