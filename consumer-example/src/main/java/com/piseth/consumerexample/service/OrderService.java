package com.piseth.consumerexample.service;

import com.piseth.consumerexample.domain.Order;
import com.piseth.consumerexample.dto.CreateOrderRequest;

public interface OrderService {
    Order create(CreateOrderRequest request);
}