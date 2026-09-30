package org.example.allnewfeaturesinjava8.stream.reduce.domain;

import java.math.BigDecimal;

public record OrderItem(
        Long id,
        String productName,
        BigDecimal price,
        int quantity
) {
}