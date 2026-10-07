package org.example.allnewfeaturesinjava14.records;

import java.math.BigDecimal;

public record Transfer(
        String transactionId,
        String sourceAccount,
        String destinationAccount,
        BigDecimal amount,
        String currency
) {
    public Transfer {
        if (transactionId == null || transactionId.isBlank()) {
            throw new IllegalArgumentException("Transaction ID is required");
        }
        if (sourceAccount == null || sourceAccount.isBlank()) {
            throw new IllegalArgumentException("Source account is required");
        }
        if (destinationAccount == null || destinationAccount.isBlank()) {
            throw new IllegalArgumentException("Destination account is required");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("Currency is required");
        }
        if (sourceAccount.equals(destinationAccount)) {
            throw new
                    IllegalArgumentException("Source and destination accounts cannot be the same");
        }
    }
}