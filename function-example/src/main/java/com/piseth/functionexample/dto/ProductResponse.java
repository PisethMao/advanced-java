package com.piseth.functionexample.dto;

import java.math.BigDecimal;

public record ProductResponse(
        String productName,
        BigDecimal unitPrice,
        int quantity,
        BigDecimal totalPrice
) {
}
