package com.piseth.streamdistinct.service;

import com.piseth.streamdistinct.domain.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {
    private final List<Product> products = List.of(
            new Product(1L, "MacBook Pro", "Laptop", new BigDecimal("2000")),
            new Product(2L, "Dell XPS", "Laptop", new BigDecimal("1800")),
            new Product(3L, "iPhone 18 Pro", "Phone", new BigDecimal("1200")),
            new Product(4L, "Samsung Galaxy S26", "Phone", new BigDecimal("1100")),
            new Product(5L, "AirPods Pro", "Accessory", new BigDecimal("250")),
            new Product(6L, "Lenovo ThinkPad", "Laptop", new BigDecimal("1500"))
    );

    public List<Product> getAllProducts() {
        return products;
    }

    public List<String> getCategories() {
        return products.stream().map(Product::category).toList();
    }

    public List<String> getDistinctCategories() {
        return products.stream().map(Product::category).distinct().toList();
    }

    public List<String> getDistinctSortedCategories() {
        return products.stream().map(Product::category).distinct().sorted().toList();
    }

    public List<String> getExpensiveProductCategories() {
        BigDecimal minimumPrice = new BigDecimal("1000");
        return products.stream()
                .filter(product -> product.price().compareTo(minimumPrice) > 0)
                .map(Product::category).distinct().sorted().toList();
    }
}