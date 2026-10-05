package com.piseth.flowdemo.publisher;

import com.piseth.flowdemo.domain.OrderEvent;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

@Component
public class OrderEventPublisher {
    private final SubmissionPublisher<OrderEvent> publisher = new SubmissionPublisher<>();

    public Flow.Publisher<OrderEvent> getPublisher() {
        return publisher;
    }

    public void publish(OrderEvent event) {
        IO.println("[PUBLISHER] Publishing: " + event);
        publisher.submit(event);
    }

    @PreDestroy
    public void close() {
        publisher.close();
    }
}
