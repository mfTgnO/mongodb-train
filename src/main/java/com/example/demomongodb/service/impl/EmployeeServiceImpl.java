package com.example.demomongodb.service.impl;

import com.example.demomongodb.entity.Employee;
import com.example.demomongodb.service.EmployeeService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.schema.JsonSchemaObject;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

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

    /**
     * findAll
     */
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
     * insert 10000 rows
     */
    @Override
    public void insertAll() {
        List<String> tags = Arrays.asList("school", "book", "bag", "headphone", "appliance", "electronics");
        List<Boolean> exists = Arrays.asList(Boolean.TRUE, Boolean.FALSE);
        ArrayList<Employee> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            Employee employee = new Employee();
            employee.setAge(random.nextInt(100) + 1);
            employee.setName(UUID.randomUUID().toString());
            employee.setSalary((random.nextInt(100) + 1) * 100);
            employee.setDateTime(LocalDateTime.now());

            int nums = random.nextInt(tags.size()) + 1;
            HashSet<String> tag = new HashSet<>();
            while (tag.size() < nums) {
                tag.add(tags.get(random.nextInt(tags.size())));
            }
            employee.setTags(tag);
//            employee.setExists(exists.get(random.nextInt(exists.size())));
            employee.setExists(exists.get(random.nextInt(exists.size())) == Boolean.TRUE ? "exists" : null);

            list.add(employee);
        }
        mongoTemplate.insertAll(list);
    }

    /**
     * equal
     *
     * @return List<Employee>
     */
    @Override
    public List<Employee> is(Integer age) {
        Query query = new Query();
        query.addCriteria(Criteria.where("age").is(age));
        return mongoTemplate.find(query, Employee.class);
    }

    /**
     * not equal
     *
     * @return List<Employee>
     */
    @Override
    public List<Employee> ne(Integer age) {
        Query query = new Query();
        query.addCriteria(Criteria.where("age").ne(age));
        return mongoTemplate.find(query, Employee.class);
    }

    /**
     * in
     *
     * @return List<Employee>
     */
    @Override
    public List<Employee> in(List<Integer> age) {
        Query query = new Query();
        query.addCriteria(Criteria.where("age").in(age));
        return mongoTemplate.find(query, Employee.class);
    }

    /**
     * mod
     *
     * @return List<Employee>
     */
    @Override
    public List<Employee> mod() {
        Query query = new Query();
        query.addCriteria(Criteria.where("age").mod(4, 0));
        return mongoTemplate.find(query, Employee.class);
    }

    /**
     * nin
     *
     * @return List<Employee>
     */
    @Override
    public List<Employee> nin(List<Integer> age) {
        Query query = new Query();
        query.addCriteria(Criteria.where("age").nin(age));
        return mongoTemplate.find(query, Employee.class);
    }

    /**
     * all
     *
     * @return List<Employee>
     */
    @Override
    public List<Employee> all() {
        List<String> tags = Arrays.asList("school", "book");
        Query query = new Query();
        query.addCriteria(Criteria.where("tags").all(tags));
        return mongoTemplate.find(query, Employee.class);
    }

    /**
     * size
     *
     * @return List<Employee>
     */
    @Override
    public List<Employee> size(Integer size) {
        Query query = new Query();
        query.addCriteria(Criteria.where("tags").size(size));
        return mongoTemplate.find(query, Employee.class);
    }

    /**
     * exists
     *
     * @return List<Employee>
     */
    @Override
    public List<Employee> exists() {
        Query query = new Query();
        query.addCriteria(Criteria.where("exists").exists(true));
        return mongoTemplate.find(query, Employee.class);
    }

    /**
     * type
     * https://docs.mongodb.com/manual/reference/operator/query/type/
     *
     * @return List<Employee>
     */
    @Override
    public List<Employee> type() {
        Query query = new Query();
//        query.addCriteria(Criteria.where("exists").type(2).and("salary").lt(5600));
//        query.addCriteria(Criteria.where("exists").type(JsonSchemaObject.Type.NULL).and("salary").lt(5600));
//        query.addCriteria(Criteria.where("exists").type(JsonSchemaObject.Type.NULL));
        query.addCriteria(Criteria.where("exists").type(JsonSchemaObject.Type.STRING));
        return mongoTemplate.find(query, Employee.class);
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