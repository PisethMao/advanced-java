package com.piseth.completablefuturedemo.domain;

import java.math.BigDecimal;

public record Product(
        Long id,
        String name,
        BigDecimal price
) {
}
