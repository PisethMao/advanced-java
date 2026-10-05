package org.example.allnewfeaturesinjava9.optionalapi;

import org.example.allnewfeaturesinjava9.optionalapi.domain.Customer;
import org.example.allnewfeaturesinjava9.optionalapi.service.CustomerService;

import java.util.List;
import java.util.Optional;

public class Main {
    static void main() {
        // 1. Simple
//        MainCustomerRepository repository = new MainCustomerRepository();
//        Optional<Customer> customer = repository.findById("C001");
//        IO.println(customer);
        // 2. or()
//        CustomerService service = new CustomerService();
//        Optional<Customer> customer = service.findCustomer("C004");
//        IO.println(customer);
        // 3. or() + ifPresentOrElse()
//        CustomerService service = new CustomerService();
//        service.findCustomer("C004").ifPresentOrElse(customer -> {
//            IO.println("Customer found");
//            IO.println("ID: " + customer.id());
//            IO.println("Name: " + customer.name());
//            IO.println("Email: " + customer.email());
//        }, () -> IO.println("Customer not found"));
        // 4. steam()
        CustomerService service = new CustomerService();
        List<String> customerIds = List.of("C001", "C002", "C999", "C004", "C888", "C003");
        List<Customer> customers = customerIds.stream().map(service::findCustomer)
                .flatMap(Optional::stream).toList();
        customers.forEach(customer -> IO.println(customer.id() + " - " + customer.name()));
    }
}
