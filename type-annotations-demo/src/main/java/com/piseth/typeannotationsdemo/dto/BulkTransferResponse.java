package com.piseth.typeannotationsdemo.dto;

import java.math.BigDecimal;
import java.util.List;

public record BulkTransferResponse(
        String transactionId,
        String sourceAccount,
        List<String> beneficiaryAccounts,
        BigDecimal amount,
        String status
) {
}
