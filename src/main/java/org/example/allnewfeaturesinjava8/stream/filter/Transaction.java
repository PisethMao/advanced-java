package org.example.allnewfeaturesinjava8.stream.filter;

import java.math.BigDecimal;

public record Transaction(
        String id,
        String customerName,
        String type,
        BigDecimal amount,
        String status
) {
}
