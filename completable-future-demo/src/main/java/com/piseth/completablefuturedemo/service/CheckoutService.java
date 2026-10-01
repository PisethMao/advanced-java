package com.piseth.completablefuturedemo.service;

import com.piseth.completablefuturedemo.domain.CheckoutContext;
import com.piseth.completablefuturedemo.domain.Customer;
import com.piseth.completablefuturedemo.domain.Product;
import com.piseth.completablefuturedemo.dto.CheckoutRequest;
import com.piseth.completablefuturedemo.dto.CheckoutResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;

@Service
public class CheckoutService {
    private final CustomerService customerService;
    private final ProductService productService;
    private final PaymentService paymentService;

    public CheckoutService(
            CustomerService customerService,
            ProductService productService,
            PaymentService paymentService
    ) {
        this.customerService = customerService;
        this.productService = productService;
        this.paymentService = paymentService;
    }

    public CompletableFuture<CheckoutResponse> checkout(CheckoutRequest request) {
        CompletableFuture<Customer> customerFuture = customerService
                .findCustomer(request.customerId());
        CompletableFuture<Product> productFuture = productService
                .findProduct(request.productId());
        CompletableFuture<CheckoutContext> contextFuture = customerFuture
                .thenCombine(productFuture, (customer, product) -> {
                            BigDecimal total = product.price().multiply(BigDecimal.valueOf(request.quantity()));
                            return new CheckoutContext(customer, product, request.quantity(), total);
                        }
                );
        return contextFuture.thenCompose(context -> paymentService.processPayment(context.totalAmount())
                        .thenApply(payment -> new CheckoutResponse(context.customer().name(), context.product().name(), context.quantity(), context.totalAmount(), payment.transactionId(), payment.status())))
                .exceptionally(error -> {
                    IO.println("Checkout failed: " + error.getMessage());
                    throw new RuntimeException("Checkout failed", error);
                });
    }
}
