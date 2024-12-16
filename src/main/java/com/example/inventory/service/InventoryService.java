package com.example.inventory.service;

import com.example.inventory.dto.InventoryDTO;
import com.example.inventory.entity.Inventory;
import com.example.inventory.entity.Product;
import com.example.inventory.exception.ResourceNotFoundException;
import com.example.inventory.repository.InventoryRepository;
import com.example.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ProductRepository productRepository;

    public Inventory getOrCreateInventory(Long productId) {
        return inventoryRepository.findByProductId(productId)
                .orElseGet(() -> {
                    // Check if the product exists
                    Product product = productRepository.findById(productId)
                            .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));

                    // Create a new inventory for the product
                    Inventory newInventory = new Inventory();
                    newInventory.setProduct(product);
                    newInventory.setStockLevel(0); // Default stock level
                    return inventoryRepository.save(newInventory);
                });
    }

    public Optional<Inventory> getInventoryByProductId(Long productId) {
        return inventoryRepository.findByProductId(productId);
    }

    public Inventory updateInventory(Long productId, InventoryDTO inventoryDTO) {
        Inventory inventory = getOrCreateInventory(productId);
        inventory.setStockLevel(inventoryDTO.getQuantity());
        return inventoryRepository.save(inventory);
    }

    public Inventory addStock(Long productId, int quantity) {
        Inventory inventory = getOrCreateInventory(productId);
        inventory.setStockLevel(inventory.getStockLevel() + quantity);
        return inventoryRepository.save(inventory);
    }

    public Inventory deductStock(Long productId, int quantity) {
        Inventory inventory = getOrCreateInventory(productId);
        if (inventory.getStockLevel() < quantity) {
            throw new IllegalArgumentException("Not enough stock to deduct. Current stock: " + inventory.getStockLevel());
        }
        inventory.setStockLevel(inventory.getStockLevel() - quantity);
        return inventoryRepository.save(inventory);
    }

    public int checkStockLevel(Long productId) {
        Inventory inventory = getOrCreateInventory(productId);
        return inventory.getStockLevel();
    }
}

