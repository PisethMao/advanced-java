package org.example.allnewfeaturesinjava8.stream.collectors;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static void main() {
        List<String> names = List.of("Mak At", "Pa Thun", "Sophaneth", "Pisal");
        // 1. For-Each Loop
//        List<String> result = new ArrayList<>();
//        for (String name : names) {
//            result.add(name.toUpperCase());
//        }
        // 2. toList()
        List<String> result = names.stream().map(String::toUpperCase)
                .collect(Collectors.toList());
        IO.println(result);
        // 3. toSet()
        List<String> categories = List.of("Laptop", "Mobile", "Tablet", "Tablet", "Tablet", "Tablet");
//        Set<String> result1 = categories.stream().collect(Collectors.toSet());
        Set<String> result1 = new HashSet<>(categories);
        IO.println(result1);
        // 4. joining()
//        String result2 = names.stream().collect(Collectors.joining(", "));
        String result2 = String.join(", ", names);
        IO.println(result2);
        // 5. counting()
//        Long count = names.stream().collect(Collectors.counting());
//        Long count = names.stream().count();
        Long count = (long) names.size();
        IO.println(count);
        // 6. toMap()
        List<Product> products = List.of(
                new Product(1L, "MacBook Pro"),
                new Product(2L, "iPhone"),
                new Product(3L, "Keyboard")
        );
        Map<Long, String> result3 = products.stream()
                .collect(Collectors.toMap(Product::id, Product::name));
        IO.println(result3);
        // 7. groupingBy()
        Map<String, List<Product>> result4 = products.stream()
                .collect(Collectors.groupingBy(Product::name));
        IO.println(result4);
        // 8. groupingBy() + counting()
        Map<String, Long> result5 = products.stream()
                .collect(Collectors.groupingBy(Product::name, Collectors.counting()));
        IO.println(result5);
        // 9. partitioningBy()
        Map<Boolean, List<Product>> result6 = products.stream().collect(
                Collectors.partitioningBy(product -> product.name().charAt(0) == 'M')
        );
        IO.println(result6);
        // 10. summingInt()
        List<Order> orders = List.of(
                new Order(1L, 3),
                new Order(2L, 5),
                new Order(3L, 2)
        );
//        Integer total = orders.stream().collect(Collectors.summingInt(Order::quantity));
        Integer total = orders.stream().mapToInt(Order::quantity).sum();
        IO.println(total);
        // 11. averagingInt()
        List<Student> students = List.of(
                new Student("Piseth", 90),
                new Student("Dara", 80),
                new Student("Sokha", 100)
        );
        Double average = students.stream().collect(Collectors.averagingInt(Student::score));
        IO.println(average);
    }
}
