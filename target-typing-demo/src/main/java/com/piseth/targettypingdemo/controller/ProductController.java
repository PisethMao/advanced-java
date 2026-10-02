package com.piseth.targettypingdemo.controller;

import com.piseth.targettypingdemo.dto.ProductResponse;
import com.piseth.targettypingdemo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/expensive")
    public List<ProductResponse> getExpensiveProducts() {
        return productService.getExpensiveProducts();
    }

    @GetMapping("/names")
    public List<String> getProductNames() {
        return productService.getProductNames();
    }

    @GetMapping("/sorted")
    public List<ProductResponse> getSortedProducts() {
        return productService.getProductsSortedByPrice();
    }

    @GetMapping("/search")
    public List<ProductResponse> searchProducts(@RequestParam String keyword) {
        return productService.searchProducts(keyword);
    }

    @GetMapping("/above")
    public List<ProductResponse> getProductsAbovePrice(@RequestParam BigDecimal price) {
        return productService.getProductsAbovePrice(price);
    }
}
