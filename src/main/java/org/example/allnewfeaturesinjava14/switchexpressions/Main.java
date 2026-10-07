package org.example.allnewfeaturesinjava14.switchexpressions;

public class Main {
    static void main() {
        TransactionType transactionType = TransactionType.INTERNATIONAL_TRANSFER;
        double amount = 1000;
        double fee = calculateTransactionFee(transactionType, amount);
        IO.println("Transaction Type : " + transactionType);
        IO.println("Transaction Amount: $" + amount);
        IO.println("Transaction Fee   : $" + fee);
    }

    public static double calculateTransactionFee(TransactionType type, double amount) {
        return switch (type) {
            case TRANSFER -> 0.50;
            case QR_PAYMENT -> 0.00;
            case BILL_PAYMENT -> 0.25;
            case INTERNATIONAL_TRANSFER -> {
                IO.println("Calculating international fee...");
                double percentageFee = amount * 0.01;
                double minimumFee = 5.00;
                yield Math.max(percentageFee, minimumFee);
            }
        };
    }
}
