package org.example.allnewfeaturesinjava9.optionalapi.repository;

import org.example.allnewfeaturesinjava9.optionalapi.domain.Customer;

import java.util.Optional;

public interface CustomerRepository {
    Optional<Customer> findById(String id);
}
