package com.piseth.vardemo.service.impl;

import com.piseth.vardemo.domain.CartSummary;
import com.piseth.vardemo.domain.Product;
import com.piseth.vardemo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final List<Product> products = List.of(
            new Product(1, "MacBook Pro", new BigDecimal("2000.00"), 10),
            new Product(2, "iPhone 18 Pro", new BigDecimal("1200.00"), 0),
            new Product(3, "AirPods Pro", new BigDecimal("250.00"), 20),
            new Product(4, "Dell XPS", new BigDecimal("1800.00"), 5)
    );

    @Override
    public List<Product> getAllProducts() {
        // 1. Version 1
//        var availableProducts = products.stream()
//                .filter(product -> product.stock() > 0)
//                .toList();
        // 2. Version 2
        return products.stream().filter(product -> product.stock() > 0).toList();
    }

    @Override
    public Product getProductById(Integer id) {
        return products.stream().filter(item -> item.id().equals(id)).findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Product not found: " + id
                ));
    }

    @Override
    public CartSummary calculateCart(List<Integer> productIds) {
        var selectedProducts = productIds.stream().map(this::getProductById).toList();
        var total = selectedProducts.stream().map(Product::price)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        var itemCount = selectedProducts.size();
        return new CartSummary(itemCount, total, selectedProducts);
    }
}