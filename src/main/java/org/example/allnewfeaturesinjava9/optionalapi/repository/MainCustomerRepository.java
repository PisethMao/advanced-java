package org.example.allnewfeaturesinjava9.optionalapi.repository;

import org.example.allnewfeaturesinjava9.optionalapi.domain.Customer;

import java.util.List;
import java.util.Optional;

public class MainCustomerRepository implements CustomerRepository {
    private final List<Customer> customers =
            List.of(
                    new Customer("C001", "Piseth", "piseth@example.com"),
                    new Customer("C002", "Dara", "dara@example.com"),
                    new Customer("C003", "Sokha", "sokha@example.com"));

    @Override
    public Optional<Customer> findById(String id) {
        return customers.stream().filter(customer -> customer.id().equals(id)).findFirst();
    }
}
