package org.example.allnewfeaturesinjava15.records;

import java.util.List;

public class Main {
    static void main() {
        BankAccount account1 = new BankAccount("001", "Piseth", 1500, "USD");
        BankAccount account2 = new BankAccount("002", "Dara", 12000, "USD");
        BankAccount account3 = new BankAccount("003", "Sokha", 500, "USD");
        List<BankAccount> accounts = List.of(account1, account2, account3);
        IO.println("=== All Accounts ===");
        accounts.forEach(IO::println);
        IO.println();
        IO.println("=== Account Accessors ===");
        IO.println(account1.accountNumber());
        IO.println(account1.accountName());
        IO.println(account1.balance());
        IO.println(account1.currency());
        IO.println();
        IO.println("=== Business Method ===");
        IO.println(account2.isHighBalance());
        IO.println();
        IO.println("=== Local Record ===");
        record AccountSummary(String name, double balance) {
        }
        List<AccountSummary> summaries = accounts.stream().map(account ->
                        new AccountSummary(account.accountName(), account.balance())).toList();
        summaries.forEach(IO::println);
        IO.println();
        IO.println("=== Equality ===");
        BankAccount duplicate = new BankAccount("001", "Piseth", 1500, "USD");
        IO.println(account1.equals(duplicate));
        IO.println(account1.equals(duplicate));
    }
}
