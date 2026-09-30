package org.example.allnewfeaturesinjava8.stream.searching.service;

import org.example.allnewfeaturesinjava8.stream.searching.domain.Product;

import java.math.BigDecimal;
import java.util.List;

public class ProductService {
    private final List<Product> products = List.of(
            new Product(1L, "MacBook Pro", "Laptop", new BigDecimal("2000")),
            new Product(2L, "iPhone 18 Pro", "Phone", new BigDecimal("1200")),
            new Product(3L, "Dell XPS 15", "Laptop", new BigDecimal("1600")),
            new Product(4L, "Samsung S26", "Phone", new BigDecimal("1100")),
            new Product(5L, "Keyboard", "Accessory", new BigDecimal("150")),
            new Product(6L, "ThinkPad X1", "Laptop", new BigDecimal("1800"))
    );

    public Product findById(Long id) {
        return products.stream().filter(product -> product.id().equals(3L)).findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public Product findAnyLaptop() {
        return products.stream()
                .peek(product -> IO.println("Processing: " + product.name()))
                .filter(product -> product.category().equalsIgnoreCase("Laptop"))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Product not found with any laptop"));
    }
}
