package com.example.demomongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @createDate: 2019-10-03 11:06
 * @description:
 */
@Document("Department")
@Data
public class Department {
    @Id
    private String id;
    private String name;
    private String description;
    private List employees;
}