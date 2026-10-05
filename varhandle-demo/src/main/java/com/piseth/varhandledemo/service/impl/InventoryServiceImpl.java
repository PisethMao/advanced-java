package com.piseth.varhandledemo.service.impl;

import com.piseth.varhandledemo.dto.InventoryResponse;
import com.piseth.varhandledemo.dto.PurchaseResponse;
import com.piseth.varhandledemo.service.InventoryService;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

@Service
public class InventoryServiceImpl implements InventoryService {
    private int stock = 10;
    private static final VarHandle STOCK_HANDLE;

    static {
        try {
            STOCK_HANDLE = MethodHandles.lookup()
                    .findVarHandle(InventoryServiceImpl.class, "stock", int.class);
        } catch (ReflectiveOperationException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    @Override
    public InventoryResponse getInventory() {
        int currentStock = (int) STOCK_HANDLE.getVolatile(this);
        return new InventoryResponse(currentStock);
    }

    @Override
    public PurchaseResponse purchase() {
        while (true) {
            int currentStock = (int) STOCK_HANDLE.getVolatile(this);
            if (currentStock <= 0) {
                return new PurchaseResponse(false, "Product is out of stock", 0);
            }
            int newStock = currentStock - 1;
            boolean updated = STOCK_HANDLE.compareAndSet(this, currentStock, newStock);

            if (updated) {
                return new PurchaseResponse(true, "Product purchased successfully", newStock);
            }
        }
    }

    @Override
    public InventoryResponse restock(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        int previousStock = (int) STOCK_HANDLE.getAndAdd(this, quantity);
        int newStock = previousStock + quantity;
        return new InventoryResponse(newStock);
    }

    @Override
    public InventoryResponse reset(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        STOCK_HANDLE.setVolatile(this, quantity);
        return new InventoryResponse(quantity);
    }
}
