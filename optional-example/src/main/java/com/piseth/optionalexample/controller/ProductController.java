package com.piseth.optionalexample.controller;

import com.piseth.optionalexample.dto.ProductResponse;
import com.piseth.optionalexample.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/search")
    public ProductResponse getProductByName(@RequestParam String name) {
        return productService.getProductByName(name);
    }
}