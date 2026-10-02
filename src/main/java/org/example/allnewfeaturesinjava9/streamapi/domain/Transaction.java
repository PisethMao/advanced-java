package org.example.allnewfeaturesinjava9.streamapi.domain;

import java.math.BigDecimal;

public record Transaction(
        String transactionId,
        String customerId,
        BigDecimal amount,
        String status
) {
}
