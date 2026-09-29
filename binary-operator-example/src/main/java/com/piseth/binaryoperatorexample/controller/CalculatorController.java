package com.piseth.binaryoperatorexample.controller;

import com.piseth.binaryoperatorexample.dto.CalculationRequest;
import com.piseth.binaryoperatorexample.dto.CalculationResponse;
import com.piseth.binaryoperatorexample.service.CalculatorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculations")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CalculationResponse calculate(@RequestBody CalculationRequest request) {
        return calculatorService.calculate(request);
    }
}