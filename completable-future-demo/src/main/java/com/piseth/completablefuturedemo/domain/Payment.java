package com.piseth.completablefuturedemo.domain;

import java.math.BigDecimal;

public record Payment(
        String transactionId,
        BigDecimal amount,
        String status
) {
}