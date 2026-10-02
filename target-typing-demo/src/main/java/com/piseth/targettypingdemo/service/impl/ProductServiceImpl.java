package com.piseth.targettypingdemo.service.impl;

import com.piseth.targettypingdemo.domain.Product;
import com.piseth.targettypingdemo.dto.ProductResponse;
import com.piseth.targettypingdemo.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

@Service
public class ProductServiceImpl implements ProductService {
    private final List<Product> products = List.of(
            new Product(1L, "MacBook Pro", "Laptop", new BigDecimal("2000.00")),
            new Product(2L, "iPhone 18 Pro", "Phone", new BigDecimal("1200.00")),
            new Product(3L, "Samsung Galaxy S26", "Phone", new BigDecimal("1100.00")),
            new Product(4L, "Dell XPS", "Laptop", new BigDecimal("1800.00")),
            new Product(5L, "AirPods Pro", "Accessory", new BigDecimal("250.00"))
    );

    @Override
    public List<ProductResponse> getAllProducts() {
        return products.stream().map(ProductResponse::from).toList();
    }

    @Override
    public List<ProductResponse> getExpensiveProducts() {
        Predicate<Product> expensiveProduct = product -> product.price().compareTo(
                new BigDecimal("1000.00")) > 0;
        return products.stream().filter(expensiveProduct).map(ProductResponse::from).toList();
    }

    @Override
    public List<String> getProductNames() {
        return products.stream().map(Product::name).toList();
    }

    @Override
    public List<ProductResponse> getProductsSortedByPrice() {
        return products.stream().sorted(Comparator.comparing(Product::price))
                .map(ProductResponse::from)
                .toList();
    }

    @Override
    public List<ProductResponse> searchProducts(String keyword) {
        return products.stream().filter(product -> product.name().toLowerCase()
                .contains(keyword.toLowerCase())).map(ProductResponse::from).toList();
    }

    @Override
    public List<ProductResponse> getProductsAbovePrice(BigDecimal price) {
        return filterProducts(product -> product.price().compareTo(price) > 0);
    }

    private List<ProductResponse> filterProducts(Predicate<Product> condition) {
        return products.stream().filter(condition).map(ProductResponse::from).toList();
    }
}
