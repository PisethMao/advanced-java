package org.example.allnewfeaturesinjava14.nullpointerexceptions;

public class Main {
    static void main() {
        Customer customer = new Customer();
        IO.println(customer.getAddress().getCity());
    }
}
