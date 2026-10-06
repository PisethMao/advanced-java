package com.piseth.vardemo.domain;

import java.math.BigDecimal;

public record Product(
        Integer id,
        String name,
        BigDecimal price,
        int stock
) {
}
