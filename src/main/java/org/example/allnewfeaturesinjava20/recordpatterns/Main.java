package org.example.allnewfeaturesinjava20.recordpatterns;

public class Main {
    record Customer(String id, String name) {
    }

    record Money(double amount, String currency) {
    }

    record Payment(String transactionId, Customer customer, Money money) {
    }

    static void main() {
        Payment payment = new Payment("TXN-10001",
                new Customer("C001", "Piseth"),
                new Money(250.50, "USD")
        );
        String transactionId = payment.transactionId();
        Customer customer = payment.customer();
        String customerId = customer.id();
        String customerName = customer.name();
        Money money = payment.money();
        double amount = money.amount();
        String currency = money.currency();
        IO.println("Transaction ID : " + transactionId);
        IO.println("Customer ID    : " + customerId);
        IO.println("Customer Name  : " + customerName);
        IO.println("Amount         : " + amount);
        IO.println("Currency       : " + currency);
    }
}
