package com.piseth.functionexample.controller;

import com.piseth.functionexample.dto.ProductRequest;
import com.piseth.functionexample.dto.ProductResponse;
import com.piseth.functionexample.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<ProductResponse> calculate(@Valid @RequestBody ProductRequest request) {
        ProductResponse response = productService.calculatePrice(request);
        return ResponseEntity.ok(response);
    }
}
