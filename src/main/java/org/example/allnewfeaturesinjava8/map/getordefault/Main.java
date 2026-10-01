package org.example.allnewfeaturesinjava8.map.getordefault;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static void main() {
        Map<String, Integer> transactionCount = new HashMap<>();
        String[] transactions = {
                "SUCCESS",
                "FAILURE",
                "SUCCESS",
                "PENDING",
                "SUCCESS",
                "FAILURE",
        };
        for (String transaction : transactions) {
            Integer count = transactionCount.getOrDefault(transaction, 0);
            transactionCount.put(transaction, ++count);
        }
        IO.println(transactionCount);
    }
}
