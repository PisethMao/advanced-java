package org.example.allnewfeaturesinjava8.optional;

import java.util.Optional;

public class Main {
    static void main() {
        CustomerService customerService = new CustomerService();
        Optional<Customer> customer = customerService.findCustomerById(1L);
        // 1. isPreset()
//        if (customer.isPresent()) {
//            IO.println("Result: " + customer.get());
//        }
        // 2. ifPresent
        customer.ifPresent(value -> IO.println("Result: " + value));
        // 3. isEmpty()
        if (customer.isEmpty()) {
            IO.println("Customer not found");
        }
        // 4. .get.name()
//        if (customer.isPresent()) {
//            IO.println(customer.get().name());
//        }
        customer.ifPresent(value -> IO.println(value.name()));
        // 5. Method Reference
        customer.ifPresent(IO::println);
        // 6. orElse()
        Customer defaultCustomer = new Customer(0L, "Guest", "unknown@example.com", "N/A");
        Customer result = customerService.findCustomerById(1L).orElse(defaultCustomer);
        IO.println("Result: " + result);
        // 7. orElseGet()
        Customer customer1 = customerService.findCustomerById(1L)
                .orElseGet(customerService::createDefaultCustomer);
        IO.println("Result: " + customer1);
        // 8. orElseThrow()
        Customer customer2 = customerService.findCustomerById(90L)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
        IO.println("Result: " + customer2);
    }
}
