package org.example.allnewfeaturesinjava8.defaultmethods;

public interface TransferService {
    void transfer(String fromAccount, String toAccount, double amount);

    default boolean isValidAmount(double amount) {
        return amount > 0;
    }
}
