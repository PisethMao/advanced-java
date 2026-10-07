package com.piseth.recordsdemo.domain;

import java.math.BigDecimal;

public record CreateProductRequest(String name, BigDecimal price) {
}
