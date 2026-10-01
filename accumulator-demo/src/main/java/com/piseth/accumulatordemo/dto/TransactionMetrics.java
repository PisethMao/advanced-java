package com.piseth.accumulatordemo.dto;

public record TransactionMetrics(
        double maximumTransactionAmount,
        long maximumProcessingTimeMs
) {
}
