package com.isaac.department_service.entity;

public record Employee(Long employeeId, String employeeName, int age, String employeePosition, Long departmentId) {
}
