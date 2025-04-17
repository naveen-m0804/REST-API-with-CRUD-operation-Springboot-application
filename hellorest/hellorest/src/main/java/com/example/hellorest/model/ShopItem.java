package com.example.hellorest.model;

public class ShopItem {

    private Long id;
    private String itemName;
    private double price;
    private int stock;
    private String description;
    private String category;

    public ShopItem() {
    }

    public ShopItem(Long id, String itemName, double price, int stock, String description, String category) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
