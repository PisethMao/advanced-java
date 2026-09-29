package com.piseth.functionexample.service;

import com.piseth.functionexample.dto.ProductRequest;
import com.piseth.functionexample.dto.ProductResponse;

public interface ProductService {
    ProductResponse calculatePrice(ProductRequest request);
}
