package com.piseth.completablefuturedemo.domain;

public record Customer(
        Long id,
        String name,
        String email
) {
}
