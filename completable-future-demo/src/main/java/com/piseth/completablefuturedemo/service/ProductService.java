package com.piseth.completablefuturedemo.service;

import com.piseth.completablefuturedemo.domain.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Service
public class ProductService {
    private final Executor taskExecutor;

    public ProductService(Executor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public CompletableFuture<Product> findProduct(Long id) {
        return CompletableFuture.supplyAsync(() -> {
            IO.println("Finding product - Thread: " + Thread.currentThread().getName());
            sleep();
            if (id == null || id != 100L) {
                throw new RuntimeException("Product not found: " + id);
            }
            return new Product(100L, "Mechanical Keyboard", new BigDecimal("75.50"));
        }, taskExecutor);
    }

    private void sleep() {
        try {
            Thread.sleep((long) 1200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
