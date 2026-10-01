package org.example.allnewfeaturesinjava8.datetimeapi.zonedatetime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {
    static void main() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        LocalDateTime localDateTime =
                LocalDateTime.of(2026, 10, 1, 10, 30);
        ZoneId zone = ZoneId.of("Asia/Phnom_Penh");
        ZonedDateTime zonedDateTime1 = localDateTime.atZone(zone);
        IO.println(zonedDateTime);
        IO.println(zonedDateTime1);
    }
}
