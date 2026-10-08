package org.example.allnewfeaturesinjava22.unnamed.inloops;


import java.util.List;

public class Main {
    static void main() {
        List<String> transactions = List.of("TXN001", "TXN002", "TXN003");
        int count = 0;
        for (String _ : transactions) {
            count++;
        }
        IO.println("Total transactions: " + count);
    }
}
