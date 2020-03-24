package com.example.demomongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.HashSet;

/**
 * @createDate: 2019-10-03 11:08
 * @description:
 */
@Document("employee")
@Data
public class Employee {
    @Id
    private String empId;
    private String name;
    private int age;
    private double salary;
    private LocalDateTime dateTime;
    private HashSet<String> tags;
    private String exists;
}