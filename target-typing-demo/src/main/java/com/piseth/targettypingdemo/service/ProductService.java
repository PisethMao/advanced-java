package com.piseth.targettypingdemo.service;

import com.piseth.targettypingdemo.dto.ProductResponse;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProducts();

    List<ProductResponse> getExpensiveProducts();

    List<String> getProductNames();

    List<ProductResponse> getProductsSortedByPrice();

    List<ProductResponse> searchProducts(String keyword);

    List<ProductResponse> getProductsAbovePrice(BigDecimal price);
}
