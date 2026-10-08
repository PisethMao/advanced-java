package org.example.allnewfeaturesinjava21.virtualthreads;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    static void main() throws Exception {
        // 1. startVirtualThread()
        Thread thread = Thread.startVirtualThread(() -> {
            IO.println("Hello from virtual thread!");
            IO.println(Thread.currentThread().isVirtual());
        });
        thread.join();
        // 2. ofVirtual()
        Thread thread2 = Thread.ofVirtual().name("payment-worker")
                .start(() -> IO.println(Thread.currentThread().getName()));
        thread2.join();
        // 3. newVirtualThreadPerTaskExecutor()
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            Future<String> result = executor.submit(() -> {
                Thread.sleep(1000);
                return "Payment completed";
            });
            IO.println(result.get());
        }
    }
}