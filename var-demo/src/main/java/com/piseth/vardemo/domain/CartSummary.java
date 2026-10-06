package com.piseth.vardemo.domain;

import java.math.BigDecimal;
import java.util.List;

public record CartSummary(
        int itemCount,
        BigDecimal total,
        List<Product> products
) {
}
