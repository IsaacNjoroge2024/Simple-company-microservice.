package com.isaac.department_service.entity;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private Long departmentId;
    private String departmentName;
    private List<Employee> employees = new ArrayList<>();

    public Department() {
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", employees=" + employees +
                '}';
    }

    public Department(Long departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }


    public void setEmployees(List<Employee> employeesByDepartmentId) {
        this.employees = employeesByDepartmentId;
    }
}
