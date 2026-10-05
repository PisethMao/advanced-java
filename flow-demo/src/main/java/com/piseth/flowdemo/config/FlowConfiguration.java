package com.piseth.flowdemo.config;

import com.piseth.flowdemo.publisher.OrderEventPublisher;
import com.piseth.flowdemo.subscriber.OrderAuditSubscriber;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlowConfiguration {
    @Bean
    CommandLineRunner subscribe(OrderEventPublisher publisher, OrderAuditSubscriber subscriber) {
        return _ -> publisher.getPublisher().subscribe(subscriber);
    }
}
