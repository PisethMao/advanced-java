package org.example.allnewfeaturesinjava8.datetimeapi;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;

public class Main {
    static void main() {
        LocalDate today = LocalDate.now();
        IO.println(today);
        String transactionId = "TXN-10001";
        BigDecimal amount = new BigDecimal("250.00");
        Instant createdAt = Instant.now();
        Instant expiresAt = createdAt.plus(Duration.ofMinutes(15));
        IO.println("Transaction: " + transactionId);
        IO.println("Amount: " + amount);
        IO.println("Created: " + createdAt);
        IO.println("Expires: " + expiresAt);
    }
}
