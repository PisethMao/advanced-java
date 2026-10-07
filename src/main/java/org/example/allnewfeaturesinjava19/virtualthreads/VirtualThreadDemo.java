package org.example.allnewfeaturesinjava19.virtualthreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadDemo {
    static void main() {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 1; i <= 10; i++) {
                int requestId = i;
                executor.submit(() -> handleRequest(requestId));
            }
        }
    }

    private static void handleRequest(int requestId) {
        IO.println("Request " + requestId + " started on " + Thread.currentThread());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        IO.println("Request " + requestId + " completed");
    }
}
