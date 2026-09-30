package com.piseth.streamsorting.service;

import com.piseth.streamsorting.domain.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductService {
    private final List<Product> products = List.of(
            new Product(1L, "MacBook Pro", "Laptop", new BigDecimal("2000")),
            new Product(2L, "iPhone 18 Pro", "Phone", new BigDecimal("1200")),
            new Product(3L, "Mouse", "Accessory", new BigDecimal("50")),
            new Product(4L, "Keyboard", "Accessory", new BigDecimal("100")),
            new Product(5L, "Dell XPS", "Laptop", new BigDecimal("1500")),
            new Product(6L, "Samsung Galaxy", "Phone", new BigDecimal("900"))
    );

    public List<Product> getAllProducts() {
        return products;
    }

    public List<Product> sortByPrice() {
        return products.stream().sorted(Comparator.comparing(Product::price)).toList();
    }

    public List<Product> sortByPriceDescending() {
        return products.stream().sorted(Comparator.comparing(Product::price).reversed()).toList();
    }

    public List<Product> sortByName() {
        return products.stream()
                .sorted(Comparator.comparing(Product::name, String.CASE_INSENSITIVE_ORDER))
                .toList();
    }

    public List<Product> sortByCategory() {
        return products.stream().sorted(Comparator.comparing(Product::category)).toList();
    }

    public List<Product> sortByCategoryThenPrice() {
        return products.stream()
                .sorted(Comparator.comparing(Product::category).thenComparing(Product::price))
                .toList();
    }
}
