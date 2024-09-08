package com.example.clientproductapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Информация о продукте")
public class ProductDto {

    @Schema(description = "ID продукта", example = "1")
    private Long id;

    @Schema(description = "ID категории", example = "2")
    private Long categoryId;

    @Schema(description = "Название продукта", example = "Product 1")
    private String name;

    @Schema(description = "Описание продукта", example = "Описание продукта")
    private String description;

    @Schema(description = "Цена продукта", example = "100.00")
    private Double price;
}
