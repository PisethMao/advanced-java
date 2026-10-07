package org.example.allnewfeaturesinjava19.patternmatchingforswitch;

public record QrPayment(String qrCode, double amount) implements Payment {
}