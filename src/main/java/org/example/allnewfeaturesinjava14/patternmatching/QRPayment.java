package org.example.allnewfeaturesinjava14.patternmatching;

public record QRPayment(String qrCode, double amount) implements Payment {

}
