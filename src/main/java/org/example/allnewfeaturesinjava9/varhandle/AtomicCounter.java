package org.example.allnewfeaturesinjava9.varhandle;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

public class AtomicCounter {
    private int value;
    private static final VarHandle VALUE;

    static {
        try {
            VALUE = MethodHandles.lookup().findVarHandle(AtomicCounter.class, "value", int.class);
        } catch (ReflectiveOperationException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public void increment() {
        VALUE.getAndAdd(this, 1);
    }

    public void decrement() {
        VALUE.getAndAdd(this, -1);
    }

    public int get() {
        return (int) VALUE.getVolatile(this);
    }
}
