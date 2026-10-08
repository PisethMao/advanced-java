package org.example.allnewfeaturesinjava21.patternmatchingforswitch;

public class TransactionProcessor {
    public static String process(Transaction transaction) {
        return switch (transaction) {
            case LocalTransfer l when l.amount() <= 0 -> "Invalid local transfer amount";
            case LocalTransfer l -> "Processing local transfer: " + l.amount();
            case InternationalTransfer i -> "Processing international transfer via " + i.swiftCode();
            case BillPayment b -> "Processing bill payment to " + b.billerCode();
        };
    }
}
