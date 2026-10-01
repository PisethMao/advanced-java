package org.example.allnewfeaturesinjava8.completablefuture;

import java.util.concurrent.CompletableFuture;

record Account(String accountNumber, double balance) {
    static CompletableFuture<Account> findAccount() {
        return CompletableFuture
                .supplyAsync(() -> new Account("00123456789", 1500.00));
    }
}
