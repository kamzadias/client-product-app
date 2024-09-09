package com.example.clientproductapp.controller;

import com.example.clientproductapp.dto.DiscountDto;
import com.example.clientproductapp.service.DiscountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/discounts")
public class DiscountController {

    private final DiscountService discountService;

    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @Operation(summary = "Получение активных акций")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Акции найдены")
    })
    @GetMapping("/active")
    public ResponseEntity<List<DiscountDto>> getActiveDiscounts() {
        List<DiscountDto> discounts = discountService.getActiveDiscounts(LocalDate.now());
        return ResponseEntity.ok(discounts);
    }
}
