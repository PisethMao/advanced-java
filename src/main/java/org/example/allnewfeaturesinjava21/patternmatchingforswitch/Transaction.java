package org.example.allnewfeaturesinjava21.patternmatchingforswitch;

sealed interface Transaction permits LocalTransfer, InternationalTransfer, BillPayment {
}