package org.example.allnewfeaturesinjava9.streamapi.service;

import org.example.allnewfeaturesinjava9.streamapi.domain.Customer;
import org.example.allnewfeaturesinjava9.streamapi.domain.Employee;
import org.example.allnewfeaturesinjava9.streamapi.domain.Order;
import org.example.allnewfeaturesinjava9.streamapi.domain.Transaction;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemoService {
    private final List<Transaction> transactions = List.of(
            new Transaction("TX001", "C001", new BigDecimal("100.00"), "SUCCESS"),
            new Transaction("TX002", "C001", new BigDecimal("250.00"), "SUCCESS"),
            new Transaction("TX003", "C002", new BigDecimal("500.00"), "FAILED"),
            new Transaction("TX004", "C002", new BigDecimal("300.00"), "SUCCESS"),
            new Transaction("TX005", "C003", new BigDecimal("150.00"), "SUCCESS")
    );

    public void takeWhileExample() {
        List<Transaction> result = transactions.stream()
                .takeWhile(transaction -> transaction.status().equals("SUCCESS")).toList();
        IO.println("=== takeWhile() ===");
        result.forEach(IO::println);
    }

    public void dropWhileExample() {
        List<Transaction> result = transactions.stream()
                .dropWhile(transaction -> transaction.status().equals("SUCCESS"))
                .toList();
        IO.println("\n=== dropWhile() ===");
        result.forEach(IO::println);
    }

    public void iterateExample() {
        List<Integer> numbers = Stream
                .iterate(1, number -> number <= 10, number -> number + 1)
                .toList();
        IO.println("\n=== Stream.iterate() ===");
        IO.println(numbers);
    }

    public void installmentExample() {
        List<String> installments = Stream
                .iterate(1, number -> number <= 12, number -> number + 1)
                .map(number -> "Installment-" + number).toList();
        IO.println("\n=== Installments ===");
        installments.forEach(IO::println);
    }

    public void ofNullableExample() {
        List<String> result = Stream.ofNullable(String.valueOf((Object) null)).toList();
        IO.println("\n=== Stream.ofNullable() ===");
        IO.println(result);
    }

    public void customerPhoneExample() {
        List<Customer> customers = List.of(
                new Customer("C001", "Piseth", "012345678"),
                new Customer("C002", "Dara", null),
                new Customer("C003", "Sokha", "098765432")
        );
        List<String> phoneNumbers = customers.stream()
                .flatMap(customer -> Stream.ofNullable(customer.phoneNumber())).toList();
        IO.println("\n=== Customer Phone Numbers ===");
        IO.println(phoneNumbers);
    }

    public void filteringCollectorExample() {
        List<Employee> employees = List.of(
                new Employee("E001", "Piseth", "IT", new BigDecimal("3000")),
                new Employee("E002", "Dara", "IT", new BigDecimal("1500")),
                new Employee("E003", "Sokha", "HR", new BigDecimal("2500")),
                new Employee("E004", "Vanna", "HR", new BigDecimal("1200"))
        );
        Map<String, List<Employee>> result = employees.stream()
                .collect(Collectors.groupingBy(Employee::department, Collectors.filtering(
                        employee -> employee.salary()
                                .compareTo(new BigDecimal("2000")) > 0, Collectors.toList())));
        IO.println("\n=== Collectors.filtering() ===");
        result.forEach((department, employeeList) -> {
            IO.println(department);
            employeeList.forEach(employee -> IO.println("  " + employee.name() + " - " + employee.salary()));
        });
    }

    public void flatMappingCollectorExample() {
        List<Order> orders = List.of(
                new Order("O001", "Piseth", List.of("MacBook Pro", "iPhone")),
                new Order("O002", "Piseth", List.of("AirPods", "Apple Watch")),
                new Order("O003", "Dara", List.of("Samsung Galaxy", "Monitor"))
        );
        Map<String, List<String>> result = orders.stream()
                .collect(Collectors.groupingBy(Order::customerName,
                        Collectors.flatMapping(order -> order.products().stream(), Collectors.toList())));
        IO.println("\n=== Collectors.flatMapping() ===");
        result.forEach((customer, products) -> {
            IO.println(customer);
            products.forEach(product -> IO.println("  " + product));
        });
    }
}
