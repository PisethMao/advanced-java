package com.piseth.completionstagedemo.dto;

public record OrderSummary(
        OrderInfo order,
        PaymentInfo payment,
        DeliveryInfo delivery
) {
}
