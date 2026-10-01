package org.example.allnewfeaturesinjava8.datetimeapi.zoneidandoffset;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class Main {
    static void main() {
        ZoneId cambodia = ZoneId.of("Asia/Phnom_Penh");
        ZonedDateTime now = ZonedDateTime.now(cambodia);
        IO.println(now);

        ZoneOffset cambodiaOffset = ZoneOffset.ofHours(7);
        OffsetDateTime offsetDateTime = OffsetDateTime.now(cambodiaOffset);
        IO.println(offsetDateTime);
    }
}
