package com.piseth.functionexample.service.impl;

import com.piseth.functionexample.dto.ProductRequest;
import com.piseth.functionexample.dto.ProductResponse;
import com.piseth.functionexample.function.ProductPriceFunction;
import com.piseth.functionexample.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductPriceFunction productPriceFunction;

    public ProductServiceImpl(ProductPriceFunction productPriceFunction) {
        this.productPriceFunction = productPriceFunction;
    }

    @Override
    public ProductResponse calculatePrice(ProductRequest request) {
        return productPriceFunction.apply(request);
    }
}
