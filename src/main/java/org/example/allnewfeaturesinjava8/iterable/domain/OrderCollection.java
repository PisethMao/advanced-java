package org.example.allnewfeaturesinjava8.iterable.domain;

import lombok.NonNull;

import java.util.Iterator;
import java.util.List;

public class OrderCollection implements Iterable<Order> {
    private final List<Order> orders;

    public OrderCollection(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public @NonNull Iterator<Order> iterator() {
        return orders.iterator();
    }
}
