package com.piseth.streamdistinct.controller;

import com.piseth.streamdistinct.domain.Product;
import com.piseth.streamdistinct.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/categories")
    public List<String> getCategories() {
        return productService.getCategories();
    }

    @GetMapping("/categories/distinct")
    public List<String> getDistinctCategories() {
        return productService.getDistinctCategories();
    }

    @GetMapping("/categories/distinct-sorted")
    public List<String> getDistinctSortedCategories() {
        return productService.getDistinctSortedCategories();
    }

    @GetMapping("/categories/expensive")
    public List<String> getExpensiveProductCategories() {
        return productService.getExpensiveProductCategories();
    }
}
