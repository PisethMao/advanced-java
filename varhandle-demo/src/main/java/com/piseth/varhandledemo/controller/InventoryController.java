package com.piseth.varhandledemo.controller;

import com.piseth.varhandledemo.dto.InventoryResponse;
import com.piseth.varhandledemo.dto.PurchaseResponse;
import com.piseth.varhandledemo.service.InventoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public InventoryResponse getInventory() {
        return inventoryService.getInventory();
    }

    @PostMapping("/purchase")
    public PurchaseResponse purchase() {
        return inventoryService.purchase();
    }

    @PostMapping("/restock")
    public InventoryResponse restock(@RequestParam int quantity) {
        return inventoryService.restock(quantity);
    }

    @PostMapping("/reset")
    public InventoryResponse reset(@RequestParam int quantity) {
        return inventoryService.reset(quantity);
    }
}
