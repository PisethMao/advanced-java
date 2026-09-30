package com.piseth.streamsorting.controller;

import com.piseth.streamsorting.domain.Product;
import com.piseth.streamsorting.service.ProductService;
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

    @GetMapping("/sort/price")
    public List<Product> sortByPrice() {
        return productService.sortByPrice();
    }

    @GetMapping("/sort/price/desc")
    public List<Product> sortByPriceDescending() {
        return productService.sortByPriceDescending();
    }

    @GetMapping("/sort/name")
    public List<Product> sortByName() {
        return productService.sortByName();
    }

    @GetMapping("/sort/category")
    public List<Product> sortByCategory() {
        return productService.sortByCategory();
    }

    @GetMapping("/sort/category-price")
    public List<Product> sortByCategoryThenPrice() {
        return productService.sortByCategoryThenPrice();
    }
}
