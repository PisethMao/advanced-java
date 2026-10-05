package org.example.allnewfeaturesinjava9.varhandle;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

public class ProductInventory {
    private int stock;
    private static final VarHandle STOCK;

    static {
        try {
            STOCK = MethodHandles.lookup().findVarHandle(ProductInventory.class, "stock", int.class);
        } catch (ReflectiveOperationException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public ProductInventory(int initialStock) {
        if (initialStock < 0) {
            throw new IllegalArgumentException("Initial stock cannot be negative");
        }
        this.stock = initialStock;
    }

    public void reserve() {
        while (true) {
            int currentStock = (int) STOCK.getVolatile(this);
            if (currentStock <= 0) {
                return;
            }
            int newStock = currentStock - 1;
            if (STOCK.compareAndSet(this, currentStock, newStock)) {
                return;
            }
        }
    }

    public void restock(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        STOCK.getAndAdd(this, quantity);
    }

    public int getStock() {
        return (int) STOCK.getVolatile(this);
    }
}
