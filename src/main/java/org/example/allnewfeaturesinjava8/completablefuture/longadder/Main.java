package org.example.allnewfeaturesinjava8.completablefuture.longadder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

public class Main {
    static void main() throws InterruptedException {
        LongAdder requestCounter = new LongAdder();
        try (ExecutorService executor = Executors.newFixedThreadPool(10)) {
            for (int i = 0; i < 100_000; i++) {
                executor.submit(requestCounter::increment);
            }
            executor.shutdown();
            executor.awaitTermination(10, TimeUnit.SECONDS);
        }
        IO.println("Total requests: " + requestCounter.sum());
    }
}
