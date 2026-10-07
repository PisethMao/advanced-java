package org.example.allnewfeaturesinjava16.sealedclasses;

public record CashPayment(double amount) implements Payment {
    @Override
    public void pay() {
        IO.println("Cash payment: $" + amount);
    }
}