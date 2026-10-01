package com.piseth.completionstagedemo.dto;

public record OrderInfo(
        String orderId,
        String productName,
        int quantity
) {
}
