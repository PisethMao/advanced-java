package com.piseth.flatmapexample.service;

import com.piseth.flatmapexample.domain.Order;
import com.piseth.flatmapexample.domain.OrderItem;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();

    List<List<OrderItem>> getItemsUsingMap();

    List<OrderItem> getAllItems();
}