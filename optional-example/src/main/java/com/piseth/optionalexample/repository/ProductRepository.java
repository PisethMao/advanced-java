package com.piseth.optionalexample.repository;

import com.piseth.optionalexample.domain.Product;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private final List<Product> products = List.of(
            new Product(1L, "MacBook Pro", "Laptop", new BigDecimal("2000")),
            new Product(2L, "iPhone 18 Pro", "Phone", new BigDecimal("1200")),
            new Product(3L, "AirPods Pro", "Accessory", new BigDecimal("250")),
            new Product(4L, "iPad Pro", "Tablet", new BigDecimal("1000"))
    );

    public List<Product> findAll() {
        return products;
    }

    public Optional<Product> findById(Long id) {
        return products.stream().filter(product -> product.id().equals(id)).findFirst();
    }

    public Optional<Product> findByName(String name) {
        return products.stream().filter(product -> product.name().equalsIgnoreCase(name))
                .findFirst();
    }
}
