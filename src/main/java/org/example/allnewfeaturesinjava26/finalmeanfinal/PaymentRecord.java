package org.example.allnewfeaturesinjava26.finalmeanfinal;

import lombok.Getter;

@Getter
public final class PaymentRecord {
    private final String transactionId;
    private final long amountKHR;
    private String status;

    public PaymentRecord(String transactionId, long amountKHR) {
        if (transactionId == null || transactionId.isBlank()) {
            throw new IllegalArgumentException("Transaction ID is required");
        }
        if (amountKHR <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        this.transactionId = transactionId;
        this.amountKHR = amountKHR;
        this.status = "PENDING";
    }

    public void markCompleted() {
        if (!"PENDING".equals(status)) {
            throw new IllegalStateException("Transaction is not pending");
        }
        this.status = "COMPLETED";
    }

    @Override
    public String toString() {
        return "PaymentRecord{" +
                "transactionId='" + transactionId + '\'' +
                ", amountKHR=" + amountKHR +
                ", status='" + status + '\'' +
                '}';
    }
}

