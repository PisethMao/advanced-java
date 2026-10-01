package org.example.allnewfeaturesinjava8.datetimeapi.localtime;

import java.time.LocalTime;

public class Main {
    static void main() {
        LocalTime localTime = LocalTime.of(10, 30, 45, 500_000_00);
        IO.println("Part 1: " + localTime);
    }
}
