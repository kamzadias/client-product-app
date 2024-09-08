package com.example.clientproductapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Информация о клиенте")
public class ClientDto {

    @Schema(description = "ID клиента", example = "1")
    private Long id;

    @Schema(description = "Имя клиента", example = "John")
    private String firstName;

    @Schema(description = "Фамилия клиента", example = "Doe")
    private String lastName;

    @Schema(description = "ИИН клиента", example = "123456789012")
    private String iin;
}
