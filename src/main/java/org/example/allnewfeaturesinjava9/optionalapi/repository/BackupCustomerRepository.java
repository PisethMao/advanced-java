package org.example.allnewfeaturesinjava9.optionalapi.repository;

import org.example.allnewfeaturesinjava9.optionalapi.domain.Customer;

import java.util.List;
import java.util.Optional;

public class BackupCustomerRepository implements CustomerRepository {
    private final List<Customer> customers =
            List.of(
                    new Customer("C004", "Vanna", "vanna@example.com"),
                    new Customer("C005", "Mony", "mony@example.com")
            );

    @Override
    public Optional<Customer> findById(String id) {
        return customers.stream().filter(customer -> customer.id().equals(id)).findFirst();
    }
}
