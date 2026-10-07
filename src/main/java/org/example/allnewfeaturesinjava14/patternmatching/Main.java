package org.example.allnewfeaturesinjava14.patternmatching;

public class Main {
    static void main() {
        Payment payment = new CardPayment("**** **** **** 1234", 100.00);
        processPayment(payment);
    }

    public static void processPayment(Payment payment) {
        if (payment instanceof CardPayment(String cardNumber, double amount)) {
            IO.println("Card Payment");
            IO.println("Card: " + cardNumber);
            IO.println("Amount: $" + amount);
        } else if (payment instanceof QRPayment(String qrCode, double amount)) {
            IO.println("QR Payment");
            IO.println("QR Code: " + qrCode);
            IO.println("Amount: $" + amount);
        } else if (payment instanceof BankTransferPayment(String accountNumber, double amount)) {
            IO.println("Bank Transfer");
            IO.println("Account: " + accountNumber);
            IO.println("Amount: $" + amount);
        }
    }
}
