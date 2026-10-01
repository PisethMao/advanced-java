package com.piseth.accumulatordemo.dto;

public record TransactionRequest(
        double amount,
        long processingTimeMs
) {
}
