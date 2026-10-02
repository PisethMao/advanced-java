package com.piseth.typeannotationsdemo.dto;

import com.piseth.typeannotationsdemo.annotation.AccountNumber;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;

public record BulkTransferRequest(
        @AccountNumber
        String sourceAccount,
        @NotEmpty(message = "Beneficiary accounts cannot be empty")
        List<@AccountNumber(message = "Beneficiary account number is invalid") String>
        beneficiaryAccounts,
        @NotNull(message = "Amount is required")
        @DecimalMin(value = "0.01", message = "Amount must be greater than or equal to 0.01")
        BigDecimal amount
) {
}
