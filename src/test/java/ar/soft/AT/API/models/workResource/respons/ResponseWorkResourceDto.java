package ar.soft.AT.API.models.workResource.respons;

import ar.soft.AT.API.models.workResource.request.LabourType;
import ar.soft.AT.API.models.workResource.request.ResourceType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class ResponseWorkResourceDto {

    private Long id;
    private Long projectId;
    private Long employmentId;
    private String employmentName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate entryDate;

    private ResourceType resourceType;
    private LabourType labourType;

    private Long mechanismTypeId;
    private String mechanismTypeName;

    private Integer planValue;
    private Integer factValue;
    private Integer recommendedValue;

    private Boolean planEdited;
    private Boolean factEdited;
    private Boolean recommendedEdited;



}
