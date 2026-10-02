package org.example.allnewfeaturesinjava8.repeatingannotations;

import java.lang.reflect.Method;

public class Main {
    static void main() throws Exception {
        Method method = PaymentService.class.getMethod("approvePayment");
        Role[] roles = method.getAnnotationsByType(Role.class);
        for (Role role : roles) {
            IO.println(role.value());
        }
    }
}
