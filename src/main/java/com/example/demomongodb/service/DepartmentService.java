package com.example.demomongodb.service;

import com.example.demomongodb.entity.Department;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @createDate: 2019-10-03 13:54
 * @description:
 */
public interface DepartmentService {
    Department addDepartment(Department department);

    List<Department> listDepartment();

    Page<Department> listDepartmentPage();

    Department updateDepartment(Department department, String id);

    void deleteDepartment(String id);

    List<Department> findAll();

    List<Department> findByName(String name);

    List<Department> findByRegex();
}