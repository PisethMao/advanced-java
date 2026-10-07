package org.example.allnewfeaturesinjava19.patternmatchingforswitch;

public class PaymentService {
    public String process(Payment payment) {
        return switch (payment) {
            case null -> "Payment cannot be null";
            case CardPayment card when card.amount() > 1000 -> "Large card payment requires review: $" + card.amount();
            case CardPayment card -> "Card payment processed: $" + card.amount();
            case QrPayment qr when qr.amount() > 1000 -> "Large QR payment requires review: $" + qr.amount();
            case QrPayment qr -> "QR payment processed: $" + qr.amount();
            case BankTransfer bank when bank.amount() > 1000 ->
                    "Large bank transfer requires review: $" + bank.amount();
            case BankTransfer bank -> "Bank transfer processed: $" + bank.amount();
        };
    }
}
