package org.example.allnewfeaturesinjava8.lambdaexpressions;

import java.math.BigDecimal;

public class Main {
    static void main() {
        // 1. Version 1: Without Lambda
//        Greeting greeting = new EnglishGreeting();
//        greeting.sayHello("Piseth");
        // 2. Version 2: @Override in Main Method
//        Greeting greeting = new Greeting() {
//            @Override
//            public void sayHello(String name) {
//                IO.println("Hello, " + name);
//            }
//        };
//        greeting.sayHello("Piseth");
        // 3. Version 3: Replace it with Lambda Expression
        Greeting greeting = name -> IO.println("Hello, " + name);
        greeting.sayHello("Piseth");
        // 4. Version 4: Lambda with 2 Parameters
//        Calculator calculator = (a, b) -> a + b;
        // 5. Version 5: We can Replace Lambda with Method Reference
        Calculator sum = Integer::sum;
        Calculator subtract = (a, b) -> a - b;
        Calculator multiply = (a, b) -> a * b;
        Calculator divide = (a, b) -> a / b;
        Integer result1 = sum.calculate(10, 5);
        Integer result2 = subtract.calculate(10, 5);
        Integer result3 = multiply.calculate(10, 5);
        Integer result4 = divide.calculate(10, 5);
        IO.println("Result 1 is = " + result1);
        IO.println("Result 2 is = " + result2);
        IO.println("Result 3 is = " + result3);
        IO.println("Result 4 is = " + result4);

        BigDecimal price = BigDecimal.valueOf(100);
        Discount normalCustomer = p -> p;
        Discount member = p -> p.multiply(new BigDecimal("0.90"));
//        Discount vip = p -> p.multiply(new BigDecimal(0.80));
        // We can use this too!!!
        Discount vip = p -> p.multiply(new BigDecimal("0.80"));
        IO.println(normalCustomer.apply(price));
        IO.println(member.apply(price));
        IO.println(vip.apply(price));
    }
}
