package org.example.allnewfeaturesinjava19.patternmatchingforswitch;

public record BankTransfer(String accountNumber, double amount) implements Payment {
}