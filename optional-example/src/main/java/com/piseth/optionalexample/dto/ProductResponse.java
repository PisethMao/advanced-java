package com.piseth.optionalexample.dto;

import com.piseth.optionalexample.domain.Product;

import java.math.BigDecimal;

public record ProductResponse(
        Long id,
        String name,
        String category,
        BigDecimal price
) {
    public static ProductResponse from(Product product) {
        return new ProductResponse(
                product.id(),
                product.name(),
                product.category(),
                product.price()
        );
    }
}
