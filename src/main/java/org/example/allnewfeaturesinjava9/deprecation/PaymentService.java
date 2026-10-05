package org.example.allnewfeaturesinjava9.deprecation;

import java.math.BigDecimal;

public class PaymentService {
    /**
     * Processes payment using a double amount.
     *
     * @param amount payment amount
     *
     * @deprecated Use {@link #pay(BigDecimal)} instead
     *             because BigDecimal is more appropriate
     *             for monetary calculations.
     */
    @Deprecated(since = "2.0", forRemoval = true)
    public void pay(double amount) {
        pay(BigDecimal.valueOf(amount));
    }

    public void pay(BigDecimal amount) {
        if (amount == null) {
            throw new IllegalArgumentException("Amount cannot be null");
        }
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        IO.println("Payment successful: $" + amount);
    }
}
