package org.example.allnewfeaturesinjava9.completablefuture;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class PaymentService {
    private final ExecutorService executor;

    public PaymentService(ExecutorService executor) {
        this.executor = executor;
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public CompletableFuture<PaymentResult> processPayment(
            String transactionId,
            BigDecimal amount,
            long delayMillis
    ) {
        return CompletableFuture.supplyAsync(() -> {
            IO.println("Processing payment on: " + Thread.currentThread().getName());
            sleep(delayMillis);
            return new PaymentResult(transactionId, amount, "SUCCESS");
        }, executor);
    }

    public CompletableFuture<String> getExchangeRate(long delayMillis) {
        return CompletableFuture.supplyAsync(() -> {
            IO.println("Loading exchange rate...");
            sleep(delayMillis);
            return "1 USD = 4,100 KHR";
        }, executor);
    }

//    public CompletableFuture<PaymentResult> validateAndProcessPayment(
//            String transactionId,
//            BigDecimal amount
//    ) {
//        if (amount == null) {
//            return CompletableFuture.failedFuture(
//                    new IllegalArgumentException("Amount is required"));
//        }
//        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
//            return CompletableFuture.failedFuture(
//                    new IllegalArgumentException("Amount must be greater than zero"));
//        }
//        return processPayment(transactionId, amount, 1000);
//    }
}
