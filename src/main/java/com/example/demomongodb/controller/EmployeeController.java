package com.example.demomongodb.controller;

import com.example.demomongodb.entity.Employee;
import com.example.demomongodb.service.EmployeeService;
import com.example.demomongodb.util.JsonResult;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/huge")
    public JsonResult insertHuge() {
        employeeService.insertAll();
        return new JsonResult<>();
    }

    @GetMapping("/age")
    public JsonResult findByAge(@RequestParam Integer age) {
        List<Employee> list = employeeService.is(age);
        JsonResult<Object> jsonResult = new JsonResult<>();
        jsonResult.setData(list);
        jsonResult.setTotal(list.size());
        return jsonResult;
    }

    @GetMapping("/age.ne")
    public JsonResult ne(@RequestParam Integer age) {
        List<Employee> list = employeeService.ne(age);
        JsonResult<Object> jsonResult = new JsonResult<>();
        jsonResult.setData(list);
        jsonResult.setTotal(list.size());
        return jsonResult;
    }

    @GetMapping("/age.in")
    public JsonResult in(@RequestParam List<Integer> age) {
        List<Employee> list = employeeService.in(age);
        JsonResult<Object> jsonResult = new JsonResult<>();
        jsonResult.setData(list);
        jsonResult.setTotal(list.size());
        return jsonResult;
    }

    @GetMapping("/age.nin")
    public JsonResult nin(@RequestParam List<Integer> age) {
        List<Employee> list = employeeService.nin(age);
        JsonResult<Object> jsonResult = new JsonResult<>();
        jsonResult.setData(list);
        jsonResult.setTotal(list.size());
        return jsonResult;
    }

    @GetMapping("/age.mod")
    public JsonResult mod() {
        List<Employee> list = employeeService.mod();
        JsonResult<Object> jsonResult = new JsonResult<>();
        jsonResult.setData(list);
        jsonResult.setTotal(list.size());
        return jsonResult;
    }

    @GetMapping("/age.all")
    public JsonResult all() {
        List<Employee> list = employeeService.all();
        JsonResult<Object> jsonResult = new JsonResult<>();
        jsonResult.setData(list);
        jsonResult.setTotal(list.size());
        return jsonResult;
    }

    @GetMapping("/age.size")
    public JsonResult size(@RequestParam Integer size) {
        List<Employee> list = employeeService.size(size);
        JsonResult<Object> jsonResult = new JsonResult<>();
        jsonResult.setData(list);
        jsonResult.setTotal(list.size());
        return jsonResult;
    }

    @GetMapping("/age.exists")
    public JsonResult exists() {
        List<Employee> list = employeeService.exists();
        JsonResult<Object> jsonResult = new JsonResult<>();
        jsonResult.setData(list);
        jsonResult.setTotal(list.size());
        return jsonResult;
    }

    @GetMapping("/age.type")
    public JsonResult type() {
        List<Employee> list = employeeService.type();
        JsonResult<Object> jsonResult = new JsonResult<>();
        jsonResult.setData(list);
        jsonResult.setTotal(list.size());
        return jsonResult;
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
