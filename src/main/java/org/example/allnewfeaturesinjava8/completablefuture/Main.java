package org.example.allnewfeaturesinjava8.completablefuture;

import java.util.concurrent.CompletableFuture;

public class Main {
    static void main() {
        // 1. Use supplyAsync()
//        CompletableFuture<String> supplyAsync =
//                CompletableFuture.supplyAsync(() -> "Hello World!");
//        String result = supplyAsync.join();
        // 2. Use runAsync()
//        CompletableFuture<Void> runAsync =
//                CompletableFuture.runAsync(() -> {
//                    IO.println("Hello World");
//                });
        // 3. Use thenApply()
//        CompletableFuture<String> future =
//                supplyAsync.thenApply(String::toUpperCase);
        // 4. Use thenAccept()
//        CompletableFuture<Void> completableFuture =
//                CompletableFuture.supplyAsync(() -> "Piseth")
//                        .thenAccept(name -> IO.println("Name: " + name));
        // 5. Use thenRun()
//        CompletableFuture<Void> completableFuture =
//                CompletableFuture.supplyAsync(() -> "Piseth")
//                        .thenRun(() -> IO.println("Welcome to the Appointment Service!"));
        // 6. Use thenCompose()
//        CompletableFuture<Account> future = findCustomer()
//                .thenCompose(_ -> Account.findAccount());
//        Account account = future.join();
//        IO.println(account);
        // 7. Use thenCombine()
//        CompletableFuture<String> customerFuture = CompletableFuture.supplyAsync(() -> "Piseth");
//        CompletableFuture<Double> balanceFuture = CompletableFuture.supplyAsync(() -> 2500.50);
//        CompletableFuture<String> result = customerFuture
//                .thenCombine(balanceFuture, (customer, balance) -> customer + " has balance $" + balance);
//        IO.println(result.join());
        // 8. Use allOf()
//        CompletableFuture<String> a = CompletableFuture.supplyAsync(() -> "A");
//        CompletableFuture<String> b = CompletableFuture.supplyAsync(() -> "B");
//        CompletableFuture<String> c = CompletableFuture.supplyAsync(() -> "C");
//        CompletableFuture<Void> all = CompletableFuture.allOf(a, b, c);
//        all.join();
//        IO.println(a.join());
//        IO.println(b.join());
//        IO.println(c.join());
        // 9. Use anyOf()
//        CompletableFuture<String> serverA = CompletableFuture.supplyAsync(() -> "Response A");
//        CompletableFuture<String> serverB = CompletableFuture.supplyAsync(() -> "Response B");
//        CompletableFuture<Object> fastest = CompletableFuture.anyOf(serverA, serverB);
//        IO.println(fastest.join());
        // 10. Use handle()
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Success")
                .handle((result, exception) -> {
                    if (exception != null) {
                        return "Failed";
                    }
                    return result;
                });
        IO.println(future.join());
        // 11. Use whenComplete()
//        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Payment success")
//                .whenComplete((result, exception) -> {
//                            if (exception != null) {
//                                IO.println("Error: " + exception.getMessage());
//                            } else {
//                                IO.println("Result: " + result);
//                            }
//                        }
//                );
    }
}
