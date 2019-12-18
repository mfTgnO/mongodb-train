package com.example.demomongodb.service;

import com.example.demomongodb.entity.Employee;

import java.util.List;

/**
 * @createDate: 2019-10-08 14:23
 * @description:
 */
public interface EmployeeService {
    List<Employee> findAll();

    Employee insert(Employee employee);

    void insertAll();

    List<Employee> findLessThan();

    List<Employee> findGreaterThan();

    List<Employee> findLessThanAndGreaterThan();

    List<Employee> sort();

    List<Employee> pageable();
}