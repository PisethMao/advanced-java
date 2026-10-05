package org.example.allnewfeaturesinjava9.completablefuture;

import java.math.BigDecimal;
import java.util.concurrent.*;

public class Main {
    static void main() {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        PaymentService paymentService = new PaymentService(executor);
        IO.println("Application started");
        // 1. Use orTimeout()
        CompletableFuture<PaymentResult> future = paymentService
                .processPayment("TXN-003", new BigDecimal("300.00"), 5000)
                .orTimeout(2, TimeUnit.SECONDS)
                .exceptionally(exception -> {
                    IO.println("Error: " + exception.getMessage());
                    return new PaymentResult("TXN-003", new BigDecimal("300.00"), "FAILED");
                });
        IO.println("Main thread continues...");
        PaymentResult result = future.join();
        IO.println(result);
        // 2. Use completeOnTimeout()
        CompletableFuture<String> future1 = paymentService.getExchangeRate(5000)
                .completeOnTimeout(
                        "Exchange rate temporarily unavailable",
                        2,
                        TimeUnit.SECONDS);
        IO.println(future1.join());
        // 3. Use delayedExecutor()
        Executor delayedExecutor = CompletableFuture
                .delayedExecutor(2, TimeUnit.SECONDS, executor);
        CompletableFuture<String> retry = CompletableFuture.supplyAsync(() -> {
                    IO.println("Retrying service...");
                    return "Retry completed";
                },
                delayedExecutor
        );
        IO.println(retry.join());
        // 4. Use completedStage()
        CompletionStage<String> stage = CompletableFuture.completedStage("USD");
        stage.thenAccept(currency -> IO.println("Currency: " + currency));
        // 5. Use failedStage()
        CompletionStage<String> stage1 = CompletableFuture.failedStage(
                new RuntimeException("Exchange rate service unavailable"));
        stage1.exceptionally(exception -> {
            IO.println(exception.getMessage());
            return "DEFAULT";
        }).thenAccept(IO::println);
        // 6. Use completeAsync()
        CompletableFuture<String> future2 = new CompletableFuture<>();
        future2.completeAsync(() -> {
            IO.println("Thread: " + Thread.currentThread().getName());
            return "COMPLETED";
        }, executor);
        IO.println(future2.join());
        // 7. Use copy()
        CompletableFuture<String> original = new CompletableFuture<>();
        CompletableFuture<String> copy = original.copy();
        copy.complete("CLIENT VALUE");
        original.complete("REAL SERVER VALUE");
        IO.println("Original: " + original.join());
        IO.println("Copy: " + copy.join());
        // 8. Use minimalCompletionStage()
        CompletableFuture<String> internalFuture = new CompletableFuture<>();
        CompletionStage<String> publicStage = internalFuture.minimalCompletionStage();
        publicStage.thenAccept(result1 -> IO.println("Client received: " + result1));
        internalFuture.complete("PAYMENT SUCCESS");
        // 9. Use defaultExecutor()
        CustomCompletableFuture<String> future3 = new CustomCompletableFuture<>(executor);
        future3.complete("PAYMENT SUCCESS");
        future3.thenApplyAsync(value -> {
            IO.println("Thread: " + Thread.currentThread().getName());
            return value.toLowerCase();
        }).thenAccept(IO::println).join();
        executor.shutdown();
    }
}
