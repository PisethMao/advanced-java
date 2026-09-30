package org.example.allnewfeaturesinjava8.iterable.domain;

import java.math.BigDecimal;

public record Order(
        Long id,
        String customerName,
        BigDecimal totalAmount
) {
}
