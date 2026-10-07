package org.example.allnewfeaturesinjava16.sealedclasses;

public sealed interface Payment permits CashPayment, CardPayment, QRPayment {
    double amount();

    void pay();
}