package org.example.allnewfeaturesinjava8.stream.filter;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    static void main() {
        List<Transaction> transactions = List.of(
                new Transaction("TX001", "Piseth", "TRANSFER", new BigDecimal("500.00"), "SUCCESS"),
                new Transaction("TX002", "Dara", "PAYMENT", new BigDecimal("1200.00"), "FAILED"),
                new Transaction("TX003", "Sokha", "TRANSFER", new BigDecimal("2500.00"), "SUCCESS"),
                new Transaction("TX004", "Vanna", "PAYMENT", new BigDecimal("300.00"), "SUCCESS"),
                new Transaction("TX005", "Lina", "TRANSFER", new BigDecimal("5000.00"), "SUCCESS")
        );
        List<Transaction> successfulTransactions = transactions
                .stream().filter(
                        transaction -> transaction.status().equals("SUCCESS")
                ).toList();
        successfulTransactions.forEach(IO::println);
    }
}
