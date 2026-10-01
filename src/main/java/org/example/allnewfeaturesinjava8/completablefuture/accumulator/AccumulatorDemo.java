package org.example.allnewfeaturesinjava8.completablefuture.accumulator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AccumulatorDemo {
    static void main() throws InterruptedException {
        ServerMetrics metrics = new ServerMetrics();
        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.submit(() -> metrics.record(120, 25.5));
        executor.submit(() -> metrics.record(450, 40.8));
        executor.submit(() -> metrics.record(75, 18.2));
        executor.submit(() -> metrics.record(950, 91.3));
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        IO.println("Requests: " + metrics.getRequestCount());
        IO.println("Maximum latency: " + metrics.getMaxLatency() + " ms");
        IO.println("Minimum latency: " + metrics.getMinLatency() + " ms");
        IO.println("Maximum CPU: " + metrics.getMaxCpu() + "%");
    }
}