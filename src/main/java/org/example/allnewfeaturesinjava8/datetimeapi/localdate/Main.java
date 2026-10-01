package org.example.allnewfeaturesinjava8.datetimeapi.localdate;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    static void main() {
        LocalDate localDate = LocalDate.of(2026, Month.OCTOBER, 1);
        IO.println("Part 1: " + localDate);
        LocalDate localDate2 = LocalDate.parse("2026-10-01");
        IO.println("Part 2: " + localDate2);
    }
}
