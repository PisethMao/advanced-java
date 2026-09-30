package org.example.allnewfeaturesinjava8.stream.limitskip;

import java.math.BigDecimal;
import java.util.List;

public class ProductService {
    private final List<Product> products = List.of(
            new Product(1L, "MacBook Pro", "Laptop", new BigDecimal("2000")),
            new Product(2L, "iPhone 18 Pro", "Phone", new BigDecimal("1200")),
            new Product(3L, "iPad Pro", "Tablet", new BigDecimal("1000")),
            new Product(4L, "AirPods Pro", "Accessory", new BigDecimal("250")),
            new Product(5L, "Apple Watch", "Watch", new BigDecimal("500")),
            new Product(6L, "Samsung Galaxy", "Phone", new BigDecimal("1100")),
            new Product(7L, "Dell XPS", "Laptop", new BigDecimal("1800")),
            new Product(8L, "ASUS ROG", "Laptop", new BigDecimal("2200")),
            new Product(9L, "Google Pixel", "Phone", new BigDecimal("900")),
            new Product(10L, "Logitech Mouse", "Accessory", new BigDecimal("80"))
    );

    public List<Product> getAllProducts() {
        return products;
    }
}
