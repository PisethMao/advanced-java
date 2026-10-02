package com.piseth.typereferencedemo.service;

import com.piseth.typereferencedemo.dto.ProductResponse;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProducts();

    List<ProductResponse> getProductsByMinimumPrice(BigDecimal minPrice);

    List<ProductResponse> getProductsSortedByPrice();
}
