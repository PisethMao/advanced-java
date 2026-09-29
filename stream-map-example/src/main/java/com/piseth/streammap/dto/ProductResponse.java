package com.piseth.streammap.dto;

import com.piseth.streammap.domain.Product;

import java.math.BigDecimal;

public record ProductResponse(
        Long id,
        String name,
        String category,
        BigDecimal price,
        String displayName
) {
    public static ProductResponse from(Product product) {
        return new ProductResponse(
                product.id(),
                product.name(),
                product.category(),
                product.price(),
                product.name() + " - " + product.category()
        );
    }
}