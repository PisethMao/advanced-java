package org.example.allnewfeaturesinjava20.virtualthreads;

import java.util.concurrent.*;

public class Main {
    static void main() throws Exception {
        long start = System.currentTimeMillis();
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            Future<String> accountFuture = executor.submit(Main::getAccount);
            Future<String> transactionFuture = executor.submit(Main::getTransactions);
            String account = accountFuture.get();
            String transactions = transactionFuture.get();
            IO.println(account);
            IO.println(transactions);
        }
        long duration = System.currentTimeMillis() - start;
        IO.println("Time: " + duration + " ms");
    }

    static String getAccount() throws InterruptedException {
        Thread.sleep(2000);
        return "Account: ACTIVE";
    }

    static String getTransactions() throws InterruptedException {
        Thread.sleep(2000);
        return "Transactions: 10 records";
    }
}
