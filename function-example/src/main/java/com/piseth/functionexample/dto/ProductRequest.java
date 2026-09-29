package com.piseth.functionexample.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRequest(
        @NotBlank
        String productName,
        @NotNull
        @DecimalMin("0.01")
        BigDecimal unitPrice,
        @Min(1)
        int quantity
) {
}
