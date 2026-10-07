package org.example.allnewfeaturesinjava15.sealedclasses;

public sealed interface PaymentResult permits PaymentSuccess, PaymentFailed, PaymentPending {
    String transactionId();
}
