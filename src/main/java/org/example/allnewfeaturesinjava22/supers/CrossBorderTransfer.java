package org.example.allnewfeaturesinjava22.supers;

import java.math.BigDecimal;
import java.util.Locale;

class CrossBorderTransfer extends Transfer {
    private final String country;

    CrossBorderTransfer(String account, BigDecimal amount, String country) {
        if (account == null || account.isBlank()) {
            throw new IllegalArgumentException("Account must not be blank");
        }
        if (amount == null || amount.signum() <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        if (country == null || country.isBlank()) {
            throw new IllegalArgumentException("Country is required");
        }
        String normalizedAccount = account.trim().toUpperCase(Locale.ROOT);
        String normalizedCountry = country.trim().toUpperCase(Locale.ROOT);
        if (!normalizedCountry.equals("KH") && !normalizedCountry.equals("LA") && !normalizedCountry.equals("TH")) {
            throw new IllegalArgumentException("Unsupported destination country");
        }
        super(normalizedAccount, amount);
        this.country = normalizedCountry;
        IO.println("Child constructor executed");
    }

    String summary() {
        return "Transfer: " + account() + " -> " + country + ", amount=" + amount();
    }
}
