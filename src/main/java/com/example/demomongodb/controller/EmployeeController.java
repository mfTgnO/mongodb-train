package com.example.demomongodb.controller;

import com.example.demomongodb.entity.Employee;
import com.example.demomongodb.service.EmployeeService;
import com.example.demomongodb.util.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @createDate: 2019-10-08 14:22
 * @description:
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public JsonResult findAll() {
        List<Employee> list = employeeService.findAll();
        return new JsonResult<>(list);
    }

    @PostMapping
    public JsonResult insert(Employee employee) {
        Employee insert = employeeService.insert(employee);
        return new JsonResult<>(insert);
    }

    @GetMapping("/findLessThan")
    public JsonResult findLessThan() {
        List<Employee> list = employeeService.findLessThan();
        return new JsonResult<>(list);
    }

    @GetMapping("/findGreaterThan")
    public JsonResult findGreaterThan() {
        List<Employee> list = employeeService.findGreaterThan();
        return new JsonResult<>(list);
    }

    @GetMapping("/findLessThanAndGreaterThan")
    public JsonResult findLessThanAndGreaterThan() {
        List<Employee> list = employeeService.findLessThanAndGreaterThan();
        return new JsonResult<>(list);
    }

    @GetMapping("/sort")
    public JsonResult sort() {
        List<Employee> list = employeeService.sort();
        return new JsonResult<>(list);
    }

    @GetMapping("/pageable")
    public JsonResult pageable() {
        List<Employee> list = employeeService.pageable();
        return new JsonResult<>(list);
    }
}
