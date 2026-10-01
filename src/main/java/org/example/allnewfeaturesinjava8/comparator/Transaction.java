package org.example.allnewfeaturesinjava8.comparator;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Transaction {
    private final String transactionId;
    private final String customerName;
    private final String type;
    private final double amount;
    private final LocalDateTime createdAt;

    public Transaction(
            String transactionId,
            String customerName,
            String type,
            double amount,
            LocalDateTime createdAt
    ) {
        this.transactionId = transactionId;
        this.customerName = customerName;
        this.type = type;
        this.amount = amount;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return transactionId +
                " | " +
                customerName +
                " | " +
                type +
                " | $" +
                amount +
                " | " +
                createdAt;
    }
}
