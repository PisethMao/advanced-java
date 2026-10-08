package com.piseth.scopedvaluesdemo.dto;

import java.math.BigDecimal;

public record AccountResponse(
        String accountId,
        String accountType,
        BigDecimal balance,
        String requestedBy,
        String requestId
) {
}