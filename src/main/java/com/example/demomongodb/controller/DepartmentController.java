package com.example.demomongodb.controller;

import com.example.demomongodb.entity.Department;
import com.example.demomongodb.service.DepartmentService;
import com.example.demomongodb.util.JsonResult;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @createDate: 2019-10-03 11:14
 * @description:
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public JsonResult addDepartment(Department department) {
        Department save = departmentService.addDepartment(department);
        return new JsonResult<>(save);
    }

    @GetMapping
    public JsonResult listDepartment() {
        List<Department> list = departmentService.listDepartment();
        return new JsonResult<>(list);
    }

    @GetMapping("/page")
    public JsonResult listDepartmentPage() {
        Page<Department> list = departmentService.listDepartmentPage();
        return new JsonResult<>(list);
    }

    @PutMapping
    public JsonResult updateDepartment(Department department, String id) {
        Department update = departmentService.updateDepartment(department, id);
        return new JsonResult<>(update);
    }

    @DeleteMapping
    public JsonResult updateDepartment(String id) {
        departmentService.deleteDepartment(id);
        return new JsonResult<>();
    }

    @GetMapping("/findAll")
    public JsonResult findAll() {
        List<Department> list = departmentService.findAll();
        return new JsonResult<>(list);
    }

    @GetMapping("/findByName")
    public JsonResult findByName(@RequestParam String name) {
        List<Department> list = departmentService.findByName(name);
        return new JsonResult<>(list);
    }

    @GetMapping("/findByRegex")
    public JsonResult findByRegex() {
        List<Department> list = departmentService.findByRegex();
        return new JsonResult<>(list);
    }
}
