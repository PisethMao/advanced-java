package org.example.allnewfeaturesinjava8.datetimeapi.instant;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {
    static void main() {
        Instant instant = Instant.parse("2026-10-01T03:30:00Z");
        ZoneId cambodia = ZoneId.of("Asia/Phnom_Penh");
        ZonedDateTime localTime = instant.atZone(cambodia);
        IO.println(localTime);
    }
}
