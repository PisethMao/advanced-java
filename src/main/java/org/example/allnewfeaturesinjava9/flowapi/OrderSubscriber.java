package org.example.allnewfeaturesinjava9.flowapi;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Flow;

public class OrderSubscriber implements Flow.Subscriber<Order> {
    private Flow.Subscription subscription;
    private final CountDownLatch completionLatch = new CountDownLatch(1);

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        IO.println("[SUBSCRIBER] Connected to publisher");
        IO.println("[SUBSCRIBER] Requesting 1 order");
        subscription.request(1);
    }

    @Override
    public void onNext(Order order) {
        IO.println();
        IO.println("[SUBSCRIBER] Received: " + order.getId());
        processOrder(order);
        IO.println("[SUBSCRIBER] Requesting next order");
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        System.err.println("[SUBSCRIBER] Error: " + throwable.getMessage());
        completionLatch.countDown();
    }

    @Override
    public void onComplete() {
        IO.println();
        IO.println("[SUBSCRIBER] Stream completed");
        completionLatch.countDown();
    }

    private void processOrder(Order order) {
        try {
            IO.println("[PROCESSING] Customer: " + order.getCustomerName());
            IO.println("[PROCESSING] Amount: $" + order.getAmount());
            IO.println("[PROCESSING] Processing " + order.getId() + "...");
            Thread.sleep(2000);
            IO.println("[PROCESSING] Finished " + order.getId());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void awaitCompletion() throws InterruptedException {
        completionLatch.await();
    }
}
