package com.piseth.completionstagedemo.dto;

public record PaymentInfo(
        String orderId,
        String status,
        double amount
) {
}