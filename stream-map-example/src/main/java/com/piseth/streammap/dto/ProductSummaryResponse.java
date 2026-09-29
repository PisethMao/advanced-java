package com.piseth.streammap.dto;

import com.piseth.streammap.domain.Product;

public record ProductSummaryResponse(Long id, String name) {
    public static ProductSummaryResponse from(Product product) {
        return new ProductSummaryResponse(product.id(), product.name());
    }
}