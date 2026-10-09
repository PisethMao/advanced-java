package org.example.allnewfeaturesinjava27.garbagecollector;

import lombok.Getter;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;

public class GcDemo {
    @Getter
    private static volatile byte[] latestPayload;

    void main() {
        IO.println("Available CPUs: " + Runtime.getRuntime().availableProcessors());
        IO.println("Maximum heap (MB): " + Runtime.getRuntime().maxMemory() / 1024 / 1024);
        IO.println("\nGarbage Collectors:");
        for (GarbageCollectorMXBean gc : ManagementFactory.getGarbageCollectorMXBeans()) {
            IO.println("- " + gc.getName());
        }
        long start = System.nanoTime();
        for (int i = 0; i < 6000; i++) {
            byte[] payload = new byte[64 * 1024];
            payload[0] = (byte) i;
            latestPayload = payload;
        }
        long elapsed = System.nanoTime() - start;
        IO.println("\nWork completed in " + elapsed / 1_000_000 + " ms");
        for (GarbageCollectorMXBean gc : ManagementFactory.getGarbageCollectorMXBeans()) {
            IO.println(gc.getName() + " collections: " + gc.getCollectionCount());
        }
    }
}

