package com.example.hellorest.controller;

import com.example.hellorest.model.ShopItem;
import com.example.hellorest.service.ShopItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ShopItemController {

    @Autowired
    private ShopItemService shopItemService;

    @GetMapping
    public List<ShopItem> getAllItems() {
        return shopItemService.getAllItems();
    }

    @GetMapping("/{id}")
    public ShopItem getItemById(@PathVariable Long id) {
        return shopItemService.getItemById(id);
    }

    @PostMapping
    public ShopItem createItem(@RequestBody ShopItem item) {
        return shopItemService.addItem(item);
    }

    @PutMapping("/{id}")
    public ShopItem updateItem(@PathVariable Long id, @RequestBody ShopItem item) {
        return shopItemService.updateItem(id, item);
    }

    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable Long id) {
        return shopItemService.deleteItem(id) ? "Deleted" : "Not Found";
    }
}
