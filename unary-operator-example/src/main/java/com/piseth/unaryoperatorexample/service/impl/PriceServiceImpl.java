package com.piseth.unaryoperatorexample.service.impl;

import com.piseth.unaryoperatorexample.dto.PriceResponse;
import com.piseth.unaryoperatorexample.service.PriceService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.UnaryOperator;

@Service
public class PriceServiceImpl implements PriceService {
    private final UnaryOperator<BigDecimal> applyDiscount = price -> price.multiply(
            new BigDecimal("0.90")
    );

    private final UnaryOperator<BigDecimal> addTax = price -> price.multiply(
            new BigDecimal("1.10")
    );

    private final UnaryOperator<BigDecimal> roundPrice = price -> price.setScale(
            2,
            RoundingMode.HALF_UP
    );

    @Override
    public PriceResponse processPrice(BigDecimal price) {
        BigDecimal afterDiscount = applyDiscount.apply(price);
        BigDecimal afterTax = addTax.apply(afterDiscount);
        BigDecimal finalPrice = roundPrice.apply(afterTax);
        return new PriceResponse(price, afterDiscount, afterTax, finalPrice);
    }
}