package com.piseth.completablefuturedemo.controller;

import com.piseth.completablefuturedemo.dto.CheckoutRequest;
import com.piseth.completablefuturedemo.dto.CheckoutResponse;
import com.piseth.completablefuturedemo.service.CheckoutService;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/orders")
public class CheckoutController {
    private final CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/checkout")
    public CompletableFuture<CheckoutResponse> checkout(@RequestBody CheckoutRequest request) {
        return checkoutService.checkout(request);
    }
}
