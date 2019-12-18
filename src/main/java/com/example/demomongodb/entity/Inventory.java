package com.example.demomongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Document("inventory")
@Data
public class Inventory {
    @Id
    private String empId;
    private String item;
    private Integer qty;
    private HashMap<String, Object> size;
    private String status;
}
