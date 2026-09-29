package com.piseth.unaryoperatorexample.dto;

import java.math.BigDecimal;

public record PriceResponse(
        BigDecimal originalPrice,
        BigDecimal afterDiscount,
        BigDecimal afterTax,
        BigDecimal finalPrice
) {
}