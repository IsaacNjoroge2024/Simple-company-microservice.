package com.isaac.department_service.client;

import com.isaac.department_service.entity.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface EmployeeClient {

    @GetExchange("employees/department/{departmentId}")
    List<Employee> findEmployeesByDepartmentId(@PathVariable("departmentId") Long departmentId);


}
