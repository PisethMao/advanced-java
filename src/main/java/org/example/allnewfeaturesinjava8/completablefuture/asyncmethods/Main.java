package org.example.allnewfeaturesinjava8.completablefuture.asyncmethods;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    static void main() {
        long start = System.currentTimeMillis();
        CompletableFuture<String> customerFuture = CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            IO.println("Customer: " + Thread.currentThread().getName());
            return "Piseth";
        });
        CompletableFuture<Double> balanceFuture = CompletableFuture.supplyAsync(() -> {
            sleep(2000);
            IO.println("Balance: " + Thread.currentThread().getName());
            return 1500.00;
        });
        CompletableFuture<List<String>> transactionsFuture = CompletableFuture.supplyAsync(() -> {
            sleep(2000);
            IO.println("Transactions: " + Thread.currentThread().getName());
            return List.of("Payment $100", "Transfer $50", "Deposit $500");
        });
        CompletableFuture<String> dashboardFuture = customerFuture.thenCombineAsync(balanceFuture, (customer, balance) -> "Customer: " + customer + "\nBalance: $" + balance)
                .thenCombineAsync(transactionsFuture, (dashboard, transactions) -> dashboard + "\nTransactions: " + transactions);
        String dashboard = dashboardFuture.join();
        IO.println();
        IO.println(dashboard);
        long end = System.currentTimeMillis();
        IO.println("\nTime: " + (end - start) + " ms");
    }
}
