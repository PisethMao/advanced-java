package org.example.allnewfeaturesinjava9.stackwalker.util;

public final class AuditLogger {
    private static final StackWalker STACK_WALKER = StackWalker.getInstance();

    private AuditLogger() {
    }

    public static void log(String message) {
        StackWalker.StackFrame caller = STACK_WALKER.walk(stream -> stream
                .filter(frame -> !frame.getClassName()
                        .equals(AuditLogger.class.getName())).findFirst().orElseThrow());
        IO.println("===== AUDIT LOG =====");
        IO.println("Class  : " + caller.getClassName());
        IO.println("Method : " + caller.getMethodName());
        IO.println("Line   : " + caller.getLineNumber());
        IO.println("Message: " + message);
        IO.println("=====================");
    }
}
