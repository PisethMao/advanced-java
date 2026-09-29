package com.piseth.flatmapexample.domain;

import java.math.BigDecimal;

public record OrderItem(
        Long id,
        String productName,
        String category,
        BigDecimal price
) {
}