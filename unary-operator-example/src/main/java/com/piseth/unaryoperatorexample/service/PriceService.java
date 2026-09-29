package com.piseth.unaryoperatorexample.service;

import com.piseth.unaryoperatorexample.dto.PriceResponse;

import java.math.BigDecimal;

public interface PriceService {
    PriceResponse processPrice(BigDecimal price);
}