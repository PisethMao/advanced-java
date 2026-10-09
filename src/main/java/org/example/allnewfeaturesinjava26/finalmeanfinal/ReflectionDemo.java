package org.example.allnewfeaturesinjava26.finalmeanfinal;

import java.lang.reflect.Field;

public class ReflectionDemo {
    void main() throws Exception {
        PaymentRecord payment = new PaymentRecord("TXN-1001", 150_000);
        IO.println("=== ORIGINAL PAYMENT ===");
        IO.println(payment);
        Field field = PaymentRecord.class.getDeclaredField("transactionId");
        field.setAccessible(true);
        IO.println();
        IO.println("=== REFLECTION ATTEMPT ===");
        IO.println("ID before: " + field.get(payment));
        try {
            field.set(payment, "TXN-9999");
            IO.println("Reflection write succeeded");
        } catch (IllegalAccessException exception) {
            IO.println("Reflection write blocked!");
            IO.println("Exception: " + exception.getClass().getSimpleName());
        }
        IO.println("ID after: " + field.get(payment));
    }
}

