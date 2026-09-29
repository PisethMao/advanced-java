package com.piseth.streammap.service;

import com.piseth.streammap.dto.ProductResponse;
import com.piseth.streammap.dto.ProductSummaryResponse;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    List<ProductResponse> findAll();

    List<String> findProductNames();

    List<String> findUppercaseNames();

    List<BigDecimal> findPrices();

    List<ProductResponse> findLaptops();

    List<ProductSummaryResponse> findSummaries();

    List<BigDecimal> findDiscountedPrices();
}