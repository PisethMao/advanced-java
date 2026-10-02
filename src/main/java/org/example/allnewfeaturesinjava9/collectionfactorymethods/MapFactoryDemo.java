package org.example.allnewfeaturesinjava9.collectionfactorymethods;

import java.util.HashMap;
import java.util.Map;

public class MapFactoryDemo {
    public static void run() {
        IO.println("========== Map.of() ==========");
        Map<String, String> country = new HashMap<>(Map.of("USA", "United States of America", "UK", "United Kingdom"));
        IO.println("Country: " + country);
        IO.println("UK: " + country.get("UK"));
        IO.println("Contains USA: " + country.containsKey("USA"));
        IO.println("Unknown Code: " + country.getOrDefault("UNKNOWN", "Unknown"));
        Map<String, String> statues = Map.of("USA", "Statue of Liberty", "UK", "Big Ben", "PSM", "Statue of Liberty");
        IO.println("Duplicate Values: " + statues);
        try {
            country.put("USA", "United States of America");
        }catch (UnsupportedOperationException e) {
            IO.println("Unsupported Operation: " + e.getMessage());
        }
        Map<String, String> mutableCountry = new HashMap<>(country);
        mutableCountry.put("USA", "United States of America");
        IO.println("Mutable Country: " + mutableCountry);
        IO.println("========== Map.ofEntries ==========");
        Map<String, String> entries = Map.ofEntries(
                Map.entry("USA", "United States of America"),
                Map.entry("UK", "United Kingdom"),
                Map.entry("PSM", "Statue of Liberty")
        );
        IO.println("Entries: " + entries);
    }
}
