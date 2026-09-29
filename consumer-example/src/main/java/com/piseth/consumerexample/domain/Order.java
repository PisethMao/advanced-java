package com.piseth.consumerexample.domain;

import java.time.Instant;
import java.util.UUID;

public record Order(
        UUID id,
        String customerName,
        String productName,
        int quantity,
        Instant createdAt
) {
}