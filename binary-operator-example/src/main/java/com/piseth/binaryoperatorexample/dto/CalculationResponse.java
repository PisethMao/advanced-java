package com.piseth.binaryoperatorexample.dto;

import com.piseth.binaryoperatorexample.enums.OperationType;

import java.math.BigDecimal;

public record CalculationResponse(
        BigDecimal number1,
        BigDecimal number2,
        OperationType operation,
        BigDecimal result
) {
}