package org.example.allnewfeaturesinjava9.optionalapi.repository;

import org.example.allnewfeaturesinjava9.optionalapi.domain.Customer;

import java.util.Map;
import java.util.Optional;

public class CacheCustomerRepository implements CustomerRepository {

    private final Map<String, Customer> cache =
            Map.of("C001", new Customer("C001", "Piseth", "piseth@example.com"));

    @Override
    public Optional<Customer> findById(String id) {
        Customer customer = cache.get(id);
        return Optional.ofNullable(customer);
    }
}
