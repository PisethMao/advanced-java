package com.piseth.typeannotationsdemo.service.impl;

import com.piseth.typeannotationsdemo.dto.BulkTransferRequest;
import com.piseth.typeannotationsdemo.dto.BulkTransferResponse;
import com.piseth.typeannotationsdemo.service.TransferService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransferServiceImpl implements TransferService {
    @Override
    public BulkTransferResponse transfer(BulkTransferRequest request) {
        String transactionId = UUID.randomUUID().toString();
        return new BulkTransferResponse(
                transactionId,
                request.sourceAccount(),
                request.beneficiaryAccounts(),
                request.amount(),
                "SUCCESS"
        );
    }
}
