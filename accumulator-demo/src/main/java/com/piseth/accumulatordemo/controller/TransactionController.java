package com.piseth.accumulatordemo.controller;

import com.piseth.accumulatordemo.dto.TransactionRequest;
import com.piseth.accumulatordemo.service.TransactionMetricsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionMetricsService metricsService;

    public TransactionController(TransactionMetricsService metricsService) {
        this.metricsService = metricsService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void processTransaction(@RequestBody TransactionRequest request) {
        metricsService.recordTransaction(request.amount(), request.processingTimeMs());
    }

    @GetMapping("/metrics")
    public com.piseth.accumulatordemo.dto.TransactionMetrics getMetrics() {
        return metricsService.getMetrics();
    }

    @DeleteMapping("/metrics")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void resetMetrics() {
        metricsService.reset();
    }
}
