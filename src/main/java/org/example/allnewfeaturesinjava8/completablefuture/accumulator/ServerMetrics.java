package org.example.allnewfeaturesinjava8.completablefuture.accumulator;

import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

public class ServerMetrics {
    private final LongAdder requestCount = new LongAdder();
    private final LongAccumulator maxLatency = new LongAccumulator(Long::max, Long.MIN_VALUE);
    private final LongAccumulator minLatency = new LongAccumulator(Long::min, Long.MAX_VALUE);
    private final DoubleAccumulator maxCpu = new DoubleAccumulator(Double::max, Double.NEGATIVE_INFINITY);

    public void record(long latency, double cpuUsage) {
        requestCount.increment();
        maxLatency.accumulate(latency);
        minLatency.accumulate(latency);
        maxCpu.accumulate(cpuUsage);
    }

    public long getRequestCount() {
        return requestCount.sum();
    }

    public long getMaxLatency() {
        return maxLatency.get();
    }

    public long getMinLatency() {
        return minLatency.get();
    }

    public double getMaxCpu() {
        return maxCpu.get();
    }
}
