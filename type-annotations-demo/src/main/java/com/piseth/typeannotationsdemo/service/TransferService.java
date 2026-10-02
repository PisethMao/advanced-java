package com.piseth.typeannotationsdemo.service;

import com.piseth.typeannotationsdemo.dto.BulkTransferRequest;
import com.piseth.typeannotationsdemo.dto.BulkTransferResponse;

public interface TransferService {
    BulkTransferResponse transfer(BulkTransferRequest request);
}
