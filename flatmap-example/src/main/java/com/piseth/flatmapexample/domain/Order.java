package com.piseth.flatmapexample.domain;

import java.util.List;

public record Order(
        Long id,
        String customerName,
        List<OrderItem> items
) {
}