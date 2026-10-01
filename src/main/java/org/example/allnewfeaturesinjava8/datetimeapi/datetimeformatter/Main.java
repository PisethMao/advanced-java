package org.example.allnewfeaturesinjava8.datetimeapi.datetimeformatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    static void main() {
        LocalDate date = LocalDate.of(2026, 10, 1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        String formattedDate = date.format(formatter);
        IO.println(formattedDate);
    }
}
