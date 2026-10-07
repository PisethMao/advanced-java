package com.piseth.recordsdemo.domain;

import java.math.BigDecimal;

public record Product(
        Long id,
        String name,
        BigDecimal price
) {
    public Product {
        if (id == null) {
            throw new IllegalArgumentException("Product ID cannot be null");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }
        if (price == null) {
            throw new IllegalArgumentException("Product price cannot be null");
        }
        if (price.signum() < 0) {
            throw new IllegalArgumentException("Product price cannot be negative");
        }
    }
}
