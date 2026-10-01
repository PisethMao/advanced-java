package org.example.allnewfeaturesinjava8.completablefuture.exceptionhandling;

import java.util.concurrent.CompletableFuture;

public class Main {
    static void main() {
        // 1. Use exceptionally()
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            IO.println("Calculating...");
            return 10 / 2;
        }).exceptionally(error -> {
            IO.println("Error: " + error.getMessage());
            return 0;
        });
        IO.println("Main thread continues...");
        IO.println(future1.join());
        // 2. Use handle()
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 10 / 2)
                .handle((result, error) -> {
                    if (error != null) {
                        IO.println("Failed: " + error.getMessage());
                        return 0;
                    }
                    return result * 2;
                });
        IO.println(future2.join());
        // 3. Use whenComplet()
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> 10 / 0)
                .whenComplete((_, error) -> {
                    if (error != null) {
                        IO.println("Operation failed: " + error.getMessage());
                    }
                });
        IO.println(future3.join());
    }
}
