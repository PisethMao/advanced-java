package com.piseth.completionstagedemo.dto;

public record DeliveryInfo(
        String orderId,
        String status,
        String estimatedDelivery
) {
}
