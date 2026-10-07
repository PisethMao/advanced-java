package org.example.allnewfeaturesinjava15.records;

public record BankAccount(
        String accountNumber,
        String accountName,
        double balance,
        String currency
) {
    public BankAccount {
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Account number is required");
        }
        if (accountName == null || accountName.isBlank()) {
            throw new IllegalArgumentException("Account name is required");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("Currency is required");
        }
    }

    public boolean isHighBalance() {
        return balance >= 10_000;
    }
}
