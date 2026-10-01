package com.piseth.completablefuturedemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
public class AsyncConfig {
    @Bean
    public Executor taskExecutor() {
        return Executors.newFixedThreadPool(10);
    }
}
