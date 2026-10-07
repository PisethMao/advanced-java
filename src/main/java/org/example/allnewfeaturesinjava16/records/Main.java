package org.example.allnewfeaturesinjava16.records;

public class Main {
    static void main() {
        Employee employee1 = new Employee(1L, "John Doe", "IT");
        Employee employee2 = new Employee(2L, "Jane Doe", "HR");
        IO.println(employee1);
        IO.println(employee2);
        IO.println(employee1.equals(employee2));
        IO.println(employee1.name());
    }
}
