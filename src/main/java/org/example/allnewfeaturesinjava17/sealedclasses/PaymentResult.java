package org.example.allnewfeaturesinjava17.sealedclasses;

public sealed interface PaymentResult permits PaymentSuccess, PaymentFailed, PaymentPending {
}