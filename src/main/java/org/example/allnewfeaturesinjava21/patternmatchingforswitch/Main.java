package org.example.allnewfeaturesinjava21.patternmatchingforswitch;

public class Main {
    static void main() {
        Transaction t1 = new LocalTransfer("123456789", 500);
        Transaction t2 = new InternationalTransfer("ABCDKHPP", 1200);
        Transaction t3 = new BillPayment("EDC001", 50);
        Transaction t4 = new LocalTransfer("123456789", -10);
        IO.println(TransactionProcessor.process(t1));
        IO.println(TransactionProcessor.process(t2));
        IO.println(TransactionProcessor.process(t3));
        IO.println(TransactionProcessor.process(t4));
    }
}
