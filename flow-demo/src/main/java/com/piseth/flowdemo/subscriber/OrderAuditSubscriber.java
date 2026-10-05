package com.piseth.flowdemo.subscriber;

import com.piseth.flowdemo.domain.OrderEvent;
import org.springframework.stereotype.Component;

import java.util.concurrent.Flow;

@Component
public class OrderAuditSubscriber implements Flow.Subscriber<OrderEvent> {
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        IO.println("[SUBSCRIBER] Connected to publisher");
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(OrderEvent item) {
        IO.println("[SUBSCRIBER] Processing: " + item);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        System.err.println("[SUBSCRIBER] Error: " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        IO.println("[SUBSCRIBER] Publisher completed");
    }
}
