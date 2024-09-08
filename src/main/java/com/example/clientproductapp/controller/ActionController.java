package com.example.clientproductapp.controller;

import com.example.clientproductapp.dto.ActionDto;
import com.example.clientproductapp.service.ActionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/actions")
public class ActionController {

    private final ActionService actionService;

    public ActionController(ActionService actionService) {
        this.actionService = actionService;
    }

    @Operation(summary = "Получение активных акций")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Акции найдены")
    })
    @GetMapping("/active")
    public ResponseEntity<List<ActionDto>> getActiveActions() {
        List<ActionDto> actions = actionService.getActiveActions(LocalDate.now());
        return ResponseEntity.ok(actions);
    }
}
