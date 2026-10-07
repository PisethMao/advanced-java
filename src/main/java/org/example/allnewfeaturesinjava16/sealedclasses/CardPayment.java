package org.example.allnewfeaturesinjava16.sealedclasses;

public record CardPayment(double amount, String cardNumber) implements Payment {
    @Override
    public void pay() {
        IO.println("Card payment: $" + amount + " using card " + maskCardNumber());
    }

    private String maskCardNumber() {
        return "**** **** **** " + cardNumber.substring(cardNumber.length() - 4);
    }
}