package com.isaac.department_service.controller;

import com.isaac.department_service.client.EmployeeClient;
import com.isaac.department_service.entity.Department;
import com.isaac.department_service.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeClient employeeClient;

    @PostMapping
    public Department add(@RequestBody Department department) {
        LOGGER.info("Department added: ");
        return departmentRepository.addDepartment(department);
    }

    @GetMapping
    public List<Department> findAll() {
        LOGGER.info("Departments found: ");
        return departmentRepository.findAllDepartments();
    }

    @GetMapping("/{departmentId}")
    public Department findDepartmentById(@PathVariable Long departmentId) {
        LOGGER.info("Department found: id = {}", departmentId);
        return departmentRepository.findDepartmentById(departmentId);
    }

    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees() {
        LOGGER.info("Departments found: ");
        List<Department> departments =
                departmentRepository.findAllDepartments();

        departments.forEach(
                department -> department
                        .setEmployees(employeeClient
                                .findEmployeesByDepartmentId(department
                                        .getDepartmentId())));
        return departments;
    }
}
