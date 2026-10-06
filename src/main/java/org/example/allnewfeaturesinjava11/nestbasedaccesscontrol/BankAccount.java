package org.example.allnewfeaturesinjava11.nestbasedaccesscontrol;

import lombok.Getter;
import lombok.Setter;

public class BankAccount {
    private final String accountNumber;
    private double balance;
    private final int pin;

    public BankAccount(String accountNumber, double balance, int pin) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.pin = pin;
    }

    @Setter
    @Getter
    class AccountManager {
        private String managerCode = "MGR-001";
        public boolean verifyPin(int enteredPin) {
            return pin == enteredPin;
        }
        public void deposit(double amount) {
            balance += amount;
            IO.println("Deposited: $" + amount);
        }
        public void withdraw(double amount) {
            if (amount <= balance) {
                balance -= amount;
                IO.println("Withdrawn: $" + amount);
            } else {
                IO.println("Insufficient balance");
            }
        }
        public void showAccountInformation() {
            IO.println("Account: " + accountNumber);
            IO.println("Balance: $" + balance);
        }
    }

    @Setter
    @Getter
    static class Auditor {
        private String auditorName = "Internal Auditor";
    }

    static void main() {
        BankAccount account = new BankAccount("ACC-001", 1000, 1234);
        AccountManager manager = account.new AccountManager();
        if (manager.verifyPin(1234)) {
            manager.deposit(500);
            manager.withdraw(200);
            manager.showAccountInformation();
        }
        IO.println();
        IO.println("Nest Host:");
        IO.println(BankAccount.class.getNestHost());
        IO.println();
        IO.println("Nest Members:");
        for (Class<?> member : BankAccount.class.getNestMembers()) {
            IO.println(member.getName());
        }
        IO.println();
        IO.println("BankAccount and AccountManager nestmates: "
                + BankAccount.class.isNestmateOf(AccountManager.class));
        IO.println("AccountManager and Auditor nestmates: "
                        + AccountManager.class.isNestmateOf(Auditor.class));
    }
}