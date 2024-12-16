package com.example.inventory.controller;

import com.example.inventory.dto.InventoryDTO;
import com.example.inventory.entity.Inventory;
import com.example.inventory.exception.ResourceNotFoundException;
import com.example.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/{productId}")
    public Inventory getInventory(@PathVariable Long productId) {
        return inventoryService.getInventoryByProductId(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found for product id: " + productId));
    }

    @PutMapping("/{productId}")
    public Inventory updateInventory(@PathVariable Long productId, @RequestBody InventoryDTO inventoryDTO) {
        return inventoryService.updateInventory(productId, inventoryDTO);
    }

    @PostMapping("/{productId}/add")
    public Inventory addStock(@PathVariable Long productId, @RequestParam int quantity) {
        return inventoryService.addStock(productId, quantity);
    }

    @PostMapping("/{productId}/deduct")
    public Inventory deductStock(@PathVariable Long productId, @RequestParam int quantity) {
        return inventoryService.deductStock(productId, quantity);
    }

    @GetMapping("/{productId}/stock-level")
    public int checkStockLevel(@PathVariable Long productId) {
        return inventoryService.checkStockLevel(productId);
    }
}
