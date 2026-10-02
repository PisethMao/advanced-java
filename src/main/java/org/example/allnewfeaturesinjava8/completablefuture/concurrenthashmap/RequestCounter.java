package org.example.allnewfeaturesinjava8.completablefuture.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

public class RequestCounter {
    private final ConcurrentHashMap<String, LongAdder> counters = new ConcurrentHashMap<>();

    public void increment(String endpoint) {
        counters.computeIfAbsent(endpoint, _ -> new LongAdder()).increment();
    }

    public void printAll() {
        counters.forEach((endpoint, counter) ->
                IO.println(endpoint + " = " + counter.sum()));
    }
}
