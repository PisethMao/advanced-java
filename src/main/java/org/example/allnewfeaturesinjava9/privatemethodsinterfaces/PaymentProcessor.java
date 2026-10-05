package org.example.allnewfeaturesinjava9.privatemethodsinterfaces;

import java.math.BigDecimal;

public interface PaymentProcessor {
    private void validateAmount(BigDecimal amount) {
        if (amount == null) {
            throw new IllegalArgumentException("Amount cannot be null");
        }
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
    }

    private void validateCurrency(String currency) {
        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("Currency is required");
        }
    }

    private void validatePayment(BigDecimal amount, String currency) {
        validateAmount(amount);
        validateCurrency(currency);
    }

    private void logTransaction(String transactionType, BigDecimal amount, String currency) {
        IO.println("[TRANSACTION] " + transactionType + " | " + amount + " " + currency);
    }

    default void payByQR(BigDecimal amount, String currency) {
        validatePayment(amount, currency);
        logTransaction("QR_PAYMENT", amount, currency);
        IO.println("QR payment completed: " + amount + " " + currency);
    }

    default void payByCard(BigDecimal amount, String currency) {
        validatePayment(amount, currency);
        logTransaction("CARD_PAYMENT", amount, currency);
        IO.println("Card payment completed: " + amount + " " + currency);
    }

    default void refund(BigDecimal amount, String currency) {
        validatePayment(amount, currency);
        logTransaction("REFUND", amount, currency);
        IO.println("Refund completed: " + amount + " " + currency);
    }
}
