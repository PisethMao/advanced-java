package com.piseth.varhandledemo.service;

import com.piseth.varhandledemo.dto.InventoryResponse;
import com.piseth.varhandledemo.dto.PurchaseResponse;

public interface InventoryService {

    InventoryResponse getInventory();

    PurchaseResponse purchase();

    InventoryResponse restock(int quantity);

    InventoryResponse reset(int quantity);
}
