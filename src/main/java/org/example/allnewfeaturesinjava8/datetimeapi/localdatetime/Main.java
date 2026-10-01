package org.example.allnewfeaturesinjava8.datetimeapi.localdatetime;

import java.time.LocalDateTime;

public class Main {
    static void main() {
        LocalDateTime localDateTime = LocalDateTime.now();
        IO.println("Part 1: " + localDateTime);
        LocalDateTime meeting = LocalDateTime.of(2026, 10, 10, 9, 30, 45);
        IO.println("Part 2: " + meeting);
        IO.println("Year: " + meeting.getYear());
        IO.println("Month: " + meeting.getMonth());
        IO.println("Month number: " + meeting.getMonthValue());
        IO.println("Day: " + meeting.getDayOfMonth());
        IO.println("Day of week: " + meeting.getDayOfWeek());
        IO.println("Hour: " + meeting.getHour());
        IO.println("Minute: " + meeting.getMinute());
        IO.println("Second: " + meeting.getSecond());
    }
}
