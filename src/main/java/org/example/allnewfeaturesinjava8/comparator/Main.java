package org.example.allnewfeaturesinjava8.comparator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    static void main() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(
                new Transaction(
                        "TXN001",
                        "Dara",
                        "TRANSFER",
                        500.00,
                        LocalDateTime.of(2026, 10, 1, 8, 30)
                )
        );
        transactions.add(
                new Transaction(
                        "TXN002",
                        "Sokha",
                        "PAYMENT",
                        1200.00,
                        LocalDateTime.of(2026, 10, 1, 8, 20)
                )
        );
        transactions.add(
                new Transaction(
                        "TXN003",
                        "Piseth",
                        "TRANSFER",
                        1200.00,
                        LocalDateTime.of(2026, 10, 1, 8, 10)
                )
        );
        transactions.add(
                new Transaction(
                        "TXN004",
                        "Vanna",
                        "PAYMENT",
                        700.00,
                        LocalDateTime.of(2026, 10, 1, 8, 40)
                )
        );
        // 1. Use Old-Style Comparator
//        Comparator<Transaction> comparator = new Comparator<Transaction>() {
//            @Override
//            public int compare(Transaction o1, Transaction o2) {
//                return Double.compare(o1.getAmount(), o2.getAmount());
//            }
//        };
//        transactions.sort(comparator);
        // 2. Use Lambda
//        Comparator<Transaction> comparator = (o1, o2) -> Double.compare(o1.getAmount(), o2.getAmount());
        // 3. Use Comparator.comparingDouble()
        Comparator<Transaction> comparator = Comparator.comparing(Transaction::getType)
                .thenComparingDouble(Transaction::getAmount)
                .thenComparing(Transaction::getCustomerName);
        transactions.sort(comparator);
        transactions.forEach(IO::println);
    }
}
