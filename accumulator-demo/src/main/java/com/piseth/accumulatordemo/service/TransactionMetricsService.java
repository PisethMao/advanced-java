package com.piseth.accumulatordemo.service;

import com.piseth.accumulatordemo.dto.TransactionMetrics;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.concurrent.atomic.LongAccumulator;

@Service
public class TransactionMetricsService {
    private final DoubleAccumulator maximumTransactionAmount =
            new DoubleAccumulator(Double::max, 0.0);
    private final LongAccumulator maximumProcessingTime =
            new LongAccumulator(Long::max, 0L);

    public void recordTransaction(double amount, long processingTimeMs) {
        maximumTransactionAmount.accumulate(amount);
        maximumProcessingTime.accumulate(processingTimeMs);
    }

    public TransactionMetrics getMetrics() {
        return new TransactionMetrics(maximumTransactionAmount.get(), maximumProcessingTime.get());
    }

    public void reset() {
        maximumTransactionAmount.reset();
        maximumProcessingTime.reset();
    }
}
