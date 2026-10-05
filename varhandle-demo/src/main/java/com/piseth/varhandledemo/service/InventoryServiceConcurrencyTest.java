package com.piseth.varhandledemo.service;

import com.piseth.varhandledemo.dto.PurchaseResponse;
import com.piseth.varhandledemo.service.impl.InventoryServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static org.junit.Assert.assertEquals;

public class InventoryServiceConcurrencyTest {
    @Test
    public void shouldNeverSellMoreProductsThanAvailable() throws Exception {
        InventoryService service = new InventoryServiceImpl();
        service.reset(10);
        int numberOfCustomers = 100;
        ExecutorService executor = Executors.newFixedThreadPool(20);
        List<Future<PurchaseResponse>> futures = new ArrayList<>();
        for (int i = 0; i < numberOfCustomers; i++) {
            Future<PurchaseResponse> future = executor.submit(service::purchase);
            futures.add(future);
        }
        int successfulPurchases = 0;
        for (Future<PurchaseResponse> future : futures) {
            PurchaseResponse response = future.get();
            if (response.success()) {
                successfulPurchases++;
            }
        }
        executor.shutdown();
        assertEquals(10, successfulPurchases);
        assertEquals(0, service.getInventory().stock());
    }
}
