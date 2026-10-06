package com.piseth.vardemo.controller;

import com.piseth.vardemo.domain.CartSummary;
import com.piseth.vardemo.domain.Product;
import com.piseth.vardemo.service.ProductService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    @PostMapping("/cart/summary")
    public CartSummary calculateCart(@RequestBody List<Integer> productIds) {
        return productService.calculateCart(productIds);
    }
}
