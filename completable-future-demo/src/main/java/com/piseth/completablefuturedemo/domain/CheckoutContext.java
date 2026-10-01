package com.piseth.completablefuturedemo.domain;

import java.math.BigDecimal;

public record CheckoutContext(
        Customer customer,
        Product product,
        Integer quantity,
        BigDecimal totalAmount
) {
}
