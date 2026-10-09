package org.example.allnewfeaturesinjava25.compactsourcefiles;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    String fileName = "transactions.csv";

    void main() throws IOException {
        List<String> lines = Files.readAllLines(Path.of(fileName));
        BigDecimal total = BigDecimal.ZERO;
        int completedCount = 0;
        for (int i = 1; i < lines.size(); i++) {
            String[] columns = lines.get(i).split(",", -1);
            if (columns.length != 3) {
                continue;
            }
            if (!"COMPLETED".equals(columns[2])) {
                continue;
            }
            BigDecimal amount = new BigDecimal(columns[1]);
            total = total.add(amount);
            completedCount++;
        }
        IO.println("Transaction Report");
        IO.println("------------------");
        IO.println("Completed: " + completedCount);
        IO.println("Total USD: " + total.toPlainString());
    }
}
