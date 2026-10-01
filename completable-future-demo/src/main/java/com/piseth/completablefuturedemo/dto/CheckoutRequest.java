package com.piseth.completablefuturedemo.dto;

public record CheckoutRequest(
        Long customerId,
        Long productId,
        Integer quantity
) {
}