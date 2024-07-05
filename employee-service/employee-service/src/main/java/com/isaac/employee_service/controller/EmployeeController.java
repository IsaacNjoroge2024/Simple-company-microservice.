package com.isaac.employee_service.controller;

import com.isaac.employee_service.entity.Employee;
import com.isaac.employee_service.repository.EmployeeRepository;
import com.netflix.discovery.converters.Auto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public Employee add(@RequestBody Employee employee) {
        LOGGER.info("Employee added: ");
        return employeeRepository.addEmployee(employee);
    }

    @GetMapping("{employeeId}")
    public Employee findEmployeeById(@PathVariable Long employeeId) {
        LOGGER.info("Employee found: employeeId = {}", employeeId);
        return employeeRepository.findEmployeeById(employeeId);
    }

    @GetMapping
    public List<Employee> findAllEmployees() {
        LOGGER.info("Employees found: ");
        return employeeRepository.findAllEmployees();
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findEmployeesByDepartmentId(@PathVariable Long departmentId) {
        LOGGER.info("Employees found: departmentId = {}", departmentId);
        return employeeRepository.findEmployeesByDepartmentId(departmentId);
    }
}
