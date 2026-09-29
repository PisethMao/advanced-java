package com.piseth.binaryoperatorexample.service;

import com.piseth.binaryoperatorexample.dto.CalculationRequest;
import com.piseth.binaryoperatorexample.dto.CalculationResponse;

public interface CalculatorService {
    CalculationResponse calculate(CalculationRequest request);
}