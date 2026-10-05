package org.example.allnewfeaturesinjava9.stackwalker;

import org.example.allnewfeaturesinjava9.stackwalker.service.OrderService;

public class Main {
    static void main() {
//        methodA();
        OrderService orderService = new OrderService();
        orderService.createOrder();
    }

//    private static void methodA() {
//        methodB();
//    }
//
//    private static void methodB() {
//        methodC();
//    }
//
//    private static void methodC() {
//        StackWalker walker = StackWalker.getInstance();
//        String callerMethod = walker.walk(stream -> stream.skip(1)
//                .findFirst()
//                .map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
//        IO.println("Caller: " + callerMethod);
//    }
}
