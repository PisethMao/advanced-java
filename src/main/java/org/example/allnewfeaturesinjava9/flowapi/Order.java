package org.example.allnewfeaturesinjava9.flowapi;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Order {
    private final String id;
    private final String customerName;
    private final BigDecimal amount;

    public Order(String id, String customerName, BigDecimal amount) {
        this.id = id;
        this.customerName = customerName;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customerName='" + customerName + '\'' +
                ", amount=" + amount +
                '}';
    }
}
