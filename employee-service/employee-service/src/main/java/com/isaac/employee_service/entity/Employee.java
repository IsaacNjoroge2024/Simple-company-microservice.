package com.isaac.employee_service.entity;

public record Employee(Long employeeId, String employeeName, int age, String employeePosition, Long departmentId) {
}
