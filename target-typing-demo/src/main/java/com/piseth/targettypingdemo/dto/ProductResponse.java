package com.piseth.targettypingdemo.dto;

import com.piseth.targettypingdemo.domain.Product;

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
