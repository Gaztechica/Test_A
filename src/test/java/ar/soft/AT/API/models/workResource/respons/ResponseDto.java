package ar.soft.AT.API.models.workResource.respons;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ResponseDto<T> {
    private LocalDateTime timestamp;
    private String success;
    private String error;
    private String description;
    private String token;
    private String refreshToken;
    private Integer pages;

    // Сюда будет подставляться бизнес-DTO
    private T data;
}
