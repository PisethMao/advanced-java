package org.example.allnewfeaturesinjava16.sealedclasses;

public class Main {
    static void main() {
        Payment cash = new CashPayment(20.00);
        Payment card = new CardPayment(100.00, "1234567812345678");
        Payment qr = new QRPayment(50.00, "KHQR-ABC123");
        cash.pay();
        card.pay();
        qr.pay();
    }
}