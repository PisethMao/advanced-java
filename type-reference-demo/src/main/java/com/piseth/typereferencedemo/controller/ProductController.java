package com.piseth.typereferencedemo.controller;

import com.piseth.typereferencedemo.dto.ProductResponse;
import com.piseth.typereferencedemo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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

    @GetMapping("/filter")
    public List<ProductResponse> getProductsByMinimumPrice(@RequestParam BigDecimal minPrice) {
        return productService.getProductsByMinimumPrice(minPrice);
    }

    @GetMapping("/sorted")
    public List<ProductResponse> getProductsSortedByPrice() {
        return productService.getProductsSortedByPrice();
    }
}
