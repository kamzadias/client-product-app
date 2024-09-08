package com.example.clientproductapp.controller;

import com.example.clientproductapp.dto.ProductDto;
import com.example.clientproductapp.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Поиск товаров по описанию")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Товары найдены")
    })
    @GetMapping("/search")
    public ResponseEntity<List<ProductDto>> getProductsByDescription(@RequestParam String description) {
        List<ProductDto> products = productService.getProductsByDescription(description);
        return ResponseEntity.ok(products);
    }

    @Operation(summary = "Фильтрация товаров")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Товары найдены")
    })
    @GetMapping("/filter")
    public ResponseEntity<List<ProductDto>> getProductsByFilter(
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) String description) {
        List<ProductDto> products = productService.getProductsByFilter(categoryId, price, description);
        return ResponseEntity.ok(products);
    }
}
