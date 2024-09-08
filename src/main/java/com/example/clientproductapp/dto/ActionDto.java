package com.example.clientproductapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

@Data
@Schema(description = "Информация об акции")
public class ActionDto {

    @Schema(description = "ID акции", example = "1")
    private Long id;

    @Schema(description = "Название акции", example = "Скидка 50%")
    private String name;

    @Schema(description = "Дата начала акции", example = "2023-01-01")
    private LocalDate beginDate;

    @Schema(description = "Дата окончания акции", example = "2023-12-31")
    private LocalDate endDate;

    @Schema(description = "Продукт, участвующий в акции")
    private ProductDto product;
}
