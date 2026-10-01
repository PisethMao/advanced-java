package com.piseth.completablefuturedemo.service;

import com.piseth.completablefuturedemo.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Service
public class CustomerService {
    private final Executor taskExecutor;

    public CustomerService(Executor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public CompletableFuture<Customer> findCustomer(Long id) {
        return CompletableFuture.supplyAsync(() -> {
            IO.println("Finding customer - Thread: " + Thread.currentThread().getName());
            sleep();
            if (id == null || id != 1L) {
                throw new RuntimeException("Customer not found: " + id);
            }
            return new Customer(1L, "Piseth", "piseth@example.com");
        }, taskExecutor);
    }

    private void sleep() {
        try {
            Thread.sleep((long) 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}