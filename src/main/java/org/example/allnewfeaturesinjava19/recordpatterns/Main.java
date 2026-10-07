package org.example.allnewfeaturesinjava19.recordpatterns;

public class Main {
    record Account(String accountNumber, String accountName) {
    }

    record Transfer(Account sender, Account receiver, double amount) {
    }

    static void main() {
        Transfer transfer = new Transfer(
                new Account("001001", "Piseth"),
                new Account("002002", "Dara"),
                150.00
        );
        processTransfer(transfer);
    }

    static void processTransfer(Object obj) {
        if (obj instanceof Transfer(
                Account(String senderNumber, String senderName),
                Account(String receiverNumber, String receiverName),
                double amount
        )) {
            if (amount <= 0) {
                IO.println("Invalid transfer amount");
                return;
            }
            IO.println("=== Processing Transfer ===");
            IO.println("From: " + senderName + " [" + senderNumber + "]");
            IO.println("To: " + receiverName + " [" + receiverNumber + "]");
            IO.println("Amount: $" + amount);
            IO.println("Transfer processed successfully");
        } else {
            IO.println("Unsupported data");
        }
    }
}
