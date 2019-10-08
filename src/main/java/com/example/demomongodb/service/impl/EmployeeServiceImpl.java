package com.example.demomongodb.service.impl;

import com.example.demomongodb.entity.Employee;
import com.example.demomongodb.service.EmployeeService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @createDate: 2019-10-08 14:23
 * @description:
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private MongoTemplate mongoTemplate;

    public EmployeeServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Employee> findAll() {
        return mongoTemplate.findAll(Employee.class);
    }

    @Override
    public Employee insert(Employee employee) {
        employee.setDateTime(LocalDateTime.now());
        return mongoTemplate.insert(employee);
    }

    /**
     * less than
     *
     * @return List<Employee>
     */
    @Override
    public List<Employee> findLessThan() {
        Query query = new Query();
        query.addCriteria(Criteria.where("age").lt(50));
        return mongoTemplate.find(query, Employee.class);
    }

    /**
     * greater than
     *
     * @return List<Employee>
     */
    @Override
    public List<Employee> findGreaterThan() {
        Query query = new Query();
        query.addCriteria(Criteria.where("age").gt(50));
        return mongoTemplate.find(query, Employee.class);
    }

    /**
     * less than and greater than
     *
     * @return List<Employee>
     */
    @Override
    public List<Employee> findLessThanAndGreaterThan() {
        Query query = new Query();
        query.addCriteria(Criteria.where("age").gt(20).lt(50));
        return mongoTemplate.find(query, Employee.class);
    }

    /**
     * sort
     *
     * @return List<Employee>
     */
    @Override
    public List<Employee> sort() {
        Query query = new Query();
        query.with(new Sort(Sort.Direction.ASC, "age"));
        return mongoTemplate.find(query, Employee.class);
    }

    /**
     * Pageable
     *
     * @return List<Employee>
     */
    @Override
    public List<Employee> pageable() {
        final Pageable pageableRequest = PageRequest.of(0, 2);
        Query query = new Query();
        query.with(pageableRequest);
        return mongoTemplate.find(query, Employee.class);
    }
}