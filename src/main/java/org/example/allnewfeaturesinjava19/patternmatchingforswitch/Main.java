package org.example.allnewfeaturesinjava19.patternmatchingforswitch;

public class Main {
    static void main() {
        PaymentService paymentService = new PaymentService();
        Payment payment1 = new CardPayment("1234-5678-9012-3456", 500);
        Payment payment2 = new QrPayment("KHQR-001", 250);
        Payment payment3 = new BankTransfer("00123456789", 800);
        IO.println(paymentService.process(payment1));
        IO.println(paymentService.process(payment2));
        IO.println(paymentService.process(payment3));
    }
}