package org.example.allnewfeaturesinjava8.functionalinterfaces.predicate;

import java.util.function.Predicate;

public class Main {
    static void main() {
        Predicate<Integer> greaterThanTen = number -> number > 10;
        boolean result = greaterThanTen.test(20);
        IO.println("Result is: " + result);

        User user = new User("Piseth", 21);
        Predicate<User> isAdult = u -> u.getAge() >= 18;
//        boolean result1 = isAdult.test(user);
//        IO.println("Result is: " + result1);
        if (isAdult.test(user)) {
            IO.println(user.getName() + " is an adult");
        } else {
            IO.println(user.getName() + " is not an adult");
        }

        Predicate<User> hasLongName = u -> u.getName().length() > 5;
        if (hasLongName.test(user)) {
            IO.println(user.getName() + " is a long");
        } else {
            IO.println(user.getName() + " is not a long");
        }

        Predicate<User> validUser = isAdult.and(hasLongName);
        if (validUser.test(user)) {
            IO.println(user.getName() + " is a user");
        } else {
            IO.println(user.getName() + " is not a user");
        }

        Predicate<User> condition = isAdult.or(hasLongName);
        if (condition.test(user)) {
            IO.println(user.getName() + " is a user");
        } else {
            IO.println(user.getName() + " is not a user");
        }

        Predicate<User> isMinor = isAdult.negate();
        if (isMinor.test(user)) {
            IO.println(user.getName() + " is a minor");
        } else {
            IO.println(user.getName() + " is not a minor");
        }
    }
}
