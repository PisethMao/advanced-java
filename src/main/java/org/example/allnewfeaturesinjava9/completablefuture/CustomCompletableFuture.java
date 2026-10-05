package org.example.allnewfeaturesinjava9.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class CustomCompletableFuture<T> extends CompletableFuture<T> {
    private final Executor executor;

    public CustomCompletableFuture(Executor executor) {
        this.executor = executor;
    }

    @Override
    public Executor defaultExecutor() {
        return executor;
    }

    @Override
    public <U> CompletableFuture<U> newIncompleteFuture() {
        return new CustomCompletableFuture<>(executor);
    }
}
