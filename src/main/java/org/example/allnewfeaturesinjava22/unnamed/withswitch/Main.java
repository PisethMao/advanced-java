package org.example.allnewfeaturesinjava22.unnamed.withswitch;

public class Main {
    static String describe(PaymentResult result) {
        return switch (result) {
            case Success(_, var amount) -> "Payment successful: $" + amount;
            case Failure(_, var reason) -> "Payment failed: " + reason;
        };
    }

    void main() {
        IO.println(describe(new Success("123", 100.0)));
        IO.println(describe(new Failure("456", "Insufficient funds")));
    }
}
