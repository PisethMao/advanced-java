package org.example.allnewfeaturesinjava8.lambdaexpressions;

import java.math.BigDecimal;

@FunctionalInterface
public interface Discount {
    BigDecimal apply(BigDecimal price);
}
