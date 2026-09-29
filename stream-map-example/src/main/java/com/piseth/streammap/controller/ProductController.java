package com.piseth.streammap.controller;

import com.piseth.streammap.dto.ProductResponse;
import com.piseth.streammap.dto.ProductSummaryResponse;
import com.piseth.streammap.service.ProductService;
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
    public List<ProductResponse> findAll() {
        return productService.findAll();
    }

    @GetMapping("/names")
    public List<String> findNames() {
        return productService.findProductNames();
    }

    @GetMapping("/names/uppercase")
    public List<String> findUppercaseNames() {
        return productService.findUppercaseNames();
    }

    @GetMapping("/prices")
    public List<BigDecimal> findPrices() {
        return productService.findPrices();
    }

    @GetMapping("/laptops")
    public List<ProductResponse> findLaptops() {
        return productService.findLaptops();
    }

    @GetMapping("/summaries")
    public List<ProductSummaryResponse> findSummaries() {
        return productService.findSummaries();
    }

    @GetMapping("/discounted-prices")
    public List<BigDecimal> findDiscountedPrices() {
        return productService.findDiscountedPrices();
    }
}