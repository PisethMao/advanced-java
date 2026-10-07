package org.example.allnewfeaturesinjava19.patternmatchingforswitch;

public sealed interface Payment permits CardPayment, QrPayment, BankTransfer {
}