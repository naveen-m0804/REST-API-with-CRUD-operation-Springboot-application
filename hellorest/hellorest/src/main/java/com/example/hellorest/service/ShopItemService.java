package com.example.hellorest.service;

import com.example.hellorest.model.ShopItem;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class ShopItemService {

    private final String filePath = "src/main/resources/items.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    private List<ShopItem> loadItems() {
        try {
            File file = new File(filePath);
            if (!file.exists()) return new ArrayList<>();
            return objectMapper.readValue(file, new TypeReference<List<ShopItem>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void saveItems(List<ShopItem> items) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<ShopItem> getAllItems() {
        return loadItems();
    }

    public ShopItem getItemById(Long id) {
        return loadItems().stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
    }

    public ShopItem addItem(ShopItem newItem) {
        List<ShopItem> items = loadItems();
        long newId = items.stream().mapToLong(ShopItem::getId).max().orElse(0) + 1;
        newItem.setId(newId);
        items.add(newItem);
        saveItems(items);
        return newItem;
    }

    public ShopItem updateItem(Long id, ShopItem updatedItem) {
        List<ShopItem> items = loadItems();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                updatedItem.setId(id);
                items.set(i, updatedItem);
                saveItems(items);
                return updatedItem;
            }
        }
        return null;
    }

    public boolean deleteItem(Long id) {
        List<ShopItem> items = loadItems();
        boolean removed = items.removeIf(item -> item.getId().equals(id));
        if (removed) saveItems(items);
        return removed;
    }
}
