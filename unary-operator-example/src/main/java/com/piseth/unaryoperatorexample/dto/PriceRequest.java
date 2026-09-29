package com.piseth.unaryoperatorexample.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record PriceRequest(
        @NotNull
        @Positive
        BigDecimal price
) {
}
