package com.piseth.recordsdemo.service;

import com.piseth.recordsdemo.domain.CreateProductRequest;
import com.piseth.recordsdemo.domain.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductService {
    private final Map<Long, Product> products = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(2);

    public ProductService() {
        products.put(1L, new Product(1L, "Laptop", new BigDecimal("1299.99")));
        products.put(2L, new Product(2L, "Mouse", new BigDecimal("29.99")));
    }

    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    public Product findById(Long id) {
        return products.get(id);
    }

    public Product create(CreateProductRequest request) {
        Long id = idGenerator.incrementAndGet();
        Product product = new Product(id, request.name(), request.price());
        products.put(id, product);
        return product;
    }
}
