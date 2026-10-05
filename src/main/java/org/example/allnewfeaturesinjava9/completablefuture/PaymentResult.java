package org.example.allnewfeaturesinjava9.completablefuture;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class PaymentResult {
    private final String transactionId;
    private final BigDecimal amount;
    private final String status;

    public PaymentResult(
            String transactionId,
            BigDecimal amount,
            String status
    ) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.status = status;
    }

    @Override
    public String toString() {
        return "PaymentResult{" +
                "transactionId='" + transactionId + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}
