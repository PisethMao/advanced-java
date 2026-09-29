package com.piseth.functionexample.function;

import com.piseth.functionexample.dto.ProductRequest;
import com.piseth.functionexample.dto.ProductResponse;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.function.Function;

@Component
public class ProductPriceFunction implements Function<ProductRequest, ProductResponse> {
    @Override
    public ProductResponse apply(ProductRequest request) {
        BigDecimal totalPrice = request.unitPrice().multiply(BigDecimal.valueOf(request.quantity()));
        return new ProductResponse(
                request.productName(),
                request.unitPrice(),
                request.quantity(),
                totalPrice
        );
    }
}