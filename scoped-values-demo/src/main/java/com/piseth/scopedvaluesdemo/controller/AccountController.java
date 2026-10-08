package com.piseth.scopedvaluesdemo.controller;

import com.piseth.scopedvaluesdemo.context.RequestContextHolder;
import com.piseth.scopedvaluesdemo.dto.AccountResponse;
import com.piseth.scopedvaluesdemo.dto.RequestContext;
import com.piseth.scopedvaluesdemo.service.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts/{accountId}")
    public AccountResponse getAccount(@PathVariable String accountId) {
        return accountService.getAccount(accountId);
    }

    @GetMapping("/context")
    public RequestContext getContext() {
        return RequestContextHolder.current();
    }
}
