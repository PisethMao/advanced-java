package com.piseth.unaryoperatorexample.controller;

import com.piseth.unaryoperatorexample.dto.PriceRequest;
import com.piseth.unaryoperatorexample.dto.PriceResponse;
import com.piseth.unaryoperatorexample.service.PriceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/prices")
public class PriceController {
    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @PostMapping("/process")
    @ResponseStatus(HttpStatus.OK)
    public PriceResponse processPrice(@Valid @RequestBody PriceRequest request) {
        return priceService.processPrice(request.price());
    }
}