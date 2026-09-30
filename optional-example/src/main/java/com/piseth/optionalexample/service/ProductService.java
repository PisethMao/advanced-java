package com.piseth.optionalexample.service;

import com.piseth.optionalexample.dto.ProductResponse;
import com.piseth.optionalexample.exception.ProductNotFoundException;
import com.piseth.optionalexample.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream().map(ProductResponse::from).toList();
    }

    public ProductResponse getProductById(Long id) {
        return productRepository.findById(id).map(ProductResponse::from)
                .orElseThrow(
                        () -> new ProductNotFoundException(id)
                );
    }

    public ProductResponse getProductByName(String name) {
        return productRepository.findByName(name).map(ProductResponse::from)
                .orElseThrow(
                        () -> new ProductNotFoundException(name)
                );
    }
}