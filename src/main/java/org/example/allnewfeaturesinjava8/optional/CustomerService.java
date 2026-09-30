package org.example.allnewfeaturesinjava8.optional;

import java.util.List;
import java.util.Optional;

public class CustomerService {
    private final List<Customer> customers = List.of(
            new Customer(1L, "Piseth", "piseth@example.com", "012345678"),
            new Customer(2L, "Dara", "dara@example.com", "098765432"),
            new Customer(3L, "Sokha", "sokha@example.com", "011222333")
    );

    public Optional<Customer> findCustomerById(Long id) {
//        for (Customer customer : customers) {
//            if (customer.id().equals(id)) {
//                return Optional.of(customer);
//            }
//        }
//        return Optional.empty();
        return customers.stream().filter(customer -> customer.id().equals(id)).findFirst();
    }

    public Customer createDefaultCustomer() {
        IO.println("Creating default customer...");
        return new Customer(0L, "Guest", "unknown@example.com", "N/A");
    }
}
