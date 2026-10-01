package com.piseth.completablefuturedemo.dto;

import java.math.BigDecimal;

public record CheckoutResponse(
        String customerName,
        String productName,
        Integer quantity,
        BigDecimal totalAmount,
        String transactionId,
        String paymentStatus
) {
}
