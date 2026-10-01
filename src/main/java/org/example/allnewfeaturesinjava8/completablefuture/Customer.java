package org.example.allnewfeaturesinjava8.completablefuture;

import java.util.concurrent.CompletableFuture;

record Customer(long id, String name) {
    static CompletableFuture<Customer> findCustomer() {
        return CompletableFuture.supplyAsync(() -> new Customer(1L, "Piseth"));
    }
}
