package com.isaac.department_service.repository;

import com.isaac.department_service.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository {

    private List<Department> departments = new ArrayList<>();

    public Department addDepartment(Department department) {
        departments.add(department);
        return department;
    }

    public Department findDepartmentById(Long departmentId) {
        return departments.stream()
                .filter(department -> department.getDepartmentId()
                        .equals(departmentId))
                .findFirst()
                .orElseThrow();
    }

    public List<Department> findAllDepartments() {
        return departments;
    }


}
