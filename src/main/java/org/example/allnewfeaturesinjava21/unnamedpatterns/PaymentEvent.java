package org.example.allnewfeaturesinjava21.unnamedpatterns;

public sealed interface PaymentEvent permits PaymentSuccess, PaymentRejected {
}