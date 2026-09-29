package com.piseth.binaryoperatorexample.dto;

import com.piseth.binaryoperatorexample.enums.OperationType;

import java.math.BigDecimal;

public record CalculationRequest(
        BigDecimal number1,
        BigDecimal number2,
        OperationType operation
) {
}