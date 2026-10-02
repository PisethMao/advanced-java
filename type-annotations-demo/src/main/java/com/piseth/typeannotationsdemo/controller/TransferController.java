package com.piseth.typeannotationsdemo.controller;

import com.piseth.typeannotationsdemo.dto.BulkTransferRequest;
import com.piseth.typeannotationsdemo.dto.BulkTransferResponse;
import com.piseth.typeannotationsdemo.service.TransferService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transfers")
public class TransferController {
    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BulkTransferResponse transfer(@Valid @RequestBody BulkTransferRequest request) {
        return transferService.transfer(request);
    }
}
