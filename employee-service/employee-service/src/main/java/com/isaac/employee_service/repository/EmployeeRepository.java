package com.isaac.employee_service.repository;

import com.isaac.employee_service.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    public List<Employee> employees = new ArrayList<>();

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public Employee findEmployeeById(Long employeeId) {
        return employees.stream()
                .filter(employee -> employee.employeeId()
                        .equals(employeeId))
                .findFirst()
                .orElseThrow();
    }

    public List<Employee> findAllEmployees() {
        return employees;
    }

    public List<Employee> findEmployeesByDepartmentId(Long departmentId) {
        return employees.stream()
                .filter(employee -> employee.departmentId()
                        .equals(departmentId))
                .toList();
    }
}
