package org.example.allnewfeaturesinjava16.sealedclasses;

public record QRPayment(double amount, String qrCode) implements Payment {
    @Override
    public void pay() {
        IO.println("QR payment: $" + amount + " using QR code: " + qrCode);
    }
}