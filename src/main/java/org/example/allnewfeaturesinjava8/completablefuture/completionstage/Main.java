package org.example.allnewfeaturesinjava8.completablefuture.completionstage;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class Main {
    static void main() {
        // 1. Use thenAccept()
        CompletionStage<String> completionStage1 = CompletableFuture.supplyAsync(() -> "Success");
        completionStage1.thenAccept(name -> IO.println("Hello, " + name + "!"));
        completionStage1.toCompletableFuture().join();
        // 2. Use thenApply()
        CompletionStage<String> completionStage2 = CompletableFuture.completedFuture("Success");
        CompletionStage<String> result = completionStage2.thenApply(String::toUpperCase);
        result.thenAccept(name -> IO.println("Hello, " + name + "!"));
        // 3. Use exceptionally()
        CompletionStage<String> completionStage3 = CompletableFuture
                .<String>supplyAsync(() -> {
                    throw new RuntimeException("Something went wrong!");
                }).exceptionally(error -> {
                    IO.println(error.getMessage());
                    return "Something went wrong!";
                });
        completionStage3.thenAccept(name -> IO.println("Hello, " + name + "!"));
    }
}
