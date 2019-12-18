package com.example.demomongodb.controller;

import com.example.demomongodb.entity.Inventory;
import com.example.demomongodb.service.InventoryService;
import com.example.demomongodb.util.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    private InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping
    public JsonResult addInventory() {
        inventoryService.addInventory();
        return new JsonResult();
    }

    @GetMapping
    public JsonResult queryInventory() {
        List<Inventory> inventories = inventoryService.queryInventoryAll();
        return new JsonResult<>(inventories);
    }
}