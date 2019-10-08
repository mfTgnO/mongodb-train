package com.example.demomongodb.dao;

import com.example.demomongodb.entity.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * @createDate: 2019-10-03 11:10
 * @description:
 */
public interface DepartmentRepository extends MongoRepository<Department, String> {
    @Query(value = "{'employees.name': ?0}", fields = "{'employees':0}")
    Department finDepartmentByEmployeeNmae(String empName);

    List findDepartmentByName(String name);
}