package org.example.allnewfeaturesinjava26.finalmeanfinal;

public class SafePaymentDemo {
    void main() {
        PaymentRecord payment = new PaymentRecord("TXN-1001", 150_000);
        IO.println("=== PAYMENT CREATED ===");
        IO.println(payment);
        payment.markCompleted();
        IO.println();
        IO.println("=== PAYMENT COMPLETED ===");
        IO.println(payment);
        PaymentRecord anotherPayment = new PaymentRecord("TXN-1002", 150_000);
        IO.println();
        IO.println("=== NEW TRANSACTION ===");
        IO.println(anotherPayment);
    }
}

