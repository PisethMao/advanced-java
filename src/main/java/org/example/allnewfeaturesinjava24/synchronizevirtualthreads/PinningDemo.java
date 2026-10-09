package org.example.allnewfeaturesinjava24.synchronizevirtualthreads;

import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class PinningDemo {
    void main() throws Exception {
        int taskCount = 12;
        var locks = IntStream.range(0, taskCount).mapToObj(_ -> new Object()).toList();
        long start = System.nanoTime();
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            var futures = IntStream.range(0, taskCount).mapToObj(i -> executor.submit(() -> {
                synchronized (locks.get(i)) {
                    IO.println("Task " + i + " virtual: "
                            + Thread.currentThread().isVirtual());
                    Thread.sleep(500);
                }
                return i;
            })).toList();
            for (var future : futures) {
                future.get();
            }
        }
        double seconds = (System.nanoTime() - start) / 1_000_000_000.0;
        System.out.printf("Total execution time: %.3f seconds%n", seconds);
    }
}

