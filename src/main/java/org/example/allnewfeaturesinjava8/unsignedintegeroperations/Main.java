package org.example.allnewfeaturesinjava8.unsignedintegeroperations;

public class Main {
    static void main() {
        int number = -1;
        IO.println(number);
        Long unsignedNumber = Integer.toUnsignedLong(number);
        IO.println(unsignedNumber);

        int value = -1;
        IO.println("Signed:");
        IO.println(value);
        IO.println("Unsigned:");
        IO.println(Integer.toUnsignedString(value));

        int a = -1;
        int b = 100;
        IO.println(a > b);
        IO.println(Integer.compareUnsigned(a, b) > 0);

        int value1 = -1;
        IO.println("Signed: " + value1 / 2);
        IO.println("Unsigned: " + Integer.divideUnsigned(value1, 2));

        int value2 = -1;
        int remainder = Integer.remainderUnsigned(value2, 2);
        IO.println(remainder);
    }
}
