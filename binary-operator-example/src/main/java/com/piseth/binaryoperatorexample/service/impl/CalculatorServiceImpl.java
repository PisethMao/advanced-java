package com.piseth.binaryoperatorexample.service.impl;

import com.piseth.binaryoperatorexample.dto.CalculationRequest;
import com.piseth.binaryoperatorexample.dto.CalculationResponse;
import com.piseth.binaryoperatorexample.enums.OperationType;
import com.piseth.binaryoperatorexample.service.CalculatorService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.function.BinaryOperator;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    private final Map<OperationType, BinaryOperator<BigDecimal>> operations;

    public CalculatorServiceImpl() {
        operations = Map.of(
                OperationType.ADD,
                BigDecimal::add,
                OperationType.SUBTRACT,
                BigDecimal::subtract,
                OperationType.MULTIPLY,
                BigDecimal::multiply,
                OperationType.MAX,
                BinaryOperator.maxBy(BigDecimal::compareTo),
                OperationType.MIN,
                BinaryOperator.minBy(BigDecimal::compareTo)
        );
    }

    @Override
    public CalculationResponse calculate(CalculationRequest request) {
        BinaryOperator<BigDecimal> operator = operations.get(request.operation());
        if (operator == null) {
            throw new IllegalArgumentException("Unsupported operation: " + request.operation());
        }
        BigDecimal result = operator.apply(request.number1(), request.number2());
        return new CalculationResponse(request.number1(), request.number2(), request.operation(), result);
    }
}
