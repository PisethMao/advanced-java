package org.example.allnewfeaturesinjava21.sequencedcollections;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.SequencedMap;
import java.util.SequencedSet;

public class Main {
    static void main() {
        // 1. SequencedSet
        SequencedSet<String> users = new LinkedHashSet<>();
        users.add("Dara");
        users.add("Sokha");
        users.add("Piseth");
        users.addFirst("Admin");
        users.addLast("Dara");
        IO.println(users);
        IO.println(users.reversed());
        // 2. SequencedMap
        SequencedMap<Integer, String> employees = new LinkedHashMap<>();
        employees.put(101, "Dara");
        employees.put(102, "Sokha");
        employees.put(103, "Piseth");
        employees.putFirst(100, "Admin");
        employees.putLast(104, "Manager");
        IO.println(employees.firstEntry());
        IO.println(employees.lastEntry());
        IO.println(employees.reversed());
        employees.pollFirstEntry();
        employees.pollLastEntry();
        IO.println(employees);
    }
}
