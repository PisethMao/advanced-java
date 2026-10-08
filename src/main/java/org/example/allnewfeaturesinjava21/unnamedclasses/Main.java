package org.example.allnewfeaturesinjava21.unnamedclasses;

import java.util.Scanner;

public class Main {
    void main() {
        Scanner scanner = new Scanner(System.in);
        IO.println("=== Banking Fee Calculator ===");
        IO.print("Enter transfer amount (USD): ");
        double amount = scanner.nextDouble();
        double fee = calculateFee(amount);
        double total = amount + fee;
        IO.println("Transfer Amount: $" + amount);
        IO.println("Service Fee: $" + fee);
        IO.println("Total Debit: $" + total);
    }

    double calculateFee(double amount) {
        if (amount <= 100) {
            return 0.50;
        }
        if (amount <= 1000) {
            return 1.00;
        }
        return 2.50;
    }
}
