package org.example.allnewfeaturesinjava13.switchexpressions;

public class Main {
    enum PaymentStatus {
        COMPLETED,
        PENDING,
        FAILED,
        EXPIRED
    }

    public static void main() {
        IO.println("Learning JEP 354");
        PaymentStatus status = PaymentStatus.FAILED;
        double amount = 1500.00;
        String result = processPaymentStatus(status, amount);
        IO.println();
        IO.println("Final result:");
        IO.println(result);
    }

    static String processPaymentStatus(PaymentStatus status, double amount) {
        return switch (status) {
            case COMPLETED -> {
                IO.println("Payment was successful.");
                yield "Your payment of $" + amount + " was completed successfully.";
            }
            case PENDING -> {
                IO.println("Payment is waiting for processing.");
                yield "Your payment of $" + amount + " is currently pending.";
            }
            case FAILED -> {
                IO.println("Payment failure detected.");
                String message;
                if (amount >= 1000) {
                    IO.println("Large transaction detected.");
                    message = "Large payment failed. " + "Please contact support.";
                } else {
                    message = "Payment failed. " + "Please try again.";
                }
                yield message;
            }
            case EXPIRED -> {
                IO.println("Payment session expired.");
                yield "The payment request has expired.";
            }
        };
    }
}
