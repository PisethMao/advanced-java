package com.piseth.typereferencedemo.service.impl;

import com.piseth.typereferencedemo.domain.Product;
import com.piseth.typereferencedemo.dto.ProductResponse;
import com.piseth.typereferencedemo.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final List<Product> products = List.of(
            new Product(1L, "MacBook Pro", new BigDecimal("2000")),
            new Product(2L, "iPhone 18 Pro", new BigDecimal("1200")),
            new Product(3L, "Samsung Galaxy S26", new BigDecimal("1100")),
            new Product(4L, "Dell XPS", new BigDecimal("1800")),
            new Product(5L, "AirPods Pro", new BigDecimal("250"))
    );

    @Override
    public List<ProductResponse> getAllProducts() {
        return products.stream().map(ProductResponse::from).toList();
    }

    @Override
    public List<ProductResponse> getProductsByMinimumPrice(BigDecimal minPrice) {
        return products.stream().filter(product -> product.price().compareTo(minPrice) >= 0)
                .map(ProductResponse::from).toList();
    }

    @Override
    public List<ProductResponse> getProductsSortedByPrice() {
        return products.stream().sorted(Comparator.comparing(Product::price))
                .map(ProductResponse::from)
                .toList();
    }
}
