package com.example.demomongodb.service.impl;

import com.example.demomongodb.entity.Inventory;
import com.example.demomongodb.service.InventoryService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {
    private MongoTemplate mongoTemplate;

    public InventoryServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void addInventory() {
        ArrayList<Inventory> list = new ArrayList<>();
        HashMap<String, Object> map = new HashMap<>();

        Inventory inv1 = new Inventory();
        inv1.setItem("journal");
        inv1.setQty(25);
        map.put("h", 14);
        map.put("w", 21);
        map.put("uom", "cm");
        inv1.setSize(map);
        inv1.setStatus("A");

        Inventory inv2 = new Inventory();
        inv2.setItem("notebook");
        inv2.setQty(50);
        map.put("h", 11);
        map.put("w", 21);
        map.put("uom", "in");
        inv2.setSize(map);
        inv2.setStatus("A");

        Inventory inv3 = new Inventory();
        inv3.setItem("paper");
        inv3.setQty(100);
        map.put("h", 8.5);
        map.put("w", 11);
        map.put("uom", "in");
        inv3.setSize(map);
        inv3.setStatus("D");

        Inventory inv4 = new Inventory();
        inv4.setItem("planner");
        inv4.setQty(75);
        map.put("h", 22.85);
        map.put("w", 30);
        map.put("uom", "cm");
        inv4.setSize(map);
        inv4.setStatus("D");

        Inventory inv5 = new Inventory();
        inv5.setItem("postcard");
        inv5.setQty(45);
        map.put("h", 10);
        map.put("w", 15.25);
        map.put("uom", "cm");
        inv5.setSize(map);
        inv5.setStatus("A");

        list.add(inv1);
        list.add(inv2);
        list.add(inv3);
        list.add(inv4);
        list.add(inv5);

        mongoTemplate.insertAll(list);
    }

    @Override
    public List<Inventory> queryInventoryAll(){
        return mongoTemplate.findAll(Inventory.class);
    }
}
