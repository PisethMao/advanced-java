package org.example.allnewfeaturesinjava8.defaultmethods;

public class BankTransferService implements TransferService {
    @Override
    public void transfer(String fromAccount, String toAccount, double amount) {
        if (!isValidAmount(amount)) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        IO.println("Transferring $" + amount);
    }
}
