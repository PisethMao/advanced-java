package com.piseth.flowdemo.domain;

import java.time.Instant;

public record OrderEvent(
        String orderId,
        String itemName,
        String status,
        Instant createdAt
) {
}
