package org.example.allnewfeaturesinjava12.switchexpresion;

public class SwitchExpressionDemo {
    static void main() {
        TransactionStatus status = TransactionStatus.SUCCESS;
        String message = getTransactionMessage(status);
        IO.println(message);
    }

    public static String getTransactionMessage(TransactionStatus status) {
        return switch (status) {
            case PENDING -> {
                IO.println("Checking pending transaction...");
                yield "Transaction is pending";
            }
            case PROCESSING -> {
                IO.println("Transaction still processing...");
                yield "Transaction is processing";
            }
            case SUCCESS -> {
                IO.println("Writing success audit log...");
                yield "Transaction completed successfully";
            }
            case FAILED -> {
                IO.println("Writing failure audit log...");
                yield "Transaction failed";
            }
            case CANCELLED -> "Transaction was cancelled";
        };
    }
}
