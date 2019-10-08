package com.example.demomongodb.service.impl;

import com.example.demomongodb.dao.DepartmentRepository;
import com.example.demomongodb.entity.Department;
import com.example.demomongodb.service.DepartmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @createDate: 2019-10-03 13:55
 * @description:
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;
    private MongoTemplate mongoTemplate;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, MongoTemplate mongoTemplate) {
        this.departmentRepository = departmentRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> listDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Page<Department> listDepartmentPage() {
        PageRequest pageRequest = PageRequest.of(0, 2);
        return departmentRepository.findAll(pageRequest);
    }

    @Override
    public Department updateDepartment(Department department, String id) {
        department.setId(id);
        return departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(String id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public List<Department> findAll() {
        return mongoTemplate.findAll(Department.class);
    }

    @Override
    public List<Department> findByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return mongoTemplate.find(query, Department.class);
    }

    @Override
    public List<Department> findByRegex() {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex("^n"));
//        query.addCriteria(Criteria.where("name").regex("n$"));
        return mongoTemplate.find(query, Department.class);
    }
}