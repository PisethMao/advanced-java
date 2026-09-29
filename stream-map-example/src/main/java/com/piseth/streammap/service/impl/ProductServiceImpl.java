package com.piseth.streammap.service.impl;

import com.piseth.streammap.domain.Product;
import com.piseth.streammap.dto.ProductResponse;
import com.piseth.streammap.dto.ProductSummaryResponse;
import com.piseth.streammap.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final List<Product> products = List.of(
            new Product(1L, "MacBook Pro", "Laptop", new BigDecimal("2000")),
            new Product(2L, "iPhone 18 Pro", "Phone", new BigDecimal("1200")),
            new Product(3L, "Samsung Galaxy S26", "Phone", new BigDecimal("1100")),
            new Product(4L, "Dell XPS", "Laptop", new BigDecimal("1800")),
            new Product(5L, "AirPods Pro", "Audio", new BigDecimal("250"))
    );

    @Override
    public List<ProductResponse> findAll() {
        return products.stream()
                .map(ProductResponse::from)
                .toList();
    }

    @Override
    public List<String> findProductNames() {
        return products.stream()
                .map(Product::name)
                .toList();
    }

    @Override
    public List<String> findUppercaseNames() {
        return products.stream()
                .map(Product::name)
                .map(String::toUpperCase)
                .toList();
    }

    @Override
    public List<BigDecimal> findPrices() {
        return products.stream()
                .map(Product::price)
                .toList();
    }

    @Override
    public List<ProductResponse> findLaptops() {
        return products.stream()
                .filter(product -> product.category().equalsIgnoreCase("Laptop"))
                .map(ProductResponse::from)
                .toList();
    }

    @Override
    public List<ProductSummaryResponse> findSummaries() {
        return products.stream()
                .map(ProductSummaryResponse::from)
                .toList();
    }

    @Override
    public List<BigDecimal> findDiscountedPrices() {
        return products.stream()
                .map(Product::price)
                .map(price -> price.multiply(new BigDecimal("0.90")))
                .toList();
    }
}