package org.example.allnewfeaturesinjava22.supers;

import java.math.BigDecimal;

class Transfer {
    private final String account;
    private final BigDecimal amount;

    Transfer(String account, BigDecimal amount) {
        this.account = account;
        this.amount = amount;
        IO.println("Parent constructor executed");
    }

    String account() {
        return account;
    }

    BigDecimal amount() {
        return amount;
    }
}
