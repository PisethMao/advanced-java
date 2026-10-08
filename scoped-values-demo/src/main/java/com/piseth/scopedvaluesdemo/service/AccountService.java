package com.piseth.scopedvaluesdemo.service;

import com.piseth.scopedvaluesdemo.context.RequestContextHolder;
import com.piseth.scopedvaluesdemo.dto.AccountResponse;
import com.piseth.scopedvaluesdemo.dto.RequestContext;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService {
    public AccountResponse getAccount(String accountId) {
        RequestContext context = RequestContextHolder.current();
        IO.println("Processing request: " + context.requestId());
        IO.println("Requested by: " + context.userId());
        return new AccountResponse(
                accountId,
                "SAVINGS",
                new BigDecimal("1250.75"),
                context.userId(),
                context.requestId()
        );
    }
}

