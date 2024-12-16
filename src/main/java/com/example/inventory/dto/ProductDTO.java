package com.example.inventory.dto;

public class ProductDTO {
    private Long id;
    private String name;
    private double price;
    private Long categoryId;
    private Integer quantity; 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public int getInventoryQuantity() {
        return quantity;
    }

    public void setInventoryQuantity(int inventoryQuantity) {
        this.quantity = inventoryQuantity;
    }
}
