package com.piseth.vardemo.service;

import com.piseth.vardemo.domain.CartSummary;
import com.piseth.vardemo.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(Integer id);

    CartSummary calculateCart(List<Integer> productIds);
}
