package org.example.allnewfeaturesinjava9.optionalapi.service;

import org.example.allnewfeaturesinjava9.optionalapi.domain.Customer;
import org.example.allnewfeaturesinjava9.optionalapi.repository.BackupCustomerRepository;
import org.example.allnewfeaturesinjava9.optionalapi.repository.CacheCustomerRepository;
import org.example.allnewfeaturesinjava9.optionalapi.repository.MainCustomerRepository;

import java.util.Optional;

public class CustomerService {
    private final CacheCustomerRepository cacheRepository;
    private final MainCustomerRepository mainRepository;
    private final BackupCustomerRepository backupRepository;

    public CustomerService() {
        this.cacheRepository = new CacheCustomerRepository();
        this.mainRepository = new MainCustomerRepository();
        this.backupRepository = new BackupCustomerRepository();
    }

    public Optional<Customer> findCustomer(String customerId) {
        return cacheRepository.findById(customerId).or(() -> mainRepository.findById(customerId))
                .or(() -> backupRepository.findById(customerId));
    }
}
