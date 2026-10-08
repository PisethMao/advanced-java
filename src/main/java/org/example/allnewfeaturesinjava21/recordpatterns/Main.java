package org.example.allnewfeaturesinjava21.recordpatterns;

public class Main {
    static String process(Object transaction) {
        return switch (transaction) {
            case Deposit(var amount) -> "Deposited: $" + amount;
            case Withdrawal(var amount) -> "Withdrawn: $" + amount;
            case null -> "Transaction is null";
            default -> "Unknown transaction";
        };
    }

    static void main() {
        IO.println(process(new Deposit(100)));
        IO.println(process(new Withdrawal(50)));
    }
}