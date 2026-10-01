package com.piseth.completablefuturedemo.service;

import com.piseth.completablefuturedemo.domain.Payment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Service
public class PaymentService {
    private final Executor taskExecutor;

    public PaymentService(Executor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public CompletableFuture<Payment> processPayment(BigDecimal amount) {
        return CompletableFuture.supplyAsync(() -> {
            IO.println("Processing payment - Thread: " + Thread.currentThread().getName());
            sleep();
            String transactionId = "TXN-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
            return new Payment(transactionId, amount, "SUCCESS");
        }, taskExecutor);
    }

    private void sleep() {
        try {
            Thread.sleep((long) 1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
