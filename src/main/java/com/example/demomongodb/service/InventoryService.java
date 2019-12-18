package com.example.demomongodb.service;

import com.example.demomongodb.entity.Inventory;

import java.util.List;

public interface InventoryService {
    void addInventory();

    List<Inventory> queryInventoryAll();
}
